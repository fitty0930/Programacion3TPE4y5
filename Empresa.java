package ProgramacionIII.entregable4y5;

import java.util.ArrayList;
import java.util.Collections;

public class Empresa {
    private static final int MAX = 99999;
    private ArrayList<Empleado> empleados;
    private ArrayList<Solucion> retornobacktracking;
    private int anteriorDif;


    public Empresa() {
        this.empleados = new ArrayList<Empleado>();
        this.retornobacktracking = new ArrayList<Solucion>();
        this.anteriorDif = MAX;
    }

    public void agregarEmpleados(ArrayList<Empleado> ingreso) {
        for (int i = 0; i < ingreso.size(); i++) {
            empleados.add(ingreso.get(i));
        }
    }

    /* EMPIEZO POR LOS MAYORES PORQUE SI A LOS MAYORES LES AGREGO MENORES VOY ACHICANDO DIFERENCIA
    EN CAMBIO A LA INVERSA LA VOY AGRANDANDO */
    public ArrayList<Solucion> formarGruposGreedy(ArrayList<Empleado> entrada) {
        // ORDENAR ENTRADA POR FUERZA DE TRABAJO
        Collections.sort(entrada);
        Collections.reverse(entrada);
        // CREO 2 soluciones con LISTAS DE SALIDA
        Solucion grupo1 = new Solucion();
        Solucion grupo2 = new Solucion();
        while (!entrada.isEmpty()) {
            Empleado e = entrada.remove(0);
            if (grupo1.getFuerzaTrabajoTotal() > grupo2.getFuerzaTrabajoTotal()) {
                // agregar al grupo2
                grupo2.agregarEmpleado(e);
            } else {
                // agregar al grupo1
                grupo1.agregarEmpleado(e);
            }
        }

        ArrayList<Solucion> retorno = new ArrayList<>();
        retorno.add(grupo1);
        retorno.add(grupo2);

        return retorno;
    }

    public ArrayList<Solucion> formarGruposBacktracking(ArrayList<Empleado> entrada) {
        Solucion grupo1 = new Solucion();
        Solucion grupo2 = new Solucion();
        ArrayList<Solucion> solucion = new ArrayList<Solucion>();
        solucion.add(grupo1);
        solucion.add(grupo2);
        this.doBacktracking(entrada, solucion, 0);
        return this.retornobacktracking;
    }

    private void doBacktracking(ArrayList<Empleado> entrada, ArrayList<Solucion> parcial, int indiceEntrada) { // AGREGAR INDICE
        if (checkIngresados(entrada)) { // CAMBIAR
            //aca encontre una solucion
            if (Math.abs(parcial.get(0).getFuerzaTrabajoTotal() - parcial.get(1).getFuerzaTrabajoTotal()) < anteriorDif) {
                this.anteriorDif = Math.abs(parcial.get(0).getFuerzaTrabajoTotal() - parcial.get(1).getFuerzaTrabajoTotal());
                System.out.println(anteriorDif);
                System.out.println(parcial.get(0).getFuerzaTrabajoTotal());
                System.out.println(parcial.get(1).getFuerzaTrabajoTotal());
                // guardar la solucion
                // ESTO ANDA MAL EL RESTO ANDA
                ArrayList<Solucion> parcialito= new ArrayList<Solucion>(); // COPIAR LISTA DE EMPLEADOS DE LA SOLUCION
                Solucion solucion1= new Solucion();
                for(int i=0; i<parcial.get(0).getSubgrupo().size();i++){
                    solucion1.agregarEmpleado(parcial.get(0).getSubgrupo().get(i));
                }

                Solucion solucion2 = new Solucion();
                for(int i=0; i<parcial.get(1).getSubgrupo().size();i++){
                    solucion1.agregarEmpleado(parcial.get(1).getSubgrupo().get(i));
                }
                parcialito.add(solucion1);
                parcialito.add(solucion2);

                this.retornobacktracking = parcialito;
            }
        } else {
            // PROBAR METERLO EN EL 1RO Y SI NO EN EL 2DO
            // probar meter en el grupo1
            parcial.get(0).agregarEmpleado(entrada.get(indiceEntrada));
            entrada.get(indiceEntrada).setIngresado(true);
            doBacktracking(entrada, parcial, indiceEntrada+1);
            parcial.get(0).quitarEmpleado(parcial.get(0).getSubgrupo().size()-1);
            entrada.get(indiceEntrada).setIngresado(false);
            //probar meter en el grupo 2
            parcial.get(1).agregarEmpleado(entrada.get(indiceEntrada));
            entrada.get(indiceEntrada).setIngresado(true);
            doBacktracking(entrada, parcial, indiceEntrada+1);
            parcial.get(1).quitarEmpleado(parcial.get(1).getSubgrupo().size()-1);
            entrada.get(indiceEntrada).setIngresado(false);
        }
    }


    private boolean checkIngresados(ArrayList<Empleado> entrada) {
        boolean retorno = true;
        for (int i = 0; i < entrada.size(); i++) {
            if (!entrada.get(i).getIngresado()) {
                retorno = false;
            }
        }

        return retorno;
    }
}
