package com.edu.poli.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ManagerPage {

    public static Target MESSAGE_MANAGER_ID = Target.the("").locatedBy("//tr[@class='heading3']//td");
    public static Target BUTTON_NEW_CUSTOMER = Target.the("").locatedBy("//ul[@class='menusubnav']//a[contains(text(),'New Customer')]");
    public static Target BUTTON_DELETE_CUSTOMER = Target.the("").locatedBy("//ul[@class='menusubnav']//a[contains(text(),'Delete Customer')]");
    public static Target BUTTON_NEW_ACCOUNT = Target.the("").locatedBy("//ul[@class='menusubnav']//a[contains(text(),'New Account')]");
    public static Target BUTTON_DELETE_ACCOUNT = Target.the("").locatedBy("//ul[@class='menusubnav']//a[contains(text(),'Delete Account')]");
}
