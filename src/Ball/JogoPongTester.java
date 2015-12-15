package Ball;

import Objetos.Barra;
import Objetos.Bola;
import Objetos.Forma;

public class JogoPongTester {
    
    //Classe principal

    public static void main(String[] args) {

        //definir a dimensão do sistema de coordenadas
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);

        Bola bola = new Bola();
        Barra barra = new Barra();
        Forma forma = new Forma() {};
        

        bola.setX(0.480);//Posição inicial eixo X da bola
        bola.setY(0.860);//Posição inicial eixo Y da bola

        bola.setVelocidadeXdaBola(0.008); //Velocidade no eixo X da bola
        bola.setVelocidadeYdaBola(0.010); //Velocidade no eixo Y da bola
        bola.setTamanhoBola(0.05);//Raio da Bola

        barra.setPosHorBarra(-0.8);//Posição no eixo X da barra

        JogoPong jp = new JogoPong();
        jp.addBola(bola);
        jp.addBarra(barra);

        //Iniciar o Jogo, tem a variavel JP que joga nessa Thread todas as informacoes da barra e da bola
        Thread t1 = new Thread(jp);
        t1.start();

    }

}
