package Scripts.Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCharacter extends JPanel
{
    public DeleteCharacter()
    {
        super();
        this.setLayout(new FlowLayout());
        setBackground(Color.BLUE);

        JLabel title = new JLabel("Deletar Personagem");
        this.add(title);

        JButton returnButton = new JButton("Voltar");
        this.add(returnButton);

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
