package ProgramacionIII.entregable4y5;

import java.util.ArrayList;
import java.util.Collections;

public class Empresa {
    private ArrayList<Empleado> empleados;
    private ArrayList<Solucion> retornobacktracking;

    public Empresa(){
        this.empleados=new ArrayList<Empleado>();
        this.retornobacktracking= new ArrayList<Solucion>();
    }

    public void agregarEmpleados(ArrayList<Empleado> ingreso){
        for(int i=0; i<ingreso.size();i++){
            empleados.add(ingreso.get(i));
        }
    }

    /* EMPIEZO POR LOS MAYORES PORQUE SI A LOS MAYORES LES AGREGO MENORES VOY ACHICANDO DIFERENCIA
    EN CAMBIO A LA INVERSA LA VOY AGRANDANDO */
    public ArrayList<Solucion> formarGruposGreedy(ArrayList<Empleado> entrada){
        // ORDENAR ENTRADA POR FUERZA DE TRABAJO
        Collections.sort(entrada);
        Collections.reverse(entrada);
        // CREO 2 soluciones con LISTAS DE SALIDA
        Solucion grupo1= new Solucion();
        Solucion grupo2= new Solucion();
        while(!entrada.isEmpty()){
            Empleado e= entrada.remove(0);
            if(grupo1.getFuerzaTrabajoTotal()>grupo2.getFuerzaTrabajoTotal()){
                // agregar al grupo2
                grupo2.agregarEmpleado(e);
            }else{
                // agregar al grupo1
                grupo1.agregarEmpleado(e);
            }
        }

        ArrayList<Solucion>retorno= new ArrayList<>();
        retorno.add(grupo1);
        retorno.add(grupo2);

        return retorno;
    }

    public ArrayList<Solucion> formarGruposBacktracking(ArrayList<Empleado> entrada){

        return this.retornobacktracking;
    }
}
