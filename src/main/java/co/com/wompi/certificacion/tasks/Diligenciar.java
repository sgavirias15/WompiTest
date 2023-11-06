package co.com.wompi.certificacion.tasks;

import co.com.wompi.certificacion.models.WompiTestModel;
import net.bytebuddy.implementation.bind.annotation.This;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.LoggerFactory;

import java.util.List;

import static co.com.wompi.certificacion.userinterfaces.PageWompiTest.*;
import static co.com.wompi.certificacion.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Diligenciar implements Task {
    private String correo;
    private String nombresyapellidos;
    private String cel;
    private String tipotransaccion;

    public Diligenciar(List<WompiTestModel> data) {

        this.correo = data.get(0).getCorreo();
        this.nombresyapellidos = data.get(0).getNombresyapellidos();
        this.cel = data.get(0).getCel();
        this.tipotransaccion = data.get(0).getTipotransaccion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LoggerFactory.getLogger(This.class).info("SE DILIGENCIA LA INFORMACION REQUERIDA");
        actor.attemptsTo(WaitUntil.the(TXT_CORREO, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),

                Enter.theValue(correo).into(TXT_CORREO),
                Enter.theValue(nombresyapellidos).into(TXT_NOMB_Y_APELL),
                Enter.theValue(cel).into(TXT_CELULAR));


        switch (tipotransaccion) {
            case TRANSACCION_APROBADA:
                LoggerFactory.getLogger(This.class).info("\n----------SE SELECCIONA LA TRANSACCION DE APROBADO----------\n");
                actor.attemptsTo(WaitUntil.the(TX_APROBADO, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                        //Click.on(DRP_LST_TRANSACCION),
                        Click.on(TX_DECLINADO),
                        Click.on(TX_APROBADO));
                break;
            case TRANSACCION_DECLINADA:
                LoggerFactory.getLogger(This.class).info("\n----------SE SELECCIONA LA TRANSACCION DE DECLINADO----------\n");
                actor.attemptsTo(WaitUntil.the(TX_DECLINADO, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                        //Click.on(DRP_LST_TRANSACCION),
                        Click.on(TX_DECLINADO));
                break;
            case TRANSACCION_ERROR:
                LoggerFactory.getLogger(This.class).info("\n----------SE SELECCIONA LA TRANSACCION DE ERROR----------\n");
                actor.attemptsTo(WaitUntil.the(TX_ERROR, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                        //Click.on(DRP_LST_TRANSACCION),
                        Click.on(TX_ERROR));
                break;
            default:

                System.out.println("no existe");
        }
        actor.attemptsTo(WaitUntil.the(CHK_ACEPTO, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                Click.on(CHK_ACEPTO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                Click.on(BTN_CONTINUAR));
    }

    public static Diligenciar camposRequeridos(List<WompiTestModel> data) {
        return instrumented(Diligenciar.class, data);
    }
}

