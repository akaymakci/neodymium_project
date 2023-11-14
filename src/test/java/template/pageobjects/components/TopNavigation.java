package template.pageobjects.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.pageobjects.pages.CareerPage;
import template.pageobjects.pages.SalesForceCommerceCloudPage;
import template.pageobjects.pages.ServicePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TopNavigation extends AbstractComponent {

    @Override
    public void isComponentAvailable() {
        var topNav = $(".navbar-header");
        topNav.should(exist);
    }
    public SelenideElement navigationContainer = $("#navigation");
    @Step("click on the top category '{topCategory}'")
    public void clickCategory(String topCategory)
    {
        navigationContainer.findAll(".navbar-header ul.nav li").findBy(exactText(topCategory)).click();
    }
    public ServicePage openServicePage(){

        clickCategory(Neodymium.localizedText("header.topNavigation.services"));

        return  new ServicePage().isExpectedPage();
    }

    public CareerPage openCareerPage(){
        clickCategory(Neodymium.localizedText("header.topNavigation.careers"));
        return  new CareerPage().isExpectedPage();
    }
    public SelenideElement subNavigation = $("#sub-navigation");
    @Step("click on the top category '{subCategory}'")
    public void clickSubCategory(String subCategory){
        subNavigation.findAll(".navbar-nav li").findBy(exactText(subCategory)).click();
    }
    @Step("validate Sub Category")
    public void validateSubCategoryByLocalizationPath(String subCategoryLocalizedPath) {
        // Asserts there are subcategories in the nav bar.
        subNavigation.findAll(".navbar a").findBy(exactText(Neodymium.localizedText(subCategoryLocalizedPath))).shouldBe(visible);
    }

    @Step("validate structure top navigation")
    public void validateStructure()
    {
        // Verifies the company Logo and name are visible.
        navigationContainer.find(".navbar-brand a[title=Home]").shouldBe(visible);

        // Verifies the Navigation bar is visible
        navigationContainer.find(".navbar-header ul.nav").shouldBe(visible);

        // Asserts there are categories in the nav bar.
        navigationContainer.find("ul.nav").shouldBe(visible);

        // validate navigation texts
        navigationContainer.findAll("li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.services"))).shouldBe(visible);
        navigationContainer.findAll("li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.xlt"))).shouldBe(visible);
        navigationContainer.findAll("li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.company"))).shouldBe(visible);
        navigationContainer.findAll("li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.news"))).shouldBe(visible);
        navigationContainer.findAll("li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.careers"))).shouldBe(visible);
        navigationContainer.findAll("li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.contact"))).shouldBe(visible);
        navigationContainer.findAll("li a").findBy(exactText(Neodymium.localizedText("header.topNavigation.blog"))).shouldBe(visible);

    }


}
