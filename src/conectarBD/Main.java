package conectarBD;

public class Main {

	public static void main(String[] args) {
		
		  String insert = "INSERT INTO Mesa (codigo, capacidad, estado, ubicacion, decorada, imagen)"   
				  			+  "VALUES  ('M007', 5, 'Disponible', 'Terraza', TRUE, 'img/mesa7.jpg')";	
		  
		 String update = "UPDATE Mesa SET capacidad = 4, estado = 'Disponible', ubicacion = 'Interior', decorada = FALSE, imagen = 'img/mesa3-actualizada.jpg' WHERE id_mesa = 3";
		 
		 String delete = "DELETE FROM Mesa WHERE id_mesa = 7"; 
		
		
		DatabaseConnection dbConnection  = new DatabaseConnection();
		dbConnection.openConnectionToDatabase();
		dbConnection.insert(insert);
		dbConnection.update(update);
		dbConnection.delete(delete);
		dbConnection.getTableData();
		dbConnection.showTableData();
		
	}

}
