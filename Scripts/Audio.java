package Scripts;

import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import com.mysql.cj.Constants;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;

public class Audio {
    private Clip clip;
    
    private String name;
    private String filePath;
    
    public Audio(String name, String filePath, boolean loop) {
        this.name = name;
        this.filePath = filePath;
        try {
            this.clip = AudioSystem.getClip();
            if (loop) {
                this.clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao criar Clip " + name);
            e.printStackTrace();
        }
    }
    
    public Clip getClip() {
        return clip;
    }
    
    public String getName() {
        return name;
    }
    
    public String getFilePath() {
        return filePath;
    }
    public void setClip(Clip clip) {
        this.clip = clip;
    }
}
