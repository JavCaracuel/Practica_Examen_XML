package org.Javier.Caracuel;

public class Coche {

String Id;
String Marca;
String Modelo;
String Cilindrada=0;

    public Coche() {
    }

    public Coche(String id, String marca, String modelo, String cilindrada) {
        Id = id;
        Marca = marca;
        Modelo = modelo;
        Cilindrada = cilindrada;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getCilindrada() {
        return Cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        Cilindrada = cilindrada;
    }
}
