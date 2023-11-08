package template.pageobjects.pages;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ServicePage extends AbstractPageObject{

    private SelenideElement servicesElement = $(".services");
    @Override
    public ServicePage isExpectedPage() {
        super.isExpectedPage();
        servicesElement.should(exist);
        return this;
    }

    @Then("^The home page should have heading, carousel, services and the company button$")
    @Step("validate the service page")
    public void validateStructure()
    {
        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        topNavigation.validateSubCategory();

        // validate teaser
        $("#teaser").should(exist);
        $("#teaser h1").shouldHave(exactText(Neodymium.localizedText("servicePage.teaser.headline")));

        // Validates main
        $("#main").should(exist);

        // Asserts the first headline is there.
        $("#introduction div h1").shouldBe(matchText("[A-Z].{4,}"));

        // Verifies service section
        $$(".service-section div[class*='col-md']").shouldHave(sizeGreaterThan(0));


    }



}
