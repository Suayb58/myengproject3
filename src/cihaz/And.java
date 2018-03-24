package cihaz;

import simulasyon.EnumCihaz;
import simulasyon.EnumMod;
import simulasyon.Kordinat;
import simulasyon.AnaFrame;
import java.awt.*;

public class And extends Kapi
{
    private boolean flag;
    
    public And(int girisSayisi)
    {
        super(girisSayisi, EnumCihaz.and,new Kordinat(0,0));
    }
    
    public And(int girisSayisi,Kordinat yer){
        super(girisSayisi,EnumCihaz.and, new Kordinat(yer.x-20,yer.y-30));
    }
    
    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2d=(Graphics2D) g;
        int x = this.getX(), y = this.getY();
        Color c = g2d.getColor();
        if ( this.seciliMi )    g2d.setColor(Color.BLUE);
        g2d.drawArc(x,y+5,50,50,0,-90);
        g2d.drawArc(x,y+5,50,50,0,90);
        g2d.drawLine(x,y+5,x+25,y+5);
        g2d.drawLine(x,y+55,x+25,y+55);
        g2d.drawLine(x,y+5,x,y+55);
        
        if ( this.getCikis()  && AnaFrame.mod == EnumMod.Calistir ) g2d.setColor(Color.red);
        g2d.fillOval(x+48,y+28,4,4);
        this.setCikisLeg(new Kordinat(x+50,y+30));
        g2d.setColor(c);
        
        int i = this.getGirisSayisi();
        
        if(i == 2)
        {
            if ( this.getGiris(0) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x-2, y+18, 4, 4);
            this.setGirisLeg(new Kordinat(x,y+20), 0);
            
            if ( this.getGiris(1) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x-2, y+38, 4, 4);
            this.setGirisLeg(new Kordinat(x,y+40), 1);
        }
        
        else if(i == 3)
        {
            if ( this.getGiris(0) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x-2, y+18, 4, 4);
            this.setGirisLeg(new Kordinat(x,y+20), 0);
            
            if ( this.getGiris(1) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x-2, y+28, 4, 4);
            this.setGirisLeg(new Kordinat(x,y+30), 1);
            
            if ( this.getGiris(2) && AnaFrame.mod == EnumMod.Calistir)  g2d.setColor(Color.red);
            else    g2d.setColor(c);
            g2d.fillOval(x-2, y+38, 4, 4);
            this.setGirisLeg(new Kordinat(x,y+40), 2);
        }
        
       
    }

    @Override
    public void setYer(Kordinat cd) {
        super.setYer(new Kordinat(cd.x-20,cd.y-30)); 
    }
    
    
    @Override
    public int isOnGirisLeg(int x, int y)  { 
        return super.isOnGirisLeg(x, y);
    }
    
    @Override
    public boolean isOnCikisLeg(int x,int y)  {
        return super.isOnCikisLeg(x, y);
    }
    
    @Override
    public boolean cihazdaMi(int x,int y)  {
        int lx = this.getX(), ly = this.getY();
        return (lx <= x && x <= lx+50 && ly+5 <= y && y <= ly+55);
    }
    

   

    @Override
    public void generateCikis()    {
        int count = 0;
        for(count=0; count < this.girisSayisi; count++)
        {
            if(!this.giris[count])
            {
                this.cikis = false;
                break;
            }
        }
        if(count == this.girisSayisi)
            this.cikis = true;
        
        int l = cikisRef.size();
        for ( int i = 0; i < l; i++ )   {
            cikisRef.get(i).setGiris();
        }
    }

    @Override
    public void setFlag(boolean b)  {
    	this.flag = b;
    }
  
    @Override
    public boolean getFlag()
    {
    	return this.flag;
    }    
}
