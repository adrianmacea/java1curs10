import java.io.*;

public class Produs implements Serializable{
    //Facem un bean, adica:
    // incapsulare completa - ascundem atributele in instanta (folosind getter-settes)
    // punem si constructorul implicit (folosind supraincarcarea)
    // facem clasa serializabila (implementand interfata java.io.Serializable) - obiectul poate fi transmis prin flux 
    //intre doua componente: aplicatia si consola, aplicatii intre ele, aplicatia si o pagina web, aplicatia si un fisier etc
    
    private String nume;
    private double pret;
    
    public Produs(){}
    
    public Produs(String nume, double pret){
        this.nume = nume;
        this.pret = pret;
    }
    
    public String getNume(){
        return this.nume;
    }
    
    public double getPret(){
        return this.pret;
    }
    
    public void setNume(){
        this.nume = nume;
    }
    
    public void setPret(){
        this.pret = pret;
    }
    
    //pt ca doresc sa afisez produsele (obiecte) intr-o lista am nevoie si de metoda toString
    //in are decid ce sa afiseze pentru fiecare produs, in cazul nostru, atributele nume si pret
    public String toString(){
        return nume+" "+pret;
    }
    
}