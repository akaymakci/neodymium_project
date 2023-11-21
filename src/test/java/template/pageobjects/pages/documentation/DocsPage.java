package template.pageobjects.pages.documentation;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class DocsPage extends AbstractDocsBrowsingPage {

    @Step("ensure this is a Docs Page")
    @Override
    public DocsPage isExpectedPage()
    {
        var tdElement = $(".td-overlay__inner");
        super.isExpectedPage();
        tdElement.should(exist);
        return this;
    }
    public void validateStructure()
    {

    }

}
