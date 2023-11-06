package co.com.wompi.certificacion.questions;

import net.bytebuddy.implementation.bind.annotation.This;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.LoggerFactory;

import static co.com.wompi.certificacion.userinterfaces.PageWompiTest.TITULO_PSE_Y_TRANSACCION;
import static co.com.wompi.certificacion.utils.Constantes.TIEMPO;

public class ValidacionPseDel implements Question {


    @Override
    public Object answeredBy(Actor actor) {
        String resultado = "";
        LoggerFactory.getLogger(This.class).info("VERFICANDO MENSAJE");
        actor.attemptsTo(WaitUntil.the(TITULO_PSE_Y_TRANSACCION, WebElementStateMatchers.isVisible()).forNoMoreThan(TIEMPO).seconds());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
        }
        resultado = Text.of(TITULO_PSE_Y_TRANSACCION).viewedBy(actor).asString();
        return resultado;
    }

    public static ValidacionPseDel mensajeEsperado() {
        return new ValidacionPseDel();
    }
}
