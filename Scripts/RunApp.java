package Scripts;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class RunApp {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        CardManager app = new CardManager();
        AudioHandler.audioPlay("Music\\mainMenuOST.wav");

        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setUndecorated(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

    }
}
