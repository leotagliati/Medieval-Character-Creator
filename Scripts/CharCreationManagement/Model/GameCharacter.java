package Scripts.CharCreationManagement.Model;

import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.ChestTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.EyeColorTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.HelmetTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.LegsTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.SkinColorTypes;

/**
 * Character
 */
public class GameCharacter {

    private int id;
    private String name;
    private String skillClass;
    private EyeColorTypes eyeColor;
    private SkinColorTypes skinColor;
    private HelmetTypes helmTypes;
    private ChestTypes chestTypes;
    private LegsTypes legsTypes;
    
    
    public GameCharacter(String name, String skillClass, EyeColorTypes eyeColor, SkinColorTypes skinColor, HelmetTypes helmTypes,  ChestTypes chestTypes,LegsTypes legsTypes) {
        this.name = name;
        this.skillClass = skillClass;
        this.eyeColor = eyeColor;
        this.skinColor = skinColor;
        this.helmTypes = helmTypes;
        this.chestTypes = chestTypes;
        this.legsTypes = legsTypes;
    }
    
    public GameCharacter() {
        
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSkillClass() {
        return skillClass;
    }
    
    public void setSkillClass(String skillClass) {
        this.skillClass = skillClass;
    }
    
    public EyeColorTypes getEyeColor() {
        return eyeColor;
    }
    
    public void setEyeColor(EyeColorTypes eyeColor) {
        this.eyeColor = eyeColor;
    }
    
    public SkinColorTypes getSkinColor() {
        return skinColor;
    }
    
    public void setSkinColor(SkinColorTypes skinColor) {
        this.skinColor = skinColor;
    }
    
    public HelmetTypes getHelmTypes() {
        return helmTypes;
    }
    
    public void setHelmTypes(HelmetTypes helmTypes) {
        this.helmTypes = helmTypes;
    }
    public ChestTypes getChestTypes() {
        return chestTypes;
    }
    
    public void setChestTypes(ChestTypes chestTypes) {
        this.chestTypes = chestTypes;
    }
    public LegsTypes getLegsTypes() {
        return legsTypes;
    }
    
    public void setLegsTypes(LegsTypes legsTypes) {
        this.legsTypes = legsTypes;
    }
}