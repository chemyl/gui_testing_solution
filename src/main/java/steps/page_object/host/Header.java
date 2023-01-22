package steps.page_object.host;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import steps.BrowserActions;

import static com.codeborne.selenide.Selenide.$;

public class Header extends BrowserActions {
    public static final SelenideElement mainHeaderLogo = $(By.xpath("//aa"));

    static public class SideHeader {
        public static final SelenideElement sideBarTitles = $(By.xpath("//*[contains(@class,'sidebar')]/li"));
        public static final SelenideElement sideBarButton = $(By.xpath("//*[@data-test-id='sidebar']//footer/button"));
    }
}
