import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    Connection con = null;
    public static Connection ConnectDb(){
        try{
            String stringConnection = "jdbc:sqlite:C:/Users/Aldrin/Downloads/sqlitestudio-3.3.3/SQLiteStudio/Loja";
            Connection con = DriverManager.getConnection(stringConnection);
            return con;
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao Conectar no banco");
            return null;
        }
    }
}