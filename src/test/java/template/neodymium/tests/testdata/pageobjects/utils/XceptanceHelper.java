package template.neodymium.tests.testdata.pageobjects.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class XceptanceHelper
{
    @Step("wait for a specific condition of an element")
    public static boolean optionalWaitUntilCondition(SelenideElement element, Condition condition, long maxWaitingTime)
    {
        boolean result = false;
        final long start = System.currentTimeMillis();
        while (!result && ((System.currentTimeMillis() - start) < maxWaitingTime))
        {
            if (element.has(condition))
            {
                result = true;
                break;
            }
            Selenide.sleep(maxWaitingTime / 20);
        }
        return result;
    }
}
