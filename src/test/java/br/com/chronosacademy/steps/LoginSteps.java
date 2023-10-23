package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginSteps {


    LoginPage loginPage;

    String username;


    @Before
    public void iniciaNavegador(Scenario cenario) {
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void fechaNavegador(Scenario cenario) throws IOException {
        if (cenario.isFailed()){
            Driver.printScreen("Erro no cenario");
        }
        System.out.println(Driver.getNomeCenario() + " - "+cenario.getStatus());
        System.out.println(cenario.isFailed());

    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() throws InterruptedException {
        Driver.getDriver().get("https://www.advantageonlineshopping.com");
        Thread.sleep(5000);
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();

    }

    @Quando("for realizado um clique fora da modal")
    public void forRealizadoUmCliqueForaDaModal() {
        loginPage.divFechaModal();

    }

    @Entao("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() throws Exception {
        try {
            loginPage.visibilityOfBtnFechar();
            loginPage.invisibilityOfBtnFechar();

        } catch (Exception e) {
            throw new Exception("A janela modal não foi fechada");
        }
    }

    @Quando("for realizado um clique no ícone de fechar modal")
    public void forRealizadoUmCliqueNoÍconeDeFecharModal() {
        loginPage.clickBtnFechar();
    }

    @Quando("for realizado um clique no link Create New Account")
    public void forRealizadoUmCliqueNoLinkCreateNewAccount() {
        loginPage.clickLinkCreateAccount();
    }

    @Entao("a pagina Create New Account deve ser exibida")
    public void aPaginaCreateNewAccountDeveSerExibida() {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());

    }

    @Quando("os campos de login sejam preenchidos da seguinte forma")
    public void osCamposDeLoginSejamPreenchidosDaSeguinteForma(Map<String, String> map) throws IOException {
        username = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.SetInpUserName(username);
        loginPage.SetInpPassword(password);
        if (remember) loginPage.clickInpRemember();
        Driver.printScreen("Preenchimento dos campos de login");

    }

    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickBtnSignIn();

    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() throws IOException {
        Assert.assertEquals(username, loginPage.getUsuarioLogado());
        Driver.printScreen("Logado no sistema");


    }

    @Entao("o sistema devera exibir uma mensagem de erro")
    public void oSistemaDeveraExibirUmaMensagemDeErro() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("Incorrect user name or password.", loginPage.getErroLogin());

    }

    @Entao("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        Assert.assertFalse(enabled);


    }
    @Dado("que esteja logado no sistema com")
    public void queEstejaLogadoNoSistemaCom(Map<String, String> map) throws InterruptedException, IOException {
        queAModalEstejaSendoExibida();
        osCamposDeLoginSejamPreenchidosDaSeguinteForma(map);
        forRealizadoOCliqueNoBotaoSignIn();
        deveSerPossivelLogarNoSistema();


    }

}
