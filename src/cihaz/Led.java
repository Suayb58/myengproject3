/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cihaz;

import simulasyon.EnumCihaz;
import simulasyon.EnumMod;
import simulasyon.Kordinat;
import simulasyon.AnaFrame;
import java.awt.*;
/**
 *
 * @author Suayb Simsek
 */
public class Led extends Kapi {

    public Led() {
        super(1, EnumCihaz.led, new Kordinat(0,0));
    }
    public Led(Kordinat location) {
        super(1, EnumCihaz.led, new Kordinat(location.x-10,location.y-10));
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        int x = this.getX(), y = this.getY();
        
        Color c = g2d.getColor();
        g2d.setColor(Color.gray);
        g2d.fillRect(x,y+20,20,10);
        if ( this.seciliMi )    g2d.setColor(Color.blue);
        g2d.setColor(c);
        g2d.drawRect(x,y+20,20,10);
        this.setGirisLeg(new Kordinat(x+10,y+40),0);
        if ( getGiris(0) && AnaFrame.mod == EnumMod.Calistir )  {
            g2d.setColor(Color.BLACK);
            g2d.drawLine(x+10,y+30,x+10,y+40);
            g2d.setColor(Color.YELLOW);
            g2d.fillArc(x+3,y,14,40,0,180);
            g2d.fillOval(x+8, y+38, 4, 4);
        }
        else    {
            g2d.fillOval(x+8, y+38, 4, 4);
            g2d.drawLine(x+10,y+30,x+10,y+40);
        }
           
        g2d.setColor(c);
        g2d.drawArc(x+3, y, 14, 40, 0, 180);
        
    }

    @Override
    public void setYer(Kordinat cd) {
        super.setYer(new Kordinat(cd.x-10,cd.y-10)); 
    }
    
    @Override
    public int isOnGirisLeg(Kordinat c) {
        return super.isOnGirisLeg(c); 
    }

    @Override
    public boolean isOnCikisLeg(Kordinat c) {
        return false;
    }

    @Override
    public int isOnGirisLeg(int x, int y) {
        return super.isOnGirisLeg(x, y); 
    }

    @Override
    public boolean isOnCikisLeg(int x, int y) {
        return super.isOnCikisLeg(x, y); 
    }

    @Override
    public boolean cihazdaMi(int x, int y) {
        if ( x >= this.getX() && x <= this.getX()+20 )  {
            if ( y >= this.getY() && y <= this.getY()+40 )  {
                return true;
            }
        }
        else if ( x == this.getX()+10 && y >= this.getY()+40 && y <= this.getY()+10 )  return true;
        return false;
    }

   

    @Override
    public boolean getFlag() {
        return super.getFlag(); 
    }

    @Override
    public void setFlag(boolean b) {
        super.setFlag(b); 
    }

    @Override
    public void generateCikis() {
        super.generateCikis(); 
    }
    
    
}
