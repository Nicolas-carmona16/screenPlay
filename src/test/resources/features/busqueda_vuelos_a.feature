# Author: Equipo calidad - busqueda de vuelos A

  Feature: Búsqueda de vuelos
    Yo como usuario quiero buscar opciones de vuelos por origen, destino y fecha para verificar la disponibilidad de vuelos que se ajusten a mis necesidades.

    Scenario: Selección del origen
      Given que estoy en la página de búsqueda de vuelos
      When selecciono el campo "origen"
      Then se despliega una lista de ciudades
      And la lista contiene todas las ciudades con aeropuerto

    Scenario: Selección del destino
      Given que estoy en la página de búsqueda de vuelos
      And seleccioné una ciudad de origen
      When selecciono el campo "destino"
      Then se despliega una lista de ciudades
      And la lista contiene todas las ciudades con aeropuerto menos la seleccionada como origen

    Scenario: Selección de la fecha ida de vuelo
      Given que estoy en la página de búsqueda de vuelos
      When selecciono el campo "ida"
      Then se muestra un calendario
      And puedo seleccionar una fecha en formato YYYY-MM-DD
      And no se permite seleccionar una fecha pasada

    Scenario: Selección de la fecha ida de vuelo
      Given que estoy en la página de búsqueda de vuelos
      When selecciono el campo "vuelta"
      Then se muestra un calendario
      And puedo seleccionar una fecha en formato YYYY-MM-DD
      And no se permite seleccionar una fecha pasada a la fecha de ida

    Scenario: Búsqueda de vuelos con resultados disponibles
      Given que estoy en la página de búsqueda de vuelos
      And he seleccionado un origen, un destino, una fecha de ida válida y una fecha de vuelta válida
      When presiono el botón de "Buscar"
      Then el sistema muestra los vuelos disponibles

    Scenario: Búsqueda de vuelos sin disponibilidad
      Given que estoy en la página de búsqueda de vuelos
      And he seleccionado un origen, un destino, una fecha de ida válida y una fecha de vuelta válida
      When presiono el botón de "Buscar"
      Then el sistema muestra un mensaje indicando que no hay vuelos disponibles para la selección