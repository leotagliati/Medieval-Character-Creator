package Scripts.ImagesConversion;

import javax.swing.JPanel;

import Scripts.Panels.CharacterCreation.ClassPanel;
import Scripts.Panels.CharacterCreation.GarmentsPanel;

public class CharacterDisplay {
    ShowPanel showPanel = new ShowPanel();

    public static void setupImages(JPanel panel) {

        ImageCreate backgroundImage = new ImageCreate(0, 0, 500, 700);
        backgroundImage.setIconFile("Images\\hud1.png");
        backgroundImage.imageSetter();
        panel.add(backgroundImage);

        // Adicionando charImage em segundo
        ImageCreate charImage = new ImageCreate(0, 0, 500, 750);
        charImage.setIconFile("Images\\charImage.png");
        charImage.imageSetter();
        panel.add(charImage);

        // Adicionando as outras imagens depois
        String helmChosen = GarmentsPanel.helmetType.toString();
        helmChosen = StringToPath.convertPng(helmChosen);

        ImageCreate helmImage = new ImageCreate(0, 0, 500, 750);
        helmImage.setIconFile(helmChosen);
        helmImage.imageSetter();
        panel.add(helmImage);

        String classChosen = ClassPanel.getClassChosen();
        classChosen = StringToPath.convertPng(classChosen);

        ImageCreate weaponImage = new ImageCreate(0, 0, 500, 775);
        weaponImage.setIconFile(classChosen);
        weaponImage.imageSetter();
        panel.add(weaponImage);

        String chestChosen = GarmentsPanel.chestType.toString();
        chestChosen = StringToPath.convertPng(chestChosen);
        ImageCreate torsoImage = new ImageCreate(0, 0, 500, 750);
        torsoImage.setIconFile(chestChosen);
        torsoImage.imageSetter();
        panel.add(torsoImage);

        String legsChosen = GarmentsPanel.legsType.toString();
        legsChosen = StringToPath.convertPng(legsChosen);
        ImageCreate legsImage = new ImageCreate(0, 0, 500, 750);
        legsImage.setIconFile(legsChosen);
        legsImage.imageSetter();
        panel.add(legsImage);

        // Ajustar a ordem dos componentes
        panel.setComponentZOrder(backgroundImage, panel.getComponentCount() - 1);
        panel.setComponentZOrder(charImage, panel.getComponentCount() - 2);
        panel.setComponentZOrder(helmImage, panel.getComponentCount() - 4);
        panel.setComponentZOrder(weaponImage, panel.getComponentCount() - 6);
        panel.setComponentZOrder(torsoImage, panel.getComponentCount() - 3);
        panel.setComponentZOrder(legsImage, panel.getComponentCount() - 5);
    }

    public static void updateImages(JPanel panel) {
        // System.out.println("TROCANDO ROUPAS");

        // clear panel
        panel.removeAll();
        ImageCreate backgroundImage = new ImageCreate(0, 0, 500, 700);
        backgroundImage.setIconFile("Images\\hud1.png");
        backgroundImage.imageSetter();
        panel.add(backgroundImage);

        // Adicionando charImage em segundo
        ImageCreate charImage = new ImageCreate(0, 0, 500, 750);
        charImage.setIconFile("Images\\charImage.png");
        charImage.imageSetter();
        panel.add(charImage);

        // Adicionando as outras imagens depois
        String helmChosen = GarmentsPanel.helmetType.toString();
        helmChosen = StringToPath.convertPng(helmChosen);

        ImageCreate helmImage = new ImageCreate(0, 0, 500, 750);
        helmImage.setIconFile(helmChosen);
        System.out.println(helmChosen);
        helmImage.imageSetter();
        panel.add(helmImage);

        String classChosen = ClassPanel.getClassChosen();
        classChosen = StringToPath.convertPng(classChosen);

        ImageCreate weaponImage = new ImageCreate(0, 0, 500, 775);
        weaponImage.setIconFile(classChosen);
        weaponImage.imageSetter();
        panel.add(weaponImage);

        String chestChosen = GarmentsPanel.chestType.toString();
        chestChosen = StringToPath.convertPng(chestChosen);
        ImageCreate torsoImage = new ImageCreate(0, 0, 500, 750);
        torsoImage.setIconFile(chestChosen);
        torsoImage.imageSetter();
        panel.add(torsoImage);

        String legsChosen = GarmentsPanel.legsType.toString();
        legsChosen = StringToPath.convertPng(legsChosen);
        ImageCreate legsImage = new ImageCreate(0, 0, 500, 750);
        legsImage.setIconFile(legsChosen);
        legsImage.imageSetter();
        panel.add(legsImage);

        // Ajustar a ordem dos componentes
        panel.setComponentZOrder(backgroundImage, panel.getComponentCount() - 1);
        panel.setComponentZOrder(charImage, panel.getComponentCount() - 2);
        panel.setComponentZOrder(helmImage, panel.getComponentCount() - 4);
        panel.setComponentZOrder(weaponImage, panel.getComponentCount() - 6);
        panel.setComponentZOrder(torsoImage, panel.getComponentCount() - 3);
        panel.setComponentZOrder(legsImage, panel.getComponentCount() - 5);

        panel.revalidate();
        panel.repaint();
    }
}
