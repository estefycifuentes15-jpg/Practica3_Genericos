package Modelo;

public class Tecnico extends Obrero {
    private String claveAcceso;

    public Tecnico(String nombre, long cedula, String codigo, String claveAcceso) {
        super(nombre, cedula, codigo);
        this.setClaveAcceso(claveAcceso);
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    @Override
    public void informacion() {
        print("NOMBRE: " + this.getNombre() + " \t CÉDULA: " + this.getCedula() + " \t CÓDIGO: " + codigo + " \t CLAVE: " + claveAcceso);
    }
}