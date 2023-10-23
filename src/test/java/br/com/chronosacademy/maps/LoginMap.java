package br.com.chronosacademy.maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {

    @FindBy(css = "#menuUser")
    public WebElement btnLogin;
    @FindBy(css = ".closeBtn")
    public WebElement btnFechar;
    @FindBy(css = ".PopUp")
    public WebElement divFechaModal;
    @FindBy(css = "*[name='username']")
    public WebElement InpUserName;
    @FindBy(css = "*[name='password']")
    public WebElement InpPassword;
    @FindBy(id ="sign_in_btn")
    public WebElement btnSignIn;
    @FindBy(css = "*[name='remember_me']")
    public WebElement inpRemember;
    @FindBy(linkText = "CREATE NEW ACCOUNT")
    public WebElement linkCreateAccount;
    @FindBy(css = ".loader")
    public WebElement divLoader;
    @FindBy(css = ".containMiniTitle")
    public WebElement txtLogado;
    @FindBy(id="signInResultMessage")
    public WebElement txtErroLogin;


////label[contains(text(), 'incorrect')]
//*[@id="signInResultMessage"]
}
