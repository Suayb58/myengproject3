/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulasyon;

import cihaz.Cihaz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
    
public class DevrePanel extends JPanel {
    
    public static int mesafe;
    public Devre ckt;
    
    public DevrePanel() {
        this.setPreferredSize(new Dimension(1920,1080));
        this.mesafe = 10;
    }
    
    public DevrePanel(Devre ckt) {
        this.setPreferredSize(new Dimension(1920,1080));
        this.mesafe = 10;
        this.ckt = ckt; 
    }
    
    boolean paintNokta (Graphics g)    {    //Basarili ise true,yoksa false döndurur.
        Graphics2D g2d=(Graphics2D) g;
        Color c = g2d.getColor();
        if ( ckt.noktaFlag )    g2d.setColor(Color.RED);
        else    g2d.setColor(Color.BLUE);
        
        try {
            Kordinat cd = new Kordinat(AnaFrame.mouseMove);
            g2d.fillRect(cd.x-3, cd.y-3, 6, 6);
            g2d.setColor(c);
            return true;
        }catch(Exception e) {            
            e.printStackTrace();
            g2d.setColor(c);
            return false;
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        int height = this.getPreferredSize().height;
        int width = this.getPreferredSize().width;
        
        for ( int i = 0; i < height; i+= 10 )    {
            for ( int j = 0; j < width; j+= 10 ) {
                g2d.drawLine(j, i, j, i);
            }
        }
        
        g2d.setColor ( Color.BLACK);
        ckt.drawDevre(g);
        
        if ( AnaFrame.mod == EnumMod.cizim )   {
            if ( AnaFrame.cihazlar == EnumCihaz.kablo )  {
                paintNokta(g);
            }
            else    {
                g2d.setColor(Color.blue);
                paintGecici(g);
            }
        }
        
    }
    
    private boolean paintGecici(Graphics g)  {   //Basarili ise true,yoksa false döndurur.
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.blue);
        try {
            if ( AnaFrame.mod == EnumMod.cizim )
                if ( ckt != null )  {
                    Cihaz temp = ckt.getGecici();
                    
                    if ( temp != null ) {
                        temp.draw(g);
                    }
                    else if ( ckt.getGeciciKaynak() != null ) 
                        ckt.getGeciciKaynak().draw(g);
                }
            return true;
        }catch (Exception e)    {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); 
    }

}
