package co.com.udea.certificacion.busquedavuelosa.models;

public class BusquedaDeVuelos {

    private String origen;
    private String destino;
    private String fechaIda;

    public BusquedaDeVuelos(String origen, String destino, String fechaIda) {
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFechaIda() {
        return fechaIda;
    }
}
