public class ArreglosParte2 {

    public ArreglosParte2() {

    }

    /**
     * Implementar un método que realice un corrimiento a derecha en un arreglo
     * ordenado de tamaño
     * MAX=10 a partir de una posición.
     */
    public void arParte2Ej1() {
        final int TAMANIO = 10;
        int[] arreglo = new int[TAMANIO];
        LibArreglos libAr = new LibArreglos();
        libAr.cargarArregloRandom(arreglo, TAMANIO);
        System.out.println("\nArreglo cargado");
        libAr.imprimirArreglo(arreglo, TAMANIO);
        libAr.corrimientoDerecha(arreglo, TAMANIO, 5);
        System.out.println("\nArreglo corrido");
        libAr.imprimirArreglo(arreglo, TAMANIO);
    }

    /**
     * Implementar un método que realice un corrimiento a izquierda en un arreglo
     * ordenado de
     * tamaño MAX=10 a partir de una posición.
     */
    public void arParte2Ej2() {
        final int TAM = 10;
        int[] arreglo = new int[TAM];
        LibArreglos lib = new LibArreglos();
        lib.cargarArregloRandom(arreglo, TAM);
        System.out.println("\nArreglo cargado");
        lib.imprimirArreglo(arreglo, TAM);
        lib.corrimientoIzquierda(arreglo, TAM, 5);
        System.out.println("\nArreglo corrido");
        lib.imprimirArreglo(arreglo, TAM);
        lib.corrimientoIzquierda(arreglo, TAM, 5);
        System.out.println("\nArreglo corrido 2");
        lib.imprimirArreglo(arreglo, TAM);
        lib.corrimientoIzquierda(arreglo, TAM, 2);
        System.out.println("\nArreglo corrido 3");
        lib.imprimirArreglo(arreglo, TAM);
    }

    /**
     * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
     * encuentra cargado,
     * solicite al usuario un número entero y lo agregue al principio del arreglo
     * (posición 0). Para ello
     * tendrá que realizar un corrimiento a derecha (se pierde el último valor del
     * arreglo).
     */
    public void arParte2Ej3() {
        final int TAM = 10;
        int[] arreglo = new int[TAM];
        LibreriaIn en = new LibreriaIn();
        int valor = -1;
        while (valor != 0) {
            System.out.println("Ingrese el valor a insertar");
            valor = en.returnEntero();
            LibArreglos lib = new LibArreglos();
            lib.cargarArregloRandom(arreglo, TAM);
            System.out.println("\nArreglo cargado");
            lib.imprimirArreglo(arreglo, TAM);
            lib.insertarElemento(arreglo, valor, 1, TAM);
            System.out.println("\nArreglo insertado");
            lib.imprimirArreglo(arreglo, TAM);
        }
    }

    /**
     * Hacer un programa que inserte un elemento en un arreglo (ordenado
     * decrecientemente) de
     * tamaño MAX=10.
     */
    public void arParte2Ej4() {
        final int TAM = 10;
        int[] arreglo = new int[TAM];
        LibArreglos lib = new LibArreglos();
        lib.cargarArregloRandom(arreglo, TAM);
        System.out.println("\nArreglo cargado");
        lib.imprimirArreglo(arreglo, TAM);
        lib.ordenarInserDec(arreglo, TAM);
        System.out.println("\nArreglo ordenado");
        lib.imprimirArreglo(arreglo, TAM);
        int valor = -1;
        LibreriaIn en = new LibreriaIn();
        while (valor != 0) {
            System.out.println("Ingrese un valor a insertar");
            valor = en.returnEntero();
            lib.insertarOrdenadoDec(arreglo, TAM, valor);
            System.out.println("\nArreglo insertado");
            lib.imprimirArreglo(arreglo, TAM);
        }
    }

    /**
     * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
     * encuentra cargado,
     * solicite al usuario un número entero y elimine la primer ocurrencia del
     * número (un número igual)
     * en el arreglo si existe. Para ello tendrá que buscar la posición y si está,
     * realizar un corrimiento a
     * izquierda (queda una copia de la última posición del arreglo en la anteúltima
     * posición)
     */

    public void arParte2Ej5() {
        final int TAM = 10;
        int[] arreglo = new int[TAM];
        LibArreglos lib = new LibArreglos();
        lib.cargarArregloRandom(arreglo, TAM);
        System.out.println("\nArreglo cargado");
        lib.imprimirArreglo(arreglo, TAM);
        LibreriaIn en = new LibreriaIn();
        System.out.println("Ingrese el valor que desea eliminar");
        int valor = en.returnEntero();
        int pos = lib.buscarPosDeElemento(arreglo, TAM, valor);
        if (pos != -1) {
            lib.corrimientoIzquierda(arreglo, TAM, pos);
        } else
            System.out.println("El elemento no se encuentra en la lista");
        System.out.println("\nArreglo eliminado");
        lib.imprimirArreglo(arreglo, TAM);
    }

    /**
     * Hacer un programa que elimine los valores pares en un arreglo de tamaño
     * MAX=10.
     */
    public void arParte2Ej6() {
        final int TAM = 10;
        int[] arreglo = new int[TAM];
        LibArreglos lib = new LibArreglos();
        lib.cargarArregloRandom(arreglo, TAM);
        System.out.println("\nArreglo cargado");
        lib.imprimirArreglo(arreglo, TAM);
        int pos=0;
        while (pos<TAM && arreglo[pos]!=-1){
            if (arreglo[pos]%2==0)
                lib.corrimientoIzquierda(arreglo, TAM, pos);
            else
                pos++;
        }
        System.out.println("\nArreglo sin pares");
        lib.imprimirArreglo(arreglo, TAM);
    }
}
