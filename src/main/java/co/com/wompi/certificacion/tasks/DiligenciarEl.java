package co.com.wompi.certificacion.tasks;

import co.com.wompi.certificacion.models.WompiTestModel;
import co.com.wompi.certificacion.utils.Constantes;
import net.bytebuddy.implementation.bind.annotation.This;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.LoggerFactory;

import java.util.List;

import static co.com.wompi.certificacion.userinterfaces.PageWompiTest.BTN_CONTINUAR;
import static co.com.wompi.certificacion.userinterfaces.PageWompiTest.TXT_MONTO_A_PAGAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DiligenciarEl implements Task {
    private String valormonto;

    public DiligenciarEl(List<WompiTestModel> data) {
        this.valormonto = data.get(0).getValormonto();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LoggerFactory.getLogger(This.class).info("SE DILIGENCIA EL MONTO");
        actor.attemptsTo(WaitUntil.the(TXT_MONTO_A_PAGAR, WebElementStateMatchers.isClickable()).forNoMoreThan(Constantes.TIEMPO).seconds(),
                Enter.theValue(valormonto).into(TXT_MONTO_A_PAGAR),
                Click.on(BTN_CONTINUAR));
    }

    public static DiligenciarEl montoAPagar(List<WompiTestModel> data) {
        return instrumented(DiligenciarEl.class, data);
    }
}
