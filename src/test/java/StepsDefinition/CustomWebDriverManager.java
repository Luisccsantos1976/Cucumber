package StepsDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomWebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Configurar o caminho do ChromeDriver
            String chromeDriverPath = "C:\\Users\\luis.cera-santos\\IdeaProjects\\Drivers\\chromedriver-win64\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            // Especificar o caminho para o perfil do usuário configurado
            String userProfile = "C:\\Users\\luis.cera-santos\\AppData\\Local\\Google\\Chrome\\User Data\\Default";

            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true); // Ignorar erros de certificado
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-first-run");
            options.addArguments("--no-default-browser-check");
            options.addArguments("--user-data-dir=" + userProfile);
            options.addArguments("--remote-debugging-port=9222");
            options.addArguments("--disable-gpu"); // Adicionar opção para desabilitar GPU
            options.addArguments("--ignore-certificate-errors"); // Ignorar erros de certificado
            options.addArguments("--allow-insecure-localhost"); // Permitir localhost inseguro
            options.addArguments("--disable-web-security"); // Desativar a segurança da web

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static boolean isDriverInitialized() {
        return driver != null;
    }

    public static void main(String[] args) {
        WebDriver driver = CustomWebDriverManager.getDriver();
        driver.get("https://expired.badssl.com/"); // URL com certificado inválido

        // Adiciona uma pausa para visualizar o navegador
        try {
            Thread.sleep(10000); // Aguarda 10 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CustomWebDriverManager.quitDriver();
    }
}
