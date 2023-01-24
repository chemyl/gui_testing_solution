package domain.user_info_ui;

import com.codeborne.selenide.Condition;
import constants.GlobalConstant;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import steps.page_object.host.UserInfoPage;
import test_wrapper.BaseTestWrapper;

import static constants.GlobalConstant.DESKTOP;
import static constants.LinkConstant.ORDER_CREATE_PAGE;

@Epic("user_info")
@Feature("Edit info")
public class UserDataEditTests extends BaseTestWrapper {

    private void precondition() {
        app.browser.openPageUrl(ORDER_CREATE_PAGE);
        app.userInfoPage.signIn(GlobalConstant.BASE_LOGIN);
    }

    @Test(description = "Create default order", groups = {DESKTOP})
    public void createDefaultOrder() {
        app.browser.executeJavaScript("src/test/resources/js_scripts/mockData.txt");
        app.assertions.isElement(Condition.visible, UserInfoPage.mainFooterPromo);
        app.assertions.isAllElementsDisplayed(
                UserInfoPage.mainFooterLogo,
                UserInfoPage.mainFooterPromo,
                UserInfoPage.mainFooterSignInBtn);


    }

}
