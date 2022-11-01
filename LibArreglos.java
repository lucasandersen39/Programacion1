import java.util.Random;

public class LibArreglos {

    public LibArreglos() {

    }

    /**
     * imprime un arreglo de enteros
     * 
     * @param ar  Arreglo a imprimir
     * @param tam Tamaño del arreglo
     */
    public void imprimirArreglo(int[] ar, int tam) {
        for (int i = 0; i < tam; i++)
            System.out.print(ar[i] + "|");
    }

    /**
     * Imprime un arreglo de Char
     * 
     * @param ar  Arreglo a mostrar
     * @param tam Tamaño del arreglo
     */
    public void imprimirArreglo(char[] ar, int tam) {
        for (int i = 0; i < tam; i++)
            System.out.print(ar[i] + "|");
    }

    /**
     * Invierte el contenido de un arreglo
     * 
     * @param ar  Arreglo a invertir
     * @param tam Tamaño del arreglo
     */
    public void invertirArreglo(int[] ar, int tam) {
        int primero = 0;
        int ultimo = tam;
        int valorAux = 0;
        while (primero < ultimo) {
            valorAux = ar[primero];
            ar[primero] = ar[ultimo];
            ar[ultimo] = valorAux;
            primero++;
            ultimo--;
        }
    }

    /**
     * Carga un arreglo con valores enteros random
     * 
     * @param ar  Arreglo a cargar
     * @param tam Tamaño del arreglo
     */
    public void cargarArregloRandom(int[] ar, int tam) {
        for (int i = 0; i < tam; i++)
            ar[i] = (int) (100 * Math.random());
    }

    /**
     * Carga un arreglo con valores char random
     * 
     * @param ar  Arreglo a cargar
     * @param tam Tamaño del arreglo
     */
    public void cargarArregloRandom(char[] ar, int tam) {
        Random ran = new Random();
        for (int i = 0; i < tam; i++)
            ar[i] = (char) (ran.nextInt(26) + 'a');
    }

    /**
     * Corre el contenido del arreglo de enteros a derecha hasta la posicion pos
     * 
     * @param ar  Arreglo al que se le quiere hacer el corrimiento
     * @param tam Tamaño del arreglo
     * @param pos Posicion hasta la que se quiere hacer el corrimiento
     */
    public void corrimientoDerecha(int[] ar, int tam, int pos) {
        int ultimo = tam - 1;
        while (ultimo > pos) {
            ar[ultimo] = ar[ultimo - 1];
            ultimo--;
        }
    }

    /**
     * Corre el contenido del arreglo de char a derecha desde la posicion pos
     * 
     * @param ar  Arreglo al que se le quiere hacer el corrimiento
     * @param tam Tamaño del arreglo
     * @param pos Posicion hasta la que se quiere hacer el corrimiento
     */
    public void corrimientoDerecha(char[] ar, int tam, int pos) {
        int ultimo = tam - 1;
        while (ultimo > pos) {
            ar[ultimo] = ar[ultimo - 1];
            ultimo--;
        }
    }

    /**
     * Corre el contenido de un arreglo de INT a izquierda desde la posicion pos.
     * Sirve para cuando queremos eliminar un elemento
     * 
     * @param ar  Arreglo al que se le quiere hacer el corrimiento
     * @param tam Tamaño del arreglo
     * @param pos Posicion que se quiere eliminar
     */
    public void corrimientoIzquierda(int[] ar, int tam, int pos) {
        int j = pos;
        while (j < (tam - 1)) {
            ar[j] = ar[j + 1];
            j++;
        }
        ar[tam - 1] = -1;
    }

    /**
     * Corre el contenido de un arreglo de CHAR a izquierda desde la posicion pos.
     * Sirve para cuando queremos eliminar un elemento
     * 
     * @param ar  Arreglo al que se le quiere hacer el corrimiento
     * @param tam Tamaño del arreglo
     * @param pos Posicion que se quiere eliminar
     */
    public void corrimientoIzquierda(char[] ar, int tam, int pos) {
        while (pos <= tam) {
            ar[pos] = ar[pos + 1];
            pos++;
        }
        ar[tam - 1] = ' ';
    }

    /**
     * Inserta un elemento en el arreglo en una posicion indicada
     * 
     * @param ar   Arreglo al cual se le hace la insercion
     * @param elem Elemento a insertar
     * @param pos  Pocicion en la que insertamos el elemento
     * @param tam  Tamaño del arreglo
     */
    public void insertarElemento(int[] ar, int elem, int pos, int tam) {
        corrimientoDerecha(ar, tam, pos);
        ar[pos] = elem;
    }

    /**
     * Borra del arreglo el elemento de la posicion dada haciendo un corrimiento a
     * izquierda
     * 
     * @param ar  arreglo al que se le quiere eliminar la posicion
     * @param tam Tamaño del arreglo
     * @param pos Posicion que se quiere eliminar
     * @return Retorna el elemento eliminado (No la posicion)
     */
    public int eliminarElemento(int[] ar, int tam, int pos) {
        int aux = ar[pos];
        corrimientoIzquierda(ar, tam, pos);
        return aux;
    }
    /**
     * Inserta un valor de forma ordenada en un arreglo que se encuentra ordenado de forma decreciente
     * @param ar
     * @param tam Tamaño del arreglo
     * @param elem Elemento a insertar
     */
    public void insertarOrdenadoDec(int[] ar, int tam, int elem) {
        int pos = tam - 1;
        while ((pos >= 0) && (ar[pos] < elem)) {
            pos--;
        }
        if (pos != (tam - 1)) {
            pos++;
            //this.corrimientoDerecha(ar, tam, pos);
            insertarElemento(ar, elem, pos, tam);
        }
    }

    public void ordenarSelecCrec(int[] arr,int tam) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < tam; i++) { // tomamos como menor el primero
            menor = arr[i]; // de los elementos que quedan por ordenar
            pos = i; // y guardamos su posición
            for (j = i + 1; j < tam; j++) { // buscamos en el resto
                if (arr[j] < menor) { // del array algún elemento
                    menor = arr[j]; // menor que el actual
                    pos = j;
                }
            }
            if (pos != i) { // si hay alguno menor se intercambia
                tmp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = tmp;
            }
        }
    }

    public void ordenarInserDec(int[] arr,int tam){
        for (int i = 1; i < tam; i++) {
            int aux = arr[i];
            int j = i - 1;
            while ((j >= 0) && (arr[j] < aux)){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = aux;
            }       
    }
    /**
     * Busca la posicion en la que se encuentra un elemento
     * @param ar
     * @param tam Tamaño del arreglo
     * @param elem Elemento a buscar
     * @return La posicion del elemento si existe, Retorna -1 si el elemento no existe en el arreglo
     */
    public int buscarPosDeElemento(int[] ar,int tam,int elem){
        int pos=0;
        while (pos<tam && ar[pos]!=elem)
            pos++;
        if (pos==tam)
            return -1;
        else
            return pos;
    }

}
