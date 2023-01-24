package steps.page_object.host;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import steps.BaseStepsForPage;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage extends BaseStepsForPage {
    public static final SelenideElement mainHeaderLogo = $(By.xpath("//aa"));

    static public class SideHeader {
        public static final SelenideElement sideBarTitles = $(By.xpath("//*[contains(@class,'sidebar')]/li"));
        public static final SelenideElement sideBarButton = $(By.xpath("//*[@data-test-id='sidebar']//footer/button"));
    }
}
