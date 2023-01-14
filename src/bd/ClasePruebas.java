package bd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ClasePruebas {
	
	//BORRAR ESTA CLASE ANTES DE ENTREGAR

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="data/usuarios.csv";
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));//cambiar si es necesario la ruta del archivo
			while((line=br.readLine())!=null) {
				String[] values = line.split(",");
				//System.out.println("nombre: "+values[0]+" apellido: "+values[1]+" admin: "+values[2]+" dinero: "+values[3]);
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}

	}

}
