package Scripts;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioHandler {

    public static void audioPlay(String file){
        try {
            String filePath = file;
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filePath));
        
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
}
