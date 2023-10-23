#language:pt

  @Login
Funcionalidade: Login

  Contexto:// serve para executar o mesmo teste antes de tudo e só pode usar se tiver a mesma coisa em todos.
    Dado que a modal esteja sendo exibida

  @fecharModal
  Cenario: Fechar a modal ao clicar fora da mesma
    Quando for realizado um clique fora da modal
    Entao a janela modal deve ser fechada

  @fecharModalIcone
  Cenario: Fechar a modal ao clicar no icone fechar
    Quando for realizado um clique no ícone de fechar modal
    Entao a janela modal deve ser fechada

  @CreateNewAccount
  Cenario: Link Create New Account
    Quando for realizado um clique no link Create New Account
    Entao a pagina Create New Account deve ser exibida

  @LoginComSucesso
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao deve ser possivel logar no sistema

    Exemplos:
      | identificacao       | login   | password  | remember |
      | campos obrigatorios | BrayanS | Brayan123 | false    |
      | todos os campos     | BrayanS | Brayan123 | true     |

  @LoginInvalido
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao o sistema devera exibir uma mensagem de erro

    Exemplos:
      | identificacao    | login    | password  | remember |
      | usuario invalido | invalido | Brayan123 | false    |
      | senha invalida   | BrayanS  | invalida  | false    |

  @DadosEmBranco
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Entao o botao sign in deve permanecer desabilitado

    Exemplos:
      | identificacao     | login   | password  | remember |
      | usuario em branco |         | Brayan123 | false    |
      | senha em branco   | chronos |           | false    |


