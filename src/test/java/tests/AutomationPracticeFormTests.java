package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));


        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("ivan@ivanov.com");

//        $("[id=gender-radio-2]").parent().click();
//        $(byText("Other")).click();
        $("#genterWrapper").$(byText("Other")).click();
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
//        $(".react-datepicker__month-select").selectOptionByValue("6");

        $("[id=userNumber]").setValue("1234567890");



        $("[id=currentAddress]").setValue("true address");


        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("ivan ivanov"));
        $("[id=output] [id=email]").shouldHave(text("ivan@ivanov.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("true address"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("very true address"));
    }

}
