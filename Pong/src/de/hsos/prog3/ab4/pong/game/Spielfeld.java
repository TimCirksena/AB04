package de.hsos.prog3.ab4.pong.game;

import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

public class  Spielfeld {
    final int widht = 800;
    final int height = 700;
    Rechteck spielflaeche;


    public Spielfeld(int x, int y){
        spielflaeche = new Rechteck(x, y, widht, height);
    }

    public void darstellen(Interaktionsbrett ib){
        spielflaeche.darstellenRahmen(ib);
    }

}
