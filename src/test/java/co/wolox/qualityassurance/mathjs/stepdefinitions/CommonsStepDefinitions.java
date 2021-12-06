package co.wolox.qualityassurance.mathjs.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Ensure;


import static co.wolox.qualityassurance.mathjs.utils.constants.EnvironmentVariables.URL_BASE;
import static co.wolox.qualityassurance.mathjs.utils.constants.JSONSchema.JSON_SCHEMA_ROUTE;
import static co.wolox.qualityassurance.mathjs.utils.constants.ResponseCode.OK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class CommonsStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(
                OnlineCast.whereEveryoneCan(
                        CallAnApi.at(URL_BASE)
                )
        );
    }

    @Then("^he should see the (.*) in the browser$")
    public void iShouldGet(String result) {
        System.out.println(result);
        theActorInTheSpotlight().attemptsTo(
                Ensure.that("correct expected result",
                        response -> response.body(is(result))),
                Ensure.that("successful status code",
                        response -> response.statusCode(OK))
        );
    }

    @Then("^he should see the correct structure in the answer$")
    public void iVerifyTheCorrectSchema() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that("correct schema",
                     response -> response.body(matchesJsonSchemaInClasspath(JSON_SCHEMA_ROUTE))
                )
        );
    }

}
