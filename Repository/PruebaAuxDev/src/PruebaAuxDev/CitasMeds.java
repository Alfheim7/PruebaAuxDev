package PruebaAuxDev;

import java.sql.*;

import javax.swing.JOptionPane;

public class CitasMeds {

	public static void main(String[] args) {

		String licence = null;
		String date;
		String hour;

		try {

			Class.forName("org.postgresql.Driver"); // Driver para conectar la base de datos
			String url = "jdbc:postgresql://Localhost:5432/pruebaauxdev"; // URL de conexión con la base de datos local
			Connection con = DriverManager.getConnection(url, "master", "master"); // URL, Usuario y clave de la base de
																					// datos
			Statement stmt = con.createStatement(); // Se crear Statement para realizar el procesamiento de las
													// sentencias de SQL
			licence = JOptionPane.showInputDialog(
					"Bienvenido al sistema de consulta de citas, Para realizar su consulta por favor indiquenos su numero de licencia sin puntos ni espacios");
			date = JOptionPane.showInputDialog(
					"Muy bien. Ahora por favor indiquenos la fecha para consultar su calendario con formato 1900-01-01");
			hour = JOptionPane.showInputDialog("Por ultimo digita la hora con formato 00:00:00");
			ResultSet rs = stmt.executeQuery(
					"SELECT pa.nombre, pa.apellido FROM cita ci INNER JOIN pacientes pa ON ci.id_paciente = pa.id INNER JOIN medico me ON ci.id_medico = me.id WHERE me.nro_licencia ='"
							+ licence + "'" + " AND fecha = '" + date + "'" + " AND hora ='" + hour + "';");

			while (rs.next()) { // rs.next permite que se ejecute la sentencia y que avance a la siguiente en
								// caso de que se agreguen mas

				// Resultado de la consulta
				JOptionPane.showMessageDialog(null, "Hola, Dr. Sus citas disponibles para el dia son: "
						+ rs.getString("nombre") + " " + rs.getString("apellido"));

			}
		} catch (Exception e) { // En caso de que haya un error en la sentencia o sintaxis nos mostrara el error
								// en consola
			e.printStackTrace();
		}

	}

}
