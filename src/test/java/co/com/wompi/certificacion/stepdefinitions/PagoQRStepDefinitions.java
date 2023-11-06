package co.com.wompi.certificacion.stepdefinitions;

import co.com.wompi.certificacion.models.WompiTestModel;
import co.com.wompi.certificacion.questions.ValidacionQrDel;
import co.com.wompi.certificacion.tasks.DarClickEn;
import co.com.wompi.certificacion.tasks.Diligenciar;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoQRStepDefinitions {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Certifier");
    }


    @And("^el usuario selecciona metodo de pago QR$")
    public void elUsuarioSeleccionaMetodoDePagoQr() {
        OnStage.theActorInTheSpotlight().attemptsTo(DarClickEn.medioDePagoQR());
    }

    @And("^el usuario ingresa la informacion requerida$")
    public void elUsuarioIngresaLaInformacionRequerida(List<WompiTestModel> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Diligenciar.camposRequeridos(data));
    }

    @Then("^el usuario vera el mensaje: (.*)$")
    public void ElUsuarioVeraElMensaje(String mensaje) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidacionQrDel.mensajeEsperado(), Matchers.containsString(mensaje)));
    }
}