package co.com.wompi.certificacion.tasks;

import co.com.wompi.certificacion.utils.Constantes;
import net.bytebuddy.implementation.bind.annotation.This;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.LoggerFactory;

import static co.com.wompi.certificacion.userinterfaces.PageWompiTest.BTN_QR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DarClickEn implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        LoggerFactory.getLogger(This.class).info("SE DA CLICK AL MEDIO DE PAGO QR");
        actor.attemptsTo(WaitUntil.the(BTN_QR, WebElementStateMatchers.isClickable()).forNoMoreThan(Constantes.TIEMPO).seconds(),
                Click.on(BTN_QR));
    }

    public static DarClickEn medioDePagoQR() {
        return instrumented(DarClickEn.class);
    }
}
