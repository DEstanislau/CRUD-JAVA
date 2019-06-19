package apresentacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import negocios.Listagem;

/**
 *
 * @author Estanislau
 */
public class TelaP extends JFrame {

    JMenuBar mb;
    JMenu mn1, mn2;
    JMenuItem i1, i2;

    TelaP() {

        super("Painel Principal");
        setSize(500, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.LIGHT_GRAY);

        mb = new JMenuBar();
        mb.setBackground(Color.LIGHT_GRAY);
        mn1 = new JMenu("Cadastro");
        mn2 = new JMenu("Sobre");

        i1 = new JMenuItem("Cadastrar Veiculo");
        i2 = new JMenuItem("Consultar Veiculo");

        mn1.add(i1);
        mn1.add(i2);
        mb.add(mn1);
        mb.add(mn2);
        setJMenuBar(mb);

        mn2.addMenuListener(
                new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JOptionPane.showMessageDialog(null, " Criado por: Alunos do Monteiro ");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        }
        );

        i1.addActionListener((ActionEvent evt) -> {
            new TelaCadastro().setVisible(true);
        });

        i2.addActionListener((ActionEvent evt) -> {
            new Listagem().setVisible(true);
        });

        setVisible(true);

    }

}
