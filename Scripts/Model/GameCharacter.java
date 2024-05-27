package Scripts.Model;

import Scripts.ImagesConversion.Enums.ChestTypes;
import Scripts.ImagesConversion.Enums.EyeColorTypes;
import Scripts.ImagesConversion.Enums.HelmetTypes;
import Scripts.ImagesConversion.Enums.LegsTypes;
import Scripts.ImagesConversion.Enums.PhysicTypes;
import Scripts.ImagesConversion.Enums.SkinColorTypes;

/**
 * Character
 */
public class GameCharacter {

    private int id;
    private String name;
    private String skillClass;
    private EyeColorTypes eyeColor;
    private SkinColorTypes skinColor;
    private PhysicTypes physicType;
    private HelmetTypes helmTypes;
    private ChestTypes chestTypes;
    private LegsTypes legsTypes;
    
    
    public GameCharacter(String name, String skillClass, EyeColorTypes eyeColor, SkinColorTypes skinColor, PhysicTypes physicType, HelmetTypes helmTypes,  ChestTypes chestTypes,LegsTypes legsTypes) {
        this.name = name;
        this.skillClass = skillClass;
        this.eyeColor = eyeColor;
        this.skinColor = skinColor;
        this.physicType = physicType;
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
    
    public PhysicTypes getPhysicType() {
        return physicType;
    }
    
    public void setPhysicType(PhysicTypes physicType) {
        this.physicType = physicType;
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