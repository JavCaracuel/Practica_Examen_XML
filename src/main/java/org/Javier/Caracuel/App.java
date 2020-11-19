package org.Javier.Caracuel;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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

        String Var_aux;





        do {

            System.out.println("   *****************************  Elige una  ********************************");
            System.out.println("   *  1- Escribir XML                                                       *");
            System.out.println("   *  2- Ver el contenido de concesionario                                  *");
            System.out.println("   *  3- Salir                                                              *");
            System.out.println("   **************************************************************************");

            try {
                menu = Entrada_teclado.nextInt();

                switch (menu){

                    case 1:

                        System.out.println("Escriba el nombre del fichero:");


                Var_aux=Entrada_teclado.next();

                Escribir_fichero(Var_aux);

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
        String Cilindrada;


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


                    Cilindrada = eElement.getElementsByTagName("cilindrada").item(0).getTextContent();

                    Coche Coche_aux=new Coche(Id,Marca,Modelo,Cilindrada);

                    Array_coches.add(Coche_aux);



                }
            }





        } catch(Exception e) {
            e.printStackTrace();
        }





    }

    public static void Escribir_fichero(String Nombre_Fichero){

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // definimos el elemento raíz del documento
            Element eRaiz = doc.createElement("concesionario");
            doc.appendChild(eRaiz);

            // definimos el nodo que contendrá los elementos
            Element eCoche = doc.createElement("coche");
            eRaiz.appendChild(eCoche);

            // atributo para el nodo coche
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            eCoche.setAttributeNode(attr);

            // definimos cada uno de los elementos y le asignamos un valor
            Element eMarca = doc.createElement("marca");
            eMarca.appendChild(doc.createTextNode("Renault"));
            eCoche.appendChild(eMarca);

            Element eModelo = doc.createElement("modelo");
            eModelo.appendChild(doc.createTextNode("Megano"));
            eCoche.appendChild(eModelo);

            Element eCilindrada = doc.createElement("cilindrada");
            eCilindrada.appendChild(doc.createTextNode("1.5"));
            eCoche.appendChild(eCilindrada);

            // clases necesarias finalizar la creación del archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("ARUS"+Nombre_Fichero+".xml"));

            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }




    }



}
