package Modelo;

import java.util.ArrayList;


public class Repositorio<T extends Persona> {
    private ArrayList<T> elementos = new ArrayList<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public T consultar(long cedulaBuscada) {
        for (int i = 0; i < elementos.size(); i++) {
            T obj = elementos.get(i);
            Long cedulaBoxed = obj.getCedula(); // Boxing implícito
            if (cedulaBoxed.longValue() == cedulaBuscada) { // Unboxing
                return obj;
            }
        }
        return null;
    }

    public ArrayList<T> listar() {
        return elementos;
    }
}