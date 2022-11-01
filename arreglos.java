import java.util.Random;

public class arreglos {

    public arreglos(){

    }

    /**
     * Cargar un arreglo de tamaño 15, pidiendo el ingreso por teclado de valores entre 1 y 12. 
     */
     final int MAX=15;
     public void arreglosEj1(){ 
        int [] arreglo= new int[MAX];
        cargarArreglo(arreglo);
        imprimirArreglo(arreglo,MAX);
     }

     /**
      * Carga un arreglo con valores ingresados por el usuario en un rango especidicado cuando se llama a la
      * funcion obtenerValorPorRango(min,max)
      */
     public void cargarArreglo(int[] ar){
        for (int i=0;i<MAX;i++){
            ar[i]=obtenerValorPorRango(1, 12);
        }
     }

     //Pide al usuario que ingrese un numero entre min y max
     public int obtenerValorPorRango(int min,int max){
        LibreriaIn en=new LibreriaIn();
        int valor=0;
        while (valor<min || valor>max){
            System.out.println("Ingrese un valor entre 1 y 12");
            valor=en.returnEntero();
        }
        return valor;
     }

     //Imprime un arreglo
     public void imprimirArreglo(int[] ar,int maximo){
        for (int i=0;i<maximo;i++)
            System.out.print(ar[i]+" - ");
     }

     //Carga un arreglo con numeros aleatorios
     public void cargarArregloAleatorio(int[] ar,int tam){
        for (int i=0;i<tam;i++)
            ar[i]=(int)(100*Math.random());
     }

     /**
      * Hacer un programa que dado un arreglo ya cargado con 10 enteros, calcule el promedio y lo
      * muestre por la consola.
      */

      public void arreglosEj2(){
        int[] arreglo=new int[MAX];
        cargarArregloAleatorio(arreglo,MAX);
        imprimirArreglo(arreglo,MAX);
        float prom=calcularPromedio(arreglo);
        System.out.println("El promedio es: "+prom); 
        System.out.println("Numeros mayores al promedio: "+elementosMayoresAlPromedio(arreglo, prom));
      }
      
      /**
       * Retorna que cantidad de numeros existen en el arreglo que sean mayores a un numero dado
       * @param ar Arreglo original 
       * @param prom Numero con el que se comparan los valores del arreglo
       * @return    La cantidad de numeros que son menores a prom
       */
      public int elementosMayoresAlPromedio(int[] ar, float prom){
            int cant=0;
            for (int i=0;i<MAX;i++)
                if (ar[i]>prom)
                    cant++;
            return cant;
        }
      /**
       * Calcula el promedio de la suma de todos los valores del arreglo. 
       * @param ar
       * @return
       */  
      public float calcularPromedio(int[] ar){
        return (sumaElementos(ar)/MAX);
      }
      /*
       * Retorna la suma de todos los valores que hay en el arreglo
       */
      public int sumaElementos(int[] ar){
        int total=0;
        for (int i=0;i<MAX;i++)
            total += ar[i];
        return total;
      }

      /**
       * Buscar un elemento en un arreglo de caracteres ya cargado de tamaño 10 y mostrar la/s
       * posicion/es del elemento, en caso de no estar indicarlo también
       */
      final int TAM=10;
       public void cargarArregloChar(char[] ar){
            LibreriaIn en=new LibreriaIn();
            for (int i=0;i<TAM;i++){
                System.out.println("ingrese una letra");
                ar[i]=en.returnChar();
            }
       }
       /**
        * Inicializa el arreglo seteando todos los valores en -1
        * @param ar
        */
       public void inicializarArreglo(int[] ar){
        for (int i=0;i<TAM;i++)
            ar[i]=-1;
       }

       public int[] buscarElemento(char[] ar,char elem){
            int[] posiciones=new int[TAM];
            inicializarArreglo(posiciones);
            int j=0;
            for (int i=0;i<TAM;i++)
                if (ar[i]==elem){
                    posiciones[j]=i;
                    j++;
                }
            return posiciones;
       }
       public void imprimirElementosArreglo(int[] ar){
        int pos=0;
        while (pos<TAM && ar[pos]!=-1){
            System.out.print(ar[pos]+" - ");
            pos++;
        }
       }

       public void arreglosEj4(){
            char letra;
            LibreriaIn en=new LibreriaIn();
            char[] arreglo=new char[TAM];
            System.out.println("Ingrese valores para el arreglo");
            cargarArregloChar(arreglo);
            System.out.println("Ingrese la letra que desea buscar");
            letra=en.returnChar();
            int[] posiciones=buscarElemento(arreglo, letra);
            if (posiciones[0]==-1)
                System.out.println("El elemento no se encontraba en el arreglo");
            else
                imprimirElementosArreglo(posiciones);
       }

       /**
        * Hacer un programa que dado un arreglo de caracteres de tamaño 10 que se encuentra cargado,
        * invierta el orden del contenido. 
        *  Este intercambio no se debe realizar de manera explícita, 
        * hay que hacer un método que incluya una iteración de intercambio
        */
         final int TAMANIO=10;
        public void cargarArregloCharRandom(char[] ar){
            Random ran=new Random();
            for (int i=0;i<TAMANIO;i++)
                ar[i]=(char)(ran.nextInt(26)+'a');
        }
        public void imprimirArreglo(char[] ar){
            for (int i=0;i<TAMANIO;i++)
                System.out.print(ar[i]+"-");
        }
        /**
         * Invierte los elementos de un arreglo tomando como inicio la posicion 0 y como fin la posicion TAMANIO-1
         * @param ar
         */
        public void invertirArreglo(char[] ar){
            char letraAux;
            int i=0;
            int j=TAMANIO-1;
            while (i<j){
                letraAux=ar[i];
                ar[i]=ar[j];
                ar[j]=letraAux;
                i++;
                j--;
            }
        }

        public void arreglosEj5(){
            char[] arreglo=new char[TAMANIO];
            cargarArregloCharRandom(arreglo);
            System.out.println("Arreglo original");
            imprimirArreglo(arreglo);
            invertirArreglo(arreglo);
            System.out.println(" Arreglo invertido");
            imprimirArreglo(arreglo);
        }

        /**
         * Implementar un método que realice un corrimiento a izquierda en un arreglo ordenado de
         * tamaño MAX=10 a partir de una posición.
         */
         final int TAMA=10;
         public void arreglosEj7(){
                int[] arreglo=new int[TAMA];
                cargarArregloAleatorio(arreglo, TAMA);
                System.out.println("Arreglo original");
                imprimirArreglo(arreglo, TAMA);
                System.out.println("\nArreglo modificado");
                corrimientoIzquierda(arreglo, TAMA, 5);
                imprimirArreglo(arreglo, TAMA);
         }
         /**
          * Realiza un corrimiento a izquierda de un arreglo en una posicion dada.
          * Le paso maximo como parametro para hacerlo generico a todos los arreglos.
          * Seteo la ultima posicion con 0 
          * En la catedra no se pasa como parametro, se toma la constante global que indica el tamaño del arreglo
          * while (i<MAX)
          * @param arreglo
          * @param maximo tamaño del arreglo
          * @param pos inicio desde el cual se quiere realizar el corrimiento
          */
         public void corrimientoIzquierda(int[] arreglo,int maximo, int pos){
            int i=pos;
            while (i<maximo-1){
                arreglo[i]=arreglo[i+1];
                i++;
            }
            arreglo[maximo-1]=0;
         }
}
