public class tpSentencias {

    public tpSentencias() {
    }

    /**
     * solicite un número e indique si es positivo o negativo
     */
    public void sentencias1() {
        int numero;
        LibreriaIn entrada = new LibreriaIn();
        numero = entrada.returnEntero();
        if (numero < 0)
            System.out.println("El numero es negativo");
        else
            System.out.println("El numero es positivo");
    }

    /**
     * solicite un número e imprima “grande” si es mayor a 100 y “chico “ si es
     * menor
     */
    public void sentencias2() {
        int numero;
        LibreriaIn entrada = new LibreriaIn();
        numero = entrada.returnEntero();
        if (numero > 100)
            System.out.println("grande");
        else if (numero < 100)
            System.out.println("Chico");
        else
            System.out.println("No es ni grande ni chico XD");
    }

    /**
     * solicite un número del 1 al 7 e imprima el día de la semana.
     */
    public void sentencias3() {
        int dia;
        LibreriaIn entrada = new LibreriaIn();
        dia = entrada.returnEntero();
        
        switch (dia) {
            case 1:
                System.out.println("Es lunes");
                break;
            case 2:
                System.out.println("Es martes");
                break;
            case 3:
                System.out.println("Es miercoles");
                break;
            case 4:
                System.out.println("Es jueves");
                break;
            case 5:
                System.out.println("Es viernes");
                break;
            case 6:
                System.out.println("Es sabado");
                break;
            case 7:
                System.out.println("Es domingo");
                break;
            default: {
                if ((dia < 1) || (dia > 7))
                    System.out.println("El dia ingresado es incorrecto");
                System.out.println("Ingrese un valor en el rango de 1 a 7");
            }
        }
    }

    /**
     * solicite una letra e imprima si es vocal o consonante.
     */

    public void sentencias4() {
        char letra, letra2;
        LibreriaIn entrada = new LibreriaIn();
        letra = entrada.returnChar();
        // Paso el char a Minuscula
        letra2 = Character.toLowerCase(letra);
        letra2='e';
        switch (letra2) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("La letra es una vocal");
                break;
            default:
                System.out.println("La letra es una consonante");
        }
    }

    /**
     * solicite 3 números e imprima “creciente” si los tres números están en orden
     * creciente, “decreciente” si están en orden decreciente o “error” si no
     * cumplen ningún orden
     */

    public void sentencias5() {
        float num1, num2, num3;
        LibreriaIn entrada = new LibreriaIn();
        num1 = entrada.returnFloat();
        num2 = entrada.returnFloat();
        num3 = entrada.returnFloat();

        if ((num1 < num2) && (num2 < num3))
            System.out.println("Creciente");
        else if ((num1 > num2) && (num2 > num3))
            System.out.println("Decreciente");
        else
            System.out.println("Error");
    }

    /**
     * Construir un programa que solicite desde teclado un número de mes y
     * posteriormente notifique por pantalla la cantidad de días de ese mes. En el
     * caso de
     * que ingrese 2 como número de mes (febrero) deberá además solicitar ingresar
     * un
     * número de anio (no usar ñ), y dependiendo de si es bisiesto o no con la
     * siguiente
     * sentencia
     * Si ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) es verdadero
     * es bisiesto
     * imprimir la cantidad de días correspondiente.
     */
    public void sentencias6() {
        int numero;
        int anio;
        LibreriaIn entrada = new LibreriaIn();
        numero = entrada.returnEntero();

        switch (numero) {
            case 1:
                System.out.println("El mes de Enero tiene 31 dias");
                break;
            case 2: {
                System.out.println("Por favor, ingrese el año");
                anio = entrada.returnEntero();
                if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
                    System.out.println("El mes de Febrero del año " + anio + " tiene 29 dias");
                else
                    System.out.println("El mes de Febrero del año " + anio + " tiene 28 dias");
                break;
            }
            case 3:
                System.out.println("El mes de Marzo tiene 31 dias");
                break;
            case 4:
                System.out.println("El mes de Abril tiene 30 dias");
                break;
            case 5:
                System.out.println("El mes de Mayo tiene 31 dias");
                break;
            case 6:
                System.out.println("El mes de Junio tiene 30 dias");
                break;
            case 7:
                System.out.println("El mes de Julio tiene 31 dias");
                break;
            case 8:
                System.out.println("El mes de Agosto tiene 31 dias");
                break;
            case 9:
                System.out.println("El mes de Septiembre tiene 30 dias");
                break;
            case 10:
                System.out.println("El mes de Octubre tiene 31 dias");
                break;
            case 11:
                System.out.println("El mes de Noviembre tiene 30 dias");
                break;
            case 12:
                System.out.println("El mes de Diciembre tiene 31 dias");
                break;
            default:
                System.out.println("El mes ngresado es incorrecto");
        }
    }

}
