package bd;


import ventanas.ClaseContenedora;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import clases.MarcaVehiculo;
import clases.TipoRepuesto;
import clases.TipoVehiculo;


public class BD {
	private static ClaseContenedora claseContenedora = new ClaseContenedora();
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// FUNCION PARA LEER UN CSV ///////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void leerCSVVehiculos(String archivo) { 
		String path = "data/"+archivo+".csv";
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null) {
				
				String[] values = line.split(",");
				String bd = "Usuario.db";
				int id = Integer. parseInt(values[3]);
				TipoVehiculo tipo = TipoVehiculo.valueOf(values[0]);
				String modelo = values[1];
				MarcaVehiculo marca = MarcaVehiculo.valueOf(values[2]);
				int precio = Integer. parseInt(values[4]);
				claseContenedora.guardarDBVehiculo(bd, id, tipo, modelo, marca, precio);			
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void leerCSVRepuestos(String archivo) { 
		String path = "data/"+archivo+".csv";
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null) {
				
				String[] values = line.split(",");
				String bd = "Usuario.db";
				int id = Integer. parseInt(values[1]);
				TipoRepuesto tipo = TipoRepuesto.valueOf(values[0]);
				int compra = Integer. parseInt(values[2]);
				int venta = Integer. parseInt(values[3]);
				claseContenedora.guardarDBRepuesto(bd, id, tipo, compra, venta);			
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
}
