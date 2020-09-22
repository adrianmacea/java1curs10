import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class FereastraPrincipala extends JFrame{
    
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("Optiuni");
    JMenuItem mi1 = new JMenuItem("Adauga produs");
    JMenuItem mi2 = new JMenuItem("Save");
    JMenuItem mi3 = new JMenuItem("Open");
    
    DefaultListModel<Produs> model = new DefaultListModel<Produs>();
    JList<Produs> list = new JList<Produs>(model);
    JScrollPane jsp = new JScrollPane(list);
    
    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    JLabel nr = new JLabel("Nr produse: 0");
    
    public FereastraPrincipala(){
        super("Magazinul Meu");
        setVisible(true);
        setSize(700,500);
        setLocation(650,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setJMenuBar(mb);
        mb.add(m1);
        m1.add(mi1); m1.addSeparator(); m1.add(mi2); m1.add(mi3);
        
        add(jsp);
        add(p1, BorderLayout.SOUTH); 
        p1.add(nr);
        
        new Thread(){
            public void run(){
                try{
                    while(true){
                        Thread.sleep(1000);
                        nr.setText("Nr produse: "+Magazin.getInstance().getProduse().size());
                    }
                }catch(InterruptedException e){}
            }
        }.start();
        
        //functionalitate stergere produs din lista la dublu click
        list.addMouseListener(
            new MouseAdapter(){
                public void mouseClicked(MouseEvent ev){
                    if(ev.getClickCount() == 2){
                        Produs p = (Produs) list.getSelectedValue();
                        Magazin.getInstance().removeProdus(p);
                        reAfisare();
                    }
                }
            }
        );
        
        mi1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    new FereastraAdaugare().addProdusListener(
                        new ProdusListener(){
                            public void produsAdaugat(){
                                reAfisare();
                            }
                        }
                    );
                }
            }
        );
        
        mi2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    try{
                        JFileChooser chooser = new JFileChooser(); // ne permite sa deshidem caseta de salvare, de deschidere etc
                        int r = chooser.showSaveDialog(null);
                        if(r == JFileChooser.APPROVE_OPTION){ //daca r == bla bla, inseamna ca s-a apasat butonul
                            File file = chooser.getSelectedFile();
                            ObjectOutputStream oos = new ObjectOutputStream(
                                new FileOutputStream(file)
                            );
                                
                            oos.writeObject(Magazin.getInstance());
                            oos.close();
                        }
                    }catch(Exception e){}
                }
            }
        );
        
        mi3.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    try{
                        JFileChooser chooser = new JFileChooser(); 
                        int r = chooser.showOpenDialog(null);
                        if(r == JFileChooser.APPROVE_OPTION){
                            File file = chooser.getSelectedFile();
                            ObjectInputStream ois = new ObjectInputStream(
                                new FileInputStream(file)
                            );
                                
                            Magazin m = (Magazin) ois.readObject();
                            Magazin.setInstance(m);
                            ois.close();
                            reAfisare();
                        }
                    }catch(Exception e){}
                }
            }
        );
    }
    
    public void reAfisare(){
        model.clear();
        ArrayList<Produs> produse = Magazin.getInstance().getProduse();
        for(Produs pr: produse){
            model.addElement(pr);
        }
    }
    
}