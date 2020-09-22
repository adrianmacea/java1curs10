public class E02{
    public static void main(String [] args){
        Fir3 f3 = new Fir3();
        // Cum pornim firul f3?
        // f3.start(); - nu mai functioneaza pt ca nu mai mosteneste pe Thread si nu mai are metoda start
        //Solutia: exista un constructor in clasa Thread care primeste ca parametru un runnable
        new Thread(f3).start();
    }
}