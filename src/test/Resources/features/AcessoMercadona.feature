Feature: Acesso ao site da Mercadona

  Como um usuário
  Quero acessar o site da Mercadona
  Para recusar os cookies e acessar as seções de Supermercados e Emprego

  @requires_browser
  Scenario: O utilizador acessa o site Mercadona, recusa os cookies, acessa a seção de Supermercados e depois Emprego
    Given o utilizador navega para a página inicial da Mercadona
    Then a página da Mercadona deve ser exibida corretamente
    And o utilizador recusa os cookies
    And o utilizador acessa a seção de Supermercados
    And o utilizador acessa a seção de Emprego
