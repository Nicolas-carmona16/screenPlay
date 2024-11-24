package co.com.udea.certificacion.busquedavuelosa.utils;

public class DateUtils {

    public static String obtenerNombreMes(String mes) {
        switch (mes) {
            case "01": return "January";
            case "02": return "February";
            case "03": return "March";
            case "04": return "April";
            case "05": return "May";
            case "06": return "June";
            case "07": return "July";
            case "08": return "August";
            case "09": return "September";
            case "10": return "October";
            case "11": return "November";
            case "12": return "December";
            default: throw new IllegalArgumentException("Mes no válido: " + mes);
        }
    }

    public static String normalizarNumero(String numero) {
        return numero.startsWith("0") ? numero.substring(1) : numero;
    }
}
