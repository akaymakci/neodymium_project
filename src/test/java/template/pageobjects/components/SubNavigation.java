package template.pageobjects.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.pageobjects.pages.SalesForceCommerceCloudPage;
import template.pageobjects.pages.ServicePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SubNavigation extends AbstractComponent{

    private SelenideElement subNav = $("#sub-navigation .navbar-default");
    private ElementsCollection subCategoriesElementCollection = $$("#sub-navigation .navbar a");
    @Override
    public void isComponentAvailable() {
        subNav.should(exist);
    }

    public SalesForceCommerceCloudPage clickSubNavigation(String subNavigation){

        $$("#sub-navigation .navbar-nav li").findBy(exactText(Neodymium.localizedText(subNavigation))).click();

        return new SalesForceCommerceCloudPage().isExpectedPage();
    }
    public void validateSubCategoryByLocalizationPath(String subCategoryLocalizedPath) {
        // Asserts there are subcategories in the nav bar.
        subCategoriesElementCollection.findBy(exactText(Neodymium.localizedText(subCategoryLocalizedPath))).shouldBe(visible);
    }
    public void validateStructure()
    {
        validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.services.overview.title");
        validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.services.salesforce.title");
    }

}
