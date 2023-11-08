package template.pageobjects.pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import com.xceptance.neodymium.util.Neodymium;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage extends AbstractPageObject
{
    @Override
    @Step("ensure this is a homepage")
    public HomePage isExpectedPage()
    {
        $("#service-areas").should(exist);
        return this;
    }
    @Step("validate poster slide")
    public void validatePosterSlide(int position, String headline)
    {
        // TODO - improve
        for (int i = 0; i <position; i++) {
            String strHeadlineFull = headline+"headline."+(i+1);
            String strButtonFull = headline+"button."+(i+1);
            $(".carousel-indicators li[data-slide-to='"+i+"']").click();
            $(".carousel-indicators li[data-slide-to='"+i+"']").shouldHave(cssClass("active"));
            $$(".carousel-inner .item h1").findBy(exactText(Neodymium.localizedText(strHeadlineFull))).shouldBe(visible);
            $$(".item .btn-primary").findBy(exactText(Neodymium.localizedText(strButtonFull))).shouldBe(visible);
        }

    }
    @Step("validate poster slide")
    public void validatePosterSlide()
    {
        validatePosterSlide(3, "slider.");

    }
    @Then("^The home page should have heading, carousel, services and the company button$")
    @Step("validate the home page")
    public void validateStructure()
    {
        // Annoying privacy message close
        $("#privacy-message .close").click();

        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // Asserts the animated carousel is there.
        $("#myCarousel").shouldBe(visible);
        validatePosterSlide();

        // Asserts the first headline is there.
        $("#service-areas .landing-intro > h1").shouldBe(matchText("[A-Z].{3,}"));

        // Verifies the "services" section is there.
        // Asserts there's at least 1 item in the list.
        $$("#service-areas .container .thumbnail").shouldHave(sizeGreaterThan(0));

        // Asserts the Welcome headline and button is there.
        $("#xlt-background p").shouldHave(exactText(Neodymium.localizedText("company.headline")));
        $$("#xlt-background .container p.lead > a.btn-primary").shouldHave(sizeGreaterThan(0));
        $("#xlt-background .btn-primary").shouldHave(exactText(Neodymium.localizedText("company.button")));

    }
}
