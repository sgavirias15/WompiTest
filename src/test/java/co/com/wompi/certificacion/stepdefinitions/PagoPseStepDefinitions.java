package co.com.wompi.certificacion.stepdefinitions;

import co.com.wompi.certificacion.models.WompiTestModel;
import co.com.wompi.certificacion.questions.ValidacionPseDe;
import co.com.wompi.certificacion.questions.ValidacionPseDel;
import co.com.wompi.certificacion.tasks.DarClickAl;
import co.com.wompi.certificacion.tasks.DiligenciarEl;
import co.com.wompi.certificacion.tasks.DiligenciarLa;
import co.com.wompi.certificacion.tasks.DiligenciarLos;
import co.com.wompi.certificacion.utils.Constantes;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoPseStepDefinitions {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Certifier");
    }

    @Given("^que el usuario se encuentra ubicado en la pagina de pagos wompi$")
    public void queElUsuarioSeEncuentraUbicadoEnLaPaginaDePagosWompi() {
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url(Constantes.URL_HOME));
    }

    @When("^el usuario diligencia el monto a pagar$")
    public void elUsuarioDiligenciaElMontoAPagar(List<WompiTestModel> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(DiligenciarEl.montoAPagar(data));
    }

    @And("^el usuario selecciona metodo de pago pse$")
    public void elUsuarioSeleccionaMetodoDePagoPse() {
        OnStage.theActorInTheSpotlight().attemptsTo(DarClickAl.medioDePagoPse());
    }

    @And("^el usuario ingresa la informacion personal requerida$")
    public void elUsuarioIngresaLaInformacionPersonalRequerida(List<WompiTestModel> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(DiligenciarLos.camposRequeridosPersonales(data));
    }

    @And("^el usuario ingresa la informacion bancaria requerida$")
    public void elUsuarioIngresaLaInformacionBancariaRequerida(List<WompiTestModel> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(DiligenciarLa.informacionBancaria(data));
    }

    @Then("^el usuario vera el siguiente mensaje: (.*)$")
    public void ElUsuarioVeraElSiguienteMensaje(String mensaje) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidacionPseDel.mensajeEsperado(), Matchers.containsString(mensaje)));
    }

    @Then("^el usuario vera el siguiente mensaje de error: (.*)$")
    public void elUsuarioVeraElSiguienteMensajeDeErrorTransacciónConErrorPSE(String mensaje) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidacionPseDe.mensajeDeError(), Matchers.containsString(mensaje)));
    }
}