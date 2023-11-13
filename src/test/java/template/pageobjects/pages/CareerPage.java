package template.pageobjects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class CareerPage extends AbstractPageObject {

    public SelenideElement jobsElement = $(".jobs");
    public ElementsCollection headlinesElementCollection = $$("#jobs-overview h1, h3:not([id=footer-information] h3)");
//    public ElementsCollection locationsElementCollection = $$()

    @Step("ensure this is a Career Page")
    @Override
    public CareerPage isExpectedPage() {
        super.isExpectedPage();
        jobsElement.should(exist);
        return this;
    }


    @Step("validate the career page")
    public void validateStructure()
    {
        // Calls validateStructure of the parent class to validate basic things
        super.validateStructure();

        // validates teaser image is there
        $(".teaser-image").shouldBe(visible);

        // validates headlines are there
        $$("#jobs-overview h1, h3:not([id=footer-information] h3)").shouldHaveSize(9);

        // Asserts headlines
        headlinesElementCollection.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.weAreHiring"))).should(exist);
        headlinesElementCollection.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.startUp"))).should(exist);
        headlinesElementCollection.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.workLife"))).should(exist);
        headlinesElementCollection.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.commitment"))).should(exist);
        headlinesElementCollection.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.careerDevelopment"))).should(exist);
        headlinesElementCollection.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.international"))).should(exist);
        headlinesElementCollection.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.roomForCreativity"))).should(exist);
        headlinesElementCollection.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.greatLocations"))).should(exist);
        headlinesElementCollection.findBy(exactText(Neodymium.localizedText("careerPage.jobsOverview.headlines.valuableInternships"))).should(exist);

        // Validates Headlines' subtexts are there
        $$("#jobs-overview p:not([class*='tab-content'] p, [id='jobs-background'] p)").shouldHaveSize(9);

        // Validates Headlines icons are there
        $$("#jobs-overview h3 i").shouldHaveSize(8);



    }

}
