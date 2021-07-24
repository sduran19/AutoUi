package com.edu.poli.interactions;

import com.edu.poli.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class PopUpAlert implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Alert alert = driver.switchTo().alert();

        Wait.inSeconds(2);
        actor.remember("ALERT_MESSAGE",alert.getText());
        alert.accept();
    }

    public static PopUpAlert ok(){
        return Tasks.instrumented(PopUpAlert.class);
    }
}
