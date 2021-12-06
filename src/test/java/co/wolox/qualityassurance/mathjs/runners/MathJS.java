package co.wolox.qualityassurance.mathjs.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/mathjs.feature",
        glue = {"co.wolox.qualityassurance.mathjs.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class MathJS {
}
