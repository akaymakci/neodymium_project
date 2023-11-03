package template.pageobjects.pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$;

import com.xceptance.neodymium.util.Neodymium;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

public class HomePage extends AbstractPageObject
{
    @Override
    @Step("ensure this is a homepage")
    public HomePage isExpectedPage()
    {
        $("#service-areas").should(exist);
        return this;
    }

    @Then("^The home page should have heading, carousel, services and the company button$")
    @Step("validate the home page")
    public void validateStructure()
    {
        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // Verifies the company Logo and name are visible.
        $("#navigation .navbar-brand a[title=Home]").shouldBe(visible);

        // Verifies the Navigation bar is visible
        $("#navigation .navbar-header ul.nav").shouldBe(visible);

        // Asserts there's categories in the nav bar.
        $$("#navigation .navbar-header ul.nav > li > a").shouldHave(sizeGreaterThan(0));

        // Asserts the first headline is there.
        $("#service-areas .landing-intro > h1").shouldBe(matchText("[A-Z].{3,}"));
        // Asserts the animated carousel is there.
        $("#myCarousel").shouldBe(visible);

        // Verifies the "services" section is there.
        // Asserts there's at least 1 item in the list.
        $$("#service-areas .container .thumbnail").shouldHave(sizeGreaterThan(0));

        // Verifies the company button is there.
        $$("#xlt-background .container p.lead > a.btn-primary").shouldHave(sizeGreaterThan(0));

        // Verifies the company addresses in footer section are there.
        $$("#addresses h3").shouldHave(sizeGreaterThan(0));

        // Verifies the company emails in footer section are there.
        $$("#addresses .email").shouldHave(sizeGreaterThan(0));

        // Verifies the company phone numbers in footer section are there.
        $$("#addresses .tel").shouldHave(sizeGreaterThan(0));

        // Verifies the footer links section is there.
        $$(".col-xs-6 ul li a").shouldHave(sizeGreaterThan(0));

    }
}
