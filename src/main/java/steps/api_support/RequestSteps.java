package steps.api_support;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RequestSteps {
    private final String TOKEN = "Authorization";
    private final String TOKEN_KEY = "Basic xxxxxxxxx";
    private final String TOKEN_TYPES = "refresh_token";
    private final String CONTENT_TYPE = "Content-Type";
    private final String CONTENT_JSON = "application/json";

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
}
