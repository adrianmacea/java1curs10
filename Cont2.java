public class Cont2{
    
    private double suma; //fata de cont 1 aici am aaugat private
    
    public Cont2(double suma){
        this.suma = suma;
    }
    
    public double getSold(){
        return suma;
    }
    
    public void retrageNumerar(double suma){
        this.suma -= suma;
    }
    
    //adaugam o metoda syncronizata pe care o vom apela in run-ul celelilalte clase
    public void verificareSiExtragere(double suma){
        synchronized(this){
            if(getSold() > suma){
                try{
                    Thread.sleep(300);
                    retrageNumerar(50);
                }catch(Exception e){}
            }
        }
    }
    // sau
    public synchronized void mNonStatica(){
    }
    
    public static synchronized void m1(){        
    }
    
    public static void m2(){  
        synchronized(Cont2.class){
        }
    }
    
}
