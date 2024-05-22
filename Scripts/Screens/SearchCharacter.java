package Scripts.Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchCharacter extends JPanel
{
    public SearchCharacter()
    {
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(Color.GREEN);

        JLabel legenda = new JLabel("Buscar Personagem");
        this.add(legenda);

        JButton returnButton = new JButton("Voltar");
        this.add(returnButton);

        // Volta para o menu inicial

        returnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.first(getParent());
            }
        });
    }
}
