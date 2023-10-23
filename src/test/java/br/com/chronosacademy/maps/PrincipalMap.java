package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrincipalMap {

    @FindBy(xpath = "/html/body/div/div/div/section[2]/div[3]/div/div/div[1]/div/h4")
    public WebElement txtTitulo;
    @FindBy(xpath = "//div[2]/div/div/a")
    public WebElement btnTitulo;

}
