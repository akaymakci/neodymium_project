package template.pageobjects.pages.documentation;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class BaseManualPage extends AbstractDocsBrowsingPage {

    @Step("ensure this is a Documentation Page")
    @Override
    public BaseManualPage isExpectedPage()
    {
        var tdContentH1Element = $(".row h1");
        super.isExpectedPage();
        tdContentH1Element.should(exist);
        return this;
    }
    public void validateStructure()
    {

    }

}
