package br.com.chronosacademy.AutomacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class VotarAleAlves {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Test
    public void inicializaNavegadorEVota() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://dgpadvogado.com.br/vereador-destaque-politico-municipio-de-guaiba-3/");

        int numeroDeRepeticoes = 250;  // Altere para o número desejado

        for (int i = 0; i < numeroDeRepeticoes; i++) {
            WebElement resposta = driver.findElement(By.id("poll-answer-889"));

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", resposta);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement botaoVote = driver.findElement(By.name("vote"));

            executor.executeScript("arguments[0].click();", botaoVote);

            driver.navigate().refresh();
        }
        driver.quit();
    }
}