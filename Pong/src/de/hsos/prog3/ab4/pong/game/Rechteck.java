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

    public int oben(){
        return y;
    }
    public int unten(){
        return y + hoehe;
    }
    public int links(){
        return x;
    }
    public int rechts(){
        return x + breite;
    }
    public int breite(){
        return breite;
    }
    public int hoehe(){
        return hoehe;
    }
    public int mitteInY(){
        return (y + breite)/2;
    }
    public int mitteInX(){
        return (x + hoehe)/2;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x += x;
    }

    void verschiebe(int dx, int dy){
        y += dy;
        x += dx;
    }
    void verschiebeNach(int x, int y){
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
        for (int i = x; i < hoehe; i++) {
            for (int j = y; j < breite; j++) {
                ib.neuerPunkt(i, j);
            }
        }
    }

}