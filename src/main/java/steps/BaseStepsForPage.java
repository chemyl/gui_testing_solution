package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.webdriverContainer;

public class BaseStepsForPage {

    @Step("Open url: '{url}'")
    public BaseStepsForPage openPageUrl(String url) {
        open(url);
        return this;
    }

    @Step("Open new tab")
    public BaseStepsForPage openNewTab() {
        Selenide.executeJavaScript("window.open('about:blank','_blank');");
        return this;
    }

    @Step("Close current tab")
    public BaseStepsForPage closeCurrentTab() {

        return this;
    }

    @Step("Click By: '{locator}'")
    public BaseStepsForPage clickBy(By locator) {
        $(locator).shouldBe(visible).scrollIntoView("{block:\"center\"}").click();
        return this;
    }

    @Step("Wait element by locator: '{locator}' for '{waitInSeconds}' seconds")
    public BaseStepsForPage waitElement(SelenideElement element, int waitInSeconds) {
        try {
            element.wait(waitInSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Step("Execute js-script: '{jsPath}'")
    public BaseStepsForPage executeJavaScript(String jsPath) {
        Path path = Paths.get(jsPath);
        String jsScript;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            jsScript = reader.lines().collect(Collectors.joining());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webdriverContainer.getWebDriver();
        jsExecutor.executeScript(jsScript);
        return this;
    }
}
