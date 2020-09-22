import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//facem o fereastra care are functia de a adauga un Produs in Magazin
public class FereastraAdaugare extends JFrame implements SubiectProdus{
    
    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel p3 = new JPanel(new FlowLayout());
    
    JLabel l1 = new JLabel("Nume: ");
    JLabel l2 = new JLabel("Pret: ");
    
    JTextField t1 = new JTextField(10);
    JTextField t2 = new JTextField(11);
    
    JButton b = new JButton("Adauga");
    
    public FereastraAdaugare(){
        super("Produs Nou");
        setVisible(true);
        setSize(200,130);
        setLocation(400,300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setLayout(new GridLayout(3,1));
        add(p1); 
        add(p2);
        add(p3);
        
        p1.add(l1); p1.add(t1);
        p2.add(l2); p2.add(t2);
        p3.add(b);
        
        b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    Magazin m = Magazin.getInstance(); //cerem instanta singleton de Magazin
                    String nume = t1.getText(); //preluam numele produsului
                    double pret = Double.parseDouble(t2.getText()); //am facut o conversie sa putem prelua stringul in double
                    m.adaugaProdus(new Produs(nume,pret));
                    notifica(); //apelam lista de listeneri
                    dispose(); //dispose aplicat pe this inchide fereastra curenta
                }
            }
        );
        
    }
    
    public void addProdusListener(ProdusListener o){
        obs.add(o);
    }
    
    public void notifica(){
        for(ProdusListener o: obs){//parcurgem lista de observatori
            o.produsAdaugat();
        }
    }
    
}
