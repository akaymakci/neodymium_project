package template.pageobjects.pages.documentation;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

import com.xceptance.neodymium.util.Neodymium;

import io.qameta.allure.Step;

public class DocsXltPage extends AbstractDocsBrowsingPage
{

    @Step("ensure this is a Docs XLT Page")
    @Override
    public DocsXltPage isExpectedPage()
    {
        super.isExpectedPage();
        var tdContentH1Element = $(".row h1");
        tdContentH1Element.shouldHave(exactText(Neodymium.localizedText("docsPage.xltDocsPage.title")));
        return this;
    }

    public void validateStructure()
    {

    }

    @Step("open homepage from Docs XLT page")
    public DocsPage openDocsPage()
    {
        $(".navbar-brand").scrollTo().click();
        return new DocsPage().isExpectedPage();
    }

}
