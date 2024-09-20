Feature: Acesso ao site da MEO

  Como um usuário
  Quero acessar o site da MEO
  Para verificar se a página é carregada corretamente, aceitar a política de privacidade, acessar serviços e voltar à página inicial para selecionar a seção Particulares.

  @requires_browser
  Scenario: O utilizador acessa o site MEO e aceita a política de privacidade
    Given o utilizador navega para a página inicial da MEO
    Then a página da MEO deve ser exibida corretamente
    And o utilizador aceita a política de privacidade
    And o utilizador acessa a seção de Serviços
    And o utilizador acessa a seção de Para Casa
    And o utilizador volta para a página inicial
    And o utilizador seleciona a seção de Particulares



