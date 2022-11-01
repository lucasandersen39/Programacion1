import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejemplo {

    
    public static void main(String[] args) {
      BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
      int numero=returnEntero();
        int numero2=returnEntero();
        factorial(numero);
        factorial(numero2);
       
    }

    public static int factorial(int num){
        int total=1;
        for (int i=1;i<=num;i++){
            total=total*i;
        }
        return total;
    }

    public static double combinatoria(int n,int r){
        double res=0;

        
        return res;
    }
    public static void imprimirNumero(int numero){
        System.out.println("88888888888888888888");
        System.out.println("----------------");
        System.out.println("zzzzzzzzzzzzzz");
        System.out.println(numero);
    }

    public static char imprimir(){
        char numero=0;
        System.out.println("dsjhksdjksgdgds");
        return numero;
    }

    public static int returnEntero() {
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

    
}
