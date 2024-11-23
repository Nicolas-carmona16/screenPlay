Feature: Búsqueda de vuelos

  Scenario: Selección del origen
    Given que estoy en la pagina de busqueda de vuelos
    When selecciona el campo "origen"
    Then se despliega una lista de ciudades para el campo "origen"

  Scenario: Selección de destino
    Given que estoy en la pagina de busqueda de vuelos
    When selecciona el campo "destino"
    Then se despliega una lista de ciudades para el campo "destino"

  Scenario: Selección de la fecha ida de vuelo
    Given que estoy en la pagina de busqueda de vuelos
    When selecciona el campo "ida"
    Then se muestra el calendario para "ida"

  Scenario: Selección de la fecha vuelta de vuelo
    Given que estoy en la pagina de busqueda de vuelos
    When selecciona el campo "vuelta"
    Then se muestra el calendario para "vuelta"

  Scenario: Búsqueda de vuelos disponibles
    Given que estoy en la pagina de busqueda de vuelos
    And selecciono origen "Barranquilla" destino "Bogota" fecha ida "2024-11-26" y fecha vuelta "2024-11-30"
    When doy click en el boton buscar
    Then se obtienen los vuelos disponibles