import java.io.*; // File
import java.util.*;	// Scanner
import java.lang.*;	//Runnable y Thread
import javax.swing.*;  //JPanel, JFrame, 
import java.awt.*;	//Colores, eventos 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;


public class BuscadorHilos  extends JFrame implements ActionListener,Runnable {
	
	JPanel panel1;
	JLabel etiqueta1;
	JTextArea area;
	JScrollPane scroll;
	JTextField ruta, nombre;
	JButton buscar, limpiar;
	
	//declarar variables de los hilos
	ArrayList<Thread> hilos =  new ArrayList<Thread>();
	ArrayList<String> rutas =  new ArrayList<String>();
	int generados=-1;
	String buscado="";

	//Constructores

	public BuscadorHilos(){
		this.setTitle("Ventana mamalona");
		setLayout(null);
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);

	}
	public BuscadorHilos(String ruta,String buscado){
		generados++;
		rutas.add(ruta); 
		this.buscado = buscado;
	}


	//metodo run

	public void run(){

		generados++;
		String miruta = rutas.get(generados);
		try{
			buscar(miruta,buscado);
		}catch(IOException ex){
			System.out.println("Error en la inicializacion de la busqueda");
		}

		}
	public void buscar(String r, String b) throws IOException{

			File f = new File(r,b);

			
			if(!f.exists()){

				System.out.println("el archivo no existe...");

			}else{

				if(f.isDirectory()){

					if(generados%2==0){

						Thread trabajador = new Thread();
						Thread trabajador = new Thread(trabajo);
						hilos.add(trabajador);
						hilos.get(generados).start();

					}

					String[] array = f.list();

					for(int i=0;i<array.length;i++){

						buscar((f.getAbsolutePath()).toString() + array[i],"nombre.txt");

						if(array[i].equals(b)){

							System.out.println("\nArchivo encontrado en: " + f.getAbsolutePath());

						}

					}

				}

			}
		}


	

	public void initComponents(){

		panel1 = new JPanel();
		panel1.setBackground( Color.BLUE);
		panel1.setBounds(0,0,600,600);

		etiqueta1 = new JLabel("Este es un Buscador");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		ruta = new JTextField("modifica ruta");
		nombre = new JTextField("modifica nombre");
		buscar = new JButton("buscar");
		limpiar = new JButton("limpiar");

		//BOUNDS
		//  POSICION X , POSICION Y , ANCHO , ALTO

		etiqueta1.setBounds(20,20,100,20);
		scroll.setBounds(20,40, 200,400);
		ruta.setBounds(225,40, 300, 20);
		nombre.setBounds(225,80, 300, 20);
		
		buscar.setBounds(225,300,100,30);
		limpiar.setBounds(330,300,100,30);
		//ActionListener escuchador = new Escuchador();
		buscar.addActionListener(this);
		limpiar.addActionListener(this);


		panel1.add(etiqueta1);
		this.add(ruta);
		this.add(nombre);
		this.add(scroll);
		this.add(buscar);
		this.add(limpiar);
		this.add(panel1);

	}

	public void actionPerformed(ActionEvent ev){

		if(ev.getSource() == limpiar){

			area.setText("");
			ruta.setText("");
			nombre.setText("");

		}
		if(ev.getSource() == buscar){

			BuscadorHilos trabajo = new BuscadorHilos(0,buscar.getText());

		}

	}

}//clase BuscadorHilos

// class Escuchador implements ActionListener{

// 	//@override //no se donde lo vi ni para que es pero se veia mamalon y lo puse
// 	public void actionPerformed(ActionEvent ev){

// 		if(ev.getSource() == limpiar){

// 			area.setText("");
// 			ruta.setText("");
// 			nombre.setText("");

// 		}

//  	}
// }

class Principal{

	public static void main(String[] args)  throws IOException {
		
		int hilos=-1;
		String busca = "nombre.txt";

		BuscadorHilos v1 = new BuscadorHilos();

		
		//	Thread hilo = new Thread(v1);
		//	hilo.start();

	}

}