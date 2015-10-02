# Testes para Android de Ponta a Ponta

Este projeto apresenta como testar sua app Android de ponta a ponta pensando em três níveis básicos de teste: unitário, serviços e funcional.

## Estrutura do projeto
   - TrianguloAppRest: contém o projeto desenvolvido no Android Studio
   - TrianguloApi_PHP: API desenvolvida em PHP com Slim Framework

> Se você quiser testar a parte de serviços rest da app android, o ideal é instalar em um servidor AMP e adicionar o TrianguloApi_PHP

### TrianguloAppRest
Projeto desenvolvido no Android Studio apresentando 3 níveis diferentes de teste, sendo o unitário em 2 visões:
   - Unitário Local (com [JUnit 4](http://junit.org) e [Roboletric](http://robolectric.org))
   - Unitário Instrumentoado (com [AndroidJUnit4](https://developer.android.com/tools/testing-support-library/index.html))
   - Serviços (com [RestAssured](https://github.com/jayway/rest-assured))
   - Interface Gráfica - UI (com [Appium](http://appium.com))

