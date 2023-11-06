package co.com.wompi.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageWompiTest {
    public static final Target TXT_MONTO_A_PAGAR = Target.the("Campo de monto a pagar")
            .located(By.xpath("//*[@class='amount-input']"));
    public static final Target BTN_CONTINUAR = Target.the("Botón Continuar")
            .located(By.xpath("//*[contains(text(),'Continuar')]"));
    public static final Target BTN_PSE = Target.the("Medio de pago PSE")
            .located(By.xpath("//*[contains(text(),'cuenta de ahorros o corriente')]"));
    public static final Target TXT_CORREO = Target.the("Campo Correo")
            .located(By.id("email"));
    public static final Target TXT_NOMB_Y_APELL = Target.the("Campo Nombres y apellidos")
            .located(By.id("fullName"));
    public static final Target TXT_CELULAR = Target.the("Campo Celular")
            .located(By.id("number"));
    public static final Target OPT_APROBADO = Target.the("Opcion que aprueba")
            .located(By.xpath("//*[contains(text(),'Banco que aprueba')]"));
    public static final Target OPT_DECLINADO = Target.the("Opcion que declina")
            .located(By.xpath("//*[contains(text(),'Banco que declina')]"));
    public static final Target OPT_ERROR = Target.the("Opcion de error")
            .located(By.xpath("//*[contains(text(),'Banco que simula un error')]"));
    public static final Target DRP_LST_TIPO_DOCUMENTO = Target.the("Desplegable Tipo de documento")
            .located(By.id("userLegalIdType"));
    public static final Target OPT_TIPO_DOCUMENTO = Target.the("Desplegable Tipo de documento")
            .located(By.xpath("//*[contains(text(),'CC')]"));
    public static final Target TXT_NUM_DOC = Target.the("Campo Numero de documento")
            .located(By.id("userLegalId"));
    public static final Target CHK_ACEPTO = Target.the("Check Acepto haber leido los reglamentos")
            .located(By.id("acceptance"));
    public static final Target TITULO_PSE_Y_TRANSACCION = Target.the("Titulo PSE y Transaccion")
            .located(By.xpath("//*[@class='title__-7har']"));
    public static final Target TITULO_PSE_Y_TRANSACCION_DE_ERROR = Target.the("Titulo PSE y Transaccion de error")
            .located(By.xpath("//*[@class='src-components-App-__App__title__Y13rn']"));

    public static final Target BTN_QR = Target.the("Medio de pago QR")
            .located(By.xpath("//*[contains(text(),'Paga con QR')]"));
    public static final Target TX_APROBADO = Target.the("Transaccion que aprueba")
            .located(By.xpath("//*[contains(text(),'APROBADA')]"));
    public static final Target TX_DECLINADO = Target.the("Transaccion que declina")
            .located(By.xpath("//*[contains(text(),'DECLINADA')]"));
    public static final Target TX_ERROR = Target.the("Transaccion con error")
            .located(By.xpath("//*[contains(text(),'ERROR')]"));
    public static final Target TITULO_QR = Target.the("Titulo QR")
            .located(By.xpath("//*[@class='src-components-App-__App__title__Y13rn']"));

    public static final Target BTN_TRANSFERENCIA = Target.the("Medio de pago Transferencia")
            .located(By.xpath("//*[contains(text(),'Transfiere con tu cuenta')]"));


    private PageWompiTest() {
    }
}
