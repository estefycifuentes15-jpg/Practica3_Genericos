package Controlador;

import Modelo.Administrativo;
import Modelo.Obrero;
import Modelo.Repositorio;
import Modelo.Tecnico;

public class Controlador {
    private Repositorio<Administrativo> repoAdministrativos = new Repositorio<>();
    private Repositorio<Obrero> repoObreros = new Repositorio<>();
    private Repositorio<Tecnico> repoTecnicos = new Repositorio<>();

    // RF-06: Valida que la cédula sea estrictamente de 10 dígitos numéricos
    public boolean validarCedula(String cedulaStr) {
        if (cedulaStr == null || !cedulaStr.matches("\\d{10}")) {
            return false;
        }
        return true;
    }

    public boolean registrarAdministrativo(String nombre, String cedulaStr, String cargo) {
        if (!validarCedula(cedulaStr)) return false;
        long cedula = Long.parseLong(cedulaStr);
        if (repoAdministrativos.consultar(cedula) != null) return false;

        repoAdministrativos.agregar(new Administrativo(nombre, cedula, cargo));
        return true;
    }

    public boolean registrarObrero(String nombre, String cedulaStr, String codigo) {
        if (!validarCedula(cedulaStr)) return false;
        long cedula = Long.parseLong(cedulaStr);
        if (repoObreros.consultar(cedula) != null) return false;

        repoObreros.agregar(new Obrero(nombre, cedula, codigo));
        return true;
    }

    public boolean registrarTecnico(String nombre, String cedulaStr, String codigo, String clave) {
        if (!validarCedula(cedulaStr)) return false;
        long cedula = Long.parseLong(cedulaStr);
        if (repoTecnicos.consultar(cedula) != null) return false;

        repoTecnicos.agregar(new Tecnico(nombre, cedula, codigo, clave));
        return true;
    }

    public String consultarEmpleadoGeneral(long cedula) {
        Administrativo adm = repoAdministrativos.consultar(cedula);
        if (adm != null) {
            return "--- EMPLEADO ENCONTRADO (ADMINISTRATIVO) ---\n" +
                   "Nombre: " + adm.getNombre() + "\n" +
                   "Cédula: " + adm.getCedula() + "\n" +
                   "Cargo: " + adm.getCargo();
        }
        
        Obrero obr = repoObreros.consultar(cedula);
        if (obr != null) {
            return "--- EMPLEADO ENCONTRADO (OBRERO) ---\n" +
                   "Nombre: " + obr.getNombre() + "\n" +
                   "Cédula: " + obr.getCedula() + "\n" +
                   "Código: " + obr.getCodigo();
        }
        
        Tecnico tec = repoTecnicos.consultar(cedula);
        if (tec != null) {
            return "--- EMPLEADO ENCONTRADO (TÉCNICO) ---\n" +
                   "Nombre: " + tec.getNombre() + "\n" +
                   "Cédula: " + tec.getCedula() + "\n" +
                   "Código: " + tec.getCodigo() + "\n" +
                   "Clave de Acceso: " + tec.getClaveAcceso();
        }
        
        return "No se encontró ningún empleado registrado con esa cédula.";
    }
}