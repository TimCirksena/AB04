package de.hsos.prog3.ab4.pong.game;

import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

public class Ball {
    public Rechteck ball;
    public int bewegungInXProFrame =4;
    public int bewegungInYProFrame =1;

    public Ball(int x, int y, int hoehe, int breite){
        ball = new Rechteck(x,y,hoehe,breite);

    }

    public void bewegen(int anzahlenFarmes){
            ball.verschiebe(4,1);

    }
    public void umkehrenDerBewegungInX(){
        this.bewegungInXProFrame*=(-1);
    }
    public void umkehrenDerBewegungInY(){
        this.bewegungInYProFrame+=(-1);
    }
    void darstellen(Interaktionsbrett ib){
        ball.darstellenRahmen(ib);
        ball.darstellenFuellen(ib);
    }
}
