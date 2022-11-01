import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExtraOperadores {

    public ExtraOperadores() {
    }
    
    /**
     * Escribir un programa que pida al usuario el radio de un
        círculo y muestre por pantalla su área y su perímetro.
        Área = π r²
        Perímetro = 2 π r
     */
    public void extra1(){
        float radio;
        double area;
        double perimetro;

        LibreriaIn entrada=new LibreriaIn();
        System.out.println("Ingrese el valor del radio");
        radio=entrada.returnFloat();
        area=Math.PI*radio*radio;
        perimetro=2*Math.PI*radio;

        System.out.println("El Area del circulo es "+area);
        System.out.println("El perimetro del circulo es "+perimetro);
    }

    /**
     * Escribir un programa que pida al usuario los lados de un
        rectángulo, muestre por pantalla su área y su perímetro,
        e indique si es un cuadrado.
        Perimetro= 2A+2B
        Area=L*L
     */
    public void extra2(){
        float lado1,lado2;
        LibreriaIn entrada=new LibreriaIn();
        System.out.println("Ingrese el valor de uno de los lados");
        lado1=entrada.returnFloat();
        System.out.println("Ingres el valor del otro lado");
        lado2=entrada.returnFloat();

        if (lado1==lado2) {
            System.out.println("El area del cuadrado es "+(lado1*lado2));
            System.out.println("El perimetro del cuadrado es "+(2*lado1+2*lado2));
        }
        else {
            System.out.println("El area del rectangulo es "+(lado1*lado2));
            System.out.println("El perimetro del rectangulo es "+(2*lado1+2*lado2));
        }
    }

    /**
     * Escribir un programa que pida al usuario los 3 ángulos de
        un triángulo y determine:
        - Si es un triángulo válido.
        - Si es rectángulo (solo si es válido).
        - Si es acutángulo (solo si es válido).
        - Si es obtusángulo (solo si es válido).
     */
    public void extra3(){
        float angulo1,angulo2,angulo3;
        LibreriaIn entrada=new LibreriaIn();
        System.out.println("Ingrese el valor del primer angulo");
        angulo1=entrada.returnFloat();
        System.out.println("Ingrese el valor del segundo angulo");
        angulo2=entrada.returnFloat();
        System.out.println("Ingrese el valor del tercer angulo");
        angulo3=entrada.returnFloat();

        if ((angulo1+angulo2+angulo3)!=180)
            System.out.println("Los lados no conforman un triangulo");
        else
            if ((angulo1==90)||(angulo2==90)||(angulo3==90))
                System.out.println("El triangulo es un triangulo rectangulo");
            else
                if ((angulo1<90)&&(angulo2<90)&&(angulo3<90))
                    System.out.println("El triangulo es un triagulo acutangulo");
                else
                    if ((angulo1>90)||(angulo2>90)||(angulo3>90))
                        System.out.println("El triangulo es un triangulo obtusangulo");
    }

    public void extra4(){
        char tipoFact,opcion;
        int numFact;
        String nombre;
        String producto1,producto2;
        float valor1,valor2,total,descuento;

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
            total=valorConIva(valor1)+valorConIva(valor2);
            System.out.println("Desea aplicar un descuento? (S/N) ");
            opcion=entrada.readLine().charAt(0);
            if (opcion=='s'||opcion=='S'){
                System.out.println("Ingrese el descuento (%) a aplicar: ");
                descuento=Float.parseFloat(entrada.readLine());
                total=total-((total*descuento)/100);
            }
            imprimirFactura(tipoFact,numFact,nombre,producto1,valor1,producto2,valor2,total);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private void imprimirFactura(char tipo,int num,String nom,String prod1,float v1,String prod2,float v2,float tot){
        System.out.println("*************************");
        System.out.println("Factura\t"+tipo+"\tN "+num);
        System.out.println("Nombre: "+nom);
        System.out.println("-------------------------");
        System.out.println("Producto \tImporte");
        System.out.println(prod1+"\t \t"+valorConIva(v1));
        System.out.println(prod2+"\t \t"+valorConIva(v2));
        System.out.println("Importe total \t"+tot);
    }

    private float valorConIva(float val){
        float valAux=val+((21*val)/100);
        return valAux;
    }
}
