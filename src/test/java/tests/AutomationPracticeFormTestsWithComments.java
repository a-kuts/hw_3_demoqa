package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTestsWithComments extends TestBase {

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
        $("[id=userNumber]").setValue("1234567890");

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOption("2008");
//        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("[id=subjectsInput]").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("[id=currentAddress]").setValue("true address");
        $("[id=state]").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("[id=city]").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanov"), text("ivan@ivanov.com"), text("true address"));
    }

}
