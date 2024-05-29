package Scripts.Panels.CharacterCreation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Scripts.AudioHandler;
import Scripts.ImagesConversion.ImageCreate;

public class NamePanel extends JPanel {

    SavePanel singlePanel = SavePanel.getInstance();

    private JLabel titleText = new JLabel("Insira seu nome");
    private JLabel pressEnterText1 = new JLabel("Aperte a tecla");
    private JLabel pressEnterText2 = new JLabel("para confirmar");
    private JTextField nameInput = new JTextField("Entrada incompleta");

    public static String nameChosen = "Entrada incompleta";

    public NamePanel() {
        super();
        // Set propriedade do titleText
        this.titleText.setBounds(40, 30, 270, 50);
        this.titleText.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 40));
        this.titleText.setHorizontalAlignment(JTextField.CENTER);
        this.titleText.setOpaque(false);
        this.titleText.setBorder(null);
        this.titleText.setForeground(Color.WHITE);
        this.titleText.setVisible(true);

        this.pressEnterText1.setBounds(50, 140, 400, 400);
        this.pressEnterText1.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 30));
        this.pressEnterText1.setHorizontalAlignment(JLabel.LEFT);
        this.pressEnterText1.setOpaque(false);
        this.pressEnterText1.setBorder(null);
        this.pressEnterText1.setForeground(Color.WHITE);
        this.pressEnterText1.setVisible(true);

        ImageCreate enterIconImage = new ImageCreate(80, 120, 400, 400);
        enterIconImage.setIconFile("Images\\enterButton.png");
        enterIconImage.imageSetter();

        this.pressEnterText2.setBounds(50, 330, 400, 200);
        this.pressEnterText2.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 30));
        this.pressEnterText2.setHorizontalAlignment(JLabel.LEFT);
        this.pressEnterText2.setOpaque(false);
        this.pressEnterText2.setBorder(null);
        this.pressEnterText2.setForeground(Color.WHITE);
        this.pressEnterText2.setVisible(true);

        // Set propriedade do nameInput
        this.nameInput.setBounds(50, 100, 250, 70);
        this.nameInput.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 25));
        this.nameInput.setHorizontalAlignment(JTextField.CENTER);
        this.nameInput.setOpaque(false);
        this.nameInput.setBorder(null);
        this.nameInput.setForeground(Color.RED);
        this.nameInput.setEditable(false);
        this.nameInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameInput.setEditable(true);
                if (nameInput.getText().equals("Entrada incompleta")) {
                    nameInput.setText("");
                }
                nameInput.setForeground(Color.WHITE);
            }
        });
        this.nameInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                    for (JButton button : MainPanel.getButtonsArray()) {
                        button.setEnabled(true);
                    }
                    if (nameInput.getText().equals("")) {
                        nameInput.setText("Entrada incompleta");
                        nameInput.setForeground(Color.RED);
                    }

                    nameInput.setEditable(false);
                    nameChosen = nameInput.getText();
                    setVisible(false);
                    
                    singlePanel.setVisible(true);
                    singlePanel.getCharInstance().setName(nameChosen);
                    if (!nameChosen.equals("Entrada incompleta")) {
                        singlePanel.nameInput.setForeground(Color.WHITE);
                    } else
                        singlePanel.nameInput.setForeground(Color.RED);
                    singlePanel.updatePanel(singlePanel.getCharInstance());
                }
                else
                {
                    AudioHandler.audioPlay("Music\\keyTyped.wav");
                }
            }

        });
        this.nameInput.setVisible(true);

        ImageCreate backgroundImage = new ImageCreate(0, 80, 350, 100);
        backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        backgroundImage.setIconFile("Images\\namePanelUnder.png");
        backgroundImage.imageSetter();

        // Set propriedades do objeto
        this.setBounds(500, 150, 350, 500);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.add(this.pressEnterText1);
        this.add(enterIconImage);
        this.add(this.pressEnterText2);
        this.add(this.titleText);
        this.add(this.nameInput);
        this.add(backgroundImage);
        this.setOpaque(false);
        this.setVisible(false);
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public void setNameInput(JTextField nameTextField) {
        this.nameInput = nameTextField;
    }

    public static String getNameChosen() {
        return nameChosen;
    }

}
