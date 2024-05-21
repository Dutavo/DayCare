package dcx.ufpb.projeto;

import javax.swing.*;
import java.awt.BorderLayout;

public class PressStartImage extends JOptionPane{
    public static int showMensage(){
        PressStartImage optionPane = new PressStartImage();
        JPanel painel = new JPanel(new BorderLayout());
        ImageIcon DaycareGif = new ImageIcon("./src/main/resources/4XPBnq9.gif");
        JLabel iconLabel = new JLabel(DaycareGif);
        painel.add(iconLabel, BorderLayout.CENTER);
        Object[] options = { "PRESS ENTER" };
        int mensagem = JOptionPane.showOptionDialog(null, painel, "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return mensagem;
    }
}
