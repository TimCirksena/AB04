package de.hsos.prog3.ab4.pong.game;

import de.hsos.prog3.ab4.pong.logik.KollisionsDetektion;
import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

public class PongSpiel {
    Spielfeld spielfeld;
    Spieler spielerLinks;
    Spieler spielerRechts;
    Interaktionsbrett ib;
    final int FPMS = 17;
    Ball ball;
    boolean game = false;
    KollisionsDetektion detektor;

    public PongSpiel() {
        startAufstellung();
        ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        initialeAufstellung();

    }

    private void initialeAufstellung() {
        detektor = new KollisionsDetektion(spielerLinks, spielerRechts, spielfeld);
        ball = new Ball(250, 400, 20, 20);
    }

    void startAufstellung() {
        spielfeld = new Spielfeld(100, 100);
        spielerLinks = new Spieler(spielfeld, 110, 400);
        spielerRechts = new Spieler(spielfeld, 880, 400);
    }

    public void spielen() throws InterruptedException {
        while (true) {
            ib.abwischen();
            spielfeld.darstellen(ib);
            spielerLinks.schlaeger.darstellenRahmen(ib);
            spielerRechts.schlaeger.darstellenRahmen(ib);
            ball.darstellen(ib);
            ib.neueLinie(500, 800, 500, 100);
            ib.neuerText(470, 150, spielerLinks.getPunkt());
            ib.neuerText(525, 150, spielerRechts.getPunkt());
            Thread.sleep(17);
            if (game) {
                ball.bewegen(17);
                detektor.checkBeruehrungBallMitTor(ball);
                detektor.checkBeruehrungBallMitSchlaeger(ball);
                detektor.checkBeruehrungBallMitGrenzen(ball);


            }
        }
    }

    public void tasteGedrueckt(String s) throws InterruptedException {
        switch (s) {
            case "a":
                spielerLinks.aufwaerts();
                break;
            case "y":
                spielerLinks.abwaerts();
                break;
            case "o":
                spielerRechts.aufwaerts();
                break;
            case "l":
                spielerRechts.abwaerts();
                break;
            case "s":
                game = !game;
                break;
            case "e":
                System.exit(1);
        }
    }
}
