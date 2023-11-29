package template.pageobjects.components.website;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.pageobjects.components.AbstractComponent;
import template.pageobjects.pages.website.CareerPage;
import template.pageobjects.pages.website.ServicePage;
import template.pageobjects.pages.website.XltPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TopNavigation extends AbstractComponent
{
    @Override
    public void isComponentAvailable()
    {
        var topNav = $(".navbar-header");
        topNav.should(exist);
    }

    public SelenideElement navigationContainer = $("#navigation");

    @Step("click on the top category '{topCategory}'")
    public void clickCategory(String topCategory)
    {
        hamburgerButtonClick();
        $$(navigationContainer.getSearchCriteria() + " .navbar-header ul.nav li").findBy(exactText(topCategory)).click();

    }

    public ServicePage openServicePage()
    {

        clickCategory(Neodymium.localizedText("header.topNavigation.services"));

        return new ServicePage().isExpectedPage();
    }

    public CareerPage openCareerPage()
    {
        clickCategory(Neodymium.localizedText("header.topNavigation.careers"));
        return new CareerPage().isExpectedPage();
    }

    public XltPage openXltPage()
    {

        clickCategory(Neodymium.localizedText("header.topNavigation.xlt"));

        return new XltPage().isExpectedPage();
    }

    public SelenideElement subNavigation = $("#sub-navigation");

    @Step("click on the top category '{subCategory}'")
    public void clickSubCategory(String subCategory)
    {
        $$(subNavigation.getSearchCriteria() + " .navbar-nav li").findBy(exactText(subCategory)).click();
    }

    @Step("validate Sub Category")
    public void validateSubCategoryByLocalizationPath(String subCategoryLocalizedPath)
    {
        // Asserts there are subcategories in the nav bar.
        $$(subNavigation.getSearchCriteria() + " .navbar a").findBy(exactText(Neodymium.localizedText(subCategoryLocalizedPath))).shouldBe(visible);
    }

    @Step("validate structure top navigation")
    public void validateStructure()
    {
        // Verifies the company Logo and name are visible.
        navigationContainer.find(" nav > div > a").shouldBe(visible);

        // Verifies the Navigation bar is visible
        hamburgerButtonClick();
        navigationContainer.find(".navbar-header ul.nav").shouldBe(visible);

        // Asserts there are categories in the nav bar.
        navigationContainer.find("ul.nav").shouldBe(visible);

        // validate navigation texts
        $$(navigationContainer.getSearchCriteria() + " li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.services"))).shouldBe(visible);
        $$(navigationContainer.getSearchCriteria() + " li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.xlt"))).shouldBe(visible);
        $$(navigationContainer.getSearchCriteria() + " li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.company"))).shouldBe(visible);
        $$(navigationContainer.getSearchCriteria() + " li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.news"))).shouldBe(visible);
        $$(navigationContainer.getSearchCriteria() + " li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.careers"))).shouldBe(visible);
        $$(navigationContainer.getSearchCriteria() + " li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.contact"))).shouldBe(visible);
        $$(navigationContainer.getSearchCriteria() + " li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.blog"))).shouldBe(visible);
        hamburgerButtonClick();
    }

    public void hamburgerButtonClick()
    {
        if (!Neodymium.isDesktop())
        {
            var hamburgerButton = $("button.navbar-toggle");
            hamburgerButton.shouldBe(visible);
            hamburgerButton.click();
        }
    }
}
