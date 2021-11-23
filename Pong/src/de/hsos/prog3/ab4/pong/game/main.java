package de.hsos.prog3.ab4.pong.game;

import de.hsos.prog3.ab4.pong.util.EinUndAusgabe;
import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

public class main {
    public static void main(String[] args) {
        EinUndAusgabe Io = new EinUndAusgabe();
        Spielfeld s = new Spielfeld(10,20,800,700);
        Interaktionsbrett ib = new Interaktionsbrett();
        s.darstellen(ib);
        Spieler playerOne = new Spieler(s,10,10);
        while (true){
            playerOne.aufwaerts(Io, ib);
        }
    }
}
