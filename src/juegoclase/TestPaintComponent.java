package juegoclase;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class TestPaintComponent extends JFrame{

    public TestPaintComponent() {
        add(new NewPanel());
    }
    public static void main(String[] args) {
        TestPaintComponent frame= new TestPaintComponent();
        frame.setTitle("TestPaintComponent");
        frame.setSize(900 , 700);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    }
class NewPanel extends JPanel implements ActionListener, MouseListener{
    private int x;
    private int y;
    private Timer timer;

    public NewPanel() {
        this.addMouseListener(this);
        timer= new Timer(10, this);
        timer.start();
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x+5, 195, 85, 65);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x+10, 200, 60, 40);
        g.setColor(Color.BLACK);
        g.fillRect(x+40, 210, 40, 10);
        g.fillOval(x+10, 238, 20, 20);
        g.fillOval(x+35, 238, 20, 20);
        
        g.setColor(Color.orange);
        g.fillRect(200, 238, 20, 20);
        
        g.setColor(Color.blue);
        g.fillRect(20, y+0, 20, 50);
        g.fillOval(120, y+0, 30, 30);
      
        g.setColor(Color.black);
        g.drawRect(x+5, 195, 85, 65);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x<900){
         x+=1;
        }
//        if(y<500){
         y+=1;
         repaint();
//    }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       System.out.println("Usted ha clickeado");
       Point mp=e.getPoint();
       if(getBounds().contains(mp)){
           this.timer.stop();
           
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}

