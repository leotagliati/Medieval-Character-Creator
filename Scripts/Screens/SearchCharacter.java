package Scripts.Screens;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Scripts.ImagesConversion.ImageCreate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class SearchCharacter extends JPanel {
    ArrayList<JButton> buttonsArray = new ArrayList<>();
    ArrayList<JTextField> charNamesArray = new ArrayList<>();
    ArrayList<JTextField> charClassesArray = new ArrayList<>();
    ArrayList<JLabel> nameLabelArray = new ArrayList<>();

    JTextField nameText = new JTextField("Seu cenoura");
    JTextField nameText2 = new JTextField("Seu chamego");
    JTextField classText = new JTextField("hortalicas");
    JTextField classText2 = new JTextField("hortalicas");

    JPanel panel = new JPanel();
    JPanel backGNDpanel = new JPanel();

    JScrollPane charDataPanel;

    public SearchCharacter() {
        super();
        this.setLayout(null);
        this.setBackground(Color.GREEN);

        GridLayout buttonsLayout = new GridLayout(charNamesArray.size(),1,0,30);
        panel.setLayout(buttonsLayout);
        panel.setBackground(Color.BLUE);

        charNamesArray.add(nameText);
        charNamesArray.add(nameText2);

        charClassesArray.add(classText);
        charClassesArray.add(classText2);


        // Adiciona os nomes como JLabels ao painel
        for (int i = 0; i < charNamesArray.size(); i++) {
            JLabel nameLabel = new JLabel(charNamesArray.get(i).getText());
            nameLabel.setIcon(new ImageIcon("Images\\user.png"));
            nameLabel.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 25));
            nameLabel.setHorizontalAlignment(JTextField.CENTER);
            nameLabel.setOpaque(false);
            nameLabel.setForeground(Color.WHITE);
            panel.add(nameLabel);
        }

        for (JLabel nameLabel : nameLabelArray) {
            nameLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if(e.getComponent() != nameLabel)
                    {
                        nameLabel.setForeground(Color.WHITE);
                    }
                    else nameLabel.setForeground(Color.RED);
                }
            });
        }

        // Configura o JScrollPane e adiciona o painel dentro dele
        charDataPanel = new JScrollPane(panel);
        charDataPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        charDataPanel.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2));
        charDataPanel.setBounds(10, 10, 474, 600);
        charDataPanel.add(backGNDpanel);

        // Adiciona o JScrollPane ao JPanel principal
        this.add(charDataPanel);

        for (JTextField nameData : charNamesArray) {
            charDataPanel.add(nameData);
            for (JTextField classData : charClassesArray) {
                charDataPanel.add(classData);
            }
        }

        this.add(charDataPanel);
        JButton returnButton = new JButton("Voltar");
        this.add(returnButton);

        // Volta para o menu inicial

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.first(getParent());
            }
        });
    }
}
