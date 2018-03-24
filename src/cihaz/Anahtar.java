/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cihaz;

import java.awt.BasicStroke;
import simulasyon.Kordinat;
import simulasyon.EnumCihaz;
import simulasyon.AnaFrame;
import simulasyon.EnumMod;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Suayb Simsek
 */
public class Anahtar extends Kapi  {

    boolean flag;
    
    public Anahtar(int yerX, int yerY) {
        super(0, EnumCihaz.anahtar, new Kordinat(yerX-10, yerY-10));
        flag = false;
    }

    public Anahtar(Kordinat yer) {
        super(0, EnumCihaz.anahtar, new Kordinat(yer.x-10,yer.y-10));
        flag = false;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        int x = this.getX(), y = this.getY();
        Color c= g2d.getColor();
        if ( this.seciliMi )    g2d.setColor(Color.BLUE);
        g2d.drawRect(x,y,20,20);
        String s = "0";
        if ( this.getCikis() && AnaFrame.mod == EnumMod.Calistir )   {
            s = "1";
            g2d.setColor(Color.red);
        }
        g2d.fillOval(x+2,y+2,16,16);
        g2d.drawLine(x+20,y+10,x+30,y+10);
        g2d.fillOval(x+28, y+8, 4, 4);
        g2d.setColor(Color.white);
        g2d.drawString(s,x+7, y+16);
        g2d.setColor(c);
        this.setCikisLeg(new Kordinat(x+30,y+10));
    }

    @Override
    public boolean isOnCikisLeg(Kordinat c) {
        return super.isOnCikisLeg(c); 
    }
    
    @Override
    public int isOnGirisLeg(int x, int y) {
        return -1;
    }


    @Override
    public boolean cihazdaMi(int x, int y) {
        if ( x >= this.getX() && x <= this.getX()+20 )  {
            if ( y >= this.getY() && y <= this.getY()+20 )
                return true;
        }
        else if ( x == this.getX()+30 && y >= this.getY() && y <= this.getY()+10 )  return true;
        return false;
    }

   

    public void toggleCikis() {
        setCikis(!this.getCikis());
    }

    @Override
    public void generateCikis() {
        int l = cikisRef.size();
        for ( int i = 0; i < l; i++ )   {
            cikisRef.get(i).setGiris();
        }
    }
    
}
