
//Escribir un programa que solicite al usuario el día y mes
//(numéricos) y determine la estación del año en la que
//nos encontramos (Hemisferio Sur).
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class hemi{
 public static void main(String[] args){
   int dia=0;
   int mes=0;
 BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
   
   try{
     System.out.println("ingrese un numero para determinar un dia");
     dia=Integer.valueOf(entrada.readLine());
     System.out.println("ingrese un numero para determinar un mes");
     mes=Integer.valueOf(entrada.readLine());  
   }
   catch(Exception exc){
    System.out.println("error");
   }
  
   if(mes>=1 && mes<=12){
   
     switch(mes){
       case 1: case 2:System.out.println("es verano"); break;
       case 3:
         if (dia<21){
           System.out.println("es verano");
           break;
         }
         else{
           System.out.println("es otono");
         }
       case 4:  case 5:System.out.println("es otoño");
         break;
         
        case 6:
          if(dia<21){
           System.out.println("es otoño");
         }
         else{
           System.out.println("es invierno");
         }
         
       case 7: case 8:System.out.println("es invierno");break;
         
       case 9:
        if(dia<21){
          System.out.println("es invierno");
        }
        else{
          System.out.println("es primavera");
        }
       case 10: case 11: System.out.println("es primavera");
         
       case 12:
         if(dia<21){
           System.out.println("es primavera");
         }
         else{
           System.out.println("es verano");
         }
       }
     }
   }
 }
