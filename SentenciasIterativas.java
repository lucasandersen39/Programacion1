import java.util.concurrent.TimeUnit;

public class SentenciasIterativas {

    public SentenciasIterativas() {

    }

    public void tpIterEj1() {
        int numero;
        LibreriaIn entrada = new LibreriaIn();
        int pares = 0;
        for (int i = 0; i < 10; i++) {
            numero = entrada.returnEntero();
            while (numero < 0) {
                System.out.println("Ingrese un numero correcto");
                numero = entrada.returnEntero();
            }
            if (numero % 2 == 0)
                pares++;
        }
        System.out.println("La cantidad de numeros pares es " + pares);
    }

    public void tpIterEj2() {
        int numero;
        int cantNumeros = 0;
        int sumaTotal = 0;
        LibreriaIn entrada = new LibreriaIn();
        numero = entrada.returnEntero();
        int maximo = numero;
        int minimo = numero;
        while (numero != 0) {
            cantNumeros++;
            sumaTotal = sumaTotal + numero;
            if (numero > maximo)
                maximo = numero;
            if (numero < minimo)
                minimo = numero;
            numero = entrada.returnEntero();
        }

        if (cantNumeros > 0) {
            System.out.println("El promedio de los numeros es: " + (sumaTotal / cantNumeros));
            System.out.println("El numero MAXIMO es: " + maximo);
            System.out.println("El numero MINIMO es: " + minimo);
        } else {
            System.out.println("No se ingreso ningun numero");
        }
    }

    public void tpIterEj3() {
        char letra;
        LibreriaIn entrada = new LibreriaIn();
        int cantRepet = 0;
        int maxRepet = 0;
        final int CANTIDADLETRAS = 15;
        for (int i = 0; i < CANTIDADLETRAS; i++) {
            letra = entrada.returnChar();
            if (letra == 'a') {
                cantRepet++;
            } else {
                if (maxRepet < cantRepet)
                    maxRepet = cantRepet;
                cantRepet = 0;
            }
        }
        if (maxRepet < cantRepet)
            maxRepet = cantRepet;
        System.out.println("La letra a se repitio: " + maxRepet);
    }

    public void tpIterEj4() {
        char letra;
        boolean estaP = false;
        boolean estaR = false;
        boolean estaO = false;
        boolean estaG = false;
        boolean secuenciaValida = false;
        LibreriaIn entrada = new LibreriaIn();
        letra = entrada.returnChar();
        while (letra != 'x') {
            if (letra == 'p' && !estaP)
                estaP = true;
            else if (letra == 'r' && estaP && !estaR)
                estaR = true;
            else if (letra == 'o' && estaP && estaR && !estaO)
                estaO = true;
            else if (letra == 'g' && estaP && estaR && estaO && !estaG)
                secuenciaValida = true;
            else {
                estaP = false;
                estaR = false;
                estaO = false;
                estaG = false;
            }
            letra = entrada.returnChar();
        }

        if (secuenciaValida)
            System.out.println("La secuencia PROG fue ingresada");
        else
            System.out.println("La secuencia PROG NO fue ingresada");
    }

    /**
     * Dado un numero noatural ingresado por teclado
     * Imprimir la tabla de multiplicar de dicho numero
     */
    public void tpiterEj5() {
        int numero;
        LibreriaIn entrada = new LibreriaIn();
        numero = entrada.returnEntero();
        while (numero <= 0) {
            System.out.println("El numero Ingresado no es correcto. Ingreselo nuevamente");
            numero = entrada.returnEntero();
        }
        System.out.println("Tabla de multiplicar del numero " + numero + ": ");
        for (int i = 0; i <= 9; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

    /**
     * Escribir un programa que dado un valor ingresado por el usuario menor que 10
     * y
     * mayor a 1, muestre por pantalla una cuenta regresiva de números desde dicho
     * valor hasta el 0 inclusive.
     */
    public void tpIterEj6() {

        int numero;
        LibreriaIn entrada = new LibreriaIn();
        numero = entrada.returnEntero();
        while ((numero < 1) || (numero > 10)) {
            System.out.println("El numero ingresado no es valido. Ingreselo nuevamente");
            numero = entrada.returnEntero();
        }
        System.out.println("Contando");
        for (int i = numero; i > 0; i--) {
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Escribir un programa que solicite el ingreso de un número mayor a 50, y los
     * muestre por pantalla en caso de ser múltiplo de 2 o 3.
     */
    public void tpIterEj7() {
        int numero;
        final int valorMinimo = 50;
        LibreriaIn entrada = new LibreriaIn();
        numero = entrada.returnEntero();
        while (numero < valorMinimo) {
            System.out.println("El numero es incorrecto. Ingreselo nuevamente");
            numero = entrada.returnEntero();
        }
        if (((numero % 2) == 0) && ((numero % 3) == 0))
            System.out.println("El numero " + numero + " es multimplo de 2 y de 3");
        else if ((numero % 2) == 0)
            System.out.println("El numero " + numero + " es multiplo de 2");
        else if ((numero % 3) == 0)
            System.out.println("El numero " + numero + " es multiplo de 3");
        else
            System.out.println("El numero " + numero + " no es multiplo de 2 ni de 3");
    }

    /**
     * Escribir un programa donde el usuario ingrese un número entre 0 y 999, y
     * muestre un mensaje de cuántos dígitos tiene. Además, si tiene 3 dígitos debe
     * informar qué número es.
     */

    public void tpIterEj8() {
        int numero;
        final int valorInicial = 0;
        final int valorFinal = 999;
        LibreriaIn entrada = new LibreriaIn();
        int cifras = 1;
        int numeroAux;
        numero = entrada.returnEntero();
        while ((numero < valorInicial) || (numero > valorFinal)) {
            System.out.println("El numero ingresado no es correcto. Ingreselo nuevamente");
            numero = entrada.returnEntero();
        }
        numeroAux = numero;
        while ((numeroAux / 10) > 1) {
            cifras++;
            numeroAux = numeroAux / 10;
        }

        if (cifras == 3)
            System.out.println("El numero de 3 cifras es: " + numero);
        else
            System.out.println("El numero solo tiene " + cifras + " cifras");
    }

    /**
     * Escribir un programa que mientras que el usuario ingrese un número distinto
     * de 0,
     * pida ingresar otro número y lo imprima.
     */

    public void tpIterEj9() {
        int numero;
        LibreriaIn entrada = new LibreriaIn();
        numero = entrada.returnEntero();
        while (numero != 0) {
            System.out.println("numero: " + numero);
            System.out.println("Ingrese otro numero ");
            numero = entrada.returnEntero();
        }
    }

    /**
     * Escribir un programa que mientras que el usuario ingrese un número distinto
     * de 0,
     * pida ingresar otros dos números e imprima el resultado de la multiplicación
     * entre los dos últimos números ingresados
     */

    public void tpIterEj10() {
        final int numeroDeCorte = 0;
        int numero;
        LibreriaIn entrada = new LibreriaIn();
        numero = entrada.returnEntero();
        while (numero != numeroDeCorte) {
            int valor1, valor2;
            System.out.println("Ingrese el primer numero ");
            valor1 = entrada.returnEntero();
            System.out.println("Ingrese el segundo valor ");
            valor2 = entrada.returnEntero();
            System.out.println(valor1 + " x " + valor2 + " = " + (valor1 * valor2));
            System.out.println("Ingrese otro numero ");
            numero = entrada.returnEntero();
        }
    }
    /**
     * Pedir números enteros positivos por teclado. En cada iteración el usuario
     * puede
     * ingresar 0 para salir del programa. Si ingresa un número distinto de 0 se
     * debe
     * pedir el ingreso de un caracter.
     * ○ Si es ‘a’ se debe permitir al usuario escribir un texto libre e imprimirlo
     * por
     * pantalla.
     * ○ Si es ‘b’ se deben pedir 5 números positivos e informar si fueron
     * ingresados en orden ascendente.
     * ○ Si es ‘c’ se deben pedir dos números enteros negativos e imprimir la raíz
     * cuadrada de su multiplicación.
     * Ante cualquier otro caracter ingresado se debe informar un error y pedir
     * nuevamente el caracter
     */
    public void tpIterEj11(){
        int numero;
        final int valorDeCorte=0;
        LibreriaIn entrada=new LibreriaIn();
        numero=entrada.returnEntero();
        while (numero!=valorDeCorte){
            char letra;
            letra=entrada.returnChar();
            while (letra!='a'&&letra!='b'&&letra!='c'){
                System.out.println("La letra ingresada no es valida. Ingresela nuevamente");
                letra=entrada.returnChar();
            }
            if (letra=='a'){
                String palabra=entrada.returnString();
                System.out.println("Palabra ingresada: "+palabra);
            }
            else
                if (letra=='b'){
                    int valor1,valor2,valor3,valor4,valor5;
                    valor1=entrada.returnEntero();
                    valor2=entrada.returnEntero();
                    valor3=entrada.returnEntero();
                    valor4=entrada.returnEntero();
                    valor5=entrada.returnEntero();
                    if ((valor1<valor2)&&(valor2<valor3)&&(valor3<valor4)&&(valor4<valor5))
                        System.out.println("La secuencia fue ingresada en forma ascendente");
                    else
                        System.out.println("La secuencia no esta en orden ascendente");
                }
                else
                    if (letra=='c'){
                        int numero1,numero2;
                        numero1=entrada.returnEntero();
                        numero2=entrada.returnEntero();
                        while ((numero1>=0)||(numero2>=0)){
                            if (numero1>=0){
                                System.out.println("ingrese un valor negativo para "+numero1);
                                numero1=entrada.returnEntero();
                            }
                            if (numero2>=0){
                                System.out.println("ingrese un valor negativo para "+numero2);
                                numero2=entrada.returnEntero();
                            }
                        }
                        System.out.println("La raiz cuadrada de "+numero1+" x "+numero2+" es: "+Math.sqrt(numero1*numero2));
                    }
            System.out.println("Ingrese un nuevo numero para continuar (0 para terminar)");
            numero=entrada.returnEntero();
        }
    }
}