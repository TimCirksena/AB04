package de.hsos.prog3.ab4.pong.game;

import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

public class PongSpiel {
    Spielfeld spielfeld;
    Spieler spielerLinks;
    Spieler spielerRechts;
    Interaktionsbrett ib;
    final int FPMS = 17;
    Ball ball;
    KollisionsDetektion detektor;

    public PongSpiel(){
        startAufstellung();
        ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        initialeAufstellung();

    }
    private void initialeAufstellung(){
        detektor = new KollisionsDetektion(spielerLinks,spielerRechts,spielfeld);
        ball = new Ball(130,400, 20,20);
    }

    void startAufstellung(){
        spielfeld = new Spielfeld(100,100,800,700);
        spielerLinks = new Spieler(spielfeld,110,400);
        spielerRechts = new Spieler(spielfeld,880,400);
    }
    void spielen() throws InterruptedException {
        while(true){
            ib.abwischen();
            spielfeld.darstellen(ib);
            spielerLinks.schlaeger.darstellenRahmen(ib);
            spielerRechts.schlaeger.darstellenRahmen(ib);
            ball.darstellen(ib);
            ball.bewegen(17);
            detektor.checkBeruehrungBallMitGrenzen(ball);
            detektor.checkBeruehrungBallMitSchlaeger(ball);
            ib.neueLinie(500,800,500,100);
            ib.neuerText(470,150,spielerLinks.getPunkt());
            ib.neuerText(525,150,spielerRechts.getPunkt());
            Thread.sleep(17);
        }
    }
    public void tasteGedrueckt(String s) throws InterruptedException {
        switch (s){
            case "a":
                spielerLinks.aufwaerts();
                break;
            case "y":
                spielerLinks.abwaerts();
                break;
            case "Oben":
                spielerRechts.aufwaerts();
                break;
            case "Unten":
                spielerRechts.abwaerts();
                break;
            case "s":
                spielen();
                break;
            case "e":
                return;
        }
    }
}
