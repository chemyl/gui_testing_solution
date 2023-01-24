package steps.page_object.host;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import steps.BaseStepsForPage;

import static com.codeborne.selenide.Selenide.$;

public class UserInfoPage extends BaseStepsForPage {

    public static final SelenideElement mainFooterLogo = $(By.xpath("//sdaf"));

    public static final SelenideElement mainFooterPromo = $(By.xpath("//sdaf"));

    public static final SelenideElement mainFooterSignInBtn = $(By.xpath("eee"));


    @Step("Make some actions with footer section")
    public UserInfoPage signIn(String login) {
        mainFooterSignInBtn.doubleClick();
        mainFooterSignInBtn.sendKeys();
        waitElement(mainFooterSignInBtn, 3);
        return this;
    }
}
