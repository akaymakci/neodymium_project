package template.pageobjects.pages.documentation;

import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class SearchWithNoResultPage extends AbstractDocsBrowsingPage
{

    @Override
    @Step("ensure this is a no hits page")
    public SearchWithNoResultPage isExpectedPage()
    {
        super.isExpectedPage();
        $("h2").shouldHave(exactText(Neodymium.localizedText("noHitsPage.searchResults")));
        return this;
    }

    /// ----- validate no hits page ----- ///

    @Override
    @Step("validate structure no hits page")
    public void validateStructure()
    {
        super.validateStructure();

    }

    /// ----- no hits page navigation ----- ///

    @Step("open homepage from No Hits page")
    public DocsPage openDocsPage()
    {
        var navbarBrand = $(".navbar-brand");
        if (Neodymium.isDesktop())
        {
            navbarBrand.scrollTo().click();
        }
        else
        {
            navbarBrand.scrollIntoView(true).click();
        }
        return new DocsPage().isExpectedPage();
    }

}
