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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;

public class AcessoMeoSteps {

    private WebDriver driver;
    private Logger logger = Logger.getLogger("ScenarioLogger");

    public AcessoMeoSteps() {
        this.driver = CustomWebDriverManager.getDriver();  // Inicializa o driver personalizado
    }

    // Step para navegar para a página inicial da MEO
    @Given("o utilizador navega para a página inicial da MEO")
    public void o_utilizador_navega_para_a_pagina_inicial_da_meo() throws InterruptedException {
        logger.log(Level.INFO, "Navegando para o site da MEO...");
        driver.get("https://www.meo.pt/");  // Navegar para a URL fornecida
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        logger.log(Level.INFO, "Página inicial da MEO carregada com sucesso.");
        Thread.sleep(5000);  // Esperar 5 segundos para garantir o carregamento completo
    }

    // Step para verificar se a página foi exibida corretamente
    @Then("a página da MEO deve ser exibida corretamente")
    public void a_pagina_da_meo_deve_ser_exibida_corretamente() throws InterruptedException {
        String pageTitle = driver.getTitle();
        logger.log(Level.INFO, "Verificando o título da página: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("MEO"),
                "O título da página não corresponde ao esperado. Título atual: " + pageTitle);
        logger.log(Level.INFO, "Página exibida corretamente.");
        Thread.sleep(5000);  // Esperar 5 segundos
    }

    // Step para aceitar a política de privacidade (se aparecer)
    @And("o utilizador aceita a política de privacidade")
    public void o_utilizador_aceita_a_politica_de_privacidade() throws InterruptedException {
        try {
            logger.log(Level.INFO, "Tentando aceitar a política de privacidade...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='CONCORDO']")));
            consentButton.click();
            logger.log(Level.INFO, "Política de privacidade aceita.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.log(Level.WARNING, "O botão de aceitação de política de privacidade não apareceu. Continuando o teste...");
        }
        Thread.sleep(5000);  // Esperar 5 segundos após tentar aceitar a política de privacidade
    }

    // Step para acessar a seção de Serviços
    @And("o utilizador acessa a seção de Serviços")
    public void o_utilizador_acessa_a_secao_de_servicos() throws InterruptedException {
        try {
            logger.log(Level.INFO, "Acessando a seção de Serviços...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement servicosButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='level-1-entry-link-title' and text()='Serviços']")));
            servicosButton.click();
            logger.log(Level.INFO, "Seção de Serviços acessada com sucesso.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.log(Level.WARNING, "O botão de Serviços não apareceu ou não pôde ser clicado.");
        }
        Thread.sleep(5000);  // Esperar 5 segundos após tentar acessar a seção de Serviços
    }

    // Step para acessar a seção de Para Casa
    @And("o utilizador acessa a seção de Para Casa")
    public void o_utilizador_acessa_a_secao_de_para_casa() throws InterruptedException {
        try {
            logger.log(Level.INFO, "Acessando a seção de Para Casa...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement paraCasaButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='level-2-entry-link icon-emcasa']")));
            paraCasaButton.click();
            logger.log(Level.INFO, "Seção de Para Casa acessada com sucesso.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.log(Level.WARNING, "O botão de Para Casa não apareceu ou não pôde ser clicado.");
        }
        Thread.sleep(5000);  // Esperar 5 segundos após tentar acessar a seção de Para Casa
    }

    // Step para voltar à página inicial
    @And("o utilizador volta para a página inicial")
    public void o_utilizador_volta_para_a_pagina_inicial() throws InterruptedException {
        try {
            logger.log(Level.INFO, "Voltando para a página inicial...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/']")));
            homeButton.click();
            logger.log(Level.INFO, "Retornado à página inicial com sucesso.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.log(Level.WARNING, "O botão para voltar à página inicial não apareceu ou não pôde ser clicado.");
        }
        Thread.sleep(5000);  // Esperar 5 segundos após tentar voltar à página inicial
    }

    // Step para selecionar a seção de Particulares
    @And("o utilizador seleciona a seção de Particulares")
    public void o_utilizador_seleciona_a_secao_de_particulares() throws InterruptedException {
        try {
            logger.log(Level.INFO, "Acessando a seção de Particulares...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement particularesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='hyperlinks-txt' and text()='Particulares']")));
            particularesButton.click();
            logger.log(Level.INFO, "Seção de Particulares acessada com sucesso.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.log(Level.WARNING, "O botão de Particulares não apareceu ou não pôde ser clicado.");
        }
        Thread.sleep(5000);  // Esperar 5 segundos após tentar acessar a seção de Particulares
    }
}