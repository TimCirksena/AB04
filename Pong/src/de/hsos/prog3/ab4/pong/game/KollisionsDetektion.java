package de.hsos.prog3.ab4.pong.game;

public class KollisionsDetektion {
    Spielfeld spielfeld;
    Spieler spielerLinks;
    Spieler spielerRechts;

    public KollisionsDetektion(Spieler links, Spieler rechts, Spielfeld spielfeld){
        this.spielfeld = spielfeld;
        this.spielerLinks = links;
        this.spielerRechts = rechts;
    }
    public void checkBeruehrungBallMitGrenzen(Ball ball){
        if(spielfeld.spielflaeche.uberschneidet(ball.ball)){
            ball.umkehrenDerBewegungInY();
        }

    }
    public  void checkBeruehrungBallMitSchlaeger(Ball ball){
        if(spielerLinks.schlaeger.uberschneidet(ball.ball)){
            if(Math.random() < 0.5){
                ball.umkehrenDerBewegungInX();
            }
            else{
                ball.umkehrenDerBewegungInY();
            }
        }
        if(spielerRechts.schlaeger.uberschneidet(ball.ball)){
            if(Math.random() < 0.5){
                ball.umkehrenDerBewegungInX();
            }
            else{
                ball.umkehrenDerBewegungInY();
            }
        }
    }
}
