package org.Javier.Caracuel;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class App 
{

    static Scanner Entrada_teclado = new Scanner(System.in);

    static ArrayList<Coche> Array_coches = new ArrayList<Coche>();


    public static void main( String[] args )
    {
        Leer_Fichero();
        Menu();

    }

    public static void Menu(){

        int menu=0;





        do {

            System.out.println("   *****************************  Elige una  ********************************");
            System.out.println("   *  1- Añadir una agenda                                                  *");
            System.out.println("   *  2- Ver array                                                          *");
            System.out.println("   *  3- Salir                                                              *");
            System.out.println("   **************************************************************************");

            try {
                menu = Entrada_teclado.nextInt();

                switch (menu){

                    case 1:

                        break;

                    case 2:

                        for (int i=0;i<Array_coches.size();i++){


                            System.out.println("Coche:"+Array_coches.get(i).Id);
                            System.out.println(Array_coches.get(i).Marca);
                            System.out.println(Array_coches.get(i).Modelo);
                            System.out.println(Array_coches.get(i).Cilindrada);


                        }

                        break;

                    case 3:

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


            }while (menu!=3);



    }

    public static void Leer_Fichero(){

        File file = new File("Concesionario.xml");


        String Id;
        String Marca;
        String Modelo;
        int Cilindrada=0;


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

                    Id =eElement.getAttribute("id");

                    Marca=eElement.getElementsByTagName("marca").item(0).getTextContent();



                    Modelo=eElement.getElementsByTagName("modelo").item(0).getTextContent();


                    Cilindrada = Integer.parseInt(eElement.getElementsByTagName("cilindrada").item(0).getTextContent());

                    Coche Coche_aux=new Coche(Id,Marca,Modelo,Cilindrada);

                    Array_coches.add(Coche_aux);



                }
            }





        } catch(Exception e) {
            e.printStackTrace();
        }





    }


}
