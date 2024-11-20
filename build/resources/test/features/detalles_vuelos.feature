# Author: Equipo calidad - busqueda de vuelos A

  Feature: Detalles de vuelos
    Yo como usuario quiero ver la información detallada de los vuelos.

    Scenario: Visualización preliminar de detalles de vuelos
      Given que he realizado una búsqueda de vuelos
      When se muestran los resultados
      Then se debe mostrar el precio, hora de salida y hora de llegada de cada vuelo