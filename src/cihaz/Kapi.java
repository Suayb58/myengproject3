package cihaz;

import simulasyon.Kordinat;
import simulasyon.EnumCihaz;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Kapi extends Cihaz
{

    private Kordinat[] girisLeg;
    private Kordinat cikisLeg;
    protected ArrayList<Cihaz> cikisRef;
    protected ArrayList<Kablo> cikisKablo;
    protected Cihaz[] girisRef;
    protected int iSayac;
    protected boolean[] giris;
    protected boolean cikis=false;
    
    public Kapi(int girisSayisi, EnumCihaz de, Kordinat yer) {
        super(girisSayisi, de, yer);
        this.giris = new boolean[5];
        iSayac = 0;
        for ( int i = 0; i < girisSayisi; i++ )  giris[i] = false;
        cikis = false;
        this.girisLeg = new Kordinat[5];
        cikisRef = new ArrayList();
        cikisKablo = new ArrayList();
        girisRef = new Cihaz[5];
        seciliMi = false;
        
        for(int count = 0; count < girisSayisi; count++) {
            girisRef[count] = null;
            giris[count] = false;
            Kablo w = new Kablo();
        }
    }
    
    
    @Override
    public final void setGirisSayisi(int inc)    {
        this.girisSayisi = inc;
    }
   
    @Override
    public final void setGiris()  {
        for(int count = 0;count < this.getGirisSayisi();count++)
        {
            this.giris[count] = this.girisRef[count].getCikis();
        }
        this.generateCikis();
        this.setCikisKabloDurum();
    }
    
    @Override
    public final void setGiris(int indis,boolean i)  {
        this.giris[indis] = i;
        this.generateCikis();
        this.setCikisKabloDurum();
    }
    
    @Override
    public final void setCikis(boolean b)   {
        this.cikis = b;
        this.generateCikis();
        this.setCikisKabloDurum();
    }
    
    public final void setCikisKabloDurum()  {
        int l = cikisKablo.size();
        for ( int i = 0; i < l; i++ )   {
            cikisKablo.get(i).setDurum(this.getCikis());
        }
    }
   
    @Override
    public final boolean getGiris(int indis) {
        return this.giris[indis];
    }
    
    @Override
    public final int getGirisX(int indis)    {
        return this.girisLeg[indis].x;
    }
    
    @Override
    public final int getGirisY(int indis)    {
        return this.girisLeg[indis].y;
    }
    
    @Override
    public final int getCikisX()    {
        return this.cikisLeg.x;
    }
    
    @Override
    public final int getCikisY()    {
        return this.cikisLeg.y;
    }
    
    @Override
    public final boolean getCikis() {
        return this.cikis;
    }
    
    
    @Override
    public final boolean setGirisRef(int indis, Cihaz d)  {
        if ( girisRef[indis] == null ) girisRef[indis] = d;
        else return false;
        return true;
    }
    
    @Override
    public final void setGirisLeg (Kordinat c, int i)    {
        girisLeg[i] = c;
    }
    
    @Override
    public final Kordinat getGirisLeg(int i) {
        return girisLeg[i];
    }

    @Override
    public final void setCikisLeg(Kordinat c) {
        this.cikisLeg = c;
    }
    
    @Override
    public final Kordinat getCikisLeg() {
        return cikisLeg;
    }

    @Override
    public boolean gecerliMi() {
        for ( int i = 0; i < girisSayisi; i++ )
            if ( girisRef[i] == null ) return false;
        return true;
    }

    @Override
    public final Cihaz getGirisRef(int index) {
        return girisRef[index];
    }

    @Override
    public final void addCikisRef(Cihaz dref) {
        cikisRef.add(dref);
    }

    @Override
    public void addCikisKablo(Kablo w) {
        cikisKablo.add(w);
    }

    
  
    
    @Override
    public final ArrayList getCikisRef() {
        return cikisRef;
    }

    
    
    
    
    
    
}
