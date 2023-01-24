package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class HelperMethods {

    public static boolean checkCondition(SelenideElement element, Condition condition) {
        try {
            element.shouldBe(condition);
            return true;
        } catch (Error error) {
            return false;
        }
    }
}
