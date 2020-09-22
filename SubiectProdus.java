import java.util.*;

public interface SubiectProdus{
    //Construim o interfata de tip "Subiect" pentru un Observer Pattern. Care trebuie sa aiba:
    // lista de ascultatori, 
    // o metoda pentru adaugare obiect la lista,
    // optional una pentru eliminare obiect din lista,
    // o metoda pentru notificarea acestor ascultatori.
    //(Toate sunt abstracte, suntem intr-o interfata.)
    
    ArrayList<ProdusListener> obs = new ArrayList<ProdusListener>();
    
    public void addProdusListener(ProdusListener o);
    
    public void notifica();

}