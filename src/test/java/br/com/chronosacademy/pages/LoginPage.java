package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    LoginMap loginMap;

    public LoginPage() {
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }

    public void clickBtnLogin() {
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();

    }

    public void clickBtnFechar() {
        loginMap.btnFechar.click();

    }

    public void divFechaModal() {
        loginMap.divFechaModal.click();

    }

    public void SetInpUserName(String username) {
        if (username != null){
            loginMap.InpUserName.sendKeys(username);
        }
    }

    public void SetInpPassword(String password) {
        if (password != null){
            loginMap.InpPassword.sendKeys(password);
        }
    }

    public void clickInpRemember() {
        loginMap.inpRemember.click();

    }

    public void clickLinkCreateAccount() {
        loginMap.linkCreateAccount.click();
    }

    public void clickBtnSignIn() {
        loginMap.btnSignIn.click();
    }
    public boolean isBtnSignIn(){
        return loginMap.btnSignIn.isEnabled(); //isEnabled é para validar se o elemento está visivel o Enablede
    }
    public void visibilityOfBtnFechar(){
        Driver.visibilityOf(loginMap.btnFechar);

    }
    public void invisibilityOfBtnFechar(){
        Driver.invisibilityOf(loginMap.btnFechar);
    }
    public void aguardaLoader(){
        Driver.attributChange(loginMap.divLoader, "display", "none");
    }
    public String getUsuarioLogado(){
        Driver.visibilityOf(loginMap.txtLogado);
        return loginMap.txtLogado.getText();
    }
    public String getErroLogin(){
        Driver.visibilityOf(loginMap.txtErroLogin);
        return loginMap.txtErroLogin.getText();
    }
}
