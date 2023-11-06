package co.com.wompi.certificacion.tasks;

import co.com.wompi.certificacion.utils.Constantes;
import net.bytebuddy.implementation.bind.annotation.This;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.LoggerFactory;

import static co.com.wompi.certificacion.userinterfaces.PageWompiTest.BTN_PSE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DarClickAl implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        LoggerFactory.getLogger(This.class).info("SE DA CLICK AL MEDIO DE PAGO PSE");
        actor.attemptsTo(WaitUntil.the(BTN_PSE, WebElementStateMatchers.isClickable()).forNoMoreThan(Constantes.TIEMPO).seconds(),
                Click.on(BTN_PSE));
    }

    public static DarClickAl medioDePagoPse() {
        return instrumented(DarClickAl.class);
    }
}
