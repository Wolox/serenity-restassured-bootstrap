package co.wolox.qualityassurance.mathjs.stepdefinitions;

import co.wolox.qualityassurance.mathjs.tasks.EvaluateWithGETRequest;
import co.wolox.qualityassurance.mathjs.tasks.EvaluateWithPOSTRequest;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActor;

public class MathJSStepDefinitions {

    @When("^I request evaluation of (.*)$")
    public void iRequestEvaluationOf(String expression) {
        theActor("Milo 2.0").attemptsTo(
                EvaluateWithGETRequest.the(expression)
        );
    }

    @When("I request evaluation with POST request of (.*)$")
    public void iRequestEvaluationWithPOSTRequestOfSinDeg(String expression) {
        theActor("juanma.z").attemptsTo(
                EvaluateWithPOSTRequest.the(expression)
        );
    }

}
