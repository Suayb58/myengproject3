/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulasyon;

import java.awt.event.MouseEvent;

/**
 *
 * @author Suayb Simsek
 */
public class Kordinat {

    public int x, y;

    public Kordinat() {
        x = 0;
        y = 0;
    }

    public Kordinat(int x, int y) {
        this.x = x - x % DevrePanel.mesafe;
        this.y = y - y % DevrePanel.mesafe;
    }

    public Kordinat(MouseEvent evt) {
        if ( evt == null )  {
            x = 0;
            y = 0;
        }
        else    {
            x = evt.getX() - evt.getX() % DevrePanel.mesafe;
            y = evt.getY() - evt.getY() % DevrePanel.mesafe;
        }
    }
    
    public Kordinat(Kordinat coord) {
        if ( coord == null )    {
            x = 0;
            y = 0;
        }
        else    {
            x = coord.x;
            y = coord.y;
        }
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
    
    
}