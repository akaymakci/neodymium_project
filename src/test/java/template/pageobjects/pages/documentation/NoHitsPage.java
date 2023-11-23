package template.pageobjects.pages.documentation;

import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NoHitsPage extends AbstractDocsBrowsingPage{

    @Override
    @Step("ensure this is a no hits page")
    public NoHitsPage isExpectedPage()
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
//        validateNoProductsFound();
    }

    /// ----- no hits page navigation ----- ///

    @Step("open homepage from No Hits page")
    public DocsPage openDocsPage()
    {
        $(".navbar-brand").scrollTo().click();
        return new DocsPage().isExpectedPage();
    }


}
