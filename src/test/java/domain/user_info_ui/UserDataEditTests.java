package domain.user_info_ui;

import constants.GlobalConstant;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import test_wrapper.Wrapper;

import static constants.GlobalConstant.DESKTOP;
import static constants.LinkConstant.ORDER_CREATE_PAGE;

@Epic("user_info")
@Feature("Edit info")
public class UserDataEditTests extends Wrapper {

    private void precondition() {
        app.browser.openPageUrl(ORDER_CREATE_PAGE);
        app.footer.signIn(GlobalConstant.BASE_LOGIN);
    }

    @Test(description = "Create default order", groups = {DESKTOP})
    public void createDefaultOrder() {

    }

}
