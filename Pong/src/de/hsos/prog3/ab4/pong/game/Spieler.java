package de.hsos.prog3.ab4.pong.game;

import de.hsos.prog3.ab4.pong.util.EinUndAusgabe;
import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

public class Spieler {
    Spielfeld spielfeld;
    Rechteck schlaeger;
    int punkt;


    public Spieler(Spielfeld real, int x, int y) {
        spielfeld = real;
        schlaeger = new Rechteck(x, y, (spielfeld.widht / 100), (spielfeld.height) / 10);

    }

    public void aufwaerts() {
        this.schlaeger.verschiebe(0,-20);
    }

    public void abwaerts() {
        this.schlaeger.verschiebe(0,20);
    }

    public String getPunkt() {
        return (""+punkt);
    }

    public void erhoehePunkte() {
        punkt++;
    }

    public void setzePunkteZurueck() {
        punkt = 0;
    }

}
