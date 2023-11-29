package template.pageobjects.components.website;

import com.xceptance.neodymium.util.Neodymium;
import template.pageobjects.components.AbstractComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Footer extends AbstractComponent
{
    // private SelenideElement footer = $("footer");
    // private ElementsCollection addressesElementCollection = $$("#addresses h3");
    // private ElementsCollection emailElementCollection = $$("#addresses .email");
    // private ElementsCollection telefonElementCollection = $$("#addresses .tel");
    // private ElementsCollection footerInformationElementCollection = $$("#footer-information div ul li a");
    // private ElementsCollection newsElementCollection = $$("#news-section p a");

    @Override
    public void isComponentAvailable()
    {
        var footer = $("footer");
        footer.should(exist);

    }

    public void validateStructure()
    {
        var addressesContainer = $("#addresses");
        var footerInformationContainer = $("#footer-information");
        var newsSectionContainer = $("#news-section");

        // Verifies the company addresses in footer section are there.
        // $$("#addresses h3").shouldHave(sizeGreaterThan(0));
        $$(addressesContainer.getSearchCriteria() + " h3").shouldHaveSize(2);

        // Verifies the company emails in footer section are there.
        // $$("#addresses .email").shouldHave(sizeGreaterThan(0));
        $$(addressesContainer.getSearchCriteria() + " .email").shouldHaveSize(2);

        // Verifies the company phone numbers in footer section are there.
        // $$("#addresses .tel").shouldHave(sizeGreaterThan(0));
        $$(addressesContainer.getSearchCriteria() + " .tel").shouldHaveSize(2);

        // Verifies the footer links section is there.
        // $$("#footer-information div ul li a").shouldHave(sizeGreaterThan(0));
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").shouldHaveSize(11);

        // Verifies the footer news section is there.
        // $$("#news-section h3").shouldHave(sizeGreaterThan(0));
        $$(newsSectionContainer.getSearchCriteria() + " h3").shouldHaveSize(1);
        // $$("#news-section p a").shouldHave(sizeGreaterThan(0));
        $$(newsSectionContainer.getSearchCriteria() + " p a").shouldHaveSize(3);

        // validate footer texts

        // $$(addressesContainer.getSearchCriteria() +" h3"
        // ).findBy(exactText(Neodymium.localizedText("footer.address.germany"))).shouldBe(visible);
        $$(addressesContainer.getSearchCriteria() + " h3").findBy(exactText(Neodymium.localizedText("footer.address.germany"))).shouldBe(visible);
        $$(addressesContainer.getSearchCriteria() + " h3").findBy(exactText(Neodymium.localizedText("footer.address.usa"))).shouldBe(visible);
        $$(addressesContainer.getSearchCriteria() + " .email").findBy(exactText(Neodymium.localizedText("footer.email.germany"))).shouldBe(visible);
        $$(addressesContainer.getSearchCriteria() + " .email").findBy(exactText(Neodymium.localizedText("footer.email.usa"))).shouldBe(visible);
        $$(addressesContainer.getSearchCriteria() + " .tel").findBy(exactText(Neodymium.localizedText("footer.tel.germany"))).shouldBe(visible);
        $$(addressesContainer.getSearchCriteria() + " .tel").findBy(exactText(Neodymium.localizedText("footer.tel.usa"))).shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.aboutUs")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.contact")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.services")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.xlt")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.references")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.privacy")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.blog")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.xing")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.linkedin")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.twitter")))
                                                                           .shouldBe(visible);
        $$(footerInformationContainer.getSearchCriteria() + " div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.github")))
                                                                           .shouldBe(visible);
        $$(newsSectionContainer.getSearchCriteria() + " h3").findBy(exactText(Neodymium.localizedText("footer.newsTexts.latestNews"))).shouldBe(visible);
        $$(newsSectionContainer.getSearchCriteria() + " p a").findBy(exactText(Neodymium.localizedText("footer.newsTexts.latestNews1"))).shouldBe(visible);
        $$(newsSectionContainer.getSearchCriteria() + " p a").findBy(exactText(Neodymium.localizedText("footer.newsTexts.latestNews2"))).shouldBe(visible);
        $$(newsSectionContainer.getSearchCriteria() + " p a").findBy(exactText(Neodymium.localizedText("footer.newsTexts.latestNews3"))).shouldBe(visible);

    }
}
