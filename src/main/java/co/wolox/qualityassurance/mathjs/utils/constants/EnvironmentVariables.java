package co.wolox.qualityassurance.mathjs.utils.constants;

import net.thucydides.core.util.SystemEnvironmentVariables;

public class EnvironmentVariables {

    private static net.thucydides.core.util.EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static final String URL_BASE = environmentVariables.getProperty("base.url");

}
