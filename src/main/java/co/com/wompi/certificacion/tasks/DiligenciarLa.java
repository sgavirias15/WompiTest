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

public class DiligenciarLa implements Task {
    private String tipobanco;
    private String numdoc;

    public DiligenciarLa(List<WompiTestModel> data) {

        this.tipobanco = data.get(0).getTipobanco();
        this.numdoc = data.get(0).getNumdoc();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LoggerFactory.getLogger(This.class).info("SE DILIGENCIA LA INFORMACION BANCARIA REQUERIDA");
        switch (tipobanco) {
            case OPCION_APROBADO:
                LoggerFactory.getLogger(This.class).info("\n----------SE SELECCIONA LA OPCION DE APROBADO----------\n");
                actor.attemptsTo(WaitUntil.the(OPT_APROBADO, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                        Click.on(OPT_APROBADO));
                break;
            case OPCION_DECLINADO:
                LoggerFactory.getLogger(This.class).info("\n----------SE SELECCIONA LA OPCION DE DECLINADO----------\n");
                actor.attemptsTo(WaitUntil.the(OPT_DECLINADO, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                        Click.on(OPT_DECLINADO));
                break;
            case OPCION_ERROR:
                LoggerFactory.getLogger(This.class).info("\n----------SE SELECCIONA LA OPCION DE ERROR----------\n");
                actor.attemptsTo(WaitUntil.the(OPT_ERROR, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                        Click.on(OPT_ERROR));
                break;
            default:

                System.out.println("no existe");
        }
        actor.attemptsTo(WaitUntil.the(DRP_LST_TIPO_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                Click.on(DRP_LST_TIPO_DOCUMENTO),
                Click.on(OPT_TIPO_DOCUMENTO),
                Enter.theValue(numdoc).into(TXT_NUM_DOC),
                Click.on(CHK_ACEPTO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(TIEMPO).seconds(),
                Click.on(BTN_CONTINUAR));

    }

    public static DiligenciarLa informacionBancaria(List<WompiTestModel> data) {
        return instrumented(DiligenciarLa.class, data);
    }
}
