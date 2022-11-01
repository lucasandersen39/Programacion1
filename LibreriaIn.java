import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LibreriaIn {
    public LibreriaIn() {

    }

    /**
     * Toma el valor entero ingresado desde teclado
     * 
     * @param
     * @return int
     */
    public int returnEntero() {
        int numero = 0;
        boolean esValido = false;
        while (!esValido) {
            try {
                //System.out.println("Ingrese un valor entero: ");
                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
                numero = Integer.parseInt(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("El valor ingresado es invalido. Ingreselo nuevamente");
            }
        }
        return numero;
    }

    public double returnDouble() {
        double numero = 0;
        boolean esValido = false;
        while (!esValido) {
            try {
                //System.out.println("Ingrese un valor real: ");
                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
                numero = Double.parseDouble(entrada.readLine());
                esValido = true;

            } catch (Exception e) {
                System.out.println("El valor ingresado es invalido. Ingreselo nuevamente");
            }
        }
        return numero;
    }

    public char returnChar() {
        char letra = '_';
        boolean esValido = false;
        while (!esValido) {
            try {
                //System.out.println("Ingrese una letra: ");
                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
                letra = entrada.readLine().charAt(0);
                esValido = true;
            } catch (Exception e) {
                System.out.println("El valor ingresado es invalido. Ingreselo nuevamente");
            }
        }
        return letra;
    }

    public String returnString() {
        String palabra = "";
        boolean esValido = false;
        while (!esValido) {
            try {
                //System.out.println("Ingrese una palabra: ");
                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
                palabra = entrada.readLine();
                esValido = true;
            } catch (Exception e) {
                System.out.println("El valor ingresado es invalido. Ingreselo nuevamente");
            }
        }
        return palabra;
    }

    public float returnFloat() {
        float numero = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean esValido = false;
        while (!esValido) {
            try {
                //System.out.println("Ingrese el numero");
                numero = Float.parseFloat(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("El valor ingresado es invalido. Ingreselo nuevamente");
            }
        }
        return numero;
    }
}