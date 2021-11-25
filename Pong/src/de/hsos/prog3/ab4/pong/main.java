package de.hsos.prog3.ab4.pong;

import de.hsos.prog3.ab4.pong.game.PongSpiel;
import de.hsos.prog3.ab4.pong.util.EinUndAusgabe;
import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

public class main {
    public static void main(String[] args) throws InterruptedException {
        PongSpiel lol = new PongSpiel();

        lol.spielen();
    }
}
