package steps.assertions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.HelperMethods.checkCondition;

public class BaseOverrideAssertions {

    @Step("Check that element: '{element}' except criteria : '{condition}'")
    public BaseOverrideAssertions isElement(Condition condition, SelenideElement element) {
        assertThat(checkCondition(element, condition))
                .withFailMessage(String.format("Element: \"%s\" is not except criteria: \"%s\"", element, condition))
                .isTrue();
        return this;
    }

    @Step("Check all elements visible on that page: '{elements}'")
    public BaseOverrideAssertions isAllElementsDisplayed(SelenideElement... elements) {
        for (SelenideElement element : elements) {
            assertThat(checkCondition(element, visible))
                    .withFailMessage(String.format("Element: \"%s\" does not exist on page", element))
                    .isTrue();
        }
        return this;
    }
}
