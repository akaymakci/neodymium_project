package template.pageobjects.pages.documentation;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

import com.xceptance.neodymium.util.Neodymium;

import io.qameta.allure.Step;

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
        if (Neodymium.isDesktop())
        {
            $(".navbar-brand").scrollTo().click();
        }
        else
        {
            $(".navbar-brand").click();
        }
        return new DocsPage().isExpectedPage();
    }

}
