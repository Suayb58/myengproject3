package cihaz;

import simulasyon.EnumMod;
import simulasyon.Kordinat;
import simulasyon.AnaFrame;
import java.awt.*;
import java.io.*;
        
public class Kablo 
{
    private boolean durum,wdDurum;
    private Kordinat baslangic, bitis, orta_nokta;
    private Cihaz girisRef, cikisRef;
    
    public Kablo()
    {
        baslangic = new Kordinat(0,0);
        bitis = new Kordinat(0,0);
        orta_nokta = new Kordinat(0,0);
        this.durum = false;
        this.wdDurum = false;
        this.girisRef = null;
        this.cikisRef = null;
    }

    public Kablo(Kordinat baslangic, Kordinat bitis, Cihaz girisRef, Cihaz cikisRef) {
        this.baslangic = baslangic;
        this.bitis = bitis;
        this.girisRef = girisRef;
        this.girisRef.addCikisKablo(this);
        this.cikisRef = cikisRef;
        this.orta_nokta = new Kordinat ((baslangic.x+bitis.x)/2, (baslangic.y+bitis.y)/2);
        this.durum = false;
    }
    
    
    public void setBaslangic(int x,int y)
    {
        this.baslangic.x = x;
        this.baslangic.y = y;
    }
    
    public void setBitis(int x,int y)
    {
        this.bitis.x = x;
        this.bitis.y = y;        
    }
    
    public int getBaslangicX()
    {
        return this.baslangic.x; 
    }
    
    public int getBaslangicY()
    {
        return this.baslangic.y; 
    }
    
    public int getBitisX()
    {
        return this.bitis.x; 
    }
    
    public int getBitisY()
    {
        return this.bitis.y; 
    }
    
    public int getOrtaNoktaX()
    {
        return this.orta_nokta.x;
    }
    
    public int getOrtaNoktaY()
    {
        return this.orta_nokta.y;
    }

    public boolean getDurum() {
        return durum;
    }

    public void setDurum(boolean durum) {
        this.durum = durum;
    }

    public Cihaz getGirisRef() {
        return girisRef;
    }

    public void setGirisRef(Cihaz girisRef) {
        this.girisRef = girisRef;
    }

    public Cihaz getCikisRef() {
        return cikisRef;
    }

    public void setCikisRef(Cihaz cikisRef) {
        this.cikisRef = cikisRef;
    }
    
    public void draw(Graphics g)
    {
        Graphics2D g2d=(Graphics2D) g;
        Color c = g2d.getColor();
        if ( durum && AnaFrame.mod == EnumMod.Calistir )    g2d.setColor(Color.red);
        g2d.drawLine(baslangic.x, baslangic.y, orta_nokta.x, baslangic.y);
        g2d.drawLine(orta_nokta.x, baslangic.y, orta_nokta.x, bitis.y);
        g2d.drawLine(orta_nokta.x, bitis.y, bitis.x, bitis.y);
        g2d.setColor(c);
    }

    @Override
    public String toString() {
        return "Kablo{" + "durum=" + durum + ", wdDurum=" + wdDurum + ", baslangic=" + baslangic + ", bitis=" + bitis + ", orta_nokta=" + orta_nokta + ", girisRef=" + girisRef + ", cikisRef=" + cikisRef + '}';
    }
    
    
}