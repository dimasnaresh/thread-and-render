/*SIMPLE APP FOR LEARNING ABOUT THREAD AND GRAPHICS RENDERING IN JAVA*/
package com.dimas.gariskuker;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GarisKurangKerjaan extends JPanel implements Runnable{
    //'LINE' POSITION VARIABLE
	private int x;
    private int y;
    
    //RECTANGLE POSITION ARRAY
    private int xR[] = new int[3];
    private int yR[] = new int[3];
    private int speed = 400;
    private int speedTong;
    private JFrame index;
    
    //DIRECTIONS
    public int arah;
    public static final int KANAN = 0;
    public static final int KIRI = 1;
    public static final int BAWAH = 2;
    public static final int ATAS = 3;
    
    public GarisKurangKerjaan(JFrame setFrame){
        //SET JFrame
        index = setFrame;
        //INITALIZE SPEED
        this.speedTong = 3;
        //INITIALIZE LINE DEFAULT POSITION
        x = 100;
        y = 100;
        setSize(index.getWidth(), index.getHeight());
        //INITIALIZE LINE DEFAULT DIRECTION
        arah = 0;
        repositionBlock();
    }
    
    //THIS METHOD FOR RANDOM RECTANGLE POSITION
    private void repositionBlock(){
        for(int x=0;x< this.xR.length;x++){
            this.xR[x] = new Random().nextInt((getWidth()-(getWidth()/2))+10) + 10;
        }
        for(int y=0;y<this.yR.length;y++){
            this.yR[y] = new Random().nextInt((getHeight()-(getHeight()/2))+10) + 10;
        }
    }

    //THIS SIMPLE METHOD...RUNNING WHEN LINE IS OUT OF AREA
    private void hitWall(){
<<<<<<< HEAD
        int hitAct = JOptionPane.showConfirmDialog(index, "HIT WALL...CONTINUE ?", "Garis Kurang Kerjaan", JOptionPane.YES_NO_OPTION);
        if(hitAct == JOptionPane.NO_OPTION){
=======
        int hitAct = JOptionPane.showConfirmDialog(index, "HIT WALL...EXIT ?", "Garis Kurang Kerjaan", JOptionPane.YES_NO_OPTION);
        if(hitAct == JOptionPane.YES_OPTION){
>>>>>>> 98679e7189be69c28c5d5a993eed1ac578e6b5dc
            System.exit(1);
        }
    }
           
    //OVERRIDE METHOD FOR RENDERING GRAPHICS
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);
        g.setColor(Color.BLACK);
        g.drawLine(this.getWidth()/2, this.getHeight()/2 ,x,y);
        
        if(speed == 0){
            repositionBlock();
            for(int x=0;x< this.xR.length;x++){
                
                g.drawRect(this.xR[x], this.yR[x], 10, 10);
                
            }
                
            speed = 400;
        }else {
            
            for(int x=0;x< this.xR.length;x++){
                
                g.drawRect(this.xR[x], this.yR[x], 10, 10);
            }    
        }--speed;
    }

    //THREAD PROCESS
    @Override
    public void run() {
        
        try{
            while (true) {
            	while (arah==0) {
            		x++;
            		
            		repaint();
            		Thread.sleep(this.speedTong);

            		if(x==getWidth()){
            			this.hitWall();
            			x= 100;
            			y= 100;
            		}
            	}

            	while (arah==1) {
            		x--;

            		repaint();
            		Thread.sleep(this.speedTong);

            		if(x==getWidth() - getWidth()){
            			this.hitWall();
            			x= 100;
            			y= 100;
            		}
            	}

            	while (arah==2) {
            		y++;

            		repaint();
            		Thread.sleep(this.speedTong);

            		if(y==getHeight()){
            			this.hitWall();
            			x= 100;
            			y= 100;
            		}
            	}

            	while (arah==3) {
            		y--;

            		repaint();
            		Thread.sleep(this.speedTong);

            		if(y==getHeight() - getHeight()){
            			this.hitWall();
            			x= 100;
            			y= 100;
            		}
            	}
            }
        }catch(InterruptedException e){
            
        }
        
    }
}