package Scripts.AddAppearancePanel;

public class StringToPath{
    public String convertPng(String s){
        String result = "Images\\" + s + ".png";
        return result;
    }
    public String convertJpg(String s){
        String result = "Images\\" + s + ".jpg";
        return result;
    }
    
}
