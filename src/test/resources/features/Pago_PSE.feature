Feature: Yo como usuario pagador
  Quiero realizar una transaccion a un comercio en modo sandbox por medio de PSE
  Donde pueda ver la transaccion realizada y se pueda validar sus estados (aprobado, declinado y error)

  Background:
    Given que el usuario se encuentra ubicado en la pagina de pagos wompi

  @EscenarioPagoAprobadoPSE
  Scenario Outline: Se verifica el resultado aprobado luego de que un usuario realiza el proceso de pago por pse
    When el usuario diligencia el monto a pagar
      | valormonto   |
      | <valormonto> |
    And el usuario selecciona metodo de pago pse
    And el usuario ingresa la informacion personal requerida
      | correo   | nombresyapellidos   | cel   |
      | <correo> | <nombresyapellidos> | <cel> |
    And el usuario ingresa la informacion bancaria requerida
      | tipobanco   | numdoc   |
      | <tipobanco> | <numdoc> |
    Then el usuario vera el siguiente mensaje: Transacción aprobada (PSE)

    Examples:
      | valormonto | correo               | nombresyapellidos            | cel        | tipobanco         | numdoc     |
      | 100000     | notengo@gmail.com.co | Andres Alfonso Zapata Suarez | 3115254558 | Banco que aprueba | 1123332234 |

  @EscenarioPagoDeclinadoPSE
  Scenario Outline: Se verifica el resultado declinado luego de que un usuario realiza el proceso de pago por pse
    When el usuario diligencia el monto a pagar
      | valormonto   |
      | <valormonto> |
    And el usuario selecciona metodo de pago pse
    And el usuario ingresa la informacion personal requerida
      | correo   | nombresyapellidos   | cel   |
      | <correo> | <nombresyapellidos> | <cel> |
    And el usuario ingresa la informacion bancaria requerida
      | tipobanco   | numdoc   |
      | <tipobanco> | <numdoc> |
    Then el usuario vera el siguiente mensaje: Transacción declinada (PSE)

    Examples:
      | valormonto | correo               | nombresyapellidos            | cel        | tipobanco         | numdoc     |
      | 500000     | notengo@gmail.com.co | Andres Alfonso Zapata Suarez | 3115254558 | Banco que declina | 1123332234 |

  @EscenarioPagoErrorPSE
  Scenario Outline: Se verifica el resultado error luego de que un usuario realiza el proceso de pago por pse
    When el usuario diligencia el monto a pagar
      | valormonto   |
      | <valormonto> |
    And el usuario selecciona metodo de pago pse
    And el usuario ingresa la informacion personal requerida
      | correo   | nombresyapellidos   | cel   |
      | <correo> | <nombresyapellidos> | <cel> |
    And el usuario ingresa la informacion bancaria requerida
      | tipobanco   | numdoc   |
      | <tipobanco> | <numdoc> |
    Then el usuario vera el siguiente mensaje de error: Transacción con error (PSE)

    Examples:
      | valormonto | correo               | nombresyapellidos            | cel        | tipobanco                 | numdoc     |
      | 800000     | notengo@gmail.com.co | Andres Alfonso Zapata Suarez | 3115254558 | Banco que simula un error | 1123332234 |