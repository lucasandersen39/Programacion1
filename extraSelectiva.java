public class extraSelectiva {
    
    public extraSelectiva(){

    }

    /**
     * Escribir un programa que solicite al usuario el día y mes
     * (numéricos) y determine la estación del año en la que
     * nos encontramos (Hemisferio Sur)
     */
    /**
     * Pedir que ingrese el mes
     * controlas que el mes este entre 1 y 12
     * pedir el dia
     * si mes es 1 3 5 7 8 10 12, que dia este entre 1 y 31
     * si mes es 2, si año bisiesto que dia este entre 1 y 29, sino que este entre 1 y 28
     * si mes es 4 6 9 11, que sia este entre 1 y 30
     * si mes es 1 o 2, es verano
     * si mes es 3, si dia<21 es verano, sino es otoño
     * si mes 4 o 5, otoño
     * si mes 6, si dia<21, es otoño, sino es invierno
     * si mes es 7 u 8, es invierno
     * si mes es 9, si dia<21, es invierno, sino es primavera
     * si mes es 10 u 11, es primavera
     * si mes es 12, si dia<21, es primavera, sino es verano
     */

     public void extraSelPractico1(){
        LibreriaIn en=new LibreriaIn();
        System.out.println("Ingrse el mes");
        int mes=en.returnEntero();
        //Valido un mes, si no es valido lo pido hasta que me ingrese uno correcto
        while (mes<1 || mes>12){
            System.out.println("El mes ingresado no es valido. Ingreselo nuevamente");
            mes=en.returnEntero();
        }
        boolean valido=false;
        int dia=0;
        //valido el dia dependiendo del mes. Si no es valido lo vuelvo a pedir
        while (!valido){
            System.out.println("ingrese el dia");
            dia=en.returnEntero();
            switch (mes){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:{
                    if (dia>=1 && dia<=31)
                        valido=true;
                    else
                        System.out.println("El dia ingresado es incorrecto");
                    break;
                }
                case 4: case 6: case 9: case 11:{
                    if (dia>=1 && dia<=30)
                        valido=true;
                    else    
                        System.out.println("El dia ingresado es incorrecto");
                    break;
                }
                case 2:{
                    System.out.println("Por favor, ingrese el año");
                    int anio = en.returnEntero();
                    if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){
                        if (dia>=1 && dia<=29)
                            valido=true;
                        else    
                            System.out.println("El dia ingresado es incorrecto");
                    }
                    else 
                    if (dia>=1 && dia<=28)
                        valido=true;
                    else
                        System.out.println("El dia ingresado es incorrecto");
                    break;
                }
            }
        }
        //Busco segun el mes que estacion cae la fecha ingresada
        switch (mes){
            case 1: case 2:{ System.out.println("Es verano");break;}
            case 3:{ 
                if (dia<21)
                    System.out.println("Es verano");
                else    
                    System.out.println("Es otoño");
                break;
            }
            case 4: case 5:{System.out.println("Es otoño");break;}
            case 6:{
                if (dia<21)
                    System.out.println("Es otoño");
                else
                    System.out.println("Es invierno");
                break;
            }
            case 7: case 8:{System.out.println("Es invierno");break;}
            case 9:{
                if (dia<21)
                    System.out.println("Es invierno");
                else
                    System.out.println("Es primavera");
                break;
            }
            case 10: case 11:{System.out.println("Es primavera");break;}
            case 12:{
                if (dia<21)
                    System.out.println("Es primavera");
                else    
                    System.out.println("Es verano");
                break;
            }
        }
     }
     /**
      * Utilizando la sentencia Switch, escribir un programa que
      * solicite el día y mes (numéricos) y determine el número
      * de días que transcurrieron del año actual.
      */

     public void extraSelEjercicio3(){
        LibreriaIn en=new LibreriaIn();
        System.out.println("Ingrse el mes");
        int mes=en.returnEntero();
        //Valido un mes, si no es valido lo pido hasta que me ingrese uno correcto
        while (mes<1 || mes>12){
            System.out.println("El mes ingresado no es valido. Ingreselo nuevamente");
            mes=en.returnEntero();
        }
        System.out.println("ingrese el dia");
        int dia=en.returnEntero();
        System.out.println("Ingrese el año");
        int anio=en.returnEntero();
        int diasFeb=0;
        if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
            diasFeb=29;
        else    
            diasFeb=28;
        switch (mes){
            case 1:{
                if (dia>=1 && dia<=31)
                    System.out.println("Han transcurrido "+dia+" dias del año");
                break;
            }
            case 2:{    
                System.out.println("Han transcurrido "+(31+dia)+" dias del año");
            }
            case 3:{
                if (dia>=1 && dia<=31)
                    System.out.println("Han transcurrido "+(31+diasFeb+dia)+" dias del año");
                break;
            }
            case 4:{
                if (dia>=1 && dia<=30)
                    System.out.println("Han transcurrido "+(62+diasFeb+dia)+" dias del año");
                break;
            }
            case 5:{
                if (dia>=1 && dia<=31)
                    System.out.println("Han transcurrido "+(92+diasFeb+dia)+" dias del año");
                break;
            }
            case 6:{
                if (dia>=1 && dia<=30)
                    System.out.println("Han transcurrido "+(123+diasFeb+dia)+" dias del año");
                break;
            }
            case 7:{
                if (dia>=1 && dia<=31)
                    System.out.println("Han transcurrido "+(153+diasFeb+dia)+" dias del año");
                break;
            }
            case 8:{
                if (dia>=1 && dia<=31)
                    System.out.println("Han transcurrido "+(184+diasFeb+dia)+" dias del año");
                break;
            }
            case 9:{
                if (dia>=1 && dia<=30)
                    System.out.println("Han transcurrido "+(215+diasFeb+dia)+" dias del año");
                break;
            }
            case 10:{
                if (dia>=1 && dia<=31)
                    System.out.println("Han transcurrido "+(245+diasFeb+dia)+" dias del año");
                break;
            }
            case 11:{
                if (dia>=1 && dia<=30)
                    System.out.println("Han transcurrido "+(276+diasFeb+dia)+" dias del año");
                break;
            }
            case 12:{
                if (dia>=1 && dia<=31)
                    System.out.println("Han transcurrido "+(306+diasFeb+dia)+" dias del año");
                break;
            }
        }
     }

     
}
