public class E01{
    public static void main (String [] args){
        Fir1 f1 = new Fir1();
        Fir2 f2 = new Fir2();
        
        //f1.run(); 
        //run nu trece firul din stadiul new in stadiul runnable, ci e pur si simplu un comportament al lui f1
        
        f1.setPriority(6); //prioritatea ia valori intre 1 si 10, implicit e 5, nu e sigur ca sistemul de operare o ia in considerare 
        f1.start(); //folosind start pornim firul de executie f1, adica trece din new in runnable
        f2.start(); //pornim si firul 2 de executie
        
        System.out.println("Se termina main!");
        //Mesajul se afiseaza PROBABIL la inceput. Main, f1 si f2 se vor executa "in paralel", dar probabil ca main termina primul.
        //E posibil ca mesajul sa apara si printre numere sau chiar la sfarsit, depinde de cum gestioneaza OS-ul firele.
        //Mesajul s-ar fi afisat SIGUR la asfarsit daca am fi folosit f1.run() de mai sus, in loc de start. 
    }
}