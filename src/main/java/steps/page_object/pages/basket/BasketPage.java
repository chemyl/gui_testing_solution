package steps.page_object.pages.basket;

import dto.Order;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import test_wrapper.BaseTestWrapper;

import static constants.GlobalConstant.*;

@Epic("basket")
@Feature("basket_feature")
public class BasketPage extends BaseTestWrapper {

    private Order order;

    @Test(description = "make order from basket", groups = {DESKTOP, MOBILE})
    public void basketTransformation() {
        order = api.requestSteps.createOrder(DELIVERY);

    }
}
