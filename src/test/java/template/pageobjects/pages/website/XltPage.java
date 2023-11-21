package template.pageobjects.pages.website;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class XltPage extends AbstractBrowsingPage {
    public SelenideElement xltOverviewElement = $("#xlt-overview");
    @Step("ensure this is a Service Page")
    @Override
    public XltPage isExpectedPage() {
        super.isExpectedPage();
        xltOverviewElement.should(exist);
        return this;
    }
    @Step("validate the xlt page")
    public void validateStructure()
    {
        super.validateStructure();
        validateSubCategories();

    }

    public void validateSubCategories(){
        topNavigation.validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.xlt.overview");
        topNavigation.validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.xlt.features");
        topNavigation.validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.xlt.documentation");
        topNavigation.validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.xlt.licenseUndSupport");
        topNavigation.validateSubCategoryByLocalizationPath("header.topNavigation.subNavigation.xlt.download");
    }
    public DocumentationPage goToDocumentationPage(){
        topNavigation.clickSubCategory(Neodymium.localizedText("header.topNavigation.subNavigation.xlt.documentation"));
        return new DocumentationPage().isExpectedPage();
    }

}
