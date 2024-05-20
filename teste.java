import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class teste {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner scanner = new Scanner(System.in);
        MainFrame c1 = new MainFrame();
        File file  = new File("Music\\mainMenuOST.wav");
        AudioInputStream backGroundMusic = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(backGroundMusic);
        clip.start();
    }
}
