import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//construim o fereastra care ESTE in acelasi timp un nou fir de executie

public class E03 extends JFrame implements Runnable{
    
    JButton b = new JButton("Hello");
    
    public E03(){
        super("Fereastra ESTE SI Thread");
        setVisible(true);
        setSize(600,400);
        setLocation(450,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        
        add(b);
    }
    
    public static void main(String [] args){
        new Thread(new E03()).start(); 
        //aici am pornit firul de executie
        //fereastra este si fir de executie in acelasi timp
    }
    
    // run il las intotdeauna la sfarsit
    public void run(){
        //pt ca firul de executie este independent putem scrie aici o bucla infinita fara sa blocam programul
        try{
            while(true){
                Thread.sleep(1000);
                if(b.getText().equals("Hello")){
                    b.setText("World");
                }else{
                    b.setText("Hello");
                }
            }
        }catch(Exception e){}
    }
}