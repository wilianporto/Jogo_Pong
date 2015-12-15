/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sons;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.swing.JFrame;

/**
 *
 * @author Wilian
 */
public class Som extends JFrame {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void play() {
        URL url = Som.class.getResource(nome + ".wav");
        AudioClip audio = Applet.newAudioClip(url);
        audio.play();
    }

}
