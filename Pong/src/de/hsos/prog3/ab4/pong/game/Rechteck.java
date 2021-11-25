package de.hsos.prog3.ab4.pong.game;


import de.hsos.prog3.ab4.pong.util.Interaktionsbrett;

import java.awt.*;

public class Rechteck {
    private int x;
    private int y;
    private int breite;
    private int hoehe;

    public Rechteck(int x, int y, int breite,int hoehe) {
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
    public void verschiebeNach(int x, int y){
        this.y = y;
        this.x = x;
    }
    public boolean ueberschneidet(Rechteck r)  {
        return x < r.x + r.breite && x + breite > r.x && y < r.y + r.hoehe && y + hoehe > r.y;
    }
    public void darstellenRahmen(Interaktionsbrett ib) {
        ib.neuesRechteck(x, y, breite, hoehe);
    }

    public void darstellenFuellen(Interaktionsbrett ib) {
        for (int i = x; i < hoehe; i++) {
            for (int j = y; j < breite; j++) {
                ib.neuerPunkt(i, j);
            }
        }
    }

    public int getX() {
        return x;
    }
}