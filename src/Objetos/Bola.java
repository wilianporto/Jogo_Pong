/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Wilian
 */
public class Bola extends Forma {

    private double x;
    private double y;

    private double larg;

    public double getTamanhoBola() {
        return tamanhoBola;
    }

    public void setTamanhoBola(double tamanhoBola) {
        this.tamanhoBola = tamanhoBola;
    }
    private double alt;

    private double velocidadeYdaBola;
    private double tamanhoBola;

    public double getVelocidadeYdaBola() {
        return velocidadeYdaBola;
    }

    public void setVelocidadeYdaBola(double velocidadeYdaBola) {
        this.velocidadeYdaBola = velocidadeYdaBola;
    }

    public double getVelocidadeXdaBola() {
        return velocidadeXdaBola;
    }

    public void setVelocidadeXdaBola(double velocidadeXdaBola) {
        this.velocidadeXdaBola = velocidadeXdaBola;
    }
    private double velocidadeXdaBola;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getLarg() {
        return larg;
    }

    public void setLarg(double larg) {
        this.larg = larg;
    }

    public double getAlt() {
        return alt;
    }

    public void setAlt(double alt) {
        this.alt = alt;
    }

}
