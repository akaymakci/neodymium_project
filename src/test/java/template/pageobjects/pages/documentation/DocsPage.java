package template.pageobjects.pages.documentation;

import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.neodymium.tests.smoke.testdata.pageobjects.components.SearchTestData;
import template.pageobjects.components.documentation.SearchForDocs;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class DocsPage extends AbstractDocsBrowsingPage {

    @Step("ensure this is a Docs Page")
    @Override
    public DocsPage isExpectedPage()
    {
        super.isExpectedPage();
        var tdContentH1Element = $(".row h1");
        tdContentH1Element.shouldHave(exactText(Neodymium.localizedText("docsPage.title")));
        return this;
    }
    public void validateStructure()
    {

    }

}
