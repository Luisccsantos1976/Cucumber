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
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Logger;

public class AcessoRecordSteps {

    private WebDriver driver;
    private Logger logger = Logger.getLogger("ScenarioLogger");

    public AcessoRecordSteps() {
        this.driver = CustomWebDriverManager.getDriver();  // Inicializa o driver personalizado
    }

    @Given("o utilizador navega para a página inicial do Record")
    public void o_utilizador_navega_para_a_página_inicial_do_Record() throws InterruptedException {
        // Acessa a URL do Record
        driver.get("https://www.record.pt/");

        // Espera até que o corpo da página seja carregado
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        // Log de sucesso
        logger.info("Usuário navegou para a página inicial do Record.");

        // Pausa de 5 segundos
        Thread.sleep(5000);
    }

    @Then("a página do Record deve ser exibida corretamente")
    public void a_página_do_Record_deve_ser_exibida_corretamente() throws InterruptedException {
        // Obtem o título da página
        String pageTitle = driver.getTitle();

        // Log do título da página
        logger.info("Título da página atual: " + pageTitle);

        // Verifica se o título contém a palavra "Record"
        Assert.assertTrue(pageTitle.contains("Record"), "O título da página não corresponde ao esperado.");

        // Pausa de 5 segundos
        Thread.sleep(5000);
    }

    @And("o utilizador cancela a pop-up de notificações, se aparecer")
    public void o_utilizador_cancela_a_pop_up_de_notificações_se_aparecer() throws InterruptedException {
        try {
            // Espera até que o botão de cancelar apareça
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement cancelarButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cancelar")));

            // Clica no botão de cancelar a pop-up
            cancelarButton.click();

            // Log de cancelamento
            logger.info("Pop-up de notificações cancelada.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // Se o botão não aparecer, ignora e prossegue
            logger.info("Pop-up de notificações não apareceu. Continuando o teste.");
        }

        // Pausa de 5 segundos para observar a ação
        Thread.sleep(5000);
    }

    @And("o utilizador acessa a aba de Sporting")
    public void o_utilizador_acessa_a_aba_de_Sporting() throws InterruptedException {
        try {
            // Espera até que o botão da aba Sporting esteja disponível e clicável
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement sportingTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'nav-link eventAnalytics sporting')]")));

            // Clica na aba Sporting
            sportingTab.click();

            // Log de sucesso
            logger.info("Aba de Sporting foi acessada.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // Se a aba não aparecer, log de erro
            logger.info("A aba de Sporting não pôde ser acessada.");
        }

        // Pausa de 5 segundos para observar a navegação
        Thread.sleep(5000);
    }

    @And("o utilizador acessa a seção de Classificação")
    public void o_utilizador_acessa_a_seção_de_Classificação() throws InterruptedException {
        try {
            // Espera até que o link de Classificação seja clicável, utilizando o XPATH fornecido
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement classificacaoLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section[1]/div/div/div[1]/div/ul/li[1]/a")));

            // Clica no link de Classificação
            classificacaoLink.click();

            // Log de sucesso
            logger.info("Seção de Classificação foi acessada.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // Se o link não aparecer, log de erro
            logger.info("A seção de Classificação não pôde ser acessada.");
        }

        // Pausa de 5 segundos para observar a navegação
        Thread.sleep(5000);
    }

    @And("o utilizador acessa a página de Entrar")
    public void o_utilizador_acessa_a_página_de_Entrar() throws InterruptedException {
        try {
            // Espera até que o botão de "Entrar" esteja disponível e clicável
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement entrarButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Entrar') and @onclick='CofinaSSOApi.gotoLogin();']")));

            // Clica no botão de Entrar
            entrarButton.click();

            // Log de sucesso
            logger.info("Usuário clicou no botão 'Entrar'.");
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // Se o botão não aparecer, log de erro
            logger.info("O botão 'Entrar' não pôde ser acessado.");
        }

        // Pausa de 5 segundos para observar a navegação
        Thread.sleep(5000);
    }
}
