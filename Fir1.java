public class Fir1 extends Thread{
    //atribute
    //constructori
    //comportamente
    
    public void run(){ //metoda principala a firului de executie
        try{
            for(int i=0;i<50;i+=2){
                Thread.sleep(300); 
                //am adaugat un timp de adormire de 300 ms dupa afisarea fiecarui numar, asta trece firul in modul blocked timpul specificat
                System.out.println(i);
            }
        }catch(InterruptedException e){}
    }
}