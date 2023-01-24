package app_manager;

import steps.assertions.BaseOverrideAssertions;
import steps.page_object.host.BasketPage;
import steps.page_object.host.UserInfoPage;

public class BaseAppManager extends BaseManager {

    public final BasketPage header = new BasketPage();
    public final UserInfoPage userInfoPage = new UserInfoPage();

    public final BaseOverrideAssertions assertions = new BaseOverrideAssertions();

}
