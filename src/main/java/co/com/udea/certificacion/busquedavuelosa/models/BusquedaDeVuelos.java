package co.com.udea.certificacion.busquedavuelosa.models;

public class BusquedaDeVuelos {

    private String origen;
    private String destino;
    private String fechaIda;

    private String fechaVuelta;

    public BusquedaDeVuelos(String origen, String destino, String fechaIda, String fechaVuelta) {
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
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

    public String getFechaVuelta() {
        return fechaVuelta;
    }
}
