package ProgramacionIII.entregable4y5;

import java.util.ArrayList;

public class Solucion {
    private ArrayList<Empleado> subgrupo;
    private int fuerzaTrabajoTotal;

    public Solucion(){
        subgrupo= new ArrayList<Empleado>();
    }

    public void agregarEmpleado(Empleado empleado){
        this.subgrupo.add(empleado);
        fuerzaTrabajoTotal+=empleado.getFuerzaTrabajo();
    }

    public ArrayList<Empleado> getSubgrupo(){
        ArrayList<Empleado>aux= new ArrayList<Empleado>(subgrupo);
        return aux;
    }

    public int getFuerzaTrabajoTotal(){
        return this.fuerzaTrabajoTotal;
    }
}
