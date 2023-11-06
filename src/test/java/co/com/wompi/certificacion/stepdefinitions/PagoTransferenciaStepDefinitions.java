package co.com.wompi.certificacion.stepdefinitions;

import co.com.wompi.certificacion.models.WompiTestModel;
import co.com.wompi.certificacion.tasks.DarClick;
import co.com.wompi.certificacion.tasks.LlenarLa;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class PagoTransferenciaStepDefinitions {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Certifier");
    }

    @And("^el usuario selecciona metodo de pago Transferencia$")
    public void elUsuarioSeleccionaMetodoDePagoTransferencia() {
        OnStage.theActorInTheSpotlight().attemptsTo(DarClick.medioDePagoTranferencia());
    }

    @And("^el usuario ingresa informacion bancaria requerida$")
    public void elUsuarioIngresaInformacionBancariaRequerida(List<WompiTestModel> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(LlenarLa.informacionBancaria(data));
    }
}