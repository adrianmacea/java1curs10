/**
 * Produs - bean (nume, pret)
 * Magazin - singleton
 * Fereastra - observer pattern
 * FereastraAdaugare - observer pattern
 * Panou in partea de jos - afiseaza nr produse la 1 secunda
 * Sterg element la dublu click
 * Caseta de salvare
 * Caseta de deschidere
 * 
 * Subiect este fie magazinul fie fereastra de adaugare, alegem mai degraba fereastra de adaugare.
 * Fereastra principala va fi observatorul ferestrei de adaugare.
 * Cand fereastra de adaugare adauga un produs, fereastra principala este notificata si va adauga produsul in magazin.
 * Pentru a realiza asta vom avea nevoie de 2 interfete: SubiectProdus si ProdusListener, plus un Adaptor (dupa caz).
 * 
 */

public class E07Main{
    
    static FereastraPrincipala fp; //cand apelam un bloc static trebuie sa fie tot cu static ...
    
    public static void main(String [] args){
        fp = new FereastraPrincipala();
    }
    
    //aceasta clasa main nu face decat sa instantieze fereastra principala
    //(se putea pune si in clasa FereastraPrincipala)
}