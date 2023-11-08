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

    private SelenideElement categoryMenu = $(".navbar-header");
    private ElementsCollection caterogiesElementCollection = $$("#navigation .navbar-header ul.nav > li > a");
    private ElementsCollection subCaterogiesElementCollection = $$("#sub-navigation .navbar a");
    @Override
    public void isComponentAvailable() {
        categoryMenu.should(exist);
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
        caterogiesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.services.title"))).shouldBe(visible);
        caterogiesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.xlt.title"))).shouldBe(visible);
        caterogiesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.news.title"))).shouldBe(visible);
        caterogiesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.company.title"))).shouldBe(visible);
        caterogiesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.careers.title"))).shouldBe(visible);
        caterogiesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.contact.title"))).shouldBe(visible);
        caterogiesElementCollection.findBy(exactText(Neodymium.localizedText("header.topNavigation.blog.title"))).shouldBe(visible);


    }
    @Step("validate sub category ")
    public void validateSubCategory()
    {
        // Asserts there are subcategories in the nav bar.
        subCaterogiesElementCollection.shouldHave(sizeGreaterThan(0));

        // validate subcategory texts
        subCaterogiesElementCollection.findBy(exactText(Neodymium.localizedText("header.subNavigation.1.title"))).shouldBe(visible);
        subCaterogiesElementCollection.findBy(exactText(Neodymium.localizedText("header.subNavigation.2.title"))).shouldBe(visible);
    }

}
