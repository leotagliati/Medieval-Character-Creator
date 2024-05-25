package Scripts.Model;

/**
 * Character
 */
public class GameCharacter {

    private int id;
    private String name;
    private String skillClass;
    private String eyeColor;
    private String skinColor;
    private String physicType;

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

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getPhysicType() {
        return physicType;
    }

    public void setPhysicType(String physicType) {
        this.physicType = physicType;
    }
}