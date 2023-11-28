package template.pageobjects.pages.website;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;

import io.qameta.allure.Step;
import template.pageobjects.pages.documentation.DocsXltPage;

public class DocumentationPage extends AbstractBrowsingPage
{

    public SelenideElement documentationElement = $("#documentation");

    @Step("ensure this is a Service Page")
    @Override
    public DocumentationPage isExpectedPage()
    {
        super.isExpectedPage();
        documentationElement.should(exist);
        return this;
    }

    @Step("validate the xlt page")
    public void validateStructure()
    {
        XltPage xltPage = new XltPage();

        super.validateStructure();

        xltPage.validateSubCategories();

        // clickDocumentationLinks(Neodymium.localizedText("links.xlt.documentation.userManual"));
        //
        // DocsPage docsPage = new DocsPage();
        // docsPage.isExpectedPage();
        goToDocsXltPage();

    }

    @Step("click on the link side links category '{links}'")
    public void clickDocumentationLinks(String link)
    {
        var documentationLinks = $$(documentationElement.getSearchCriteria() + " ul li a");
        documentationLinks.findBy(exactText(link)).click();
    }

    public DocsXltPage goToDocsXltPage()
    {
        clickDocumentationLinks((Neodymium.localizedText("links.xlt.documentation.userManual")));
        return new DocsXltPage().isExpectedPage();
    }

}
