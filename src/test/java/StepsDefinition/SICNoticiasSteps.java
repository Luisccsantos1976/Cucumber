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
import org.testng.Assert;
import java.util.logging.Logger;

public class SICNoticiasSteps {

    private WebDriver driver;
    private Logger logger = Logger.getLogger("ScenarioLogger");

    public SICNoticiasSteps() {
        this.driver = CustomWebDriverManager.getDriver();  // Inicializa o driver personalizado
    }

    // Step para navegar para a página inicial da SIC Notícias
    @Given("o utilizador navega para a página inicial da SIC Notícias")
    public void o_utilizador_navega_para_a_pagina_inicial_da_sic_noticias() throws InterruptedException {
        driver.get("https://sicnoticias.pt/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        logger.info("Usuário navegou para a página inicial da SIC Notícias.");
        Thread.sleep(5000);  // Esperar 5 segundos para garantir o carregamento completo
    }

    // Step para verificar se a página foi exibida corretamente
    @Then("a página da SIC Notícias deve ser exibida corretamente")
    public void a_pagina_da_sic_noticias_deve_ser_exibida_corretamente() throws InterruptedException {
        String pageTitle = driver.getTitle();
        logger.info("Título da página atual: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("SIC Notícias"),
                "O título da página não corresponde ao esperado. Título atual: " + pageTitle);
        Thread.sleep(5000);  // Esperar 5 segundos
    }

    // Step para aceitar e fechar a política de privacidade (se aparecer)
    @And("o utilizador aceita e fecha a política de privacidade (se aparecer)")
    public void o_utilizador_aceita_e_fecha_a_politica_de_privacidade_se_aparecer() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Aceitar e fechar']")));
            consentButton.click();
            logger.info("O utilizador aceitou e fechou a política de privacidade.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.warning("O botão de aceitação de política de privacidade não apareceu, continuando o teste.");
        }
        Thread.sleep(5000);  // Esperar 5 segundos após tentar aceitar a política de privacidade
    }

    // Step para acessar a seção Conflito Israel-Palestina
    @And("o utilizador acessa a seção Conflito Israel-Palestina")
    public void o_utilizador_acessa_a_secao_conflito_israel_palestina() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement sectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Conflito Israel-Palestina']")));
            sectionLink.click();
            logger.info("O utilizador acessou a seção Conflito Israel-Palestina.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.warning("O link para a seção Conflito Israel-Palestina não apareceu ou não pôde ser clicado.");
        }
        Thread.sleep(5000);  // Esperar 5 segundos após tentar acessar a seção
    }
}
