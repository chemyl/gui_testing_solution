package domain.create_order_ui;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.BaseStepsForPage;

import java.util.Map;

import static constants.GlobalConstant.DESKTOP;
import static constants.GlobalConstant.MOBILE;

public class CreateNewOrderTest extends BaseStepsForPage {

    public void precondition(){

    }


    @Test(description = "newCreateOrderTests", groups = {DESKTOP, MOBILE})
    @Parameters
    public void createNewOrder(Map<String, String> SHIPPING_TYPE) {
        precondition();

    }

    public static final Map<String, String> SHIPPING_TYPE = Map.of(
            "Delivery", "del",
            "PickPoint", "pkp",
            "PickUp", "pku"
    );

}


