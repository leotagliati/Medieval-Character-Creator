package Scripts.ImagesConversion;

import javax.swing.*;
import java.awt.*;

public class ImageCreate extends JLabel
{
    private int iconPosX;
    private int iconPosY;
    private int iconWidth;
    private int iconHeight;
    private int[] iconAlignment = new int[2];
    private String iconFileString = "";
    
    public ImageCreate(int posX, int posY, int width, int height)
    {
        this.iconPosX = posX;
        this.iconPosY = posY;
        this.iconHeight = height;
        this.iconWidth = width;
        
        this.setLayout(null);
        this.setBounds(this.iconPosX, this.iconPosY, this.iconWidth, this.iconHeight);
        this.setHorizontalAlignment(this.iconAlignment[0]);
        this.setVerticalAlignment(this.iconAlignment[1]);
        this.setIcon(new ImageIcon(this.iconFileString));
        this.setBackground(Color.RED);
        this.setOpaque(false);
        this.setVisible(true);
    }

    public void imageSetter() {
        this.setIcon(new ImageIcon(this.iconFileString));
    }

    public int[] getAlignment() {
        return iconAlignment;
    }

    public void setAlignment(int horizontal, int vertical)
    {
        this.iconAlignment[0] = horizontal;
        this.iconAlignment[1] = vertical;
    }

    public void setIconFile(String filePathString) {
        this.iconFileString = filePathString;
    }
}
