package com.edu.poli.tasks;

import com.edu.poli.questions.TextOfThe;
import com.edu.poli.userinterface.ManagerPage;
import com.edu.poli.userinterface.NewAccountPage;
import com.edu.poli.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

public class CreateAccount implements Task {

    private Map<String,String> accountData;

    public CreateAccount(Map<String, String> accountData) {
        this.accountData = accountData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ManagerPage.BUTTON_NEW_ACCOUNT, WebElementStateMatchers.isClickable()),
                Click.on(ManagerPage.BUTTON_NEW_ACCOUNT),
                WaitUntil.the(NewAccountPage.CUSTOMER_ID, WebElementStateMatchers.isClickable()),
                Enter.theValue(actor.recall("ID_CUSTOMER").toString()).into(NewAccountPage.CUSTOMER_ID),
                Click.on(NewAccountPage.ACCOUNT_TYPE_LIST),
                Click.on(NewAccountPage.OPTION_ACCOUNT_TYPE.of(accountData.get("accountType"))),
                Enter.theValue(accountData.get("initialDeposit")).into(NewAccountPage.INIT_DEPOSIT),
                Click.on(NewAccountPage.BUTTON_SAVE)
        );

        actor.attemptsTo(WaitUntil.the(NewAccountPage.ACCOUND_ID_CREATED, WebElementStateMatchers.isCurrentlyVisible()));

        actor.remember("ID_ACCOUNT",actor.asksFor(TextOfThe.element(NewAccountPage.ACCOUND_ID_CREATED)));

        Wait.inSeconds(2);
    }

    public static CreateAccount withTheData(Map<String,String> accountData){
        return Tasks.instrumented(CreateAccount.class, accountData);
    }
}
