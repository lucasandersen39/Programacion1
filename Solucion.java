import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solucion {
    
    public Solucion(){
        
    }
    public void tp1ej1(){
        int num1,num2,num3,num4,num5;
        num1=ingresaValor();
        num2=ingresaValor();
        num3=ingresaValor();
        num4=ingresaValor();
        num5=ingresaValor();
        
        System.out.println("Valores: "+num5+", "+num4+", "+num3+", "+num2+", "+num1+". ");
        
    }

    private int ingresaValor(){
        try{
            BufferedReader bufer=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el valor: ");
            int valor=new Integer(bufer.readLine());
            return valor;
            }
        catch (Exception e){
            System.out.println(e);
            return 0;
        }
        
    }

    public void tp1ej2(){
        int numero;
        char letra;
        float decimal;

        try{
            BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el valor entero: ");
            numero=new Integer(entrada.readLine());
            System.out.println("Ingrese en valor del caracter: ");
            letra=(char)entrada.readLine().charAt(0);
            System.out.println("Ingrese el valor con coma: ");
            decimal=new Float(entrada.readLine());
            System.out.println("Entero: "+numero+", Letra: "+letra+", Decimal: "+decimal);
        }
        catch (Exception e){
            System.out.println(e);
        }
        
    }

    public void tp1ej3(){
        final int constante;
        int num1,num2;
        try{
            BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el valor de la constante: ");
            constante= new Integer(entrada.readLine());
            num1=constante;
            num2=num1*2;
            System.out.println("Valor de la constante: "+constante+", Valor final: "+num2);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void tp1ej4(){
        String nombre;
        int edad;
        float altura;
        String ocupacion;

        try{
            BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el nombre: ");
            nombre=entrada.readLine();
            System.out.println("Ingrese la edad: "+entrada.readLine());
            edad=new Integer(entrada.readLine());
            System.out.println("Ingrese la altura: ");
            altura= new Float(entrada.readLine());
            System.out.println("Ingrese la ocupación: ");
            //ocupacion=new String(entrada.readLine());
            ocupacion=entrada.readLine();
            this.ImprimirDatos(nombre, edad, altura, ocupacion);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void ImprimirDatos(String nom,int ed,float alt, String oc){
        System.out.println("-------------------------");
        System.out.println("Datos de "+nom);
        System.out.println("Edad: "+ed);
        System.out.println("Altura: "+alt);
        System.out.println("Ocupación: "+oc);
    }

    public void tp1ej5(){
        char tipoFact;
        int numFact;
        String nombre;
        String producto1,producto2;
        float valor1,valor2;

        try{ 
            BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el tipo de factura: ");
            tipoFact=entrada.readLine().charAt(0);
            System.out.println("Ingrese el numero de factura: ");
            numFact=new Integer(entrada.readLine());
            System.out.println("Ingrese el nombre del cliente: ");
            nombre=entrada.readLine();
            System.out.println("Ingrese el producto 1: ");
            producto1=entrada.readLine();
            System.out.println("Ingrese el valor: ");
            valor1= new Float(entrada.readLine());
            System.out.println("Ingrese el producto 2: ");
            producto2=entrada.readLine();
            System.out.println("Ingrese el valor: ");
            valor2=new Float(entrada.readLine());
            imprimirFactura(tipoFact,numFact,nombre,producto1,valor1,producto2,valor2);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    private void imprimirFactura(char tipo,int num,String nom,String prod1,float v1,String prod2,float v2){
        System.out.println("*************************");
        System.out.println("Factura\t"+tipo+"\tN "+num);
        System.out.println("Nombre: "+nom);
        System.out.println("-------------------------");
        System.out.println("Producto \tImporte");
        System.out.println(prod1+"\t \t"+v1);
        System.out.println(prod2+"\t \t"+v2);
        System.out.println("Importe total \t"+(v1+v2));
    }

}