package com.edu.poli.tasks;

import com.edu.poli.questions.TextOfThe;
import com.edu.poli.userinterface.NewCustomerPage;
import com.edu.poli.userinterface.ManagerPage;
import com.edu.poli.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

public class CreateCustomer implements Task {

    private Map<String, String> customer;

    public CreateCustomer(Map<String, String> customer) {
        this.customer = customer;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ManagerPage.BUTTON_NEW_CUSTOMER, WebElementStateMatchers.isClickable()),
                Click.on(ManagerPage.BUTTON_NEW_CUSTOMER),
                WaitUntil.the(NewCustomerPage.NAME_FIELD, WebElementStateMatchers.isClickable()),
                Enter.theValue(customer.get("customerName")).into(NewCustomerPage.NAME_FIELD),
                Check.whether(customer.get("gender").equals("male"))
                        .andIfSo(Click.on(NewCustomerPage.MALE_FIELD))
                        .otherwise(Click.on(NewCustomerPage.FEMALE_FIELD)),
                Enter.theValue(customer.get("dateOfBirth")).into(NewCustomerPage.DATE_FIELD),
                Enter.theValue(customer.get("address")).into(NewCustomerPage.ADDRESS_FIELD),
                Enter.theValue(customer.get("city")).into(NewCustomerPage.CITY_FIELD),
                Enter.theValue(customer.get("state")).into(NewCustomerPage.STATE_FIELD),
                Enter.theValue(customer.get("pin")).into(NewCustomerPage.PIN_FIELD),
                Enter.theValue(customer.get("mobileNumber")).into(NewCustomerPage.TELEPHONE_FIELD),
                Enter.theValue(customer.get("email")).into(NewCustomerPage.EMAIL_FIELD),
                Enter.theValue(customer.get("password")).into(NewCustomerPage.PASS_FIELD),
                Click.on(NewCustomerPage.BUTTON_SAVE)
        );

        actor.attemptsTo(WaitUntil.the(NewCustomerPage.CUSTOMER_ID, WebElementStateMatchers.isCurrentlyVisible()));

        actor.remember("ID_CUSTOMER",actor.asksFor(TextOfThe.element(NewCustomerPage.CUSTOMER_ID)));

        Wait.inSeconds(2);

    }

    public static CreateCustomer withTheData(Map<String,String> customer){
        return Tasks.instrumented(CreateCustomer.class,customer);
    }
}
