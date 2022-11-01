import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Secuencias {
    final static int MAX = 20;
    final static int MAXPAT = 5;
    final static int MAXREEM=3;
    public static void main(String[] args) {
       // int[] arreglo = new int[MAX];
       /* int[] arPatron = new int[MAXPAT];
        System.out.println("Carga de arreglo inicial");*/
       /*  cargarArreglo(arreglo, MAX);
        imprimirArreglo(arreglo, MAX);
        ejercicio3Segunda(arreglo);*/
        /* 
        System.out.println("Carga del arreglo patron");
        cargarArreglo(arPatron, MAXPAT);*/
        // ejercicio1(arreglo);
        // ejercicio2(arreglo);
        // ejercicio3(arreglo);
        // ejercicio4(arreglo);
        // ejercicio5(arreglo);
        //ejercicio6(arreglo, arPatron);
        //ejercicio7(arreglo);
        char[] arregloC=new char[MAX];
        char[] arregloPat=new char[MAXPAT];
        char[] arregloReem=new char[MAXREEM];
        System.out.println("Carga de arreglo original");
        cargarArreglo(arregloC, MAX);
        System.out.println("Carga de arreglo patron");
        cargarArreglo(arregloPat, MAXPAT);
        System.out.println("carga de arreglo para reemplazar");
        cargarArreglo(arregloReem, MAXREEM);
        imprimirArreglo(arregloPat, MAXPAT);
        imprimirArreglo(arregloReem, MAXREEM);
        imprimirArreglo(arregloC, MAX);
        ejercicio8(arregloC, arregloPat, arregloReem);

        imprimirArreglo(arregloC, MAX);
    }

    public static int getEntero() {
        int numero = 0;
        boolean valido = false;
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        while (!valido) {
            try {
                System.out.println("Ingrese un valor entero");
                numero = Integer.parseInt(bufer.readLine());
                valido = true;
            } catch (Exception e) {
                System.out.println("El valor ingresado es invalido. Ingreselo nuevamente");
            }

        }
        return numero;
    }

    public static char getChar(){
        char letra=' ';
        boolean valido=false;
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        while (!valido){
            try{
                letra = bufer.readLine().charAt(0);
                valido=true;
            }
            catch (Exception e){
                System.out.println("Char invalido, ingreselo nuevamente");
            }
        }
        return letra;
    }

    public static void cargarArreglo(int[] arreglo, int tam) {
        arreglo[0] = 0;
        for (int i = 1; i < tam - 1; i++) {
            arreglo[i] = getEntero();
        }
        System.out.println("**Fin carga del arreglo**");
        arreglo[tam - 1] = 0;
    }

    public static void cargarArreglo(char[] arreglo,int tam){
        arreglo[0] = '*';
        for (int i = 1; i < tam - 1; i++) {
            arreglo[i] = getChar();
        }
        System.out.println("**Fin carga del arreglo**");
        arreglo[tam - 1] = '*';
    }

    public static void imprimirArreglo(int[] arr, int tam) {
        for (int i = 0; i < tam; i++)
            System.out.print(arr[i] + "|");
        System.out.println("");
        System.out.println("-------------------------------");
    }

    public static void imprimirArreglo(char[] arreglo,int tam){
        for (int i = 0; i < tam; i++)
            System.out.print(arreglo[i] + "|");
        System.out.println("");
        System.out.println("-------------------------------");
    }

    /**
     * Hacer un programa que devuelva la posición de inicio y fin de la primera
     * secuencia de
     * números distinta de ceros.
     */
    public static void ejercicio1(int[] arreglo) {
        int inicio = 0;
        int fin = 0;
        inicio = buscarInicio(arreglo, 0,MAX);
        if (inicio < MAX) {
            fin = buscarFinal(arreglo, inicio,MAX);
            System.out.println("La primer secuencia empieza en " + inicio + " y termina en " + fin);
        } else
            System.out.println("No hay secuencia en el arreglo");
    }

    /**
     * Busca la posicion donde empieza una secuencia desde una posicion dada
     * 
     * @param ar  Arreglo
     * @param pos Posicion desde la que se desea buscar el inicio de la secuencia
     * @return posicion de comienzo de la secuencia
     */
    public static int buscarInicio(int[] ar, int pos,int tam) {
        while ((pos < tam) && (ar[pos] == 0))
            pos++;
        return pos;
    }

    public static int buscarInicio(char[] arreglo,int pos, int tam){
        while ((pos<tam)&&(arreglo[pos]=='*'))
            pos++;
        return pos;
    }

    /**
     * Retorna la posicion en la que finaliza una secuencia
     * 
     * @param ar  Arreglo con secuencias
     * @param ini Posicion de inicio de la secuencia
     * @return Entero con la posicion donde finaliza la secuencia actual
     */
    public static int buscarFinal(int[] ar, int ini,int tam) {
        while ((ini < tam) && (ar[ini] != 0))
            ini++;
        if (ini < tam)
            return ini - 1;
        return ini;
    }

    public static int buscarFinal(char[] arreglo, int inicio, int tam){
        while ((inicio<tam) && (arreglo[inicio]!='*'))
            inicio++;
        if (inicio<tam)
            return inicio-1;
        return inicio;
    }

    /**
     * Hacer un programa que devuelva la posición de inicio y fin de la secuencia de
     * números
     * distintos de ceros cuya suma del contenido sea mayor
     * 
     * @param arreglo Arreglo cargado
     */
    public static void ejercicio2(int[] arreglo) {
        int inicioMayor = 0;
        int sumaMayor = 0;
        int finMayor = 0;
        int inicio = -1;
        int fin = -1;
        while (inicio < MAX) {
            inicio = buscarInicio(arreglo, fin + 1,MAX);
            if (inicio < MAX) {
                fin = buscarFinal(arreglo, inicio,MAX);
                int suma = sumarElementos(arreglo, inicio, fin);
                if (suma > sumaMayor) {
                    sumaMayor = suma;
                    inicioMayor = inicio;
                    finMayor = fin;
                }
            }
        }
        if (sumaMayor > 0)
            System.out.println("La secuencia de mayor suma empieza en " + inicioMayor + " y termina en " + finMayor
                    + " y suma " + sumaMayor);
        else
            System.out.println("No existe una secuencia en el arreglo");
    }

    public static int sumarElementos(int[] arreglo, int inicio, int fin) {
        int sumaTotal = 0;
        for (inicio = inicio; inicio <= fin; inicio++)
            sumaTotal = sumaTotal + arreglo[inicio];
        return sumaTotal;
    }

    /**
     * Hacer un programa que devuelva la posición de inicio y fin de la anteúltima
     * secuencia de
     * números distintos de ceros.
     */
    public static void ejercicio3(int[] ar) {
        int tamAnte = 0;
        int finalAnte = -1;
        int inicio = 0;
        int fin = -1;
        int tam = 0;
        while (inicio < MAX) {
            tam = fin - inicio + 1;
            inicio = buscarInicio(ar, fin + 1,MAX);
            if (inicio < MAX) {
                finalAnte = fin;
                tamAnte = tam;
                fin = buscarFinal(ar, inicio,MAX);
            }
        }
        if (finalAnte > 0)
            System.out.println(
                    "La anteultima secuencia empieza en " + (finalAnte - tamAnte + 1) + " y termina en " + finalAnte);
        else
            System.out.println("No existen 2 secuencias en el arreglo");
    }

    public static void ejercicio3Segunda(int[] arreglo){
        int ini=MAX;
        int fin=MAX-1;
        int cant=0;
        while (ini>0&&cant<2){
            ini=buscarInicioDes(arreglo, fin-1);
            if (ini>0){
                fin=buscarFinDes(arreglo, ini);
                cant++;
            }
        }
        if (cant==2)
            System.out.println("La anteultima esta en "+fin+" y "+ ini);
        else
            System.out.println("No existen 2 secuencias en el arreglo");
    }
    public static int buscarInicioDes(int[] arreglo, int pos){
        while (pos>0&&arreglo[pos]==0)
            pos--;
        return pos;
    }
    public static int buscarFinDes(int[] arreglo, int ini){
        while (ini>0&&arreglo[ini]!=0)
            ini--;      
        if (ini>0)
            return ini+1;
        return ini;
    }

    /**
     * Hacer un programa que devuelva la posición de inicio y de fin de la secuencia
     * de mayor
     * tamaño
     * 
     * @param ar Arreglo ya cargado
     */
    public static void ejercicio4(int[] arreglo) {
        int inicioMayor = 0;
        int tamMayor = 0;
        int inicio = -1;
        int fin = -1;
        while (inicio < MAX) {
            inicio = buscarInicio(arreglo, fin + 1,MAX);
            if (inicio < MAX) {
                fin = buscarFinal(arreglo, inicio,MAX);
                if ((fin - inicio + 1) > tamMayor) {
                    tamMayor = fin - inicio + 1;
                    inicioMayor = inicio;
                }
            }
        }
        if (tamMayor > 0)
            System.out.println(
                    "La secuencia mayor empieza en " + inicioMayor + " y termina en " + (inicioMayor + tamMayor - 1));
        else
            System.out.println("No existe una secuencia en el arreglo");
    }

    /**
     * Hacer un programa que dado un número N ingresado por el usuario, elimine las
     * secuencias de tamaño N de números distintos de cero
     * 
     * @param arreglo Arreglo de enteros cargado
     */
    public static void ejercicio5(int[] arreglo) {
        int numero;
        System.out.println("Ingrese la longitud a eliminar");
        numero = getEntero();
        int inicio = -1;
        int fin = -1;
        while (inicio < MAX) {
            inicio = buscarInicio(arreglo, fin + 1,MAX);
            if (inicio < MAX) {
                fin = buscarFinal(arreglo, inicio,MAX);
                if ((fin - inicio + 1) == numero) {
                    eliminarSecuencia(arreglo, inicio, fin - inicio + 1);
                    fin = inicio;
                }
            }
        }
    }

    /**
     * Elimina una secuencia de tamaño tamSec desde la posicion deseada
     * 
     * @param arreglo Arreglo del que se quiere eliminar la secuencia
     * @param inicio  Posicion de inicio de la secuencia en el arreglo
     * @param tamSec  Tamaño que tiene la secuencia que se quiere eliminar
     */
    public static void eliminarSecuencia(int[] arreglo, int inicio, int tamSec) {
        for (int i = 0; i < tamSec; i++) {
            corrimientoIzq(arreglo, inicio);
        }
    }

    /**
     * Realiza el corrimiento a izquierda desde una posicion dada, eliminando el
     * elemento en esa posicion
     * 
     * @param arreglo Arreglo en el que se quiere realizar el corrimiento
     * @param pos     Posicion del elemento que se quiere eliminar
     */
    public static void corrimientoIzq(int[] arreglo, int pos) {
        for (int i = pos; i < MAX - 1; i++)
            arreglo[i] = arreglo[i + 1];
    }

    public static void corrimientoIzq(char[] arreglo, int pos) {
        for (int i = pos; i < MAX - 1; i++)
            arreglo[i] = arreglo[i + 1];
    }
    /**
     * Hacer un programa que elimine de un arreglo todas las ocurrencias de una
     * secuencia patrón dada
     * por otro arreglo
     * 
     * @param arreglo  Arreglo cargado
     * @param arPatron Arreglo con el patron que vamos a eliminar de {@arreglo}
     */
    public static void ejercicio6(int[] arreglo, int[] arPatron) {
        int inicio = -1;
        int fin = -1;
        int inicioPat=buscarInicio(arPatron, 0,MAXPAT);
        int finPat=buscarFinal(arPatron, inicioPat,MAXPAT);
        while (inicio < MAX) {
            inicio = buscarInicio(arreglo, fin + 1,MAX);
            if (inicio < MAX) {
                fin = buscarFinal(arreglo, inicio,MAX);
                if (finPat-inicioPat+1==fin-inicio+1)
                    if (esSecuenciaIgual(arreglo, inicio, fin, arPatron,inicioPat)) {
                        eliminarSecuencia(arreglo, inicio, fin - inicio + 1);
                        fin = inicio;
                }
            }
        }
    }

    public static boolean esSecuenciaIgual(int[] arreglo, int inicio, int fin, int[] patron,int inicioPat) {
        while (inicio<=fin&&arreglo[inicio]==patron[inicioPat]){
            inicio++;
            inicioPat++;
        }
        return(inicio>fin);
    }

    /**
     * Hacer un programa que elimine de un arreglo todas las secuencias que tienen
     * orden descendente
     * entre sus elementos.
     * 
     * @param arreglo
     */
    public static void ejercicio7(int[] arreglo) {
        int inicio = -1;
        int fin = -1;
        while (inicio < MAX) {
            inicio = buscarInicio(arreglo, fin + 1,MAX);
            if (inicio < MAX) {
                fin = buscarFinal(arreglo, inicio,MAX);
                if (esSecuenciaAscendente(arreglo, inicio, fin)) {
                    eliminarSecuencia(arreglo, inicio, fin - inicio + 1);
                    fin = inicio;
                }
            }
        }
    }

    /**
     * Verifica si una secuencia dada es ascendente
     * 
     * @param arreglo
     * @param inicio  Posicion de inicio de la secuencia
     * @param fin     Posicion final de la secuencia
     * @return True si es ascendente, False si no lo es
     */
    public static boolean esSecuenciaAscendente(int[] arreglo, int inicio, int fin) {
        boolean asc = true;
        if (inicio == fin)
            asc = false;
        else
            while (inicio < fin && asc) {
                if (arreglo[inicio] >= arreglo[inicio + 1])
                    asc = false;
                inicio++;
            }
        return asc;
    }
    /**
     * Hacer un programa que reemplace de un arreglo A todas las ocurrencias de una secuencia patrón
     * dada en un arreglo P, por la secuencia contenida en el arreglo R.
     * @param arreglo Arreglo original
     * @param patron Arreglo con la secuencia patron
     * @param arReem Arreglo con la secuencia que se quiere insertar
     */
    public static void ejercicio8(char[] arreglo, char[] patron, char[] arReem){
        int inicio=0;
        int fin=-1;
        int inicioPat=buscarInicio(patron, 0, MAXPAT);
        int finPat=buscarFinal(patron, inicioPat, MAXPAT);
        while (inicio<MAX){
            inicio=buscarInicio(arreglo,(fin+1), MAX);
            if (inicio<MAX){
                fin=buscarFinal(arreglo, inicio, MAX);
                if (fin-inicio+1==finPat-inicioPat+1)
                    if (esSecuenciaIgual(arreglo, inicio, fin, patron, inicioPat)){
                        prepararSecuencia(arreglo,inicio,fin,arReem);
                        reemplazarSecuencia(arreglo,inicio,arReem);
                    }
            }
        }
    }

    public static void prepararSecuencia(char[] arreglo, int inicio,int fin,char[] arReem){
        int inicioR=buscarInicio(arReem, 0, MAXREEM);
        int finR=buscarFinal(arReem, inicioR, MAXREEM);
        int tamR=finR-inicioR+1;
        int dif=tamR-(fin-inicio+1);
        realizarCorrimientos(arreglo, inicio, dif);
    }

    public static void realizarCorrimientos(char[] arreglo,int inicio,int dif){
        if (dif>0){
            while (dif>0&&inicio<MAX-1){
                corrimientoDerecha(arreglo, inicio);
                dif--;
                inicio++;
            }
        }
        else
            if (dif<0){
                while (dif<0){
                    corrimientoIzq(arreglo, inicio);
                    dif++;
                }
            }
    }

    public static void reemplazarSecuencia(char[] arreglo,int inicio, char[] arReem){
        int inicioR=buscarInicio(arReem, 0, MAXREEM);
        int finR=buscarFinal(arReem, inicioR, MAXREEM);
        while (inicio<MAX&&inicioR<=finR){
            arreglo[inicio]=arReem[inicioR];
            inicio++;
            inicioR++;
        }
    }

    public static void corrimientoDerecha(char[] arreglo,int inicio){
        int pos=MAX-2;
        while (pos>inicio){
            arreglo[pos]=arreglo[pos-1];
            pos--;
        }
    }

    public static boolean esSecuenciaIgual(char[] arreglo, int inicio,int fin,char[] patron,int inicioPat){
        while (inicio<=fin && arreglo[inicio]==patron[inicioPat]){
            inicio++;
            inicioPat++;
        }
        return (inicio>fin);
    }
}
