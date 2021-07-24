package com.edu.poli.stepdefinitions;

import com.edu.poli.models.enums.User;
import com.edu.poli.questions.Recall;
import com.edu.poli.questions.TextOfThe;
import com.edu.poli.tasks.*;
import com.edu.poli.userinterface.NewAccountPage;
import com.edu.poli.userinterface.NewCustomerPage;
import com.edu.poli.utils.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CuentaUsuarioStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After(order = 0)
    public void deleteCustomer(){
        System.out.println("ID_CUSTOMER " + OnStage.theActorInTheSpotlight().recall("ID_CUSTOMER"));
        OnStage.theActorInTheSpotlight().attemptsTo(
                Check.whether(OnStage.theActorInTheSpotlight().recall("ID_CUSTOMER").toString().isEmpty())
                        .otherwise(DeleteCustomer.withID(OnStage.theActorInTheSpotlight().recall("ID_CUSTOMER").toString()))
        );
    }

    @After(order = 1)
    public void deleteAccount(){
        System.out.println("ID_ACCOUNT " + OnStage.theActorInTheSpotlight().recall("ID_ACCOUNT"));
        if (OnStage.theActorInTheSpotlight().recall("ID_ACCOUNT")!=null) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    DeleteAccount.withID(OnStage.theActorInTheSpotlight().recall("ID_ACCOUNT").toString())
            );
        }
    }

    @Dado("^que el (.*) esta en la pagina de administracion$")
    public void queElAdministradorEstaEnLaPaginaDeAdministracion(User actor) {
        OnStage.theActorCalled(actor.getName()).wasAbleTo(Open.browserOn().thePageNamed("home.page"));
        OnStage.theActorInTheSpotlight().attemptsTo(Authenticate.withTheUser(actor));
    }

    @Cuando("realiza la creacion la de cuenta del cliente")
    public void realizaLaCreacionLaDeCuentaDelCliente(Map<String,String> customerData) {
        OnStage.theActorInTheSpotlight().remember("CUSTOMER_DATA",customerData);
        OnStage.theActorInTheSpotlight().attemptsTo(CreateCustomer.withTheData(customerData));
    }

    @Entonces("el administrador ve la confirmacion de creacion de la cuenta")
    public void elAdministradorVeLaConfirmacionDeCreacionDeLaCuenta() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                TextOfThe.element(NewCustomerPage.USER_CREATION_MESSAGE),
                equalTo(Constants.CUSTOMER_CREATED)));
    }

    @Dado("realiza la creacion de una cuenta para el cliente creado")
    public void realizaLaCreacionDeUnaCuentaParaElClienteCreado(Map<String,String> accountData) {
        OnStage.theActorInTheSpotlight().remember("ACCOUNT_DATA",accountData);
        OnStage.theActorInTheSpotlight().attemptsTo(CreateAccount.withTheData(accountData));
    }

    @Entonces("el administrador ve la informacion creada de la cuenta")
    public void elAdministradorVeLaInformacionCreadaDeLaCuenta() {
        Map<String,String> customerData = OnStage.theActorInTheSpotlight().recall("CUSTOMER_DATA");
        Map<String,String> accountData = OnStage.theActorInTheSpotlight().recall("ACCOUNT_DATA");
        String CUSTOMER_ID = OnStage.theActorInTheSpotlight().recall("ID_CUSTOMER");
        OnStage.theActorInTheSpotlight().should(
                seeThat(TextOfThe.element(NewAccountPage.USER_CREATION_MESSAGE), equalTo(Constants.ACCOUNT_CREATED)),
                seeThat(TextOfThe.element(NewAccountPage.CUSTOMER_ID_TABLE), equalTo(CUSTOMER_ID)),
                seeThat(TextOfThe.element(NewAccountPage.CUSTOMER_NAME_TABLE), equalTo(customerData.get("customerName"))),
                seeThat(TextOfThe.element(NewAccountPage.EMAIL_TABLE), equalTo(customerData.get("email"))),
                seeThat(TextOfThe.element(NewAccountPage.ACCOUNT_TYPE_TABLE), equalTo(accountData.get("accountType"))),
                seeThat(TextOfThe.element(NewAccountPage.CURRENT_AMOUNT_TABLE), equalTo(accountData.get("initialDeposit")))
        );
    }

    @Dado("realiza la eliminacion de la cuenta creada")
    public void realizaLaEliminacionDeLaCuentaCreada() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                        DeleteAccount.withID(OnStage.theActorInTheSpotlight().recall("ID_ACCOUNT").toString())
        );
    }

    @Entonces("el administrador ve la alerta con el mensaje de confirmacion")
    public void elAdministradorVeLaAlertaConElMensajeDeConfirmacion() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Recall.string("ALERT_MESSAGE"), equalTo(Constants.ALERT_ACCOUNT_DELETED)));
    }
}
