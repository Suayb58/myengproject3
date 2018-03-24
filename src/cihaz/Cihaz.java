package cihaz;

import simulasyon.EnumCihaz;
import simulasyon.Kordinat;
import java.awt.*;
import java.util.ArrayList;

public class Cihaz 
{
    protected int girisSayisi;
    protected Kordinat yer;
    protected EnumCihaz tur;
    protected boolean seciliMi;
    
    public Cihaz(){}
    public Cihaz(int girisSayisi,EnumCihaz de,int yerX,int yerY)
    {
        this.girisSayisi = girisSayisi;
        this.yer = new Kordinat(yerX, yerY);
        this.tur = de;
    }
    public Cihaz(int inputCount,EnumCihaz de,Kordinat location) {
        this.girisSayisi = inputCount;
        this.yer = new Kordinat(location);
        this.tur = de;
    }
    public void setGirisSayisi(int i)    {
        this.girisSayisi = i;
    }
 
    public void setYer(Kordinat cd)    {
        yer = cd;
    }
    
    public final Kordinat getYer()    {
        return yer;
    }
    
    public final void setX(int i)    {
        this.yer.x = i;
    }
    
    public final void setY(int i)    {
        this.yer.y = i;
    }
    
    public final int getGirisSayisi()    {
        return girisSayisi;
    }
    
    public final int getX()    {
        return yer.x;
    }
    
    public final int getY()    {
        return yer.y;
    }
    
    public boolean isSelected()    {return seciliMi;}
    public void setSelected(boolean b)   {seciliMi = b;}
    
    public void draw(Graphics g){}
    
  
    public int isOnGirisLeg(Kordinat c){return isOnGirisLeg(c.x,c.y);}
    public boolean isOnCikisLeg(Kordinat c){return isOnCikisLeg(c.x,c.y);}
    
   
    public int isOnGirisLeg(int x,int y)   {
        int in = this.getGirisSayisi();
        for ( int i = 0; i < in; i++ )  {
            Kordinat c = this.getGirisLeg(i);
            if ( c.x == x && c.y == y ) return i;
        }
        return -1;
    }
    
    public boolean isOnCikisLeg(int x,int y){
        Kordinat c = this.getCikisLeg();
        return ( c.x == x && c.y == y );
    }
    
    public boolean cihazdaMi(int x,int y){return false;}
    
    public boolean setGirisRef(int index, Cihaz dref){return true;}
    public boolean delete() {return false;}
    public Cihaz getGirisRef(int index){return null;}
    public void addCikisRef(Cihaz dref){}
    public void addCikisKablo(Kablo w)  {}
    public ArrayList getCikisRef(){return null;}
    public int getGirisX(int index){return -1;}
    public int getGirisY(int index){return -1;}
    public int getCikisX(){return -1;}
    public int getCikisY(){return -1;}
    public void setFlag(){};
    public boolean getFlag(){return false;}
    public void setFlag(boolean b){}
    public final void setType(EnumCihaz de)  {
        this.tur = de;
    }    
    public final EnumCihaz getTur()    {
        return this.tur;
    }
    public void setGiris(int index,boolean i) {}
    public boolean getGiris(int index){return false;}
    public void generateCikis(){}
    public boolean getCikis(){return false;}
    public void setGiris(){}
    public boolean gecerliMi()    {return true;}
    public void setGirisLeg (Kordinat c, int i) {}
    public Kordinat getGirisLeg(int i) {return null;}
    public void setCikis(boolean b) {}
    public void setCikisLeg (Kordinat c) {}
    public Kordinat getCikisLeg() {return null;}
}
