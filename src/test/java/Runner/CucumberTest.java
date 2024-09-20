package Runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import StepsDefinition.CustomWebDriverManager;
import org.example.suporte.HttpClientUtil;

@CucumberOptions(
        features = "src/test/resources/features",   // Path para os arquivos .feature
        glue = {"StepsDefinition", "Hooks"},        // Caminho para os Steps Definitions e Hooks
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/CucumberTestReport.xml"
        },
        publish = true
)
public class CucumberTest extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public static void setup() {
        // Desabilitar verificação SSL globalmente
        HttpClientUtil.disableSslVerification();

        // Inicializar o driver
        CustomWebDriverManager.getDriver();
    }

    @AfterSuite
    public static void teardown() {
        // Verificar se o driver foi inicializado antes de tentar fechá-lo
        if (CustomWebDriverManager.isDriverInitialized()) {
            CustomWebDriverManager.quitDriver();
        }
    }
}

