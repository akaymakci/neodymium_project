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

    @Step("click on the top category and hover and click subcategory'{topCategory}, {subCategory}'")
    public void hoverAndClickSubCategory(String topCategory,String subCategory)
    {

        var mainNavbar = $("#main_navbar");
        $$(mainNavbar.getSearchCriteria() + " li span").findBy(exactText(topCategory)).click();
        $$(mainNavbar.getSearchCriteria() + " li ul.dropdown-menu a.dropdown-item").findBy(exactText(subCategory)).hover().click();

    }

    public BaseManualPage openBaseManualPage(){

        hoverAndClickSubCategory(Neodymium.localizedText("docsPage.topNavigation.xlt.title"),Neodymium.localizedText("docsPage.topNavigation.xlt.baseManual"));

        return  new BaseManualPage().isExpectedPage();
    }




}
