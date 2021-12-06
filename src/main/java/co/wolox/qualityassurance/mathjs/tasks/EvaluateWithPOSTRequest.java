package co.wolox.qualityassurance.mathjs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static co.wolox.qualityassurance.mathjs.endpoints.MathJSRoutes.MATHJS_VERSION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EvaluateWithPOSTRequest implements Task {

    private final String expression;

    public EvaluateWithPOSTRequest(String expression) {
        this.expression = expression;
    }

    @Step("{0} send a POST request")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(MATHJS_VERSION).with(
                        request -> request.header("Content-Type","application/json")
                                .body("{\"expr\": \"" + expression + "\"}")
                                .log().all()
                )
        );
    }

    public static EvaluateWithPOSTRequest the(String expression){
        return instrumented(EvaluateWithPOSTRequest.class, expression);
    }
}
