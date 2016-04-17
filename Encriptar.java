package numeroMas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import daw.com.Teclado;

public class Encriptar {
	
	private String textoEncriptado;
	
	public Encriptar(){
		
		textoEncriptado = "";
	}
	public static void main(String[] args) {
		// Programa realizado por Juan Carlos Paz Delgado
		Encriptar aplicacion = new Encriptar();
		aplicacion.run();
	}
	public void run(){
		int opc;
		do {
			opc = mostrarMenu();
			evaluarOpc(opc);
		}while(opc!=6);

	}
	public int mostrarMenu(){
		int opc;
		do{
			System.out.println("1. Encriptar texto");
			System.out.println("2. Desencriptar texto");
			System.out.println("3. Leer texto");
			System.out.println("4. Guardar archivo");
			System.out.println("5. Abrir archivo");
			System.out.println("6. Salir");
			System.out.println();
			opc = Teclado.leerInt("Elige una opción: ");
		}while(opc < 1 || opc > 6);

		return opc;
	}
	public void evaluarOpc(int opc){
		switch(opc){
		case 1:
			encriptarTexto();
			break;
		case 2:
			desencriptarTexto();
			break;
		case 3:
			leerTexto();
			break;
		case 4:
			guardarFichero(textoEncriptado);
			break;
		case 5:
			abrirFichero();
			break;
		case 6:
			despedida();
			break;
		}
	}
	public void encriptarTexto(){
		String texto=Teclado.leerString("Texto a encriptar: ");
		String texto2;
		char n[];

		n = texto.toCharArray();

		for(int i = 0; i < n.length;i++){
			n[i]++;
		}
		texto2 = new String(n);
		System.out.println(texto2);
		textoEncriptado = texto2;
	}
	public String desencriptarTexto(){
		String texto=textoEncriptado;
		String texto2;
		char n[];

		n = texto.toCharArray();

		for(int i = 0; i < n.length;i++){
			n[i]--;
		}
		texto2 = new String(n);
		System.out.println(texto2);
		return texto2;
	}
	public void leerTexto(){
		System.out.println(textoEncriptado);
	}
	public void guardarFichero(String a){
		try {
			FileWriter bruto = new FileWriter(Teclado.leerString("Nombre del fichero: "));
			BufferedWriter filtro = new BufferedWriter(bruto);
			PrintWriter pw = new PrintWriter(filtro);
			pw.print(a+"\n");
			
			pw.close();
			filtro.close();
			bruto.close();
			
			System.out.println("Archivo guardado!");
		}catch(IOException e){
			System.out.println("Error de escritura");
		}
	}
	public void abrirFichero(){
		File f = new File(Teclado.leerString("Fichero a abrir: "));
		if(f.exists()){
			try{
				FileReader bruto = new FileReader(f);
				BufferedReader filtro = new BufferedReader(bruto);
				textoEncriptado = filtro.readLine();
				
				filtro.close();
				bruto.close();
				
				System.out.println("Archivo abierto!");
			}catch(IOException e){
				System.out.println("Error de lectura");
			}
		}else{
			System.out.println("El archivo no existe");
		}
	}
	public void despedida(){
		System.out.println("Gracias por utilizar este programa");
	}
}
