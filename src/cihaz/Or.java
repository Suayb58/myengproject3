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
public class Or extends Kapi    {

    public Or(int girisSayisi) {
        super(girisSayisi, EnumCihaz.or, new Kordinat(0,0));
    }
    
    public Or(int girisSayisi, Kordinat yer) {
        super(girisSayisi, EnumCihaz.or, new Kordinat(yer.x-80,yer.y-30));
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        int x = this.getX(), y = this.getY();
        Color c = g2d.getColor();
        if ( this.seciliMi )    g2d.setColor(Color.BLUE);
        g2d.drawArc(x,y+5,100,50,0,-90);
        g2d.drawArc(x,y+5,100,50,0,90);
        g2d.drawArc(x+40,y+5,20,50,0,-90);
        g2d.drawArc(x+40,y+5,20,50,0,90);
        
        if ( this.getCikis()&& AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
        else    g2d.setColor(c);
        g2d.fillOval(x+98,y+28,4,4);
        this.setCikisLeg(new Kordinat(x+100,y+30));
        
        int i = this.getGirisSayisi();
        
        if(i == 2)
        {
            if ( this.getGiris(0) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x+50, y+19, 10, 2);
            g2d.fillOval(x+48, y+18, 4, 4);
            this.setGirisLeg(new Kordinat(x+50,y+20), 0);
            
            if ( this.getGiris(1) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x+50, y+39, 10, 2);
            g2d.fillOval(x+48, y+38, 4, 4);
            this.setGirisLeg(new Kordinat(x+50,y+40), 1);
        }
        
        else if(i == 3) {
            if ( this.getGiris(0) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x+50, y+19, 10, 2);
            g2d.fillOval(x+48, y+18, 4, 4);
            this.setGirisLeg(new Kordinat(x+50,y+20), 0);
            
            if ( this.getGiris(1) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x+50, y+29, 10, 2);
            g2d.fillOval(x+48, y+28, 4, 4);
            this.setGirisLeg(new Kordinat(x+50,y+30), 1);
            
            if ( this.getGiris(2) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x+50, y+39, 10, 2);
            g2d.fillOval(x+48, y+38, 4, 4);
            this.setGirisLeg(new Kordinat(x+50,y+40), 2);
        }
        
        
    }

    @Override
    public void setYer(Kordinat cd) {
        super.setYer(new Kordinat(cd.x-80, cd.y-30)); 
        Kordinat c = new Kordinat(cd.x-80, cd.y-30);
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
        if ( x >= this.getX()+50 && x <= this.getX()+100)   {
            if ( y >= this.getY() && y <= this.getY()+60 )
                return true;
        }
        return super.cihazdaMi(x, y); 
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
        int count = 0;
        for(count=0; count < this.girisSayisi; count++)
        {
            if(this.giris[count])
            {
                this.cikis = true;
                break;
            }
        }
        if(count == this.girisSayisi)
            this.cikis = false;
        
        int l = cikisRef.size();
        for ( int i = 0; i < l; i++ )   {
            cikisRef.get(i).setGiris();
        }
    }

    
}
