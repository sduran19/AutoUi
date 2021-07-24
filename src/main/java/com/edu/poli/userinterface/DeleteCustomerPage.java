package com.edu.poli.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class DeleteCustomerPage {

    public static Target ID_CUSTOMER_FIELD = Target.the("").locatedBy("//table//form[@name='fbal']/following-sibling::tbody//input[@name='cusid']");
    public static Target BUTTON_SAVE = Target.the("").locatedBy("//table//form[@name='fbal']/following-sibling::tbody//input[@name='AccSubmit']");
}
