package bd;


import ventanas.ClaseContenedora;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class BD {
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// FUNCION PARA LEER UN CSV ///////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void leerCSV(String archivo) { 
		String path = "data/"+archivo+".csv";
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null) {
				
				String[] values = line.split(",");
				String bd = "Usuario";
				String nombre = values[0];
				String contrasena = values[1];
				int admin = Integer. parseInt(values[2]);
				int dinero = Integer. parseInt(values[3]);
				ClaseContenedora claseContenedora = new ClaseContenedora();
				claseContenedora.guardarDBUsuario(bd, nombre, contrasena, admin, dinero);
				
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
