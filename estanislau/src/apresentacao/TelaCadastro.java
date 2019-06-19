package apresentacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.Veiculo;
import persistencia.VeiculoDAOMysql;

/**
 *
 * @author Estanislau
 */
public class TelaCadastro extends JFrame implements ActionListener, ItemListener {

    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4;
    JToggleButton bt1, bt2;
    JPanel pn;
    JComboBox cb;
    String nome, cor, ano, tipo, marca;

    public TelaCadastro() {
        super("Tela de Cadastro");
        setSize(500, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container c = getContentPane();
        c.setBackground(Color.LIGHT_GRAY);

        String[] potencia = {"Carro", "Moto"};

        pn = new JPanel(null);

        l1 = new JLabel("Nome      -->");
        l1.setBounds(30, 80, 100, 20);
        l1.setFont(new Font("arial", 3, 13));
        l2 = new JLabel("Cor         -->");
        l2.setBounds(30, 120, 90, 20);
        l2.setFont(new Font("arial", 3, 13));
        l3 = new JLabel("Marca     -->");
        l3.setBounds(30, 160, 90, 20);
        l3.setFont(new Font("arial", 3, 13));
        l4 = new JLabel("Ano        -->");
        l4.setBounds(30, 200, 90, 20);
        l4.setFont(new Font("arial", 3, 13));
        l5 = new JLabel("Cadastrar Veiculo");
        l5.setBounds(170, 20, 180, 20);
        l5.setFont(new Font("arial", 3, 15));
        l5.setHorizontalAlignment(SwingConstants.CENTER);
        l6 = new JLabel("Trabalhamos somente com carro e moto.");
        l6.setBounds(140, 190, 250, 100);
        l6.setFont(new Font("arial", 3, 11));

        t1 = new JTextField(15);
        t1.setBounds(140, 80, 300, 20);
        t2 = new JTextField(15);
        t2.setBounds(140, 120, 300, 20);
        t3 = new JTextField(15);
        t3.setBounds(140, 160, 300, 20);
        t4 = new JTextField(15);
        t4.setBounds(140, 200, 40, 20);

        bt1 = new JToggleButton("Cancelar");
        bt1.setBounds(140, 260, 100, 40);
        bt2 = new JToggleButton("Cadastrar");
        bt2.setBounds(250, 260, 100, 40);

        cb = new JComboBox(potencia);
        cb.setBounds(30, 20, 60, 20);

        tipo = "carro";

        pn.add(l5);
        pn.add(l1);
        pn.add(l2);
        pn.add(l3);
        pn.add(l4);
        pn.add(t1);
        pn.add(t2);
        pn.add(t3);
        pn.add(t4);
        pn.add(cb);
        pn.add(bt1);
        pn.add(bt2);
        pn.add(l6);
        c.add(pn);

        t1.addActionListener(this);
        t2.addActionListener(this);
        t3.addActionListener(this);
        t4.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        cb.addItemListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (bt2.isSelected()) {

            nome = t1.getText();
            cor = t2.getText();
            ano = t3.getText();
            marca = t4.getText();

            Veiculo veiculo = new Veiculo(nome, cor, ano, tipo, marca);
            VeiculoDAOMysql vDAOMysql = new VeiculoDAOMysql();
            try {
                vDAOMysql.insert(veiculo);
                JOptionPane.showMessageDialog(null, "Veiculo Cadastrado com Sucesso");
                dispose();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }

        if (bt1.isSelected()) {

            dispose();
        }

    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (cb.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Carro Selecionado");
            tipo = "carro";

        } else if (cb.getSelectedIndex() == 1) {
            JOptionPane.showMessageDialog(null, "Moto Selecionado");
            tipo = "moto";
        }
    }
}
