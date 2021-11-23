package de.hsos.prog3.ab4.pong.game;


import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

import java.awt.*;

public class Rechteck {
    private Point bottomLeft;
    private Point topRight;
    private int x;
    private int y;
    private int breite;
    private int hoehe;

    public Rechteck(int x, int y, int hoehe, int breite) {
        this.breite = breite;
        this.hoehe = hoehe;
        this.x = x;
        this.y = y;
    }
    /* HELFERMETHODEN */

    private int oben(){
        return y;
    }
    private int unten(){
        return y + hoehe;
    }
    private int links(){
        return x;
    }
    private int rechts(){
        return x + breite;
    }
    private int breite(){
        return breite;
    }
    private int hoehe(){
        return hoehe;
    }
    private int mitteInY(){
        return (y + breite)/2;
    }
    private int mitteInX(){
        return (x + hoehe)/2;
    }

    void verschiebe(int dx, int dy){
        y += dy;
        x += dx;
    }
    private void verschiebeNach(int x, int y){
        this.y = y;
        this.x = x;
    }
    boolean uberschneidet(Rechteck other){
        if(this.topRight.getY() < other.bottomLeft.getY() || this.bottomLeft.getY() > other.topRight.getY()){
            return false;
        }
        if(this.topRight.getX() < other.bottomLeft.getX() || this.bottomLeft.getX() > other.topRight.getX()){
            return false;
        }
        return true;
    }

    public void darstellenRahmen(Interaktionsbrett ib) {
        ib.neuesRechteck(x, y, hoehe, breite);
    }

    public void darstellenFuellen(Interaktionsbrett ib) {
        for (int i = x; i < breite+x; i++) {
            for (int j = y; j < breite + y; j++) {
                ib.neuerPunkt(i, j);
            }
        }
    }

}