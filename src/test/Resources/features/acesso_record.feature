Feature: Acesso ao site do Record

  Como um usuário
  Quero acessar o site do Record
  Para verificar se a página é carregada corretamente, cancelar a pop-up de notificações, acessar a aba de Sporting, a seção de Classificação e a página de Entrar.

  @requires_browser
  Scenario: O utilizador acessa o site Record, cancela a pop-up de notificações, navega para a aba Sporting, acessa a classificação e a página de Entrar
    Given o utilizador navega para a página inicial do Record
    Then a página do Record deve ser exibida corretamente
    And o utilizador cancela a pop-up de notificações, se aparecer
    And o utilizador acessa a aba de Sporting
    And o utilizador acessa a seção de Classificação
    And o utilizador acessa a página de Entrar
