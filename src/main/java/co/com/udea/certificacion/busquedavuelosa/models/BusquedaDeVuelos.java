package co.com.udea.certificacion.busquedavuelosa.models;

public class BusquedaDeVuelos {

    private String origen;
    private String destino;

    public BusquedaDeVuelos(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }
}
