import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import Scripts.AudioHandler;

public class teste {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        MainFrame c1 = new MainFrame();
        AudioHandler.tocamusica("Music\\mainMenuOST.wav");
    }
}
