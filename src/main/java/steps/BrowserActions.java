package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BrowserActions {

    @Step("Open url: '{url}'")
    public BrowserActions openPageUrl(String url) {
        open(url);
        return this;
    }

    @Step("Open new tab")
    public BrowserActions openNewTab() {
        Selenide.executeJavaScript("window.open('about:blank','_blank');");
        return this;
    }

    @Step("Close current tab")
    public BrowserActions closeCurrentTab() {

        return this;
    }

    @Step("Click By: '{locator}'")
    public BrowserActions clickBy(By locator) {
        $(locator).shouldBe(visible).scrollIntoView("{block:\"center\"}").click();
        return this;
    }

    @Step("Wait element by locator: '{locator}' for '{waitInSeconds}' seconds")
    public BrowserActions waitElement(SelenideElement element, int waitInSeconds) {
        try {
            element.wait(waitInSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
