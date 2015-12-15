package Objetos;

import java.awt.Color;

public abstract class Forma {

    private double eixoX;

    public double getEixoX() {
        return eixoX;
    }

    public void setEixoX(double eixoX) {
        this.eixoX = eixoX;
    }

    public double getEixoY() {
        return eixoY;
    }

    public void setEixoY(double eixoY) {
        this.eixoY = eixoY;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    private double eixoY;

    private Color cor;

}
