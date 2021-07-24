package com.edu.poli.tasks;

import com.edu.poli.interactions.PopUpAlert;
import com.edu.poli.userinterface.DeleteAccountPage;
import com.edu.poli.userinterface.ManagerPage;
import com.edu.poli.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class DeleteAccount implements Task {

    private String idAccount;

    public DeleteAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ManagerPage.BUTTON_DELETE_ACCOUNT, WebElementStateMatchers.isClickable()),
                Click.on(ManagerPage.BUTTON_DELETE_ACCOUNT),
                WaitUntil.the(ManagerPage.BUTTON_DELETE_CUSTOMER, WebElementStateMatchers.isClickable()),
                Enter.theValue(idAccount).into(DeleteAccountPage.ID_ACCOUNT_FIELD),
                Click.on(DeleteAccountPage.BUTTON_SAVE),
                PopUpAlert.ok(),
                PopUpAlert.ok()
        );
        Wait.inSeconds(2);
    }

    public static DeleteAccount withID(String id){
        return Tasks.instrumented(DeleteAccount.class,id);
    }
}

