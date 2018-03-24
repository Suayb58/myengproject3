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
public class Not extends Kapi {

    public Not(int girisSayisi) {
        super(girisSayisi, EnumCihaz.not, new Kordinat(0,0));
    }
    public Not(int girisSayisi, Kordinat yer) {
        super(girisSayisi, EnumCihaz.not, new Kordinat(yer.x-10, yer.y-15));
        
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        int x = this.getX(), y = this.getY();
        
        Color c = g2d.getColor();
        if ( this.seciliMi )    g2d.setColor(Color.BLUE);
        g2d.drawLine(x, y+5, x, y+35);
        g2d.drawLine(x, y+5, x+20, y+20);
        g2d.drawLine(x+20, y+20, x, y+35);
        g2d.drawOval(x+20, y+16, 8, 8);
        
        if ( this.getGiris(0) && AnaFrame.mod == EnumMod.Calistir )  g2d.setColor(Color.red);
        else    g2d.setColor(c);
        g2d.fillOval(x-2,y+18,4,4);
        this.setGirisLeg(new Kordinat(x,y+20),0);
        
        if ( this.getCikis() && AnaFrame.mod == EnumMod.Calistir )  g2d.setColor(Color.red);
        else    g2d.setColor(c);
        g2d.fillOval(x+28,y+18,4,4);
        this.setCikisLeg(new Kordinat(x+30,y+20));
    }

    @Override
    public void setYer(Kordinat cd) {
        cd.x-= 10;
        cd.y-= 15;
        cd = new Kordinat(cd.x,cd.y);
        super.setYer(cd); 
    }

    
    @Override
    public int isOnGirisLeg(Kordinat c) {
        return super.isOnGirisLeg(c); 
    }

    @Override
    public boolean isOnCikisLeg(Kordinat c) {
        return super.isOnCikisLeg(c); 
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
        return (x >= this.getX() && x <= this.getX()+30 && y >= this.getY()+10 && y <= this.getY()+20);
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
        this.cikis = !this.giris[0];
        
        int l = cikisRef.size();
        for ( int i = 0; i < l; i++ )   {
            cikisRef.get(i).setGiris();
        }
    }
    
    
}
