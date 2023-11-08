package template.pageobjects.components;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.pageobjects.pages.ServicePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TopNavigation extends AbstractComponent {

    private SelenideElement categoryMenu = $(".navbar-header");
    @Override
    public void isComponentAvailable() {
        categoryMenu.should(exist);
    }

    @Step("click on the top category '{topCategory}'")
    public void clickCategory(String topCategory)
    {
        $$("#navigation .navbar-header ul.nav li").findBy(exactText(topCategory)).click();
    }
    public ServicePage openServicePage(){
        clickCategory(Neodymium.localizedText("header.topNavigation.1.title"));
        return  new ServicePage().isExpectedPage();
    }
    @Step("validate structure top navigation")
    public void validateStructure()
    {
        // Verifies the company Logo and name are visible.
        $("#navigation .navbar-brand a[title=Home]").shouldBe(visible);

        // Verifies the Navigation bar is visible
        $("#navigation .navbar-header ul.nav").shouldBe(visible);

        // validate navigation texts
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.1.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.3.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.2.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.4.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.5.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.6.title"))).shouldBe(visible);
        $$("#navigation .navbar-header ul.nav > li > a").findBy(exactText(Neodymium.localizedText("header.topNavigation.7.title"))).shouldBe(visible);
        $$("#sub-navigation .navbar a").findBy(exactText(Neodymium.localizedText("header.subNavigation.1.title"))).shouldBe(visible);
        $$("#sub-navigation .navbar a").findBy(exactText(Neodymium.localizedText("header.subNavigation.2.title"))).shouldBe(visible);


        // Asserts there's categories in the nav bar.
        $$("#navigation .navbar-header ul.nav > li > a").shouldHave(sizeGreaterThan(0));

    }

}
