package constants;

import configuration.MainTestConfig;

public class LinkConstant {

    static public final String BASE_URL = MainTestConfig.BASE_URL;
    static public final String PASSPORT_PAGE = "https://tprivate.auth.alfabank.ru/passport/cerberus-mini/dashboard/username?response_type=code&client_id=newclick-web&scope=openid%20newclick-web&acr_values=username&non_authorized_user=true";
    static public final String MAIN_PAGE = BASE_URL + "/dashboard";
    static public final String ORDER_CREATE_PAGE = BASE_URL + "/dashboard/marketplace";


}
