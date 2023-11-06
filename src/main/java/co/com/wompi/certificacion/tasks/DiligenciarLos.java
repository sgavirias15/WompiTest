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

import static co.com.wompi.certificacion.userinterfaces.PageWompiTest.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DiligenciarLos implements Task {
    private String correo;
    private String nombresyapellidos;
    private String cel;


    public DiligenciarLos(List<WompiTestModel> data) {

        this.correo = data.get(0).getCorreo();
        this.nombresyapellidos = data.get(0).getNombresyapellidos();
        this.cel = data.get(0).getCel();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LoggerFactory.getLogger(This.class).info("SE DILIGENCIA LA INFORMACION PERSONAL REQUERIDA");
        actor.attemptsTo(WaitUntil.the(TXT_CORREO, WebElementStateMatchers.isClickable()).forNoMoreThan(Constantes.TIEMPO).seconds(),
                Enter.theValue(correo).into(TXT_CORREO),
                Enter.theValue(nombresyapellidos).into(TXT_NOMB_Y_APELL),
                Enter.theValue(cel).into(TXT_CELULAR),
                Click.on(BTN_CONTINUAR)
        );
    }

    public static DiligenciarLos camposRequeridosPersonales(List<WompiTestModel> data) {
        return instrumented(DiligenciarLos.class, data);
    }
}
