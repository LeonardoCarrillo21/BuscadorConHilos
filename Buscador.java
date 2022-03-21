
import java.io.*;
import java.util.*;

public class Buscador{
	
	public void buscar(String ruta, String arch )throws IOException{

		File f = new File(ruta);

			
			if(!f.exists()){

				System.out.println("el archivo no existe...");

			}else{

				if(f.isDirectory()){

					String[] array = f.list();

					for(int i=0;i<array.length;i++){

						buscar((f.getAbsolutePath()).toString() + array[i],"nombre.txt");

						if(array[i].equals(arch)){

							System.out.println("\nArchivo encontrado en: " + f.getAbsolutePath());

						}

					}

				}

			}

	}


	public static void main(String [] args)throws IOException{

		Scanner sc = new Scanner(System.in);
		String r;
		System.out.println("\nEscribe una ruta:");
		r = sc.nextLine();
		
		Buscador obj = new Buscador();

		obj.buscar(r,"nombre.txt");

	}
} 