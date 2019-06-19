package persistencia;

import java.sql.*;
import java.util.*;
import modelo.Veiculo;

/**
 *
 * @author Estanislau
 */
public class VeiculoDAOMysql implements VeiculoDAO<Veiculo> {

    private DBConnection conn;

    public VeiculoDAOMysql() {
        this.conn = new DBConnection();
    }

    @Override
    public void insert(Veiculo veiculo) throws Exception {
        String sql = "INSERT INTO VEICULO ( nome, cor, ano, tipo, marca) VALUES (?,?,?,?,?)";

        try {
            if (conn.conectar()) {

                PreparedStatement stmt = this.conn.getConnection().prepareStatement(sql);

                stmt.setString(1, veiculo.getNome());
                stmt.setString(2, veiculo.getCor());
                stmt.setString(3, veiculo.getAno());
                stmt.setString(4, veiculo.getTipo());
                stmt.setString(5, veiculo.getMarca());

                stmt.execute();
                stmt.close();
                this.conn.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Veiculo veiculo) throws Exception {
        String sql = "UPDATE VEICULO SET nome = ?, cor = ?, ano = ?, tipo = ?, marca = ? WHERE id = ?";

        try {
            if (this.conn.conectar()) {

                PreparedStatement stmt = this.conn.getConnection().prepareStatement(sql);

                stmt.setString(1, veiculo.getNome());
                stmt.setString(2, veiculo.getCor());
                stmt.setString(3, veiculo.getAno());
                stmt.setString(4, veiculo.getTipo());
                stmt.setString(5, veiculo.getMarca());

                stmt.execute();
                stmt.close();
                this.conn.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Veiculo veiculo) throws Exception {
        String sql = "DELETE FROM veiculo WHERE id = ?";

        try {
            if (this.conn.conectar()) {

                PreparedStatement stmt = this.conn.getConnection().prepareStatement(sql);

                stmt.setInt(1, veiculo.getId());

                stmt.execute();
                stmt.close();
                this.conn.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Veiculo> consult() throws Exception {
        List<Veiculo> listVeiculos = new ArrayList<>();

        String sql = "SELECT * FROM veiculo ORDER BY id";

        try {
            if (this.conn.conectar()) {

                PreparedStatement stmt = this.conn.getConnection().prepareStatement(sql);

                ResultSet resultado = stmt.executeQuery();

                while (resultado.next()) {
                    Veiculo veiculo = new Veiculo();

                    veiculo.setId(resultado.getInt("id"));
                    veiculo.setNome(resultado.getString("nome"));
                    veiculo.setCor(resultado.getString("cor"));
                    veiculo.setAno(resultado.getString("ano"));
                    veiculo.setTipo(resultado.getString("tipo"));
                    veiculo.setMarca(resultado.getString("marca"));

                    listVeiculos.add(veiculo);
                }

                stmt.close();
                this.conn.getConnection().close();
                resultado.close();
            }
            return listVeiculos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
