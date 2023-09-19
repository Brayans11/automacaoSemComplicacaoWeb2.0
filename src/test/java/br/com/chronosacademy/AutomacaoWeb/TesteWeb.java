package br.com.chronosacademy.AutomacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;

public class TesteWeb {

    ChromeDriver driver;

    @Before
    public void inicializaTeste() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://chronosacademy.orbitpages.online/cursos");
    }

    @Test
    public void primeiroTeste() {
        String xpathTitulo = "//*[@id=\"block-214\"]/div/div/div/div[1]/div/div";
        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = txtTitulo.getText();
        Assert.assertEquals("Conheça todos os nossos cursos.", titulo);
        driver.quit();

    }

    @After
    public void finalizaTeste() {
        driver.quit();

    }
}
