package org.Javier.Caracuel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;


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

    public static void Leer_Fichero(){

        File file = new File("Concesionario.xml");

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("coche");

            for(int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("\nCoche id: " + eElement.getAttribute("id"));
                    System.out.println("Marca: "
                            + eElement.getElementsByTagName("marca").item(0).getTextContent());
                    System.out.println("Modelo: "
                            + eElement.getElementsByTagName("modelo").item(0).getTextContent());
                    System.out.println("Cilindrada: "
                            + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
                }
            }





        } catch(Exception e) {
            e.printStackTrace();
        }





    }


}
