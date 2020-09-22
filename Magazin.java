import java.util.*;

//clasa singleton, adica poate avea o singura instanta
public class Magazin implements java.io.Serializable{
    
    private ArrayList<Produs> listaProduse = new ArrayList<Produs>();
    
    //declar o variabila statica privata de tip Magazin, initial nula - folosita apoi in metoda getInstance
    private static Magazin singleton = null; //e null implicit oricum, dar am pus sa se vada
    
    //intr-un singleton constructorul este private
    private Magazin(){}
    
    //metoda statica de tip Magazin care ne returneaza mereu aceeasi instanta de Magazin, dupa ce aceasta a fost creata
    public static Magazin getInstance(){
        if(singleton == null){
            singleton = new Magazin();
        }
        return singleton;
    }
    
    //metoda statica de tip void care inlocuieste instanta cu cea salvata in fisier
    public static void setInstance(Magazin m){
        singleton = m;
    }
    
    public void adaugaProdus(Produs p){
        listaProduse.add(p);
    }
    
    public ArrayList<Produs> getProduse(){
        return listaProduse;
    }
    
    public void removeProdus(Produs p){
        listaProduse.remove(p);
    }
}