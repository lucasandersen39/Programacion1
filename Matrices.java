import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Matrices {
    final static int FIL = 4;
    final static int COL = 20;

    public static void main(String[] args) {
        int[][] matriz = new int[FIL][COL];
        // cargarMatriz(matriz);
        cargarMatrizSecuencia(matriz);
        // imprimirMatriz(matriz);
        System.out.println("---------------------------");
        // ordenarMatrizCrec(matriz);
        imprimirMatriz(matriz);
        ejercicio11(matriz);
        //ejercicio10(matriz);
        // ejercicio9(matriz);
        // ejercicio8(matriz);
        // ejercicio7(matriz);
        // ejercicio6(matriz);
        // ejercicio5(matriz);
        // ejercicio4(matriz);
        // ejercicio3(matriz);
        // ejercicio2(matriz);
        // ejercicio1(matriz);
        // imprimirMatriz(matriz);
    }

    /**
     * Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se
     * encuentra precargada,
     * invierta el orden del contenido por fila. Este intercambio no se debe
     * realizar de manera explícita, hay
     * que hacer un método que incluya una iteración de intercambio.
     * 
     */
    public static void ejercicio1(int[][] matriz) {
        for (int f = 0; f < FIL; f++)
            invertirFila(matriz[f]);
    }

    public static void invertirFila(int[] fila) {
        int ini = 0;
        int fin = COL - 1;
        while (ini < fin) {
            int aux = fila[ini];
            fila[ini] = fila[fin];
            fila[fin] = aux;
            ini++;
            fin--;
        }
    }

    public static void cargarMatriz(int[][] matriz) {
        for (int f = 0; f < FIL; f++)
            for (int c = 0; c < COL; c++)
                matriz[f][c] = obtenerNumeroAleatorio(9);
    }

    public static int obtenerNumeroAleatorio(int max) {
        return (int) (max * Math.random());
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int f = 0; f < FIL; f++) {
            for (int c = 0; c < COL; c++)
                System.out.print(matriz[f][c] + " ");
            System.out.println(" ");
        }
    }

    /**
     * Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se
     * encuentra precargada,
     * obtenga la cantidad de números pares que tiene y la imprima
     * 
     * @param matriz
     */
    public static void ejercicio2(int[][] matriz) {
        int cant = 0;
        for (int f = 0; f < FIL; f++)
            cant += contarParesFilas(matriz[f]);

        System.out.println("Hay " + cant + " numeros pares en la matriz");
    }

    public static int contarParesFilas(int[] arreglo) {
        int total = 0;
        for (int c = 0; c < COL; c++)
            if (arreglo[c] % 2 == 0)
                total++;
        return total;
    }

    public static int getNumero() {
        int numero = 0;
        boolean esValido = false;
        while (!esValido) {
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
            try {
                numero = Integer.parseInt(bufer.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("El valor ingresado es incorrecto. Ingrese un valor entero nuevamente");
            }
        }
        return numero;
    }

    /**
     * Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se
     * encuentra precargada,
     * solicite al usuario una posición fila, columna y realice un corrimiento a
     * izquierda.
     * 
     * @param matriz
     */
    public static void ejercicio3(int[][] matriz) {
        System.out.println("Ingrese un valor entre" + 0 + " y " + FIL + " para la fila");
        int fila = obtenerValorPorRango(0, FIL);
        System.out.println("Ingrese un valor entre " + 0 + " y " + COL + " para la columna");
        int columna = obtenerValorPorRango(0, COL);
        corrimientoIzqFila(matriz[fila], columna);
    }

    public static int obtenerValorPorRango(int min, int max) {
        int valor = min - 1;
        while (valor < min || valor > max) {
            System.out.println("Ingrese un valor entre " + min + " y " + max);
            valor = getNumero();
        }
        return valor;
    }

    public static void corrimientoIzqFila(int[] fila, int col) {
        for (int i = col; i < (COL - 1); i++)
            fila[i] = fila[i + 1];
        fila[COL - 1] = 0;
    }

    /**
     * Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se
     * encuentra precargada,
     * solicite al usuario un número entero y una posición fila, columna. Con estos
     * datos tendrá que realizar un
     * corrimiento a derecha (se pierde el último valor en dicha fila) y colocar el
     * número en la matriz en la
     * posición fila, columna indicada.
     */
    public static void ejercicio4(int[][] matriz) {
        System.out.println("Ingrese un valor entre" + 0 + " y " + FIL + " para la fila");
        int fila = obtenerValorPorRango(0, FIL);
        System.out.println("Ingrese un valor entre " + 0 + " y " + COL + " para la columna");
        int columna = obtenerValorPorRango(0, COL);
        System.out.println("Ingrese el valor a insertar");
        int valor = getNumero();
        corrimientoDerFila(matriz[fila], columna);
        matriz[fila][columna] = valor;
    }

    public static void corrimientoDerFila(int[] arreglo, int col) {
        for (int fin = (COL - 1); fin > col; fin--)
            arreglo[fin] = arreglo[fin - 1];
    }

    /**
     * Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se
     * encuentra precargada,
     * solicite al usuario un número entero y elimine la primer ocurrencia de número
     * en la matriz (un número
     * igual) si existe. Para ello tendrá que buscar la posición y si está, realizar
     * un corrimiento a izquierda y no
     * continuar buscando.
     * 
     * @param matriz
     */
    public static void ejercicio5(int[][] matriz) {
        System.out.println("Ingrese el valor a eliminar");
        int valor = getNumero();
        boolean esta = false;
        int i = 0;
        while (i < FIL && !esta) {
            int j = 0;
            while (j < COL && !esta) {
                if (matriz[i][j] == valor) {
                    corrimientoIzqFila(matriz[i], j);
                    esta = true;
                }
                j++;
            }
            i++;
        }
    }

    /**
     * Hacer un programa que dada una matriz de enteros de tamaño 5*10 que se
     * encuentra precargada,
     * solicite al usuario un número entero y elimine todas las ocurrencia de número
     * en la matriz si existe.
     * Mientras exista (en cada iteración tiene que buscar la posición fila y
     * columna) tendrá que usar dicha
     * posición para realizar un corrimiento a izquierda.
     * 
     * @param matriz
     */
    public static void ejercicio6(int[][] matriz) {
        System.out.println("Ingrese el valor a eliminar");
        int valor = getNumero();
        for (int i = 0; i < FIL; i++)
            for (int j = 0; j < COL; j++)
                if (matriz[i][j] == valor) {
                    corrimientoIzqFila(matriz[i], j);
                    j--;
                }
    }

    /**
     * Hacer un programa que dado una matriz ordenada creciente por filas de enteros
     * de tamaño 4*5 que se
     * encuentra precargada, solicite al usuario un número entero y una fila, y
     * luego inserte el número en la
     * matriz en la fila indicada manteniendo su orden.
     * 
     * @param matriz
     */
    public static void ejercicio7(int[][] matriz) {
        System.out.println("Ingrese un valor entre" + 0 + " y " + FIL + " para la fila");
        int fila = obtenerValorPorRango(0, FIL);
        System.out.println("Ingrese el valor a insertar");
        int valor = getNumero();
        int pos = buscarPosicionCrec(matriz[fila], valor);
        if (pos != -1) {
            corrimientoDerFila(matriz[fila], pos);
            matriz[fila][pos] = valor;
        } else
            System.out.println("El valor ingresado No se puede insertar ya que es mayor que todos los elementos");
    }

    public static int buscarPosicionCrec(int[] arreglo, int valor) {
        int pos = 0;
        while (pos < COL && arreglo[pos] < valor)
            pos++;

        if (pos < COL)
            return pos;
        else
            return -1;
    }

    public static void ordenarMatrizCrec(int[][] matriz) {
        for (int i = 0; i < FIL; i++)
            ordenarFilaCrec(matriz[i]);
    }

    public static void ordenarFilaCrec(int[] arreglo) {
        for (int i = 1; i < COL; i++)
            for (int j = 0; j < COL - 1; j++)
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
    }

    /**
     * Hacer un programa que dado una matriz ordenada creciente por filas de enteros
     * de tamaño 4*5 que se
     * encuentra precargada, solicite al usuario un número entero y una fila, y
     * elimine la primer ocurrencia de
     * número en la fila indicada (un número igual) si existe.
     * 
     * @param matriz
     */
    public static void ejercicio8(int[][] matriz) {
        System.out.println("Ingrese un valor entre" + 0 + " y " + FIL + " para la fila");
        int fila = obtenerValorPorRango(0, FIL);
        System.out.println("Ingrese el valor a insertar");
        int valor = getNumero();
        int pos = buscarPosicionCrec(matriz[fila], valor);
        if ((pos != -1) && (matriz[fila][pos] == valor))
            corrimientoIzqFila(matriz[fila], pos);
        else
            System.out.println("El valor ingresado No se puede eliminar ya que no se encuentra en la fila dada");
    }

    /**
     * Hacer un programa que dado una matriz de enteros de tamaño 4*5 que se
     * encuentra precargada,
     * solicite al usuario el ingreso de una fila y dos números enteros (columnas de
     * la matriz), y ordene de
     * forma creciente la matriz en la fila indicada entre las dos posiciones
     * columnas ingresadas.
     * 
     * @param matriz
     */
    public static void ejercicio9(int[][] matriz) {
        System.out.println("Ingrese un valor entre" + 0 + " y " + (FIL - 1) + " para la fila");
        int fila = obtenerValorPorRango(0, FIL - 1);
        System.out.println("Ingrese el primer valor entre " + 0 + " y " + (COL - 1) + " para la columna inicio");
        int colIni = obtenerValorPorRango(0, COL - 1);
        System.out.println("Ingrese el segundo valor entre " + 0 + " y " + (COL - 1) + " para la columna fin");
        int colFin = obtenerValorPorRango(0, COL - 1);

        ordenarFilaPorRango(matriz[fila], colIni, colFin);
    }

    public static void ordenarFilaPorRango(int[] arreglo, int ini, int fin) {
        int menor, pos, tmp;
        for (int i = ini; i < fin; i++) { // tomamos como menor el primero
            menor = arreglo[i]; // de los elementos que quedan por ordenar
            pos = i; // y guardamos su posición
            for (int j = i + 1; j <= fin; j++) { // buscamos en el resto
                if (arreglo[j] < menor) { // del array algún elemento
                    menor = arreglo[j]; // menor que el actual
                    pos = j;
                }
            }
            if (pos != i) { // si hay alguno menor se intercambia
                tmp = arreglo[i];
                arreglo[i] = arreglo[pos];
                arreglo[pos] = tmp;
            }
        }
    }

    /* MATRIZ DE SECUENCIA */

    public static void cargarMatrizSecuencia(int[][] matriz) {
        for (int i = 0; i < FIL; i++) {
            matriz[i][0] = 0;
            for (int j = 1; j < COL - 1; j++)
                matriz[i][j] = obtenerNumeroAleatorio(10);
            matriz[i][COL - 1] = 0;
        }
    }

    /**
     * Hacer un programa que dada la matriz de secuencias de enteros definida y
     * precargada, permita
     * obtener a través de métodos la posición de inicio y la posición de fin de la
     * secuencia ubicada a
     * partir de una posición entera y una fila, ambas ingresadas por el usuario.
     * Finalmente, si existen
     * imprima por pantalla ambas posiciones obtenidas.
     * 
     * @param matriz
     */
    public static void ejercicio10(int[][] matriz) {
        System.out.println("Ingrese la fila donde desea buscar");
        int fila = obtenerValorPorRango(0, FIL - 1);
        System.out.println("Ingrese la posicion de la columna");
        int pos = obtenerValorPorRango(0, COL - 1);
        int inicio;
        int fin;
        if (matriz[fila][pos] != 0) {
            inicio = obtenerInicioInvertido(matriz[fila], pos);
            fin = obtenerFin(matriz[fila], pos);
            System.out.println("La secuencia comienza en la posicion " + inicio + " y termina en " + fin);
        } else
            System.out.println("No hay una secuencia en la posicion seleccionada");
    }

    public static int obtenerFin(int[] arreglo, int ini) {
        while (ini < COL - 1 && arreglo[ini] != 0)
            ini++;

        return (ini - 1);
    }

    public static int obtenerInicioInvertido(int[] arreglo, int pos) {
        while (pos > 0 && arreglo[pos] != 0)
            pos--;

        return pos + 1;
    }

    public static int obtenerInicio(int[] arreglo, int pos) {
        while (pos < (COL-1) && arreglo[pos] == 0)
            pos++;

        if (pos < (COL-1))
            return pos;
        else
            return (COL-1);
    }

    /**
     * Hacer un programa que dada la matriz de secuencias de enteros definida y
     * precargada permita
     * encontrar por cada fila la posición de inicio y fin de la secuencia cuya suma
     * de valores sea mayor.
     * 
     * @param matriz
     */
    public static void ejercicio11(int[][] matriz) {
        int fila = 0;
        while (fila < FIL) {
            int inicio = buscarInicioSumaMayor(matriz[fila]);
            if (inicio != -1) {
                int fin = obtenerFin(matriz[fila], inicio);
                System.out.println("La secuencia que mas suma en la fila " + fila + " empieza en " + inicio
                        + " y termina en " + fin);
            } else
                System.out.println("No hay secuencia en la fila " + fila);
            fila++;
        }
    }

    public static int buscarInicioSumaMayor(int[] arreglo) {
        int sumaMayor = 0;
        int iniMayor = -1;
        int inicio = obtenerInicio(arreglo, 0);
        while (inicio < COL-1) {
            int fin = obtenerFin(arreglo, inicio);
            int suma = sumarSecuencia(arreglo, inicio, fin);
            if (suma > sumaMayor) {
                sumaMayor = suma;
                iniMayor = inicio;
            }
            inicio = obtenerInicio(arreglo, fin + 1);
        }
        return iniMayor;
    }

    public static int sumarSecuencia(int[] arreglo, int ini, int fin) {
        int suma = 0;
        for (int i = ini; i <= fin; i++)
            suma += arreglo[i];

        return suma;
    }

    /**
     * Hacer un programa que dada la matriz de secuencias de enteros definida y precargada, y un número
        entero ingresado por el usuario, elimine de cada fila las secuencias de tamaño igual al número
        ingresado.
     * @param matriz
     */
    public static void ejercicio13(int[][] matriz){
        System.out.println("Ingrese la longitud de la secuencia a eliminar");
        int valor=getNumero();

        
    }
}
