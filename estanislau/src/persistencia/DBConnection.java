package persistencia;

import java.sql.*;

    public class DBConnection{
        
        private String SERVER;
        private String BANCO;
        private String USER;
        private String PASS;
        private Connection c;

    public DBConnection() {
        this.SERVER = "localhost:3306";
        this.BANCO = "shop";
        this.USER = "root";
        this.PASS = "";
    }
    
    public boolean conectar(){
        try{
            
            this.c = DriverManager.getConnection("jdbc:mysql://" + this.SERVER + "/" + this.BANCO, this.USER, this.PASS);
            return true;        
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Connection getConnection(){
        return c;
    }
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }





























/*
public class DBConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/estanislau";
    private static final String USER = "root";
    private static final String PASS = "96989629";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na Conexão: ", ex);
        }

    }

    public static void closeConnection(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível fechar conexão. ERRO: ", ex);
        }
    }

public static void closeConnection(Connection con, PreparedStatement stmt) {
    
    closeConnection(con);

        try {
           if(stmt != null){
               stmt.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível fechar conexão. ERRO: ", ex);
        }
    }

public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
    
    closeConnection(con, stmt);

        try {
           if(rs != null){
               rs.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível fechar conexão. ERRO: ", ex);
        }
    }
}



public class DBConnection {
    
    public static Connection getConnection(){
        Connection con = null;
        
        try{
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/estanislau", "root", "96989629");
            System.out.println("Conectado com Sucesso !");
        }catch(SQLException e){
            System.err.println("Erro ao conectar !");
        }
        return con;
    }
    
    public static void main(String[] args){
       DBConnection.getConnection();
    }
    
   
}


*/
     
  
    




