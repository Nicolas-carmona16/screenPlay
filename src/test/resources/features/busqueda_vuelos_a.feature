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
    And selecciono origen "Barranquilla" destino "Bogota" fecha ida "2025-01-01" y fecha vuelta "2025-01-10"
    When doy click en el boton buscar
    Then se obtienen los vuelos disponibles

  Scenario: Búsqueda de vuelo no disponible
    Given que estoy en la pagina de busqueda de vuelos
    And selecciono origen "Barranquilla" destino "Bogota" fecha ida "2024-12-16" y fecha vuelta "2024-12-20"
    When doy click en el boton buscar
    Then se obtienen el mensaje "No hay vuelos disponibles para las fechas seleccionadas."

  Scenario: Origen no disponible
    Given que estoy en la pagina de busqueda de vuelos
    When selecciono origen "Monteria"
    Then se muestra el mensaje no disponible

  Scenario: Destino no disponible
    Given que estoy en la pagina de busqueda de vuelos
    When selecciono destino "Monteria"
    Then se muestra el mensaje no disponible

  Scenario: Seleccionar el mismo origen y destino
    Given que estoy en la pagina de busqueda de vuelos
    And selecciono origen "Medellin"
    When selecciono destino "Medellin"
    Then se muestra el mensaje no disponible

  Scenario: Seleccionar una fecha de ida anterior a la actual
    Given que estoy en la pagina de busqueda de vuelos
    When selecciono fecha de ida "2024-11-20"
    Then se muestra el mensaje de error fecha ida "La fecha de salida no puede ser anterior a la fecha actual."

  Scenario: Seleccionar una fecha de vuelta anterior a la de ida
    Given que estoy en la pagina de busqueda de vuelos
    And selecciono fecha de ida "2025-01-01"
    When selecciono fecha de vuelta "2024-12-12"
    Then se muestra el mensaje de error fecha vuelta "La fecha de regreso debe ser despues de la fecha de salida."