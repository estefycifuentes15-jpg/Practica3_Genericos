package Modelo;

public class Administrativo extends Persona {
    private String cargo;

    public Administrativo(String nombre, long cedula, String cargo) {
        this.setNombre(nombre);
        this.setCedula(cedula);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void informacion() {
        print("NOMBRE: " + this.getNombre() + " \t CÉDULA: " + this.getCedula() + " \t CARGO: " + this.getCargo());
    }
}