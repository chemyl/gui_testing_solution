package steps.page_object.host;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import steps.BrowserActions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Footer extends BrowserActions {

    public static final SelenideElement mainFooterLogo = $(By.xpath("//sdaf"));

    public static final SelenideElement mainFooterPromo = $(By.xpath("//sdaf"));

    public static final SelenideElement mainFooterSignInBtn = $(By.xpath("eee"));


    @Step("Make some actions with footer section")
    public Footer signIn(String login) {
        mainFooterSignInBtn.doubleClick();
        mainFooterSignInBtn.sendKeys();
        waitElement(mainFooterPromo, 3);
        return this;
    }
}
