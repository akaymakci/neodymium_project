package template.pageobjects.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Footer extends AbstractComponent{
    private SelenideElement footer = $("footer");
    private ElementsCollection addressesElementCollection = $$("#addresses h3");
    private ElementsCollection emailElementCollection = $$("#addresses .email");
    private ElementsCollection telefonElementCollection = $$("#addresses .tel");
    private ElementsCollection footerInformationElementCollection = $$("#footer-information div ul li a");
    private ElementsCollection newsElementCollection = $$("#news-section p a");

    @Override
    public void isComponentAvailable() {
        footer.should(exist);
    }
    public void validateStructure()
    {
        // Verifies the company addresses in footer section are there.
        $$("#addresses h3").shouldHave(sizeGreaterThan(0));

        // Verifies the company emails in footer section are there.
        $$("#addresses .email").shouldHave(sizeGreaterThan(0));

        // Verifies the company phone numbers in footer section are there.
        $$("#addresses .tel").shouldHave(sizeGreaterThan(0));

        // Verifies the footer links section is there.
        $$("#footer-information div ul li a").shouldHave(sizeGreaterThan(0));

        // Verifies the footer news section is there.
        $$("#news-section h3").shouldHave(sizeGreaterThan(0));
        $$("#news-section p a").shouldHave(sizeGreaterThan(0));

        // validate footer texts
        addressesElementCollection.findBy(exactText(Neodymium.localizedText("footer.address.germany"))).shouldBe(visible);
        addressesElementCollection.findBy(exactText(Neodymium.localizedText("footer.address.usa"))).shouldBe(visible);
        emailElementCollection.findBy(exactText(Neodymium.localizedText("footer.email.germany"))).shouldBe(visible);
        emailElementCollection.findBy(exactText(Neodymium.localizedText("footer.email.usa"))).shouldBe(visible);
        telefonElementCollection.findBy(exactText(Neodymium.localizedText("footer.tel.germany"))).shouldBe(visible);
        telefonElementCollection.findBy(exactText(Neodymium.localizedText("footer.tel.usa"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.aboutUs"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.contact"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.services"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.xlt"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.references"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.privacy"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.blog"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.xing"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.linkedin"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.twitter"))).shouldBe(visible);
        footerInformationElementCollection.findBy(exactText(Neodymium.localizedText("footer.linkTexts.github"))).shouldBe(visible);
        $$("#news-section h3").findBy(exactText(Neodymium.localizedText("footer.newsTexts.latestNews"))).shouldBe(visible);
        newsElementCollection.findBy(exactText(Neodymium.localizedText("footer.newsTexts.latestNews1"))).shouldBe(visible);
        newsElementCollection.findBy(exactText(Neodymium.localizedText("footer.newsTexts.latestNews2"))).shouldBe(visible);
        newsElementCollection.findBy(exactText(Neodymium.localizedText("footer.newsTexts.latestNews3"))).shouldBe(visible);
    }
}
