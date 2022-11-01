import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Naty {

    static final int N = 20;

    public static void main(String[] args) {
        int[] arreglo = { 0, 2, 5, 0, 3, 4, 6, 0, 0, 3, 4, 0, 0, 4, 5, 6, 7, 8, 0, 0 };
        int[] arregloReem={0,0,2,3,5,0};
        int cant = contarCantidadSecAscendentes(arreglo);
        System.out.println(cant);
        int valor = getNumeroPorRango(1, 10);
        if (cant % valor == 0)
            buscarSecuenciaAInvertir(valor, arreglo);
        imprimirArreglo(arreglo);

        /*int valorEliminar = getNumeroPorRango(1, 20);
        buscarSecuenciasXSumaTotal(arreglo, valorEliminar);
        imprimirArreglo(arreglo);*/

        buscarSecuenciaParaReemplazar(arreglo, arregloReem);
        System.out.println("\n");
        imprimirArreglo(arreglo);
    }

    /**
     * Imprime un arreglo
     * @param arreglo
     */
    public static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < N; i++)
            System.out.print(arreglo[i] + "|");
    }
    /*
     * Dada un arreglo de N enteros con secuencias separadas por ceros (0) contar e
     * informar la
     * cantidad de secuencias que están en orden ascendente.
     * Por ejemplo, el siguiente arreglo posee 3 secuencias que cumplen con dicha
     * condición.
     */

    // 0 0 0 2 5 0 3 4 1 0 0 3 5 0 8 0
    // Buscar el inicio de la secuencia
    // Buscar el fin
    // Ver si es ascendente

    // Buscar el inicio de la secuencia
    public static int encontrarInicio(int[] arr, int pos) {
        while (pos < N && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }
    /**
     * Recorre el arreglo hasta que encuentra un 0, que implica el fin de la secuencia
     * @param arr Arreglo en el cual buscar
     * @param pos Posicion a partir de la cual buscar el fin
     * @return la posicion final de la secuencia
     */
    public static int encontrarFin(int[] arr, int pos) {
        while (pos < N && arr[pos] != 0)
            pos++;

        return pos - 1;
    }

    // 4 2 3 4 5 6
    // verifica si una secuencia es ascendente
    public static boolean esAscendente(int[] arr, int ini, int fin) {
        boolean esAsc = true;
        while ((ini < fin) && (esAsc)) {
            if (arr[ini] > arr[ini + 1])
                esAsc = false;
            ini++;
        }
        return esAsc;
    }

    // contar e informar la cantidad de secuencias que están en orden ascendente.
    // Busca el inicio de una secuenci
    // Busca el fin de la secuencia
    // pregunta si es ascendente
    // 0 0 0 2 5 0 3 4 1 0 0 3 5 0 8 0
    public static int contarCantidadSecAscendentes(int[] arr) {
        int cant = 0;
        int inicio = encontrarInicio(arr, 0);
        while (inicio < N) {
            int fin = encontrarFin(arr, inicio);
            if (esAscendente(arr, inicio, fin)) {
                cant++;
            }
            inicio = encontrarInicio(arr, fin + 1);
        }
        return cant;
    }

    /**
     * Pide al usuario que ingrese un numero desde el teclado entre un rango minimo y un maximo
     * @param min Rango minimo
     * @param max Rango maximo
     * @return El entero ingresado por el usuario
     */
    public static int getNumeroPorRango(int min, int max) {
        int numero = min - 1;
        while (numero < min || numero > max) {
            try {
                System.out.println("Ingrese un entero entre " + min + " y " + max);
                BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
                numero = Integer.parseInt(bufer.readLine());
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        return numero;
    }

    /**
     * Busca en el arreglo la secuencia 
     * @param valor
     * @param arreglo
     */
    public static void buscarSecuenciaAInvertir(int valor, int[] arreglo) {
        int contador = 0;
        int inicio = encontrarInicio(arreglo, 0);
        while (inicio < N) {
            int fin = encontrarFin(arreglo, inicio);
            contador++;
            if (valor == contador)
                invertirSecuencia(arreglo, inicio, fin);
            inicio = encontrarInicio(arreglo, fin + 1);
        }
    }

    public static void invertirSecuencia(int[] arreglo, int ini, int fin) {
        int aux;
        while (ini < fin) {
            aux = arreglo[ini];
            arreglo[ini] = arreglo[fin];
            arreglo[fin] = aux;
            ini++;
            fin--;
        }
    }

    /*
     * Pedir un numero del 1 al 20 y eliminar las secuencias cuya suma sea igual al
     * numero ingresado
     */
    public static void buscarSecuenciasXSumaTotal(int[] arreglo, int suma) {
        int ini = encontrarInicio(arreglo, 0);
        while (ini < N) {
            int fin = encontrarFin(arreglo, ini);
            int sumaTotal = calcularSumaSecuencia(arreglo, ini, fin);
            if (suma == sumaTotal)
                eliminarSecuencia(arreglo, ini, (fin - ini + 1));
            else
                ini = encontrarInicio(arreglo, fin + 1);
        }
    }

    public static int calcularSumaSecuencia(int[] arreglo, int ini, int fin) {
        int suma = 0;
        while (ini <= fin) {
            suma += arreglo[ini];
            ini++;
        }
        return suma;
    }

    public static void eliminarSecuencia(int[] arreglo, int ini, int cantidad) {
        while (cantidad > 0) {
            corrimientoIzquierda(arreglo, ini);
            cantidad--;
        }
    }

    public static void corrimientoIzquierda(int[] arreglo, int pos) {
        while (pos < (N - 1)) {
            arreglo[pos] = arreglo[pos + 1];
            pos++;
        }
        arreglo[N - 1] = 0;
    }

    /* Reemplazar todas las secuencias cuya longitud sea multiplo de 2 */
    public static void buscarSecuenciaParaReemplazar(int[] arreglo, int[] arReem) {
        int ini = encontrarInicio(arreglo, 0);
        while (ini < N) {
            int fin = encontrarFin(arreglo, ini);
            if ((fin - ini + 1) % 2 == 0) {
                reemplazarSecuencia(arreglo, ini, fin, arReem);
                fin=encontrarFin(arreglo, ini);
            }
            ini=encontrarInicio(arreglo, fin+1);
        }
    }

    public static void reemplazarSecuencia(int[] arreglo, int ini,int fin, int[] arReem){
        int iniR=encontrarInicio(arReem, 0);
        int finR=encontrarFin(arReem, iniR);
        int longR=(finR-iniR+1);
        int longArr=(fin-ini+1);
        if (longR>longArr)
            corrimientoDerecha(arreglo,fin,longR-longArr);
        else
            if (longR<longArr)
                corrimientoIzquierda(arreglo, fin-(longArr-longR));

        insertarSecuencia(arreglo,ini,arReem,iniR,finR);
    }

    public static void corrimientoDerecha(int[] arreglo, int fin, int cant) {
        int pos = N - 2;
        while (pos > (fin+1)) {
            arreglo[pos] = arreglo[pos - 1];
            pos--;
        }
    }

    public static void insertarSecuencia(int[] arreglo,int ini,int[] arrReem,int iniR,int finR){
        while (iniR<=finR){
            arreglo[ini]=arrReem[iniR];
            ini++;
            iniR++;
        }
    }
}
