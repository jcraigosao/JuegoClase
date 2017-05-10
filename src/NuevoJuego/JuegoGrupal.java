
package NuevoJuego;


import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javafx.scene.shape.Circle;
import javax.swing.JPanel;
import juegoclase.TestPaintComponent;

public class JuegoGrupal extends JFrame {
    
    public JuegoGrupal() {
        add(new NuevoPanel());
    }
    public static void main(String[] args) {
        JuegoGrupal frame= new JuegoGrupal();
        frame.setTitle("JuegoGrupal");
        frame.setSize(900 , 700);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    }

class NuevoPanel extends JPanel implements ActionListener, MouseListener{
    private int x;
    private int y;
    private Timer timer;
    private int secuencia;
    private int z;

    public NuevoPanel(){
        this.addMouseListener(this);
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer= new Timer(70, this);
        timer.start();
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y+385, 32, 32);
    }
    
    public void checkCollision(){
    Rectangle tanque= getBounds();
    Rectangle objeto= new Rectangle(400, 398, 20, 20);
    Rectangle objeto2= new Rectangle(20, z+0, 20, 50); 
    if(tanque.intersects(objeto)||tanque.intersects(objeto2)){
        System.out.print("Colision");
        timer.stop();
    }
    
}
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Image fondo= loadImage("blue_background.png");
        for(int i=0; i<45; i++){
        g.drawImage(fondo, i*20, 0, null);
        }
        Image nubes= loadImage("clouds.png");
        for(int k=0;k<3; k++){
        g.drawImage(nubes, k*335, 100, null);
        }
        
        Image muñeco= loadImage("walking.png");
        g.drawImage(muñeco, x, y+180, x+100, y+300, (this.secuencia*115), 0,(this.secuencia*115)+115, 134, this);
        
        Image piso= loadImage("ground_single.png"); 
        for(int t=0; t<9; t++){
        g.drawImage(piso, t*111, 500, null);
        }
        Image moneda= loadImage("FullCoins.png");
        //g.drawImage(moneda, );
//        Image gato= loadImage("cats.gif");
//        g.drawImage(gato, x, 360, x+132, 440, (this.secuencia*132), 0, (this.secuencia*132)+132, 80, this);
        
//        g.setColor(Color.RED);
//        g.fillRect(x+10, 360, 60, 40);
//        g.setColor(Color.BLACK);
//        g.fillRect(x+40, 370, 48, 10);
//        g.fillOval(x+10, 398, 20, 20);
//        g.fillOval(x+35, 398, 20, 20);
        
        g.setColor(Color.orange);
        g.fillRect(400, 398, 20, 20);
        
        g.setColor(Color.blue);
        g.fillRect(20, z+0, 20, 50);
        g.fillOval(120, z+0, 30, 30);
      
        g.setColor(Color.black);
        g.drawRect(x, y+385, 32, 32);
    }
    public Image loadImage (String imageName){
        ImageIcon ii= new ImageIcon(imageName);
        Image image= ii.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(x<900){
//         x+=5;
//        }
        if(this.secuencia ==2){
            this.secuencia=0;
        }else{
            this.secuencia++;
        }
        if(z<500){
            z+=5;
        
   }
        checkCollision();
        repaint();
    }
    
    private class TAdapter extends KeyAdapter{
        public void keyReleased(KeyEvent e){
            System.out.println("Soltó el botón");
        }
        public void keyPressed(KeyEvent e){
            System.out.println("Presionó el botón");
            int key= e.getKeyCode();
            if(key==KeyEvent.VK_SPACE){
                System.out.println("Presiono el espacio");
            }
            if(key==KeyEvent.VK_LEFT){
                x=x-5;
            }
            if(key==KeyEvent.VK_RIGHT){
                x=x+5;
            }
            if(key==KeyEvent.VK_UP){
                y=y-5;
            }
            if(key==KeyEvent.VK_DOWN){
                y=y+5;
            }
            
        }
      
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