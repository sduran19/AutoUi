package com.edu.poli.tasks;

import com.edu.poli.models.enums.User;
import com.edu.poli.questions.TextOfThe;
import com.edu.poli.userinterface.LoginPage;
import com.edu.poli.userinterface.ManagerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Authenticate implements Task {

    private User user;

    public Authenticate(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.ID_USER_FIELD, WebElementStateMatchers.isClickable()),
                Enter.theValue(user.getId()).into(LoginPage.ID_USER_FIELD),
                Enter.theValue(user.getPassword()).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );

        String idUser = actor.asksFor(TextOfThe.element(ManagerPage.MESSAGE_MANAGER_ID));
        System.out.println("ID USER LOGIN: " + idUser);

        actor.attemptsTo(Ensure.that(idUser).contains(user.getId()));
    }

    public static Authenticate withTheUser(User user){
        return Tasks.instrumented(Authenticate.class, user);
    }
}
