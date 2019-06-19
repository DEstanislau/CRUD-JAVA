package negocios;

import apresentacao.TelaCadastro;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import modelo.Veiculo;
import persistencia.VeiculoDAOMysql;

/**
 *
 * @author Estanislau
 */
public final class Listagem extends JFrame implements ActionListener {
    
    JTable tb;
    JToggleButton bt1, bt2, bt3, bt4;
    
    public Listagem() {
        super("Tabela de Consulta");
        setSize(600, 450);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        
        String[] columns = {"Id", "Nome", "Cor", "Ano", "Tipo", "Marca"};
        Object[][] data = {
            {"1", "Uno", "Preta", "2000", "Carro", "Fiat"},
            {"2", "BMW 3000", "Dourada", "2019", "Moto", "BMW"},
            {"3", "Gol", "Branco", "2018", "Carro", "Volkswagen"}
        };
        
        tb = new JTable(data, columns);
        tb.setPreferredScrollableViewportSize(new Dimension(560, 355));
        tb.setFillsViewportHeight(true);
        tb.enable(false);
        
        bt1 = new JToggleButton("Sair");
        bt2 = new JToggleButton("Novo Veículo");
        bt3 = new JToggleButton("Editar");
        bt3.setBackground(Color.YELLOW);
        bt4 = new JToggleButton("Excluir");
        bt4.setBackground(Color.RED);
        
        JScrollPane scroll = new JScrollPane(tb);
        
        c.add(scroll);
        c.add(bt1);
        c.add(bt2);
        c.add(bt3);
        c.add(bt4);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (bt1.isSelected()) {
            dispose();
        }
        
        if (bt2.isSelected()) {
            new TelaCadastro().setVisible(true);
            dispose();
        }
        
        if (bt3.isSelected()) {
            VeiculoDAOMysql vdao = new VeiculoDAOMysql();
            Veiculo v = new Veiculo("Uno", "Preta", "2000", "Carro", "Fiat");
            try {
             //   vdao.update(v);
            } catch (Exception ex) {
                Logger.getLogger(Listagem.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if (bt4.isSelected()) {
            VeiculoDAOMysql vdao = new VeiculoDAOMysql();
            Veiculo v = new Veiculo("Uno", "Preta", "2000", "Carro", "Fiat");
            try {
              //  vdao.delete(v);
            } catch (Exception ex) {
                Logger.getLogger(Listagem.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}
