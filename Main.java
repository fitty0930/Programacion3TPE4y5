package ProgramacionIII.entregable4y5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        e1	Juan	Pérez	32	48
        e2	Roberto	Hernández	45	57
        e3	Camila	Gutiérrez	33	51
        e4	Francisco	Martínez	22	73
        e5	Benjamín	Núñez	55	15
        e6	Mateo	Morales	24	33
        e7	Delfina	López	36	92
        e8	Catalina	Cruz	51	71
        e9	Benicio	Montero	48	19
        e10	Valentino	González	58	22
        e11	Olivia	Gómez	33	41
        e12	Martina	Díaz	21	49
        e13	Joaquín	Cabrera	22	14
        e14	Bautista	Domínguez	36	33
        e15	Emilia	Paz	40	16
        e16	Francesca	Figueroa	43	21
        e17	Santino	Blanco	25	79
        e18	Ignacio	Ibarra	61	32
        e19	Andrea	Chávez	27	78
        e20	Elena 	Mengochea 	 52	 67
        */
        Empleado e1 = new Empleado("Juan", "Pérez", 32, 48);
        Empleado e2 = new Empleado("Roberto", "Hernández", 45, 57);
        Empleado e3 = new Empleado("Camila", "Gutiérrez", 33, 51);
        Empleado e4 = new Empleado("Francisco", "Martínez", 22, 73);
        Empleado e5 = new Empleado("Benjamín", "Núñez", 55, 15);
        Empleado e6 = new Empleado("Mateo", "Morales", 24, 33);
        Empleado e7 = new Empleado("Delfina", "López", 36, 92);
        Empleado e8 = new Empleado("Catalina", "Cruz", 51, 71);
        Empleado e9 = new Empleado("Benicio", "Montero", 48, 19);
        Empleado e10 = new Empleado("Valentino", "González", 58, 22);
        Empleado e11 = new Empleado("Olivia", "Gómez", 33, 41);
        Empleado e12 = new Empleado("Martina", "Díaz", 21, 49);
        Empleado e13 = new Empleado("Joaquín", "Cabrera", 22, 14);
        Empleado e14 = new Empleado("Bautista", "Domínguez", 36, 33);
        Empleado e15 = new Empleado("Emilia", "Paz", 40, 16);
        Empleado e16 = new Empleado("Francesca", "Figueroa", 43, 21);
        Empleado e17 = new Empleado("Santino", "Blanco", 25, 79);
        Empleado e18 = new Empleado("Ignacio", "Ibarra", 61, 32);
        Empleado e19 = new Empleado("Andrea", "Chávez", 27, 78);
        Empleado e20 = new Empleado("Elena", "Mengochea", 52, 67);
        ArrayList<Empleado>empleados=new ArrayList<Empleado>();
        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);
        empleados.add(e4);
        empleados.add(e5);
        empleados.add(e6);
        empleados.add(e7);
        empleados.add(e8);
        empleados.add(e9);
        empleados.add(e10);
        empleados.add(e11);
        empleados.add(e12);
        empleados.add(e13);
        empleados.add(e14);
        empleados.add(e15);
        empleados.add(e16);
        empleados.add(e17);
        empleados.add(e18);
        empleados.add(e19);
        empleados.add(e20);

        Empresa empresa= new Empresa();
        empresa.agregarEmpleados(empleados);

        ArrayList<Empleado> ingreso= new ArrayList<>();
        Empleado [] entrada1=  {e1, e2, e3, e4, e5, e6};
        ingreso.clear();
        for(int i=0; i<entrada1.length; i++){
            ingreso.add(entrada1[i]);
        }
        ArrayList<Solucion> solucion= empresa.formarGruposGreedy(ingreso);
        System.out.println("solucion 1 fuerza trabajo total "+solucion.get(0).getFuerzaTrabajoTotal());
        System.out.println("solucion 1 cantidad de empleados "+solucion.get(0).getSubgrupo().size());
        System.out.println("solucion 2 fuerza trabajo total "+solucion.get(1).getFuerzaTrabajoTotal());
        System.out.println("solucion 2 cantidad de empleados "+solucion.get(1).getSubgrupo().size());




    }
}
