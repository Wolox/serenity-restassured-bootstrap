package co.wolox.qualityassurance.mathjs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static co.wolox.qualityassurance.mathjs.endpoints.MathJSRoutes.MATHJS_VERSION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EvaluateWithGETRequest implements Task {

    private final String expression;

    public EvaluateWithGETRequest(String expression) {
        this.expression = expression;
    }

    @Step("{0} send a GET request")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(MATHJS_VERSION).with(
                        request -> request.queryParam("expr", expression)
                                .log().all()
                )
        );
    }

    public static EvaluateWithGETRequest the(String expression){
        return instrumented(EvaluateWithGETRequest.class, expression);
    }
}
