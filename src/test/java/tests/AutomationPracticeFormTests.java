package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("ivan@ivanov.com");
        $("[id=gender-radio-1]").setValue("Male");
 //       $("[id=gender-radio-2]").setValue("true address");
//        $("[id=gender-radio-3]").setValue("true address");
        $("[id=userNumber]").setValue("1234567890");
        $("[id=dateOfBirthInput]").setValue("05 Mar 2026");
        $("[id=subjectsInput]").setValue("true info");

//        $("[id=hobbies-checkbox-1]").setValue("1");
        $("[id=hobbies-checkbox-2]").setValue("2");
        $("[id=hobbies-checkbox-3]").setValue("3");
 //       $("[id=uploadePicture]").setValue("true address");

        $("[id=currentAddress]").setValue("true address");

        $("[id=react-select-3-live-region]").setValue("Uttar Pradesh");
        $("[id=react-select-4-live-region]").setValue("Agra");

        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("ivan ivanov"));
        $("[id=output] [id=email]").shouldHave(text("ivan@ivanov.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("true address"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("very true address"));
    }

}
