package com.edu.poli.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class NewCustomerPage {

    public static Target NAME_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@name='name']");
    public static Target MALE_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@value='m']");
    public static Target FEMALE_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@value='f']");
    public static Target DATE_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@id='dob']");
    public static Target ADDRESS_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//textarea[@name='addr']");
    public static Target CITY_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@name='city']");
    public static Target STATE_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@name='state']");
    public static Target PIN_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@name='pinno']");
    public static Target TELEPHONE_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@name='telephoneno']");
    public static Target EMAIL_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@name='emailid']");
    public static Target PASS_FIELD = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@name='password']");
    public static Target BUTTON_SAVE = Target.the("").locatedBy("//table//form[@name=\"addcust\"]/following-sibling::tbody//input[@name='sub']");

    public static Target CUSTOMER_ID = Target.the("").locatedBy("//tr//td[contains(text(),'Customer ID')]/following-sibling::td");
    public static Target USER_CREATION_MESSAGE = Target.the("").locatedBy("//table[@id='customer']//p[@class='heading3']");

}





