Feature: Prueba Browserstack

  Background:
		#@PRECOND_XRAY-21
    Given Ingresar a pagina


  @TEST_PX-4
  Scenario: BrowserStack
    When Busco "casa de tus sueños"
