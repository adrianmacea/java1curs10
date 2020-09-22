public class Cont1{
    
    double suma;
    
    public Cont1(double suma){
        this.suma = suma;
    }
    
    public double getSold(){
        return suma;
    }
    
    public void retrageNumerar(double suma){
        this.suma -= suma;
    }
}