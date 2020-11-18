package org.Javier.Caracuel;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    static Scanner Entrada_teclado = new Scanner(System.in);


    public static void main( String[] args )
    {

            Menu();

    }

    public static void Menu(){

        int menu=0;



        do {

            System.out.println("   *****************************  Elige una  ********************************");
            System.out.println("   *  1- Añadir una agenda                                                  *");
            System.out.println("   *  2- Salir                                                              *");
            System.out.println("   **************************************************************************");

            try {
                menu = Entrada_teclado.nextInt();

                switch (menu){

                    case 1:

                        break;

                    case 2:

                        System.out.println("Saliendo");

                        break;

                    default:

                        System.out.println("Introduzca el numero de nuevo:");

                    break;

                }

            }catch (InputMismatchException ime){

                System.out.println("¡Cuidado! Solo puedes insertar números. Intentalo de nuevo:");

                Entrada_teclado.next();

            }


            }while (menu!=2);



    }


}
