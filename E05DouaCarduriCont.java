/**
 * Conditia de retragere numerar este pusa astfel incat sa nu se poata retrage bani daca sunt fonduri insuficiente
 * 
 */

public class E05DouaCarduriCont{
    
    static Cont1 cont = new Cont1(200);
    
    public static void main(String [] args){
        
        new Thread(){
            public void run(){
                try{
                    while(cont.getSold()>0){
                        if(cont.getSold()>50){
                            Thread.sleep(300);
                            cont.retrageNumerar(50);
                            System.out.println("Sot: "+cont.getSold());
                        }
                    }
                }catch(Exception e){}
            }      
        }.start();
        
        
        new Thread(){
            public void run(){
                try{
                    while(cont.getSold()>0){
                        if(cont.getSold()>70){
                            Thread.sleep(200);
                            cont.retrageNumerar(70);
                            System.out.println("Sotie: "+cont.getSold());
                        }
                    }
                }catch(Exception e){}
            }      
        }.start();
    }
    
}