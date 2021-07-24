package com.edu.poli.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class NewAccountPage {

    public static Target CUSTOMER_ID = Target.the("").locatedBy("//input[@name='cusid']");
    public static Target ACCOUNT_TYPE_LIST = Target.the("").locatedBy("//select[@name='selaccount']");
    public static Target OPTION_ACCOUNT_TYPE = Target.the("").locatedBy("//select[@name='selaccount']//option[contains(text(),'{0}')]");
    public static Target INIT_DEPOSIT = Target.the("").locatedBy("//input[@name='inideposit']");
    public static Target BUTTON_SAVE = Target.the("").locatedBy("//input[@name='button2']");

    public static Target ACCOUND_ID_CREATED = Target.the("").locatedBy("//tr//td[contains(text(),'Account ID')]/following-sibling::td");
    public static Target USER_CREATION_MESSAGE = Target.the("").locatedBy("//table[@id='account']//p[@class='heading3']");

    public static Target CUSTOMER_ID_TABLE = Target.the("").locatedBy("//td[contains(text(),'Customer ID')]/following-sibling::td");
    public static Target CUSTOMER_NAME_TABLE = Target.the("").locatedBy("//td[contains(text(),'Customer Name')]/following-sibling::td");
    public static Target EMAIL_TABLE = Target.the("").locatedBy("//td[contains(text(),'Email')]/following-sibling::td");
    public static Target ACCOUNT_TYPE_TABLE = Target.the("").locatedBy("//td[contains(text(),'Account Type')]/following-sibling::td");
    public static Target CURRENT_AMOUNT_TABLE = Target.the("").locatedBy("//td[contains(text(),'Current Amount')]/following-sibling::td");
}
