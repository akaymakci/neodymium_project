package template.pageobjects.pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

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
    public void validatePosterSlide(String position, String headline)
    {
        // TODO - improve
//        System.out.println("myCaroulse Slide Element = "+ $$("#myCarousel .carousel-indicators [data-target]").toString());
//        System.out.println("Texts = "+$$(".carousel-caption h1").texts().get(0).toString());
//        System.out.println("Neodymium Localized Texts = ");
//        System.out.println(Neodymium.localizedText(headline));
//        $$(".carousel-indicators li").findBy(exactText(position)).click();
//        jsClickFunction($(".carousel-indicators li:nth-child(1)").shouldHave(exactText("")));
//        $$(".carousel-caption h1:nth-child(1)").findBy(exactText(Neodymium.localizedText(headline))).shouldBe(visible);
////        $$(".carousel-caption .btn-primary").findBy(exactText(Neodymium.localizedText("slider.button.1"))).shouldBe(visible);
//        jsClickFunction($(".carousel-indicators li:nth-child(2)").shouldHave(exactText(""))); //.click();
//        $$(".carousel-caption h1:nth-child(2)").findBy(exactText(Neodymium.localizedText(headline))).shouldBe(visible);
////        $$(".carousel-caption .btn-primary").findBy(exactText(Neodymium.localizedText("slider.button.1"))).shouldBe(visible);
//        jsClickFunction($(".carousel-indicators li:nth-child(3)").shouldHave(exactText("")));//.click();
//        $$(".carousel-caption h1:nth-child(3)").findBy(exactText(Neodymium.localizedText(headline))).shouldBe(visible);
//        $$(".carousel-indicators li:nth-child(1)").findBy(exactText("")).click();
//        $$(".carousel-indicators li:nth-child(2)").findBy(exactText("")).click();
//        $$(".carousel-indicators li:nth-child(3)").findBy(exactText("")).click();
//        $$(".carousel-caption h1").findBy(exactText(Neodymium.localizedText(headline))).shouldBe(visible);
//        $$(".carousel-caption .btn-primary").findBy(exactText(Neodymium.localizedText("slider.button.1"))).shouldBe(visible);
        $$(".carousel-indicators li[data-slide-to='0']").findBy(exactText("")).click();
//        $$(".carousel-indicators li").findBy(exactText("")).click();
//        $$(".carousel-indicators li").findBy(exactText("")).click();
//        System.out.println(" exact text: "+  $(".item .carousel-caption h1:nth-child(1)").shouldBe(enabled).toString());
        $$(".carousel-indicators li[data-slide-to='1']").findBy(exactText("")).click();
//        System.out.println(" exact text: "+  $(".item .carousel-caption h1:nth-child(2)").shouldBe(enabled).toString());
        $$(".carousel-indicators li[data-slide-to='2']").findBy(exactText("")).click();
        System.out.println(" exact text: "+  $$(".item .carousel-caption h1").findBy(visible).getOwnText());
    }
    @Step("validate poster slide")
    public void validatePosterSlide()
    {
        validatePosterSlide("3", "slider.headline.1");
        validatePosterSlide("2", "slider.headline.2");
        validatePosterSlide("1", "slider.headline.3");
    }
    @Then("^The home page should have heading, carousel, services and the company button$")
    @Step("validate the home page")
    public void validateStructure()
    {
        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // Annoying privacy message close
        $("#privacy-message .close").click();

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

        validatePosterSlide();

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
        $$("#footer-information div ul li a").shouldHave(sizeGreaterThan(0));

        // Verifies the footer news section is there.
        $$("#news-section h3").shouldHave(sizeGreaterThan(0));
        $$("#news-section p a").shouldHave(sizeGreaterThan(0));

        // validate navigation texts
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.1.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.3.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.2.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.4.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.5.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.6.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.7.title"))).shouldBe(visible);

        // validate footer texts
        $$("#addresses h3").findBy(exactText(Neodymium.localizedText("footer.address.germany"))).shouldBe(visible);
        $$("#addresses h3").findBy(exactText(Neodymium.localizedText("footer.address.usa"))).shouldBe(visible);
        $$("#addresses .email").findBy(exactText(Neodymium.localizedText("footer.email.germany"))).shouldBe(visible);
        $$("#addresses .email").findBy(exactText(Neodymium.localizedText("footer.email.usa"))).shouldBe(visible);
        $$("#addresses .tel").findBy(exactText(Neodymium.localizedText("footer.tel.germany"))).shouldBe(visible);
        $$("#addresses .tel").findBy(exactText(Neodymium.localizedText("footer.tel.usa"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.1"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.2"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.3"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.4"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.5"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.6"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.7"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.8"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.9"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.10"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.11"))).shouldBe(visible);
        $$("#news-section h3").findBy(exactText(Neodymium.localizedText("footer.newsTexts.1"))).shouldBe(visible);
        $$("#news-section p a").findBy(exactText(Neodymium.localizedText("footer.newsTexts.2"))).shouldBe(visible);
        $$("#news-section p a").findBy(exactText(Neodymium.localizedText("footer.newsTexts.3"))).shouldBe(visible);
        $$("#news-section p a").findBy(exactText(Neodymium.localizedText("footer.newsTexts.4"))).shouldBe(visible);
    }
    public void jsClickFunction(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver(); ;
        jse.executeScript("arguments[0].click()", element);
    }
}
