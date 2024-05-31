package Scripts.ImagesConversion;

public class StringToPath{
    public static String convertPng(String s){
        String result = "Images\\" + s + "Image.png";
        return result;
    }
    public static String convertJpg(String s){
        String result = "Images\\" + s + "Image.jpg";
        return result;
    }
    public static String convertIcon(String s){
        String result = "Images\\Icons\\"+s+"Icon.png";
        return result;
    }
    
}
