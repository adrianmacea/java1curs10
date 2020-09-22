import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//construim o fereastra care CREAZA un nou fir de executie in constructor

public class E04 extends JFrame{
    
    JButton b = new JButton("Hello");
    
    public E04(){
        super("Fereastra CREAZA Thread");
        setVisible(true);
        setSize(600,400);
        setLocation(450,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        
        add(b);
        
        //Mai jos, am creat un nou fir de executie, care contine o bucla infinita.
        //In mod normal in constructor nu pot sa am bucla infinita, pentru ca nu s-ar putea realiza instanta -  
        //o instanta este creata in momentul in care s-a executat si ultima linie de cod a costructorului.
        //Bucla infinita nu blocheaza programul pentru ca firele de executie sunt independente si individuale.
        //In cazul nostru constructorul doar creaza si porneste al doilea fir de executie.
        new Thread(){
            public void run(){
                try{
                    while(true){
                        Thread.sleep(1000);
                        if(b.getText() == "Hello"){
                            b.setText("World");
                        }else{
                            b.setText("Hello");
                        }
                    }
                }catch(Exception e){}
            }
        }.start();
        
    }
    
    public static void main(String [] args){
        new E04(); 
    }
    
}
