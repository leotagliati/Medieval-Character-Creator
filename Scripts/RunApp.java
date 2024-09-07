package Scripts;
import Scripts.LoginManagement.Screens.TelaLanguage;

public class RunApp {
    public static void main(String[] args) {
        TelaLanguage telaLanguage = new TelaLanguage();
        telaLanguage.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        AudioHandler.audioPlay("D:\\Git Repositories\\Projeto-Semestral-LP1\\Music\\RainAmbience.wav");
        AudioHandler.audioPlay("D:\\Git Repositories\\Projeto-Semestral-LP1\\Music\\MedievalOST.wav");
    }
}
