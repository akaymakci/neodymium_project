package template.pageobjects.pages.website;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends AbstractBrowsingPage
{
    private final SelenideElement homePageElement = $(".homepage");

    @Override
    @Step("ensure this is a homepage")
    public HomePage isExpectedPage()
    {
        homePageElement.should(exist);
        return this;
    }

    @Step("validate poster slide")
    private void validatePosterSlide()
    {
        var carouselIndicator = $$(".carousel-indicators li");
        for (int i = 0; i < carouselIndicator.size(); i++)
        {
            String headline = "slider.";
            String strHeadlineFull = headline + "headline." + (i + 1);
            String strButtonFull = headline + "button." + (i + 1);

            $(".carousel-indicators li[data-slide-to='" + i + "']").click(ClickOptions.usingJavaScript());
            $(".carousel-indicators li[data-slide-to='" + i + "']").shouldHave(cssClass("active"));
            $$(".carousel-inner .item h1").findBy(exactText(Neodymium.localizedText(strHeadlineFull))).shouldBe(visible);
            $$(".item .btn-primary").findBy(exactText(Neodymium.localizedText(strButtonFull))).shouldBe(visible);
        }

    }

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
