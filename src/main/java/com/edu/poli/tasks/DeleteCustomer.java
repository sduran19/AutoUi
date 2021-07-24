package com.edu.poli.tasks;

import com.edu.poli.interactions.PopUpAlert;
import com.edu.poli.userinterface.DeleteCustomerPage;
import com.edu.poli.userinterface.ManagerPage;
import com.edu.poli.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class DeleteCustomer implements Task {

    private String idCustomer;

    public DeleteCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ManagerPage.BUTTON_DELETE_CUSTOMER, WebElementStateMatchers.isClickable()),
                Click.on(ManagerPage.BUTTON_DELETE_CUSTOMER),
                WaitUntil.the(DeleteCustomerPage.ID_CUSTOMER_FIELD, WebElementStateMatchers.isClickable()),
                Enter.theValue(idCustomer).into(DeleteCustomerPage.ID_CUSTOMER_FIELD),
                Click.on(DeleteCustomerPage.BUTTON_SAVE),
                PopUpAlert.ok(),
                PopUpAlert.ok()
        );
        Wait.inSeconds(2);
    }

    public static DeleteCustomer withID(String id){
        return Tasks.instrumented(DeleteCustomer.class,id);
    }
}
