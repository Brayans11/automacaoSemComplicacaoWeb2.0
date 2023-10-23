#language:pt
@CRUD
Funcionalidade: Account CRUD

  @CadastroConta
  Cenario: Cadastro nova conta
    Dado a página de new account esteja sendo exibida
    Quando os campos de cadastro estiverem preenchidos com
      | username | Brayan15                    |
      | email    | brayansilveira2320@gmail.com |
      | password | Brayan15                     |
      | country  | Brazil                       |
    Entao deve ser possivel logar no sistema apos o cadastro

  @loginCRUD
  Cenario: Realizar Login crud
    Dado que a modal esteja sendo exibida
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | Brayan15 |
      | password | Brayan15 |
      | remember | false    |
    Quando for realizado o clique no botao sign in
    Entao deve ser possivel logar no sistema

  @alterarCrud
  Cenario: Realizar alteracao de conta
    Dado que esteja logado no sistema com
      | login    | Brayan15 |
      | password | Brayan15 |
      | remember | false    |
    Dado que esteja na pagina de alteracao de conta
    Quando altero os valores dos seguintes campos
      | firstName | Chronos |
      | lastName  | Teste   |
    Quando for realizado o clique em salvar
    Entao a alteracao foi exibida na pagina myAccount

    @exclusaoCRUD
    Cenario: Deletar usuario
      Dado que esteja logado no sistema com
        | login    | Brayan15 |
        | password | Brayan15 |
        | remember | false    |
      Dado que esteja na pagina myAccount
      Quando for efetuado a acao do clique delete e em yes
      Entao o usuario deve ser deletado






