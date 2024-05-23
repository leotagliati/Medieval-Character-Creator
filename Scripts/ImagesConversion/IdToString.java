package Scripts.ImagesConversion;

import Scripts.Panels.CharacterCreation.AppearancePanel;
import Scripts.Panels.CharacterCreation.ClassPanel;
import Scripts.Panels.CharacterCreation.GarmentsPanel;

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
                this.helmetID = "helm1";
                break;
            case "2":
                this.helmetID = "helm2";
                break;
            case "3":
                this.helmetID = "helm3";
                break;
            default:
                this.helmetID = "helm1";
                break;
        }
        switch (this.chestID) {
            case "1":
                this.chestID = "chest1";
                break;
            case "2":
                this.chestID = "chest2";
                break;
            case "3":
                this.chestID = "chest3";
                break;
            default:
                this.chestID = "chest1";
                break;
        }
        switch (this.legsID) {
            case "1":
                this.legsID = "legs1";
                break;
            case "2":
                this.legsID = "legs2";
                break;
            case "3":
                this.legsID = "legs3";
                break;

            default:
                this.legsID = "legs1";
                break;
        }
        switch (this.classID) {
            case "Cavaleiro":
                this.classID = "sword";
                break;
            case "Arauto":
                this.classID = "spear";
                break;
            case "Feiticeiro":
                this.classID = "staff";
                break;
            case "Clérigo":
                this.classID = "grimoire";
                break;
            default:
                this.classID = "sword";
                break;
        }
        switch (this.eyeID) {
            case "1":
                this.eyeID = "eyes1";
                break;
            case "2":
                this.eyeID = "eyes2";
                break;
            case "3":
                this.eyeID = "eyes3";
                break;
            default:
                this.eyeID = "eyes1";
                break;
        }
        switch (this.skinID) {
            case "1":
                this.skinID = "skin1";
                break;
            case "2":
                this.skinID = "skin2";
                break;
            case "3":
                this.skinID = "skin3";
                break;
            default:
                this.skinID = "skin1";
                break;
        }
        switch (this.physicID) {
            case "1":
                this.physicID = "weakChar";
                break;
            case "2":
                this.physicID = "strongChar";
                break;
            default:
                this.physicID = "weakChar";
                break;
        }
      
    }
}
