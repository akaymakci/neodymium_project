package template.pageobjects.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;
import io.qameta.allure.Step;
import template.pageobjects.pages.CareerPage;
import template.pageobjects.pages.ServicePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TopNavigation extends AbstractComponent {

    private SelenideElement topNav = $(".navbar-header");
    private ElementsCollection categoriesElementCollection = $$("#navigation .navbar-header ul.nav > li > a");


    @Override
    public void isComponentAvailable() {
        topNav.should(exist);
    }

    @Step("click on the top category '{topCategory}'")
    public void clickCategory(String topCategory)
    {
        $$("#navigation .navbar-header ul.nav li").findBy(exactText(topCategory)).click();
    }
    public ServicePage openServicePage(){
        clickCategory(Neodymium.localizedText("header.topNavigation.services.title"));
        return  new ServicePage().isExpectedPage();
    }

    public CareerPage openCareerPage(){
        clickCategory(Neodymium.localizedText("header.topNavigation.careers.title"));
        return  new CareerPage().isExpectedPage();
    }

    @Step("validate structure top navigation")
    public void validateStructure()
    {
               // Verifies the company Logo and name are visible.
        $("#navigation .navbar-brand a[title=Home]").shouldBe(visible);

        // Verifies the Navigation bar is visible
        $("#navigation .navbar-header ul.nav").shouldBe(visible);

        // Asserts there are categories in the nav bar.
        $$("#navigation .navbar-header ul.nav > li > a").shouldHave(sizeGreaterThan(0));

        // validate navigation texts
        categoriesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.services.title"))).shouldBe(visible);
        categoriesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.xlt.title"))).shouldBe(visible);
        categoriesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.news.title"))).shouldBe(visible);
        categoriesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.company.title"))).shouldBe(visible);
        categoriesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.careers.title"))).shouldBe(visible);
        categoriesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.contact.title"))).shouldBe(visible);
        categoriesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.blog.title"))).shouldBe(visible);


    }


}
