package Scripts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import Scripts.Database.ConnFactory;
import Scripts.Model.GameCharacter;
import Scripts.Repository.CharacterRepository;

public class RunApp {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        CardManager app = new CardManager();
        AudioHandler.audioPlay("Music\\mainMenuOST.wav");

        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setUndecorated(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

        // character.setName("calvetti");
        // character.setSkillClass("programador");
        // character.setEyeColor("1");
        // character.setSkinColor("3");
        // character.setPhysicType("1");
        
        CharacterRepository repo = new CharacterRepository();
        GameCharacter character = repo.searchCharacter(61);
        System.out.println(character.getName());
        System.out.println(character.getSkillClass());
        System.out.println(character.getChestTypes());
        System.out.println(character.getEyeColor());
        // for (int i = 1; i < 43; i++) {
        //     GameCharacter character = new GameCharacter();
        //     character.setId(i);
        //     repo.deleteCharacter(character);
        // }
        // ArrayList<GameCharacter> values = repo.GetAllCharcters();
        // System.out.println(values);


    }
}
