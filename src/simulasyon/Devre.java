/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulasyon;

import cihaz.Cihaz;
import cihaz.Led;
import cihaz.Not;
import cihaz.And;
import cihaz.Anahtar;
import cihaz.Kablo;
import cihaz.Or;
import static simulasyon.EnumCihaz.not;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Devre {
    
    public boolean noktaFlag;
    public ArrayList<Cihaz> cihaz;
    public ArrayList<Anahtar> anahtar;
    public Cihaz gecici;
    public Anahtar geciciKaynak;
    public ArrayList<Kablo> kablo;
    public int sayacCihaz, sayacAnahtar, sayacKablo;  
    public Kordinat baslangic, bitis;
    
    public Devre() {

        cihaz = new ArrayList<Cihaz> ();
        anahtar = new ArrayList<Anahtar>();
        kablo = new ArrayList<Kablo>();
        sayacCihaz = 0;
        sayacAnahtar = 0;
        sayacKablo = 0;
    }
    
    public Devre ( Devre ckt )  {
        this.cihaz = ckt.cihaz;
        this.anahtar = ckt.anahtar;
        this.sayacCihaz = ckt.sayacCihaz;
        this.sayacAnahtar = ckt.sayacAnahtar;
        this.sayacKablo = ckt.sayacKablo;
    }
    public void drawDevre ( Graphics g)   {
        Graphics2D g2d=(Graphics2D) g;
        sayacCihaz = cihaz.size();
        for ( int i = 0; i < sayacCihaz; i++ )  {
            g2d.setColor(Color.BLACK);
            cihaz.get(i).draw(g);
        }

        sayacAnahtar = anahtar.size();
        for ( int i = 0; i < sayacAnahtar; i++ )  {
            g2d.setColor(Color.BLACK);
            anahtar.get(i).draw(g);
        }
        
        sayacKablo = kablo.size();
        for ( int i = 0; i < sayacKablo; i++ )  {
            g2d.setColor(Color.BLACK);
            kablo.get(i).draw(g);
        }
        g2d.setColor(Color.BLUE);
        drawGeciciKablo(g);
    }
    
    public boolean addKablo (Kordinat baslangicNoktasi, Cihaz baslangicCihazi, Kordinat bitisNoktasi, Cihaz bitisCihazi )   {
        if ( baslangicCihazi == null || bitisCihazi == null )  {
            JOptionPane.showMessageDialog(null, "Gecersiz Baglanti");
            return false;
        }
        if ( baslangicCihazi.isOnCikisLeg(baslangicNoktasi) )    {
            if ( bitisCihazi.isOnCikisLeg(bitisNoktasi) ) {
                JOptionPane.showMessageDialog(null, "2 cikis baglanti noktasini baglayamazsiniz");
                baslangic = null;
                bitis = null;
                return false;
            }
            else    {
                int indx = bitisCihazi.isOnGirisLeg(bitisNoktasi);
                if (indx < -1)  {
                    JOptionPane.showMessageDialog(null, "Gecersiz Baglanti");
                    return false;
                }
                if ( bitisCihazi.setGirisRef(indx, baslangicCihazi) == false )    {
                    JOptionPane.showMessageDialog(null, "Bu "+bitisCihazi.getClass().toString()+" cihazi zaten bir girise sahip");
                    return false;
                }
                baslangicCihazi.addCikisRef(bitisCihazi);
                kablo.add(new Kablo(baslangicNoktasi, bitisNoktasi, baslangicCihazi, bitisCihazi));
            }
        }
        else if ( bitisCihazi.isOnCikisLeg(bitisNoktasi) )    {
            if ( baslangicCihazi.isOnCikisLeg(baslangicNoktasi) ) {
                JOptionPane.showMessageDialog(null, "2 cikis baglanti noktasini baglayamazsiniz");
                baslangic = null;
                bitis = null;
                return false;
            }
            else    {
                int indx = baslangicCihazi.isOnGirisLeg(baslangicNoktasi);
                if (indx < -1)  {
                    JOptionPane.showMessageDialog(null, "Gecersiz Baglanti");
                    return false;
                }
                if ( baslangicCihazi.setGirisRef(indx, bitisCihazi) == false )    {
                    JOptionPane.showMessageDialog(null, "Bu "+baslangicCihazi.getClass().toString()+" cihazi zaten bir girise sahip");
                    return false;
                }
                bitisCihazi.addCikisRef(baslangicCihazi);
                kablo.add(new Kablo(bitisNoktasi, baslangicNoktasi, bitisCihazi, baslangicCihazi));
                
            }
        }
        return false;
    }
    
    public void drawGeciciKablo (Graphics g) {
        try {
            Graphics2D g2d=(Graphics2D) g;
            int midx = (baslangic.x+bitis.x)/2;
            midx = (midx+5);
            midx-= midx%10;

            g2d.drawLine(baslangic.x, baslangic.y, midx, baslangic.y);
            g2d.drawLine(midx, baslangic.y, midx, bitis.y);
            g2d.drawLine(midx, bitis.y, bitis.x, bitis.y);
        }   catch(Exception e)  {
        }
    }
    
    public void setGecici ( MouseEvent evt, int inputCount )   {
        try {
            Kordinat cd = new Kordinat(evt);
            switch ( AnaFrame.cihazlar ) {
                case and:
                    gecici = new And(inputCount, cd);
                    break;
                case or:
                    gecici = new Or(inputCount, cd);
                    break;
                case not:
                    if ( gecici == null || gecici.getTur() != EnumCihaz.not ) gecici = new Not(inputCount, cd);
                    else    gecici.setYer(cd);
                    break;
               
                case led:
                    if ( gecici == null || gecici.getTur() != EnumCihaz.led ) gecici = new Led(cd);
                    else    gecici.setYer(cd);
                    break;
                case anahtar:
                    gecici = null;
                    setGeciciKaynak (cd);
                    break;
            }           
        } catch (Exception e)   {
            e.printStackTrace();
            gecici = null;
        }
        System.gc();
    }
    
    public void setGeciciKaynak ( Kordinat cd ) {
        try {
            geciciKaynak = new Anahtar(cd);
        }   catch(Exception e)  {
            e.printStackTrace();
        }
    }
    
    public Cihaz getGecici() {
        return gecici;
    }
    
    public Anahtar getGeciciKaynak()   {
        return geciciKaynak;
    }
    
    public void placeGecici ()    {
        try {
            if ( gecici != null ) {
                cihaz.add(gecici);
                sayacCihaz++;
                gecici = null;
            }
            else if ( geciciKaynak != null )  {
                anahtar.add(geciciKaynak);
                sayacAnahtar++;
                geciciKaynak = null;
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Cihaz searchCihaz (Kordinat cd)   {
        for ( int i = 0; i < sayacCihaz; i++ )
            if ( cihaz.get(i).cihazdaMi(cd.x, cd.y) )
                return cihaz.get(i);
        return searchKaynak(cd);
    }
    
    public Anahtar searchKaynak (Kordinat cd)   {
        for ( int i = 0; i < sayacAnahtar; i++ )
            if ( anahtar.get(i).cihazdaMi(cd.x, cd.y))
                return anahtar.get(i);
        return null;
    }
    
    public Kablo searchKablo (Kordinat cd)   {
        
        return null;
    }
    
    public boolean gecerliMi()    {
        sayacCihaz = cihaz.size();
        for ( int i = 0; i < sayacCihaz; i++ )
            if ( !cihaz.get(i).gecerliMi() ) return false;
        
        return true;
    }
    
    public void clear() {    
        cihaz = new ArrayList<Cihaz> ();
        anahtar = new ArrayList<Anahtar>();
        kablo = new ArrayList<Kablo>();
        sayacCihaz = 0;
        sayacAnahtar = 0;
        sayacKablo = 0;
    }
    
   
    
    public String toString()    {
        String str = new String("");
        str+= sayacCihaz + " " + cihaz.get(0).getX()+" "+cihaz.get(0).getY();
        return str;
    }
    
    public void kopyala ( Devre ckt )  {
        this.cihaz = null;
        this.cihaz = ckt.cihaz;
        this.anahtar = null;
        this.anahtar = ckt.anahtar;
        this.kablo = null;
        this.kablo = ckt.kablo;
        this.sayacCihaz = cihaz.size();
        this.sayacAnahtar = anahtar.size();
    }
}
