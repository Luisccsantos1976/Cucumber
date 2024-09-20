package Hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import StepsDefinition.CustomWebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class Hooks {

    private Logger logger;
    private java.util.logging.FileHandler fileHandler;

    @Before("@requires_browser")
    public void setup(Scenario scenario) {
        WebDriver driver = CustomWebDriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        System.out.println("Setup do navegador completo.");
        // Configurando o logging com base no status
        setupLogging(scenario);
    }

    @After("@requires_browser")
    public void teardown(Scenario scenario) {
        // Capturar o status correto (incluindo se o cenário está UNDEFINED)
        String status = scenario.getStatus().name();

        // Capturar o screenshot sempre com o status correto
        captureScreenshot(scenario, status);

        // Gerar o log sempre com o status correto
        logScenarioDetails(scenario, status);

        if (fileHandler != null) {
            fileHandler.close();
        }

        System.out.println("Teardown do navegador completo.");
    }

    // Método atualizado para capturar screenshots e adicionar o status ao nome do arquivo
    private void captureScreenshot(Scenario scenario, String status) {
        WebDriver driver = CustomWebDriverManager.getDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Adicionar o status correto (PASS, FAILED, UNDEFINED) ao nome do arquivo
        String sanitizedScenarioName = sanitizeFilename(scenario.getName());

        try {
            File screenshotsDir = new File("target/cucumber-reports/screenshots/");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }

            File targetFile = new File(screenshotsDir, sanitizedScenarioName + "_" + status + ".png");
            org.openqa.selenium.io.FileHandler.copy(screenshot, targetFile);
            System.out.println("Screenshot salvo em: " + targetFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método atualizado para configurar o logging e adicionar o status ao final do arquivo de log
    private void setupLogging(Scenario scenario) {
        String sanitizedScenarioName = sanitizeFilename(scenario.getName());

        try {
            File logsDir = new File("target/cucumber-reports/logs/");
            if (!logsDir.exists()) {
                logsDir.mkdirs();
            }

            logger = Logger.getLogger("ScenarioLogger");
            fileHandler = new java.util.logging.FileHandler(logsDir.getAbsolutePath() + "/" + sanitizedScenarioName + ".log", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.info("Iniciando o cenário: " + scenario.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para gerar os detalhes do cenário (incluindo o status correto)
    private void logScenarioDetails(Scenario scenario, String status) {
        logger = Logger.getLogger("ScenarioLogger");
        logger.log(Level.INFO, "Cenário concluído. Nome: " + scenario.getName());
        logger.log(Level.INFO, "Status do cenário: " + status);  // Inclui UNDEFINED, PASS ou FAILED
    }

    // Método para sanitizar o nome do arquivo, removendo caracteres inválidos
    private String sanitizeFilename(String name) {
        return name.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
    }
}
