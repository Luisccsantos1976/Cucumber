package StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;
import org.testng.Assert;

public class AcessoMercadonaSteps {

    private WebDriver driver;
    private Logger logger = Logger.getLogger("ScenarioLogger");

    public AcessoMercadonaSteps() {
        this.driver = CustomWebDriverManager.getDriver();  // Inicializa o driver personalizado
    }

    @Given("o utilizador navega para a página inicial da Mercadona")
    public void o_utilizador_navega_para_a_pagina_inicial_da_mercadona() throws InterruptedException {
        driver.get("https://www.mercadona.pt/pt/iniciacao");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        logger.info("Usuário navegou para a página inicial da Mercadona.");
        Thread.sleep(5000);  // Espera de 5 segundos
    }

    @Then("a página da Mercadona deve ser exibida corretamente")
    public void a_pagina_da_mercadona_deve_ser_exibida_corretamente() throws InterruptedException {
        String pageTitle = driver.getTitle();
        logger.info("Título da página atual: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("Mercadona"), "O título da página não corresponde ao esperado.");
        Thread.sleep(5000);  // Espera de 5 segundos
    }

    @And("o utilizador recusa os cookies")
    public void o_utilizador_recusa_os_cookies() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement recusarCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Recusar']")));
            recusarCookiesButton.click();
            logger.info("O utilizador recusou os cookies.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.info("O botão de cookies não apareceu. Continuando o teste.");
        }
        Thread.sleep(5000);  // Espera de 5 segundos após aceitar os cookies
    }

    @And("o utilizador acessa a seção de Supermercados")
    public void o_utilizador_acessa_a_secao_de_supermercados() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement supermercadosButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='topEnlacesEstilo' and @href='/pt/supermercados-portugal']")));
            supermercadosButton.click();
            logger.info("O utilizador acessou a seção de Supermercados.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.info("O botão de Supermercados não apareceu ou não pôde ser clicado.");
        }
        Thread.sleep(5000);  // Espera de 5 segundos após acessar Supermercados
    }

    @And("o utilizador acessa a seção de Emprego")
    public void o_utilizador_acessa_a_secao_de_emprego() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement empregoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='topEnlacesEstilo' and @href='/pt/emprego']")));
            empregoButton.click();
            logger.info("O utilizador acessou a seção de Emprego.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.info("O botão de Emprego não apareceu ou não pôde ser clicado.");
        }
        Thread.sleep(5000);  // Espera de 5 segundos após acessar Emprego
    }
}
