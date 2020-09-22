public class Fir2 extends Thread{
        
    public void run(){ //metoda principala a firului de executie
        try{
            for(int i=1;i<50;i+=2){
                Thread.sleep(300);
                System.out.println(i);
            }
        }catch(InterruptedException e){}
    }
}
