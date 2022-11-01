public class DisDescendente {
    
    public DisDescendente(){

    }
    /**
     * Escribir un diseño de programa que mientras que el usuario
     * ingrese un número natural, pida ingresar otro numero
     * cualquiera y lo imprima.
     */

     public void descEjerciocio1(){
        LibreriaIn en=new LibreriaIn();
        int numero1=en.returnEntero();
        while (numero1>0){
            int numero2= en.returnEntero();
            System.out.println("El numero ingresado es: "+numero2);
            numero1=en.returnEntero();
        }
     }

     /**
      * Escribir un diseño de programa que mientras que el usuario
      * ingrese un número distinto de 0, pida ingresar otros dos
      * números e imprima el resultado de la multiplicación entre los
      * dos últimos números ingresados.
      */

      public void descEjercicio2(){
        LibreriaIn en=new LibreriaIn();
        int valor=en.returnEntero();
        while (valor!=0){
            int numero1=en.returnEntero();
            int numero2=en.returnEntero();
            System.out.println(numero1+" x "+numero2+" = "+(numero1*numero2));
            valor=en.returnEntero();
        }
      }

      /**
       * Realizar un programa que dado un caracter ingresado desde
       * teclado (a o b) permita realizar dos operaciones entre dos
       * enteros N y M menores a 10 ingresados desde teclado
       * también. Las operaciones son:
       * _ Si el usuario ingresa a obtener la suma entre N y M.
       * _ Si el usuario ingresa b obtener la resta entre N y M.
       */

       public void descEjercicio3(){
        LibreriaIn en=new LibreriaIn();
        char seguir='s';
        while (seguir=='s' || seguir=='S'){
            char opcion=en.returnChar(); 
            if (opcion != 'a' && opcion != 'b')
                System.out.println("El valor ingresado es incorrecto");
            else{
                int valor1=en.returnEntero();
                int valor2=en.returnEntero();
                if (opcion=='a'){
                    if (estaEnRango(valor1)&&estaEnRango(valor2))
                        System.out.println(valor1+" + "+valor2+" = "+sumar(valor1,valor2));
                    else
                        System.out.println("Los numeros deben ser menores a 10");
                }else
                    if (opcion=='b'){
                        if (estaEnRango(valor1)&&estaEnRango(valor2))                
                            System.out.println(valor1+" - "+valor2+" = "+sumar(valor1,valor2*(-1)));
                        else
                            System.out.println("Los numeros deben ser menores a 10");
                    }
            }
            System.out.println("Desea continuar? (s/n)");
            opcion=en.returnChar();
        }
       }
       public int sumar(int numero1,int numero2){
            return (numero1+numero2);
       }
       public boolean estaEnRango(int numero){
           return (numero<10);
       }

       /**
        * Escribir un método que retorne el mayor de dos números. Usar
        * ese método para calcular el máximo de una serie de números
        * ingresados por el usuario (20 números en total).
        */
       public void descEjercicio4(){
            LibreriaIn en=new LibreriaIn();
            int max=-9999;
            int valor=0;
            for (int i=0;i<20;i++){
                valor=en.returnEntero();
                max=mayor(max,valor);
            }
            System.out.println("El numero mayor ingresado fue: "+max);
       }
       public int mayor(int num1,int num2){
            if (num1>num2)
                return num1;
            else    
                return num2;
       }

       /**
        * Escribir un programa que simule 1000 lanzamientos de un dado y
        * muestre por pantalla cuantas veces salió el valor del dado
        * correspondiente al número entero N ingresado por el usuario.
        * Considerar el valor N ingresado se corresponda a un valor posible
        * para un dado. Usar la sentencia Math.random() que devuelve un
        * valor aleatorio real entre 0 y 1.
        * Para asignar un posible valor a la variable dado entero:
        * dado = (int) (6*Math.random() + 1)
        */
        final int DADOMIN=1;
        final int DADOMAX=6;
        final int CANT=1000;
        public void descEjercicio5(){
            LibreriaIn en=new LibreriaIn();
            int numero=en.returnEntero();
            int cant=0;
            if (valorValido(numero)){
                for (int i=0;i<CANT;i++)
                    if (numero==tirarDado())
                        cant++;
                System.out.println("El numero "+numero+" ha salido "+cant+" veces!!");
            }
            else
                System.out.println("Debe ingresar un numero entre "+DADOMIN+" y "+DADOMAX);
            
        }

        public int tirarDado(){
            return (int) (DADOMAX*Math.random() + 1);
        }

        public boolean valorValido(int num){
            return (num>=DADOMIN && num<=DADOMAX);
        }

        /**
        * Realizar un programa que, dada una opción (1,2,3,4), permita
        * realizar operaciones entre tres números reales (r1,r2,r3) ingresados
        * desde teclado. Para la opción
        * 1. Calcular la raíz cuadrada de (r1-r3)
        * 2. Calcular el promedio de r1, r2 y r3
        * 3. Calcular cociente de la raíz cuadrada de (r3 - r2) dividida
        * por r1
        * 4. Calcular el cociente del promedio de los tres valores
        * dividido por la raíz cuadrada de r2
        */
        public void descEjercicio6(){ 
            int opcion=obtenerDatoCorrecto();
            LibreriaIn en=new LibreriaIn();
            double r1=en.returnDouble();
            double r2=en.returnDouble();
            double r3=en.returnDouble();

            if (opcion==1){
                if (r1>=r3)
                    System.out.println("La raiz cuadrada de r1-r3 es: "+calcularRaizCuadrada(r1-r3));
                else
                    System.out.println("No se puede calcular la raiz. r3 debe ser mayo o igual que r2");
            }
            else
                if (opcion==2){
                    System.out.println("El promedio de r1, r2 y r3 es: "+calculaPromedio(r1, r2, r3));
                }
                else
                    if (opcion==3){
                        if (r3>=r2 && r1!=0){
                            System.out.print("El cociente de la raíz cuadrada de (r3 - r2) dividida por r1 es: ");
                            System.out.println(calcularCociente(calcularRaizCuadrada(r3-r2), r1));
                        }
                        else
                            System.out.println("r3 debe ser >= que r2 y r1 debe ser distinto de 0");
                    }
                    else
                        if (opcion==4)
                            if (r2!=0){
                                System.out.print("el cociente del promedio de los tres valores dividido por la raíz cuadrada de r2 es:");
                                System.out.println(calcularCociente(calculaPromedio(r1, r2, r3), calcularRaizCuadrada(r2)));
                            }
                            else
                                System.out.println("r2 debe ser distinto de 0");
        }

        public double calcularRaizCuadrada(double v1){
            return Math.sqrt(v1);
        }

        public double calculaPromedio(double v1,double v2,double v3){
            return ((v1+v2+v3)/3);
        }

        public double calcularCociente(double v1,double v2){
            return (v1/v2);
        }

        public int obtenerDatoCorrecto(){
            LibreriaIn en=new LibreriaIn();
            int valor=0;
            while (valor<1||valor>4){
                valor=en.returnEntero();
            }
            return valor;
        }

        /**
         * Escribir un programa que haga uso de la funcionalidad
         * para tirar un dado del práctico anterior. Arrojar 5 dados
         * hasta hacer Generala servida. Contar la cantidad de
         * intentos y mostrarlo por pantalla
         */
        public void extraDescEj2(){
            boolean hayGenerala=false;
            int cant=0;
            while (!hayGenerala){
                cant++;
                if (esGenerala(tirarDado(), tirarDado(), tirarDado(), tirarDado(), tirarDado()))
                    hayGenerala=true;
            }
            System.out.println("Cantidad de iteraciones: "+cant);
        }

        public boolean esEscalera(int v1,int v2,int v3,int v4,int v5){
            System.out.println(v1+"-"+v2+"-"+v3+"-"+v4+"-"+v5);
            if ((v1!=1 && v2!=1 && v3!=1 && v4!=1 && v5!=1) ||
                (v1!=6 && v2!=6 && v3!=6 && v4!=6 && v5!=6)){
                    if (v1!=v2 && v1!=v3 && v1!=v4 && v1!=v5 && v2!=v3 && v2!=v4 && v2!=v5 && v3!=v4 && v3!=v5 && v4!=v5)
                        return true;
                }
            return false;
        }

        public boolean esGenerala(int v1,int v2,int v3,int v4,int v5){
            System.out.println(v1+"-"+v2+"-"+v3+"-"+v4+"-"+v5);
            if (v1==v2 && v2==v3 && v3==v4 && v4==v5)
                return true;
            
            return false;
        }

        /**
         * Escribir un programa que solicite al usuario dos números
         * ○ Opción 1: calcule la cantidad de combinaciones sin
         * repeticiones posibles de n elementos tomados de a r
         * ○ Opción 2: calcula la cantidad de combinaciones con
         * repeticiones de n elementos tomados de a r
         * enteros r y n (donde r≤n), y un número de opción (1 o 2).
         */
        public void extraDescEj1(){
            LibreriaIn en=new LibreriaIn();
            int opcion=obtenerOpcionCorrecta();
            int n=0;
            int r=1;
            while (!datoValido(n,r)){
                System.out.println("Ingrese el valor de n");
                n=en.returnEntero();
                System.out.println("Ingrese el valor de r");
                r=en.returnEntero();           
            }
            double resultado=0;
           
            if (opcion==1)
                resultado=combinatoriaSin(n,r);
            else
                resultado=combinatoriaCon(n, r);

            System.out.println("El resultado de la combinatoria es: "+ resultado);
        }

        public boolean datoValido(int n,int r){
            if (r<=n)
                return true;
            else {
                System.out.println("r debe ser <= n");
                return false;
            }
        }
        public int obtenerOpcionCorrecta(){
            LibreriaIn en=new LibreriaIn();
            System.out.println("Ingrese una opcion (1 o 2)");
            int opcion=en.returnEntero();
            while (opcion!=1&&opcion!=2){
                System.out.println("Opcion incorrecta, ingrese una opcion nuevamente");
                opcion=en.returnEntero();
            }
            return opcion;
        }

        public double combinatoriaCon(int n,int r){
            return combinatoriaSin(n+r-1,r);
        }
        public double combinatoriaSin(int n,int r){
            return (factorial(n)/((factorial(r)*factorial(n-r))));
        }

        public int factorial(int numero){
            int total=1;
            for (int i=1;i<=numero;i++){
                total*=i;
            }
            return total;

        }
}
