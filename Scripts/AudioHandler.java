package Scripts;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class AudioHandler {

    public static void tocamusica(String file){
        try {
            String filePath = file;
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filePath));
        
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
            } catch (Exception e) {
                // TODO: handle exception
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
