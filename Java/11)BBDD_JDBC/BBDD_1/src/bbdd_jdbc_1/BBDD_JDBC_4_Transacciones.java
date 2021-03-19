import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BBDD_JDBC_4_Transacciones {

    public static void main(String[] args) {
        Connection miConexion = null;
	try{					

            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_java_sql_220", "root", "");				
            miConexion.setAutoCommit(false); //Lo trato como bloque
            Statement miStatement =miConexion.createStatement();

            String instruccionSql_1="INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";

            miStatement.executeUpdate(instruccionSql_1);

            String instruccionSql_2="INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";

            miStatement.executeUpdate(instruccionSql_2);
            miConexion.commit(); //Doy el ok de q todo esta bien
            System.out.println("Datos INSERTADOS correctamente");

        }catch(Exception e){

            System.out.println("ERROR EN LA INSERCI�N DE DATOS!!");
            e.printStackTrace();
            try {
                miConexion.rollback(); //genero try catch para rollback, rollback vuelve hacia atras si algo no anda bien, garantiza la integridad de los datos
            } catch (SQLException ex) {
                Logger.getLogger(BBDD_JDBC_4_Transacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
