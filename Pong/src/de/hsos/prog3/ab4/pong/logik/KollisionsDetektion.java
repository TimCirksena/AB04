package de.hsos.prog3.ab4.pong.logik;

import de.hsos.prog3.ab4.pong.game.Ball;
import de.hsos.prog3.ab4.pong.game.Spieler;
import de.hsos.prog3.ab4.pong.game.Spielfeld;

public class KollisionsDetektion {
    Spielfeld spielfeld;
    Spieler spielerLinks;
    Spieler spielerRechts;

    public KollisionsDetektion(Spieler links, Spieler rechts, Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
        this.spielerLinks = links;
        this.spielerRechts = rechts;
    }

    public void checkBeruehrungBallMitGrenzen(Ball ball) {
        if (ball.ball.getY() > 790 || ball.ball.getY() < 100) {
            ball.umkehrenDerBewegungInY();
        }

    }
    public void checkBeruehrungBallMitTor(Ball ball){
        if(ball.ball.getX() > 900){
            spielerLinks.erhoehePunkte();
            ball.ball.verschiebeNach(400,350);
        }else if(ball.ball.getX() < 100){
            spielerRechts.erhoehePunkte();
            ball.ball.verschiebeNach(400,350);
        }

    }

    public void checkBeruehrungBallMitSchlaeger(Ball ball) {
        if (spielerLinks.schlaeger.ueberschneidet(ball.ball)) {
            if (Math.random() < 0.5) {
                ball.umkehrenDerBewegungInX();
            } else {
                ball.umkehrenDerBewegungInX();
                ball.umkehrenDerBewegungInY();
            }
        }
        if (spielerRechts.schlaeger.ueberschneidet(ball.ball)) {
            if (Math.random() < 0.5) {
                ball.umkehrenDerBewegungInX();
            } else {
                ball.umkehrenDerBewegungInX();
                ball.umkehrenDerBewegungInY();
            }
        }
    }
}
