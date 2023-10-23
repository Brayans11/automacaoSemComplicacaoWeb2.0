package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;

import java.util.Map;

public class NewAccountSteps {
    NewAccountPage newAccountPage;
    String username;



    @Dado("a página de new account esteja sendo exibida")
    public void aPáginaDeNewAccountEstejaSendoExibida() {
        newAccountPage = new NewAccountPage();
        Driver.getDriver().get("https://www.advantageonlineshopping.com");
        Driver.getDriver().get("https://www.advantageonlineshopping.com/#/register");
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());

    }
    @Quando("os campos de cadastro estiverem preenchidos com")
    public void osCamposDeCadastroEstiveremPreenchidosComIdentificacao(Map<String, String> map) throws InterruptedException {
        username = map.get("username");
        newAccountPage.setInpUserName(map.get("username"));
        newAccountPage.setInpEmail(map.get("email"));
        newAccountPage.setInpPassword(map.get("password"));
        newAccountPage.setInpConfirmPassword(map.get("password"));
        newAccountPage.selectCountry(map.get("country"));
        newAccountPage.clickInpIagree();
        newAccountPage.clickBtnRegister();

    }
    @Entao("deve ser possivel logar no sistema apos o cadastro")
    public void deveSerPossivelLogarNoSistemaAposOCadastro() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(username, loginPage.getUsuarioLogado());


    }

}
