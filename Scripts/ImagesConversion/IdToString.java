package Scripts.ImagesConversion;

import Scripts.Panels.AppearancePanel;
import Scripts.Panels.ClassPanel;
import Scripts.Panels.GarmentsPanel;

public class IdToString {

    private String helmetID;
    private String chestID;
    private String legsID;
    private String classID;
    private String eyeID;
    private String skinID;
    private String physicID;

    public IdToString(String helmetID, String chestID, String legsID, String classID, String eyeID, String skinID) {
        this.helmetID = helmetID;
        this.chestID = chestID;
        this.legsID = legsID;
        this.classID = classID;
        this.eyeID = eyeID;
        this.skinID = skinID;
    }

    public void IdSetup(){
        this.helmetID = GarmentsPanel.getHelmetID();
        this.chestID = GarmentsPanel.getChestID();
        this.legsID = GarmentsPanel.getLegsID();
        this.classID = ClassPanel.getClassChosen();
        this.eyeID = AppearancePanel.getEyeID();
        this.skinID = AppearancePanel.getSkinID();
        this.physicID = AppearancePanel.getPhysicID();

    }

    public void StringSetup(){
        switch (this.helmetID) {
            case "1":
                this.helmetID = "Capacete";
                break;
            case "2":
                this.helmetID = "Coroa";
                break;
            case "3":
                this.helmetID = "Elmo";
                break;
            default:
                this.helmetID = "Capacete";
                break;
        }
        switch (this.chestID) {
            case "1":
                this.chestID = "Armadura";
                break;
            case "2":
                this.chestID = "Blusa";
                break;
            case "3":
                this.chestID = "Camisa";
                break;
            default:
                this.chestID = "Armadura";
                break;
        }
        switch (this.legsID) {
            case "1":
                this.legsID = "Calça";
                break;
            case "2":
                this.legsID = "Calção";
                break;
            case "3":
                this.legsID = "Saia";
                break;

            default:
                this.legsID = "Calça";
                break;
        }
        switch (this.classID) {
            case "1":
                this.classID = "Cavaleiro";
                break;
            case "2":
                this.classID = "Arauto";
                break;
            case "3":
                this.classID = "Feiticeiro";
                break;
            case "4":
                this.classID = "Clérigo";
                break;
            default:
                this.classID = "Cavaleiro";
                break;
        }
        switch (this.eyeID) {
            case "1":
                this.eyeID = "Olho1";
                break;
            case "2":
                this.eyeID = "Olho2";
                break;
            case "3":
                this.eyeID = "Olho3";
                break;
            default:
                this.eyeID = "Olho1";
                break;
        }
        switch (this.skinID) {
            case "1":
                this.skinID = "Pele1";
                break;
            case "2":
                this.skinID = "Pele2";
                break;
            case "3":
                this.skinID = "Pele3";
                break;
            default:
                this.skinID = "Pele1";
                break;
        }
        switch (this.physicID) {
            case "1":
                this.physicID = "Fisico1";
                break;
            case "2":
                this.physicID = "Fisico2";
                break;
            case "3":
                this.physicID = "Fisico3";
                break;
            default:
                this.physicID = "Fisico1";
                break;
        }
      
    }
}
