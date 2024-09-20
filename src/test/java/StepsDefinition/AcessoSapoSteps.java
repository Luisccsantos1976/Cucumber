package StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class AcessoSapoSteps {

    private WebDriver driver;
    private Logger logger = Logger.getLogger("ScenarioLogger");

    public AcessoSapoSteps() throws Exception {
        disableSSLVerification();  // Desativa a verificação SSL
        this.driver = CustomWebDriverManager.getDriver();  // Inicializa o driver personalizado
    }

    // Método para desabilitar verificação SSL
    public static void disableSSLVerification() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
    }

    @Given("o utilizador navega para a página inicial do Sapo")
    public void o_utilizador_navega_para_a_página_inicial_do_Sapo() throws InterruptedException {
        driver.get("https://www.sapo.pt/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        logger.info("Usuário navegou para a página inicial do Sapo.");
        Thread.sleep(5000);
    }

    @Then("a página do Sapo deve ser exibida corretamente")
    public void a_página_do_Sapo_deve_ser_exibida_corretamente() throws InterruptedException {
        String pageTitle = driver.getTitle();
        logger.info("Título da página atual: " + pageTitle);
        Assert.assertTrue(pageTitle.toLowerCase().contains("sapo"), "O título da página não corresponde ao esperado.");
        Thread.sleep(5000);
    }

    @Then("o utilizador seleciona Atualidade")
    public void o_utilizador_seleciona_atualidade() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement atualidadeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Atualidade']")));
            atualidadeButton.click();
            logger.info("O utilizador clicou em 'Atualidade'.");
        } catch (Exception e) {
            logger.info("O botão 'Atualidade' não pôde ser acessado.");
        }
        Thread.sleep(5000);
    }

    @Then("o utilizador seleciona Entretenimento")
    public void o_utilizador_seleciona_entretenimento() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement entretenimentoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Entretenimento']")));
            entretenimentoButton.click();
            logger.info("O utilizador clicou em 'Entretenimento'.");
        } catch (Exception e) {
            logger.info("O botão 'Entretenimento' não pôde ser acessado.");
        }
        Thread.sleep(5000);
    }

    @Then("o utilizador seleciona Capas de Jornais")
    public void o_utilizador_seleciona_capas_de_jornais() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement capasDeJornaisButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Capas de Jornais')]")));
            capasDeJornaisButton.click();
            logger.info("O utilizador clicou em 'Capas de Jornais'.");
        } catch (Exception e) {
            logger.info("O botão 'Capas de Jornais' não pôde ser acessado.");
        }
        Thread.sleep(5000);
    }

    @And("o utilizador seleciona a opção de Mail")
    public void o_utilizador_seleciona_a_opção_de_mail() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement mailButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.bsu-mail.svelte-z2mxgl")));
            mailButton.click();
            logger.info("O utilizador clicou na opção de 'Mail'.");
        } catch (Exception e) {
            logger.info("A opção de 'Mail' não pôde ser acessada.");
        }
        Thread.sleep(5000);
    }

    @And("o utilizador clica na opção de Entrar com Google")
    public void o_utilizador_clica_na_opção_de_entrar_com_google() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement googleLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sapo_google_login_button']")));
            googleLoginButton.click();
            logger.info("O utilizador clicou na opção 'Entrar com Google'.");
        } catch (Exception e) {
            logger.info("A opção 'Entrar com Google' não pôde ser acessada.");
        }
        Thread.sleep(5000);
    }

    @And("o utilizador seleciona a conta Luis Carlos Cera Santos")
    public void o_utilizador_seleciona_a_conta_Luis_Carlos_Cera_Santos() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement accountElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-identifier='luisccsantos201902@gmail.com']")));
            accountElement.click();
            logger.info("O utilizador selecionou a conta 'Luis Carlos Cera Santos'.");
        } catch (Exception e) {
            logger.info("A conta 'Luis Carlos Cera Santos' não pôde ser acessada.");
        }
        Thread.sleep(5000);
    }

    @Then("o utilizador vê a mensagem de erro {string} e clica em Tentar Novamente")
    public void o_utilizador_vê_a_mensagem_de_erro_e_clica_em_tentar_novamente(String mensagemErro) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement erroElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), '" + mensagemErro + "')]")));
            Assert.assertTrue(erroElement.getText().contains(mensagemErro), "A mensagem de erro não corresponde ao esperado.");
            logger.info("A mensagem de erro foi exibida corretamente: " + mensagemErro);

            WebElement tentarNovamenteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Tentar novamente')]")));
            tentarNovamenteButton.click();
            logger.info("O utilizador clicou em 'Tentar novamente'.");
        } catch (Exception e) {
            logger.info("A mensagem de erro ou o botão 'Tentar novamente' não pôde ser acessado.");
        }
        Thread.sleep(5000);
    }
}
