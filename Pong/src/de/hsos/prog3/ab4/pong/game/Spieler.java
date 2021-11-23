package de.hsos.prog3.ab4.pong.game;

import de.hsos.prog3.ab4.pong.util.EinUndAusgabe;
import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

public class Spieler {
    Spielfeld spielfeld;
    Rechteck schlaeger;
    int punkt;


    public Spieler(Spielfeld real, int x, int y){
        spielfeld = real;
        schlaeger = new Rechteck(x,y,(spielfeld.widht/100),(spielfeld.height)/10);
    }
    void aufwaerts(EinUndAusgabe IO, Interaktionsbrett ib){
        try{
            Thread.sleep(100);
        }catch(Exception e){
            System.out.println("Pipi");
        }
        if("a" == IO.leseString()){
            schlaeger.verschiebe(2,2);
            schlaeger.darstellenRahmen(ib);
            schlaeger.darstellenFuellen(ib);
        }else if("b" == IO.leseString()){
            schlaeger.verschiebe(-2,-2);
            schlaeger.darstellenRahmen(ib);
            schlaeger.darstellenFuellen(ib);
        }

    }
}
