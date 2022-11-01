import java.util.Scanner;

public class Practico2{

    public Practico2(){

    }

    public void tp2ej1(){
        double num1,num2,num3,resultado;
        LibreriaIn entrada=new LibreriaIn();
        num1=entrada.returnDouble();
        num2=entrada.returnDouble();
        num3=entrada.returnDouble();
        resultado=num1/num2;
        resultado=resultado-num3;
        System.out.println("El resultado de ("+num1+"/"+num2+") - "+num3+" es: "+resultado);
    }

    public void tp2ej2(){
        int numero;
        LibreriaIn entrada=new LibreriaIn();
        numero=entrada.returnEntero();
        System.out.println("La division por 2 de "+numero+" es:"+(numero/2));
        System.out.println("La division por 3 de "+numero+" es:"+(numero/3));
        System.out.println("La division por 4 de "+numero+" es:"+(numero/4));
    }

    public void tp2ej3(){
        int num1,num2;
        LibreriaIn entrada=new LibreriaIn();
        num1=entrada.returnEntero();
        num2=entrada.returnEntero();
        System.out.println("El numero "+num1+" es mayor que "+num2+"? "+(num1>num2));
        System.out.println("El numero "+num1+" es multiplo de 2?"+((num1%2)==0));
        System.out.println("El numero "+num2+" es multiplo de 2?"+((num2%2)==0));
    }

    public void tp2ej4(){
        int numero;
        boolean res;
        LibreriaIn entrada= new LibreriaIn();
        numero = entrada.returnEntero();
        System.out.println("El numero "+numero+" es multiplo de 6 y de 7? "+(((numero%6)==0)&&((numero%7)==0)));
        res=((numero>30)&&((numero%2)==0))||(numero<=30);
        System.out.println("El numero "+numero+" es mayor a 30 o multiplo de 2 o menor que 30? "+res);
        res=(numero/5)>10;
        System.out.println("El cociente de dividir "+numero+" por 5 es mayor que 10? "+res); 
    }

    public void tp2ej5(){
        int num1,num2;
        LibreriaIn entrada= new LibreriaIn();
        num1=entrada.returnEntero();
        num2=entrada.returnEntero();
        System.out.println("El numero original es "+(num1++)+" y su incremento es "+(num1));
        System.out.println("El numero original es "+(num2--)+" y su decremento es "+(num2));
    }

    public void division(){
        int num1=65;
        int num2=2;
        double res;
        res=((double)num1)/((double)num2);
        System.out.println(res);
    }
    
    public void leer(){
    Scanner en=new Scanner(System.in);
    String e1="";
    String e2="";
    byte edad;
    double al=0;

    System.out.println("v1");
    e1=en.nextLine();
    System.out.println("v2");
    e2=en.nextLine();
    
    
    
    System.out.println("altura");
    al=en.nextDouble();
    System.out.println("edad");
    edad=en.nextByte();
    en.nextLine();
    System.out.println("v2");
    e2=en.nextLine();
    
    System.out.println(edad+"*-"+e1+"--"+al+"--"+e2);
    en.close();
    }
}