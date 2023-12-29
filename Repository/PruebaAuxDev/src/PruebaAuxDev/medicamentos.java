package PruebaAuxDev;

import java.sql.*;
import javax.swing.JOptionPane;

public class medicamentos {

	public static void main(String[] args) {

		String document = null;

		try {

			Class.forName("org.postgresql.Driver"); // Driver para conectar la base de datos
			String url = "jdbc:postgresql://Localhost:5432/pruebaauxdev"; // URL de conexión con la base de datos local
			Connection con = DriverManager.getConnection(url, "master", "master"); // URL, Usuario y clave de la base de
																					// datos
			Statement stmt = con.createStatement(); // Se crear Statement para realizar el procesamiento de las
													// sentencias de SQL
			document = JOptionPane.showInputDialog(
					"Bienvenido al sistema de consulta de medicamentos, Para realizar su consulta por favor indiquenos su numero de documento sin puntos ni espacios");
			ResultSet rs = stmt.executeQuery(
					"SELECT me.nombre FROM cita ci INNER JOIN pacientes pa ON ci.id_paciente = pa.id INNER JOIN medicamento me ON ci.id = me.id_cita WHERE pa.nro_documento ='"
							+ document + "';");

			while (rs.next()) { // rs.next permite que se ejecute la sentencia y que avance a la siguiente en
								// caso de que se agreguen mas

				// Resultado de la consulta
				JOptionPane.showMessageDialog(null, "Hola, El (Los) medicamentos que tienes disponibles son: "
						+ rs.getString("nombre") + " Puedes solicitarlos en tu farmacia mas cercana");

			}
		} catch (Exception e) { // En caso de que haya un error en la sentencia o sintaxis nos mostrara el error
								// en consola
			e.printStackTrace();
		}

	}

}

/*
 * Creacion de la base de datos, Tablas e inserts con la cual se pobló
 * 
 * CREATE DATABASE PruebaAuxDev;
 * 
 * USE PruebaAuxDev;
 * 
 * CREATE TABLE Pacientes( id int PRIMARY KEY, nro_documento int, nombre
 * varchar(75), apellido varchar(75), edad int, genero varchar(20) );
 * 
 * CREATE TABLE medico( id int PRIMARY KEY, nro_licencia int, nombre
 * varchar(75), apellido varchar(75), especialidad varchar(20) );
 * 
 * CREATE TABLE cita( id int primary key, fecha date, hora time, id_medico int,
 * id_paciente int, FOREIGN KEY (id_medico) REFERENCES medico (id), FOREIGN KEY
 * (id_paciente) REFERENCES Pacientes (id) );
 * 
 * CREATE TABLE medicamento( id int primary key, id_cita int, FOREIGN KEY
 * (id_cita) REFERENCES cita (id), nro_lote int, nombre varchar(50) );
 * 
 * INSERT INTO cita VALUES ('1','2023-12-01','14:00:00','1','1'); INSERT INTO
 * cita VALUES ('2','2023-12-01','14:30:00','2','2'); INSERT INTO cita VALUES
 * ('3','2023-12-02','15:00:00','3','3'); INSERT INTO cita VALUES
 * ('4','2023-12-02','15:30:00','4','4'); INSERT INTO cita VALUES
 * ('5','2023-12-03','11:20:00','5','5'); INSERT INTO cita VALUES
 * ('6','2023-12-03','11:50:00','6','6');
 * 
 * INSERT INTO medicamento VALUES ('1','1','10000001','Risperidona'); INSERT
 * INTO medicamento VALUES ('2','2','10000002','Ibuprofeno'); INSERT INTO
 * medicamento VALUES ('3','3','10000003','Paracetamol'); INSERT INTO
 * medicamento VALUES ('4','4','10000004','Lumar'); INSERT INTO medicamento
 * VALUES ('5','5','10000005','Losartan'); INSERT INTO medicamento VALUES
 * ('6','6','10000006','Migradorixina');
 * 
 * INSERT INTO medico VALUES ('1','1000049716','David Felipe','Morales Gil','Med. General');
 * INSERT INTO medico VALUES ('2','1001281487','Katerin Yiseth','Vasquez
 * Ospina','Med. General'); INSERT INTO medico VALUES ('3','35512843','Cristian
 * David','Romero','Med. General'); INSERT INTO medico VALUES ('4','1030668993','Carlos
 * Andres','Bernal Reyes','Med. General'); INSERT INTO medico VALUES ('5','1050951151','Hector
 * Alberto','Gomez Rocha','Med. General'); INSERT INTO medico VALUES
 * ('6','45699825','Eduardo','Pardo Contreras','Med. General');
 * 
 * INSERT INTO Pacientes VALUES ('1','1010101010','Ana Maria','Morales
 * Rojas','24','Femenino'); INSERT INTO Pacientes VALUES ('2','1111111111','Ana
 * Milena','Leon Casas','35','Femenino'); INSERT INTO Pacientes VALUES
 * ('3','1212121212','Laura Camila','Martinez Caceres','15','Femenino'); INSERT
 * INTO Pacientes VALUES ('4','1313131313','Mario Alberto','Agudelo
 * Torres','19','Masculino'); INSERT INTO Pacientes VALUES
 * ('5','1414141414','Oscar Alejandro','Moyano Ospina','34','Masculino'); INSERT
 * INTO Pacientes VALUES ('6','1515151515','Camilo Andres','Quintero
 * Mendez','55','Masculino');
 * 
 */