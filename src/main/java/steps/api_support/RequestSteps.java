package steps.api_support;

import com.google.gson.Gson;
import dto.Order;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import okhttp3.*;
import org.asynchttpclient.util.Assertions;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

public class RequestSteps {
    private final String TOKEN = "Authorization";
    private final String TOKEN_KEY = "Basic xxxxxxxxx";
    private final String TOKEN_TYPES = "refresh_token";
    private final String CONTENT_TYPE = "Content-Type";
    private final String CONTENT_JSON = "application/json";
    private final int TIMEOUT = 10;
    private final String CREATE_ORDER_URL = "https://server.order.create";

    @SneakyThrows
    @Step("Cleaning user-data by userId: '{userId}'")
    public RequestSteps cleaningUserData(String userId) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.build();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, userId);
        Request post = new Request.Builder()
                .url("https://server.user.clean.cache")
                .method("POST", requestBody)
                .addHeader(CONTENT_TYPE, CONTENT_JSON)
                .addHeader(TOKEN, TOKEN_KEY)
                .build();
        okHttpClient.newCall(post)
                .execute();
        return this;
    }

    @SneakyThrows
    @Step("Create order with type: '{type}'")
    public Order createOrder(String type) {
        TrustManager[] trustAllCerts = createTrustManager();
        SSLSocketFactory sslSocketFactory = createSslConnect(trustAllCerts);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
        builder.hostnameVerifier((hostname, session) -> true);
        OkHttpClient okHttpClient = builder.readTimeout(TIMEOUT, TimeUnit.SECONDS).build();
        Request request = new Request.Builder()
                .url(CREATE_ORDER_URL)
                .get()
                .addHeader(TOKEN, TOKEN_KEY)
                .addHeader(CONTENT_TYPE, CONTENT_JSON)
                .build();
        Gson gson = new Gson();
        Response response = okHttpClient.newCall(request).execute();
        assert response.body() != null;
        Order order = gson.fromJson(response.body().string(), Order.class);
        Assertions.assertNotNull(order.getOrderNumber(), "Order create failed " + order);
        return order;
    }

    @SneakyThrows
    private TrustManager[] createTrustManager() {
        return new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };
    }

    @SneakyThrows
    private SSLSocketFactory createSslConnect(TrustManager[] trustAllCerts) {
        final SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        return sslContext.getSocketFactory();
    }
}
