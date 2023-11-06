Feature: Yo como usuario pagador
  Quiero realizar una transaccion a un comercio en modo sandbox por medio de QR
  Donde pueda ver la transaccion realizada y se pueda validar sus estados (aprobado, declinado y error)

  Background:
    Given que el usuario se encuentra ubicado en la pagina de pagos wompi

  @EscenarioPagoAprobadoQR
  Scenario Outline: Se verifica el resultado aprobado luego de que un usuario realiza el proceso de pago por QR
    When el usuario diligencia el monto a pagar
      | valormonto   |
      | <valormonto> |
    And el usuario selecciona metodo de pago QR
    And el usuario ingresa la informacion requerida
      | correo   | nombresyapellidos   | cel   | tipotransaccion   |
      | <correo> | <nombresyapellidos> | <cel> | <tipotransaccion> |
    Then el usuario vera el mensaje: Transacción aprobada (QR Bancolombia)

    Examples:
      | valormonto | correo               | nombresyapellidos            | cel        | tipotransaccion      |
      | 100000     | notengo@gmail.com.co | Andres Alfonso Zapata Suarez | 3115254558 | Transacción APROBADA |

  @EscenarioPagoDeclinadoPSE
  Scenario Outline: Se verifica el resultado declinado luego de que un usuario realiza el proceso de pago por pse
    When el usuario diligencia el monto a pagar
      | valormonto   |
      | <valormonto> |
    And el usuario selecciona metodo de pago QR
    And el usuario ingresa la informacion requerida
      | correo   | nombresyapellidos   | cel   | tipotransaccion   |
      | <correo> | <nombresyapellidos> | <cel> | <tipotransaccion> |
    Then el usuario vera el mensaje: Transacción declinada (QR Bancolombia)

    Examples:
      | valormonto | correo               | nombresyapellidos            | cel        | tipotransaccion      |
      | 300000     | notengo@gmail.com.co | Andres Alfonso Zapata Suarez | 3115254558 | Transacción DECLINADA |

  @EscenarioPagoErrorPSE
  Scenario Outline: Se verifica el resultado error luego de que un usuario realiza el proceso de pago por pse
    When el usuario diligencia el monto a pagar
      | valormonto   |
      | <valormonto> |
    And el usuario selecciona metodo de pago QR
    And el usuario ingresa la informacion requerida
      | correo   | nombresyapellidos   | cel   | tipotransaccion   |
      | <correo> | <nombresyapellidos> | <cel> | <tipotransaccion> |
    Then el usuario vera el mensaje: Transacción con error (QR Bancolombia)

    Examples:
      | valormonto | correo               | nombresyapellidos            | cel        | tipotransaccion      |
      | 800000     | notengo@gmail.com.co | Andres Alfonso Zapata Suarez | 3115254558 | Transacción con ERROR |