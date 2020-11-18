package org.Javier.Caracuel;

public class Coche {

String Id;
String Marca;
String Modelo;
int Cilindrada=0;

    public Coche() {
    }

    public Coche(String id, String marca, String modelo, int cilindrada) {
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

    public int getCilindrada() {
        return Cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        Cilindrada = cilindrada;
    }
}
