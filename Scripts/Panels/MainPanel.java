package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Scripts.ImagesConversion.ImageCreate;

public class MainPanel extends JPanel {
    public JButton charNameButton, charVestureButton, charClassButton, charAppearenceButton;
    private ArrayList<JLabel> buttonsDesignArray = new ArrayList<JLabel>();
    private ArrayList<JButton> buttonsArray = new ArrayList<JButton>();
    private JPanel backGNDPanel;

    public MainPanel() {
        super();
        // Inicializa os Botoes
        this.charNameButton = new JButton("Nome");
        this.charClassButton = new JButton("Classe");
        this.charVestureButton = new JButton("Vestimenta");
        this.charAppearenceButton = new JButton("Aparência");

        // Add os botoes no arrayList
        this.buttonsArray.add(charNameButton);
        this.buttonsArray.add(charVestureButton);
        this.buttonsArray.add(charClassButton);
        this.buttonsArray.add(charAppearenceButton);

        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.setColumns(1);
        buttonsLayout.setRows(this.buttonsArray.size());
        buttonsLayout.setVgap(40);

        for (int i = 0; i < this.buttonsArray.size(); i++) {
            ImageCreate backgroundImage = new ImageCreate(0, 0, 300, 100);
            backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
            backgroundImage.setIconFile("Images\\button.png");
            backgroundImage.imageSetter();
            buttonsDesignArray.add(backgroundImage);
        }

        // Set propriedade dos botoes
        for (JButton button : this.buttonsArray) {
            button.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 28));
            button.setForeground(Color.WHITE);
            button.setOpaque(true);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusable(false);
        }

        // Set painel das imagens de fundo
        this.backGNDPanel = new JPanel();
        this.backGNDPanel.setLayout(buttonsLayout);
        this.backGNDPanel.setBounds(50, 150, 300, 500);
        this.backGNDPanel.setOpaque(false);
        this.backGNDPanel.setBackground(Color.GREEN);

        // Set propriedades do objeto
        this.setLayout(buttonsLayout);
        this.setBounds(75, 150, 250, 500);
        this.setOpaque(false);
        this.setBackground(Color.RED);

        for (JButton button : this.buttonsArray) {
            this.add(button);
        }
        for (JLabel buttonImage : buttonsDesignArray) {
            backGNDPanel.add(buttonImage);
        }
    }

    public ArrayList<JButton> getButtonsArray() {
        return buttonsArray;
    }

    public JPanel getBackPanel() {
        return backGNDPanel;
    }

    public ArrayList<JLabel> getButtonsDesignArray() {
        return buttonsDesignArray;
    }
}
