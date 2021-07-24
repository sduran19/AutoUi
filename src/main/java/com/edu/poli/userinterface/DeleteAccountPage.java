package com.edu.poli.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class DeleteAccountPage {

    public static Target ID_ACCOUNT_FIELD = Target.the("").locatedBy("//table//form[@name='fbal']/following-sibling::tbody//input[@name='accountno']");
    public static Target BUTTON_SAVE = Target.the("").locatedBy("//table//form[@name='fbal']/following-sibling::tbody//input[@name='AccSubmit']");
}
