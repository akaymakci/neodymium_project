package template.pageobjects.components.documentation;

import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.neodymium.tests.smoke.documentation.BaseManualPageTest;
import template.pageobjects.components.AbstractComponent;
import template.pageobjects.pages.documentation.BaseManualPage;
import template.pageobjects.pages.documentation.DocsPage;
import template.pageobjects.pages.website.DocumentationPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class TopNavigationForDocumentation extends AbstractComponent {
    @Override
    public void isComponentAvailable() {

        var brandElement = $(".navbar-brand");
        brandElement.should(exist);

    }

    @Step("click on the top category '{topCategory}'")
    public void clickCategory(String topCategory)
    {
        var mainNavbar = $("#main_navbar");
        $$(mainNavbar.getSearchCriteria() + " li span:nth-of-type(1)").findBy(exactText(topCategory)).click();
    }

    @Step("click on the top category and hover and click subcategory'{topCategory, subCategory}'")
    public void hoverAndClickSubCategory(String topCategory,String subCategory)
    {

        var mainNavbar = $("#main_navbar");
        $$(mainNavbar.getSearchCriteria() + " li span:nth-of-type(1)").findBy(exactText(topCategory)).click();
        if($$(mainNavbar.getSearchCriteria() + " li span:nth-of-type(1)").first().getOwnText().equals("XLT"))
            $$(mainNavbar.getSearchCriteria() + " li:nth-of-type(1) ul.dropdown-menu a.dropdown-item").findBy(exactText(subCategory)).hover().click();
        else
            $$(mainNavbar.getSearchCriteria() + " li:nth-of-type(2) ul.dropdown-menu a.dropdown-item").findBy(exactText(subCategory)).hover().click();

    }

    public BaseManualPage openBaseManualPage(){

//        clickCategory(Neodymium.localizedText("documentation.topNavigation.xlt.baseManual"));

        hoverAndClickSubCategory(Neodymium.localizedText("documentation.topNavigation.xlt.title"),Neodymium.localizedText("documentation.topNavigation.xlt.baseManual"));

        return  new BaseManualPage().isExpectedPage();
    }




}
