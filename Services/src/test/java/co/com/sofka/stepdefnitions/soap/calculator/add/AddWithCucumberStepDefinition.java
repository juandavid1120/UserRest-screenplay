package co.com.sofka.stepdefnitions.soap.calculator.add;

import co.com.sofka.stepdefnitions.soap.calculator.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static co.com.sofka.questions.ReturnStringValue.systemValue;
import static co.com.sofka.tasks.calculator.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddWithCucumberStepDefinition extends SetUp {

   /* private static final String ADD_XML = System.getProperty("user.dir") + "\\src\\test\\resources\\calculator\\add.xml";*/
    /*private static final String INT_A = "[codigoISO]";*/



    @Given("que el usuario de la aplicacion se encuentre en home page")
    public void que_el_usuario_de_la_aplicacion_ha_definido_como_codigo() {
        setUp();

    }

    @When("el usuario de la aplicacion ejecuta la busqueda con el codigo {int}")
    public void el_usuario_de_la_aplicacion_ejecuta_la_busqueda(int codigoUser) {
        actor.attemptsTo(
                doGet().

                        usingThe(String.format(RESOURCE, codigoUser))
                        /*with(headers()).
                        and(bodyRequest)*/
        );
    }

    @Then("el usuario deberia obtener el resultado valido")
    public void el_usuario_deberia_obtener_el_resultado() {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_OK,
                        response -> response
                                .statusCode(SC_OK)
                                .body("data.id", equalTo(2))
                                .body("data.email", equalTo("janet.weaver@reqres.in"))
                                .body("data.first_name", equalTo("Janet"))
                                .body("data.last_name", equalTo("Weaver"))
                                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))


                )

        );
    }

    @Given("que el usuario de la aplicacion esta en pagina principal")
    public void que_el_usuario_de_la_aplicacion_esta_en_pagina_principal() {
        setUp();

    }

    @When("el usuario de la aplicacion busca con el codigo {int}")
    public void el_usuario_de_la_aplicacion_busca_con_el_codigo(int codigoUser) {
        actor.attemptsTo(
                doGet().

                        usingThe(String.format(RESOURCE, codigoUser))
                        /*with(headers()).
                        and(bodyRequest)*/
        );
    }

    @Then("el usuario deberia obtener el resultado fallido")
    public void el_usuario_deberia_obtener_el_resultado_fallido() {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_NOT_FOUND,
                        response -> response
                                .statusCode(SC_NOT_FOUND)
                                .body("data", equalTo(null))
                )

        );
    }



    /*@Given("que el usuario de la calculadora ha definido como sumandos el {int} y el {int}")
    public void queElUsuarioDeLaCalculadoraHaDefinidoComoSumandosElYEl(Integer intA, Integer intB) {
        setUp();
        bodyRequest = defineBodyRequest(intA, intB);
    }

    @When("el usuario de la calculadora ejecuta el cálculo")
    public void elUsuarioDeLaCalculadoraEjecutaElCalculo() {
        actor.attemptsTo(
                doPost().
                        usingThe(RESOURCE).
                        with(headers()).
                        and(bodyRequest)
        );
    }

    @Then("el ususario debería obtener el resultado {int}")
    public void elUsusarioDeberiaObtenerElResultado(Integer total) {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_OK,
                        response -> response
                                .statusCode(SC_OK)
                ),
                seeThat(
                        "El resultado de la suma debe ser: ",
                        systemValue(fromLastResponseBy(actor)),
                        containsString("<AddResult>" + total + "</AddResult>")
                )
        );
    }
*/
    /*private String defineBodyRequest(String StringA){
        return


    }*/





}
