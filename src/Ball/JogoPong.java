package Ball;

import Objetos.Barra;
import Objetos.Bola;
import Sons.Som;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class JogoPong extends Applet implements Runnable {

    private Bola bola;
    private Barra barra;

    @Override
    public void run() {
        Som executarSom = new Som();
        Bola bola = this.getBola();
        Barra barra = this.getBarra();

        StdDraw.setPenRadius(0.03); //Tamanho Bola - Radio
        int parar = 1; //Para o jogo        
        int cont = 0, pontos = 0, vidas = 2, level = 1;

        //Loop
        while (parar != 0) {

            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && barra.getPosHorBarra() >= -1.51) {
                barra.setPosHorBarra(barra.getPosHorBarra() - 0.02);

            } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && barra.getPosHorBarra() <= 0) {
                barra.setPosHorBarra(barra.getPosHorBarra() + 0.02);
            }

            // saltar fora da parede de acordo com a lei de colisão elástica
            if (Math.abs(bola.getX() + bola.getVelocidadeXdaBola()) > 1.0 - bola.getTamanhoBola()) {
                bola.setVelocidadeXdaBola(bola.getVelocidadeXdaBola() * -1);
            }
            if (Math.abs(bola.getY() + bola.getVelocidadeYdaBola()) > 1.0 - bola.getTamanhoBola()) {
                bola.setVelocidadeYdaBola(bola.getVelocidadeYdaBola() * -1);
            }

            /*
             Cruza a posição da barra com a bola, para assim ser possível a bola cair somente em cima da barra, caso cair fora da erro
             até dar o GAME OVER
             */
            if (((bola.getY() - bola.getTamanhoBola()) <= -0.947) && bola.getX() < (barra.getPosHorBarra() + 0.999999)//DIREITA
                    && (bola.getX() > (barra.getPosHorBarra() + 0.51))) { //ESQUERDA
                System.err.println("Acertou a Barra");
                pontos += 15;

                bola.setVelocidadeYdaBola(bola.getVelocidadeYdaBola() * -1);
                cont += 1;
                System.out.println(cont);
                executarSom.setNome("pong");
                executarSom.play();

                /*
                 Caso a bolinha bater três vezes em cima da barra, sobe um nível e também aumenta um pouco as velocidades X e Y da bola
                 */
                if (cont == 3) {
                    cont = 0;
                    executarSom.setNome("level");
                    executarSom.play();
                    level += 1;
                    System.out.println("Level: " + level);
                    bola.setVelocidadeXdaBola(bola.getVelocidadeXdaBola() * 1.2);
                    bola.setVelocidadeYdaBola(bola.getVelocidadeYdaBola() * 1.1);
                }

                /*
                 Caso a bolinha passar a altura estabelecida, ou seja encontar no chão não em cima da barra retoro a mensagem 
                 de GAME OVER e para o jogo
                 */
            } else if ((bola.getY()) < -0.93944) {
                parar = 0;
                System.err.println("GAME OVER");
                JOptionPane.showMessageDialog(null, "GAME OVER " + "\r\n" + " Level: " + level + "\r\n" + "Pontos: " + pontos);

            }
            // Atualiza posição
            bola.setX(bola.getX() + bola.getVelocidadeXdaBola());
            bola.setY(bola.getY() + bola.getVelocidadeYdaBola());

            // clear the background
            StdDraw.clear(StdDraw.GRAY);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(bola.getX(), bola.getY(), bola.getTamanhoBola());
            StdDraw.setPenColor(StdDraw.DARK_GRAY);//Cor da barra

            StdDraw.line((0.95 + barra.getPosHorBarra()), (-0.97), (0.55 + barra.getPosHorBarra()), (-0.97));//Ajustes da barra
            //0.95 Horizontaltamanho da barra -0.87 - DireitaLocalVerticalBarra -- 0.55 TamanhoHorizontalbarra -0.97 EsquerdaLocalVerticalBarra

            // display and pause for 20 ms
            StdDraw.show(10);
        }
    }

    public void addBola(Bola bola) {
        this.bola = bola;
    }

    public void addBarra(Barra barra) {
        this.barra = barra;
    }

    private Bola getBola() {
        return this.bola;
    }

    private Barra getBarra() {
        return this.barra;
    }
}
