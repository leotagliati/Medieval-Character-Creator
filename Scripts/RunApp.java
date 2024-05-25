package Scripts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import Scripts.Database.ConnFactory;
import Scripts.Repository.CharacterRepository;

public class RunApp
{
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        CardManager app = new CardManager();
        AudioHandler.audioPlay("Music\\mainMenuOST.wav");

        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setUndecorated(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

        CharacterRepository repo = new CharacterRepository();
        ArrayList<Scripts.Model.Character> values = repo.GetAllCharcters();
        // System.out.println(values);
    }
}
