package template.pageobjects.pages;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class CareerPage extends AbstractPageObject {

    private SelenideElement jobsElement = $(".jobs");
    @Override
    public CareerPage isExpectedPage() {
        super.isExpectedPage();
        jobsElement.should(exist);
        return this;
    }

    @Then("^The home page should have heading, carousel, services and the company button$")
    @Step("validate the career page")
    public void validateStructure()
    {
        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // validates teaser image is there
        $(".teaser-image").shouldBe(visible);


    }

}
