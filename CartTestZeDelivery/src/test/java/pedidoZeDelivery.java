
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class pedidoZeDelivery {

    String homePage = "https://www.ze.delivery/";

    String zipSearchElement = "#address-search-input-address";
    String zipCode = "09710001";
    String cssFakeZipBox = "#fake-address-search-input";
    String resultadoPesquisaClick = "#backdrop > div > div:nth-child(3)";
    String botaoSemComplemento = "#address-details-checkbox-without-complement";
    String produtosDisponiveis = "#address-details-button-continue";
    String botaoMaioridade = "age-gate-button-yes";
    String aceitaCookie = "#onetrust-accept-btn-handler";
    String compraBud = "#__next > div > div.css-3ht4b8 > div:nth-child(1) > div > a:nth-child(5)";
    String sixPack = "#plus-button";
    String adicionarAoCarrinho = "#add-product";
    String cssQuantidadeNoCarrinho = "#total-qty-products";
    String cssProdutoNoCarrinho  = "#product-card > div.css-1tvwda9 > div.css-yky53v > div.css-oeej2";
    String resultadoEsperadoQuantidade = "6 produtos";
    String resultadoEsperadoItem = "Brahma Chopp 269ml";





    @Test
    @DisplayName("Quando adicionar minhas cervejas ao carrinho, Entao meu produto e quantidade devem aparecer corretos")
    public void pedidoZeDelivery () {

        WebDriver driver = new ChromeDriver();
        driver.get(homePage);

        WebElement botaoCookies = new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(aceitaCookie)));
        botaoCookies.click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement fakeZipBox = driver.findElement(By.cssSelector(cssFakeZipBox));
        fakeZipBox.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement zipBox = driver.findElement(By.cssSelector(zipSearchElement));
        zipBox.sendKeys(zipCode);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement clickAdress = driver.findElement(By.cssSelector(resultadoPesquisaClick));
        clickAdress.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement semComplemento = driver.findElement(By.cssSelector(botaoSemComplemento));
        semComplemento.click();


        WebElement verProdutos = new WebDriverWait(driver, Duration.ofSeconds(12))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(produtosDisponiveis)));
        verProdutos.click();


        WebElement clickMaioridade = new WebDriverWait(driver, Duration.ofSeconds(12))
                .until(ExpectedConditions.elementToBeClickable(By.id(botaoMaioridade)));
        clickMaioridade.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement cardBud = driver.findElement(By.cssSelector(compraBud));
        cardBud.click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement addBud = driver.findElement(By.cssSelector(sixPack));
        addBud.click();
        addBud.click();
        addBud.click();
        addBud.click();
        addBud.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement adicionaAoCarrinho = driver.findElement(By.cssSelector(adicionarAoCarrinho));
        adicionaAoCarrinho.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement quantidadeCarrinho = driver.findElement(By.cssSelector(cssQuantidadeNoCarrinho));

        quantidadeCarrinho.getText();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement itemNoCarrinho = driver.findElement(By.cssSelector(cssProdutoNoCarrinho));
        itemNoCarrinho.getText();

        String verificaProduto = itemNoCarrinho.getText();
        String quantidadeNoCarrinho = quantidadeCarrinho.getText();


        assertThat(itemNoCarrinho.getText(), containsString(resultadoEsperadoItem));
        assertThat(quantidadeCarrinho.getText(), containsString(resultadoEsperadoQuantidade));



    }


    //public void buyForm("Henrique","Brazil","Sao Paulo","486500000000000", "11", "2025"){

    }

