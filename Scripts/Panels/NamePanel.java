package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Scripts.AudioHandler;
import Scripts.ImageCreate;

public class NamePanel extends JPanel {

    private JTextField titleTextField;
    private JTextField nameTextField;
    public static String nameChosen = "Entrada incompleta";

    public NamePanel() {

        super();
        this.titleTextField = new JTextField("Insira seu nome");
        this.titleTextField.setBounds(40, 20, 270, 50);
        this.titleTextField.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 40));
        this.titleTextField.setHorizontalAlignment(JTextField.CENTER);
        this.titleTextField.setOpaque(false);
        this.titleTextField.setBorder(null);
        this.titleTextField.setForeground(Color.WHITE);
        this.titleTextField.setEditable(false);

        this.nameTextField = new JTextField("Entrada incompleta");
        this.nameTextField.setBounds(50, 100, 250, 70);
        this.nameTextField.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 25));
        this.nameTextField.setHorizontalAlignment(JTextField.CENTER);
        this.nameTextField.setOpaque(false);
        this.nameTextField.setBorder(null);
        this.nameTextField.setForeground(Color.RED);
        this.nameTextField.setEditable(false);
        this.nameTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameTextField.setEditable(true);
                if (nameTextField.getText().equals("Entrada incompleta")) {
                    nameTextField.setText("");
                }
                nameTextField.setForeground(Color.WHITE);
            }
        });
        this.nameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                    if (nameTextField.getText().equals("")) {
                        nameTextField.setText("Entrada incompleta");
                        nameTextField.setForeground(Color.RED);
                    }
                    nameTextField.setEditable(false);
                    nameChosen = nameTextField.getText();
                    setVisible(false);
                    ChosenAttPanel.getBackgPanel().setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(true);
                    ChosenAttPanel.updatePanel(NamePanel.getNameChosen(), ClassPanel.getClassChosen());
                }
            }

        });
        nameChosen.equals(nameTextField.getText());
        this.nameTextField.setVisible(true);
        this.titleTextField.setVisible(true);

        ImageCreate backgroundImage = new ImageCreate(0, 80, 350, 100);
        backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        backgroundImage.setIconFile("Images\\namePanelUnder.png");
        backgroundImage.imageSetter();

        this.setBounds(500, 150, 350, 500);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.add(this.nameTextField);
        this.add(this.titleTextField);
        this.add(backgroundImage);
        this.setOpaque(false);
        this.setVisible(false);
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public static String getNameChosen() {
        return nameChosen;
    }

}
