package co.wolox.qualityassurance.mathjs.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Ensure;


import static co.wolox.qualityassurance.mathjs.utils.constants.EnvironmentVariables.URL_BASE;
import static co.wolox.qualityassurance.mathjs.utils.constants.JSONSchema.JSON_SCHEMA_ROUTE;
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

    @Then("^I should get (.*)$")
    public void iShouldGet(int result) {
        System.out.println(result);
        theActorInTheSpotlight().attemptsTo(
                Ensure.that("correct expected result",
                        response -> response.body(is(result)))
        );
    }
    @Then("^I should get status (.*)$")
    public void iShouldGetStatus(int code) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that("correct status code",
                        response -> response.statusCode(code))
        );
    }

    @Then("^I verify the correct schema$")
    public void iVerifyTheCorrectSchema() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that("correct schema",
                     response -> response.body(matchesJsonSchemaInClasspath(JSON_SCHEMA_ROUTE))
                )
        );
    }

}
