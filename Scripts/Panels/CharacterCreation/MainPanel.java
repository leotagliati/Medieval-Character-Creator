package Scripts.Panels.CharacterCreation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Scripts.ImageCreate;

public class MainPanel extends JPanel
{
    public JButton charNameButton, charVestureButton, charClassButton, charAppearenceButton, returnButton;
    private ArrayList<JLabel> buttonsImage = new ArrayList<JLabel>();
    private ArrayList<JButton> mainButtons = new ArrayList<JButton>();
    private JPanel backgJPanel;

    public MainPanel()
    {
        super();
        // Inicializa os Botoes
        this.charNameButton = new JButton("Nome");
        this.charClassButton = new JButton("Classe");
        this.charVestureButton = new JButton("Vestimenta");
        this.charAppearenceButton = new JButton("Aparência");
        this.returnButton = new JButton("Voltar");

        // Add os botoes no arrayList
        this.mainButtons.add(charNameButton);
        this.mainButtons.add(charVestureButton);
        this.mainButtons.add(charClassButton);
        this.mainButtons.add(charAppearenceButton);
        this.mainButtons.add(returnButton);

        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.setColumns(1);
        buttonsLayout.setRows(this.mainButtons.size());
        buttonsLayout.setVgap(40);

        for (int i = 0; i < this.mainButtons.size(); i++) {
            ImageCreate backgroundImage = new ImageCreate(0, 0, 300, 100);
            backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
            backgroundImage.setIconFile("Images\\button.png");
            backgroundImage.imageSetter();
            buttonsImage.add(backgroundImage);
        }

        // Set design dos botoes
        for (JButton jButton : this.mainButtons) {
            jButton.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 28));
            jButton.setForeground(Color.WHITE);
            jButton.setOpaque(true);
            jButton.setContentAreaFilled(false);
            jButton.setBorderPainted(false);
            jButton.setFocusable(false);
        }

        this.backgJPanel = new JPanel();
        this.backgJPanel.setLayout(buttonsLayout);
        this.backgJPanel.setBounds(50, 150, 300, 500);
        this.backgJPanel.setOpaque(false);
        this.backgJPanel.setBackground(Color.GREEN);

        this.setLayout(buttonsLayout);
        this.setBounds(75, 150, 250, 500);
        this.setOpaque(false);
        this.setBackground(Color.RED);

        for (JButton jButton : this.mainButtons) {
            this.add(jButton);
        }
        for (JLabel jLabel : buttonsImage) {
            backgJPanel.add(jLabel);
        }
    }

    public ArrayList<JButton> getMainButtons() {
        return mainButtons;
    }

    public JPanel getBackgJPanel() {
        return backgJPanel;
    }

    public ArrayList<JLabel> getButtonsImage() {
        return buttonsImage;
    }
}
