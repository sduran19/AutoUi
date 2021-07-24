package com.edu.poli.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static Target ID_USER_FIELD = Target.the("Campo de ingreso ID usuario").locatedBy("//form[@name='frmLogin']//input[@name='uid']");
    public static Target PASSWORD_FIELD = Target.the("Campo de ingreso password usuario").locatedBy("//form[@name='frmLogin']//input[@name='password']");
    public static Target LOGIN_BUTTON = Target.the("Boton de inicio de sesion").locatedBy("//form[@name='frmLogin']//input[@name='btnLogin']");
}
