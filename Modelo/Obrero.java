package Modelo;

public class Obrero extends Persona {
    protected String codigo;

    public Obrero(String nombre, long cedula, String codigo) {
        this.setNombre(nombre);
        this.setCedula(cedula);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void informacion() {
        print("NOMBRE: " + this.getNombre() + " \t CÉDULA: " + this.getCedula() + " \t CÓDIGO: " + codigo);
    }
}