package template.pageobjects.components;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Neodymium;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Footer extends AbstractComponent{
    private SelenideElement footer = $("footer");
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
        $$("#addresses h3").findBy(exactText(Neodymium.localizedText("footer.address.germany"))).shouldBe(visible);
        $$("#addresses h3").findBy(exactText(Neodymium.localizedText("footer.address.usa"))).shouldBe(visible);
        $$("#addresses .email").findBy(exactText(Neodymium.localizedText("footer.email.germany"))).shouldBe(visible);
        $$("#addresses .email").findBy(exactText(Neodymium.localizedText("footer.email.usa"))).shouldBe(visible);
        $$("#addresses .tel").findBy(exactText(Neodymium.localizedText("footer.tel.germany"))).shouldBe(visible);
        $$("#addresses .tel").findBy(exactText(Neodymium.localizedText("footer.tel.usa"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.1"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.2"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.3"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.4"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.5"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.6"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.7"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.8"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.9"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.10"))).shouldBe(visible);
        $$("#footer-information div ul li a").findBy(exactText(Neodymium.localizedText("footer.linkTexts.11"))).shouldBe(visible);
        $$("#news-section h3").findBy(exactText(Neodymium.localizedText("footer.newsTexts.1"))).shouldBe(visible);
        $$("#news-section p a").findBy(exactText(Neodymium.localizedText("footer.newsTexts.2"))).shouldBe(visible);
        $$("#news-section p a").findBy(exactText(Neodymium.localizedText("footer.newsTexts.3"))).shouldBe(visible);
        $$("#news-section p a").findBy(exactText(Neodymium.localizedText("footer.newsTexts.4"))).shouldBe(visible);
    }
}
