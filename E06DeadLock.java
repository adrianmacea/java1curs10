/**
 * exemplu dead lock - aplicatia se blocheaza pentru ca firele de executie asteapta unul dupa celalalt
 * 
 * trebuia facut cu un if else
 * 
 */

public class E06DeadLock{
    
    static Cont2 cont = new Cont2(200);
    
    public static void main(String [] args){
        
        new Thread(){
            public void run(){
                  while(cont.getSold()>0){
                      cont.verificareSiExtragere(50);
                      System.out.println("Sot: "+cont.getSold());
                  }
            }      
        }.start();
        
        
        new Thread(){
            public void run(){
                  while(cont.getSold()>0){
                      cont.verificareSiExtragere(70);
                      System.out.println("Sotie: "+cont.getSold());
                  }
            }      
        }.start();
    }
    
}
