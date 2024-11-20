Feature: Búsqueda de vuelos

  Scenario: Selección del origen
    Given que estoy en la pagina de busqueda de vuelos
    When selecciona el campo "origen"
    Then se despliega una lista de ciudades para el campo "origen"

  Scenario: Selección de destino
    Given que estoy en la pagina de busqueda de vuelos
    When selecciona el campo "destino"
    Then se despliega una lista de ciudades para el campo "destino"