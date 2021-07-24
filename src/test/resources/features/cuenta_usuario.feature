# language: es
Característica: El usuario requiere un portal de gestion de los usuarios y sus cuentas del Banco

  @CreateClient
  Escenario: Generar cliente
    Dado que el ADMINISTRADOR esta en la pagina de administracion
    Cuando realiza la creacion la de cuenta del cliente
      | customerName | Nombre Apellido         |
      | gender       | male                    |
      | dateOfBirth  | 19/02/1996              |
      | address      | Direccion               |
      | city         | Virginia                |
      | state        | Virginia                |
      | pin          | 123456                  |
      | mobileNumber | 3113123125              |
      | email        | test-test0111@correo.com |
      | password     | Contra123               |
    Entonces el administrador ve la confirmacion de creacion de la cuenta

  @CreateAccount
  Escenario: Generar cuenta del cliente
    Dado que el ADMINISTRADOR esta en la pagina de administracion
    Cuando realiza la creacion la de cuenta del cliente
      | customerName | Nombre Apellido         |
      | gender       | male                    |
      | dateOfBirth  | 19/02/1996              |
      | address      | Direccion               |
      | city         | Virginia                |
      | state        | Virginia                |
      | pin          | 123456                  |
      | mobileNumber | 3113123125              |
      | email        | test-test022@correo.com |
      | password     | Contra123               |
    Y realiza la creacion de una cuenta para el cliente creado
      | accountType    | Current |
      | initialDeposit | 600     |
    Entonces el administrador ve la informacion creada de la cuenta

  @DeleteAccount
  Escenario: Eliminar cuenta del cliente
    Dado que el ADMINISTRADOR esta en la pagina de administracion
    Cuando realiza la creacion la de cuenta del cliente
      | customerName | Nombre Apellido         |
      | gender       | male                    |
      | dateOfBirth  | 19/02/1996              |
      | address      | Direccion               |
      | city         | Virginia                |
      | state        | Virginia                |
      | pin          | 123456                  |
      | mobileNumber | 3113123125              |
      | email        | test-test033@correo.com |
      | password     | Contra123               |
    Y realiza la creacion de una cuenta para el cliente creado
      | accountType    | Current |
      | initialDeposit | 600     |
    Y realiza la eliminacion de la cuenta creada
    Entonces el administrador ve la alerta con el mensaje de confirmacion