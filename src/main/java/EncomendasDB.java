import java.sql.*;

public class EncomendasDB {
    public  void  inserir ( EncomendasMateriais  mate ) {
        try {
            String sql =  "INSERT INTO tb_encomenda (nome, tamanho, peso) values (?,?,?)" ;
            Connection connection =  Banco.ConnectDb();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString( 1 , mate.getNome());
            pstmt.setDouble( 2 , mate.getTamanho());
            pstmt.setDouble( 3 , mate.getPeso());


            pstmt.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
    public static void createDB()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Aldrin/Downloads/sqlitestudio-3.3.3/SQLiteStudio/Loja");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE tb_Mercadorias " +
                    "(ID INTEGER PRIMARY KEY autoincrement," +
                    " NAME           CHAR(50)    NOT NULL, " +
                    " message        TEXT     NOT NULL, " +
                    " date_added     datetime)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }





    public static void insertDB()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection( "jdbc:sqlite:C:/Users/Aldrin/Downloads/sqlitestudio-3.3.3/SQLiteStudio/Loja");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO tb_Mercadorias  (NAME,message,date_added) " +
                    "VALUES ('Zulma', 'Hello every one!!!', datetime())," +
                    " ('Nina', 'whats up!!!',datetime());";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public static void selectDB()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection( "jdbc:sqlite:C:/Users/Aldrin/Downloads/sqlitestudio-3.3.3/SQLiteStudio/Loja");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM tb_Mercadorias ;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                String  message = rs.getString("message");
                String date_added = rs.getString("date_added");
                System.out.println( "ID : " + id );
                System.out.println( "Name : " + name );
                System.out.println( "Message : " + message );
                System.out.println( "Date Added : " + date_added );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        System.out.println("Operation done successfully");
    }

    public static void updateDB()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection( "jdbc:sqlite:C:/Users/Aldrin/Downloads/sqlitestudio-3.3.3/SQLiteStudio/Loja");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "UPDATE tb_Mercadorias   set message = 'This is updated by updateDB()' where ID=1;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM tb_Mercadorias ;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                String  message = rs.getString("message");
                String date_added = rs.getString("date_added");
                System.out.println( "ID : " + id );
                System.out.println( "Name : " + name );
                System.out.println( "Message : " + message );
                System.out.println( "Date Added : " + date_added );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public static void deleteDB()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection( "jdbc:sqlite:C:/Users/Aldrin/Downloads/sqlitestudio-3.3.3/SQLiteStudio/Loja");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DELETE from tb_Mercadorias  where ID=1;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM tb_Mercadorias ;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                String  message = rs.getString("message");
                String date_added = rs.getString("date_added");
                System.out.println( "ID : " + id );
                System.out.println( "Name : " + name );
                System.out.println( "Message : " + message );
                System.out.println( "Date Added : " + date_added );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}






