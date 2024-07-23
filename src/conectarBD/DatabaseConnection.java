
package conectarBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseConnection {
	
	private  final String DATABASE_URL = "jdbc:mysql://localhost:3306/restaurante";
	private  final String DATABASE_USER = "root";
	private  final String DATABASE_PASSWORD = "12345678";
	private  Connection databaseConnection;
	private  Statement  statement;
	private  ResultSet queryResult;

	   public void openConnectionToDatabase() {
	        try {        	
	            databaseConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
	            statement = databaseConnection.createStatement();
	            System.out.println("Conexión a la BD"); 
	        } catch (Exception e) {	           
	            System.out.println("Error en conexión" + e.getMessage()); 
	            databaseConnection = null;
	            statement = null;
	        }
	    }
	     
	  
	   public void closeConnection() {
		   try {
				   databaseConnection.close();
				   System.out.println("Conexión cerrada");
			   } catch (Exception e) {
				   System.out.println("Error al cerrar conexión" + e.getMessage());
			   } 
	   }

	
	   public void getTableData() {
		   try {		
			     queryResult = statement.executeQuery("select * from mesa"); 
			    System.out.println("Tabla abierta");				    
		   } catch (Exception e) {
			   System.out.println("Error al Abrir tabla" + e.getMessage());
		   }
	   }
	   
	   
	   public void showTableData() {
			try {				
				while( queryResult.next() ) {						
					System.out.println(
							
								queryResult.getString("codigo")		+ "  "	+
								queryResult.getString("capacidad")	+ "  "	+ 
								queryResult.getString("estado")		+ "  "	+ 
								queryResult.getString("ubicacion")
							
							);
				}
				
			} catch (Exception e) {
				System.out.println("Error al visualizar datos " + e.getMessage());
			}
	   }
	   
	   public void insert(String insert) {
			   try {
				  statement.executeUpdate(insert);			
				  System.out.println("Elemento insertado");
			} catch (Exception e) {
				System.out.println("Elemento insertado " + e.getMessage()); 
			}
		   
	   }

	   public void update(String update) {
			   try {
				 statement.executeUpdate(update);			
				 System.out.println("Elemento modificado correctamente");
			} catch (Exception e) {
				System.out.println("Error al actualizar " + e.getMessage());
			}
	   
	   }

	   public void delete(String delete) {
		   System.out.println(delete);
		   try {
			 statement.executeUpdate(delete);			
			 System.out.println("Se elimino el registro ");
		} catch (Exception e) {
			System.out.println("Error al eliminar" + e.getMessage());
		}
   }
   
}
