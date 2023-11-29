package template.pageobjects.pages.documentation;

import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class BaseManualPage extends AbstractDocsBrowsingPage
{

    @Step("ensure this is a Base Manual Page")
    @Override
    public BaseManualPage isExpectedPage()
    {
        var tdContentH1Element = $(".row h1");
        super.isExpectedPage();
        tdContentH1Element.shouldHave(exactText(Neodymium.localizedText("docsPage.topNavigation.xlt.baseManual")));
        return this;
    }

    public void validateStructure()
    {

    }

}
