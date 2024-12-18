package Scripts;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioHandler {
    public static Audio loginMenuTheme = new Audio("LoginOST",
            "Music\\MedievalOST.wav", true);
    public static Audio loginMenuAmbience = new Audio("LoginAmbience",
            "Music\\RainAmbience.wav", true);
    public static Audio charCreationTheme = new Audio("CharCreationOST",
            "Music\\charCreationOST.wav", true);
    public static Audio gothicMenuTheme = new Audio("GothicAmbience",
            "Music\\gothicOST.wav", true);

    public static Audio buttonEntered = new Audio("ButtonEntered", "Music\\buttonEntered.wav", false);
    public static Audio buttonClicked = new Audio("ButtonClicked", "Music\\buttonClicked.wav", false);
    public static Audio buttonConfirm = new Audio("ButtonConfirm", "Music\\buttonConfirm.wav", false);
    public static Audio buttonDelete = new Audio("ButtonDelete", "Music\\buttonDelete.wav", false);
    public static Audio negateOperation = new Audio("NegateOperation", "Music\\negateOperation.wav", false);
    public static Audio acceptOperation = new Audio("AcceptOperation", "Music\\acceptOperation.wav", false);
    public static Audio keyTyped = new Audio("KeyTyped", "Music\\keyTyped.wav", false);

    public static void audioPlay(Audio audioSource) {
        try {
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(audioSource.getFilePath()));
            Clip clip = AudioSystem.getClip();
            audioSource.setClip(clip);
            audioSource.getClip().open(aui);
            audioSource.getClip().setMicrosecondPosition(0);
            audioSource.getClip().start();
            // System.out.println("iniciando o audio " + audioSource.getName());
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o audio " + audioSource.getName());
            e.printStackTrace();
        }

    }

    public static void audioStop(Audio audioSource) {
        if(audioSource.getClip() == null)
        {
            return;
        }
        audioSource.getClip().stop();
    }

}
