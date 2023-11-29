package template.pageobjects.components;

import com.xceptance.neodymium.util.SelenideAddons;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.title;

public class Title extends AbstractComponent
{
    public void isComponentAvailable()
    {
    }

    @Step("validate title matches: '{title}'")
    public void validateTitle(String title)
    {
        SelenideAddons.wrapAssertionError(() -> {
            Assert.assertEquals(title, title());
        });
    }
}
