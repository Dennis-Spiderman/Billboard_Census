package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.BillboardData;

public class Main {

	private static BillboardData data;
	private static Scanner in;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		data = new BillboardData();
		
		System.out.println("Bienvenido.\n");
		menu();
	}
	
	public static void menu() throws IOException {
		System.out.println("\n_______ Menú _______");
		
		System.out.println("\n1) Para importar nuevos datos."
				+ "\n2) Para agregar una valla publicitaria."
				+ "\n3) Para mostrar vallas publicitarias."
				+ "\n4) Para exportar reporte de peligrosidad."
				+ "\n0) Para salir.");
		
		int selection = Integer.parseInt(in.nextLine());
		
		switch (selection) {
		case 1:
			importData();
			break;
			
		case 2:
			addBillboard();
			break;
			
		case 3:
			seeBillboards();
			break;
			
		case 4:
			exportDangerReport();
			break;
			
		case 0:
			exit();
			break;

		default:
			System.out.println("\nLa opción es invalida. Intenta nuevamente");
			menu();
			break;
		}
	}
	
	public static void importData() throws IOException {
		System.out.println("\n_____ Importar datos _____");
		
		try {
			System.out.println("\nIngresa el path del archivo que quieres importar:");
			String path = in.nextLine();
			
			data.loadDatos(path);
			
			System.out.println("\nLos datos han sido importados correctamente.");
			menu();
		} catch (FileNotFoundException e) {
			System.out.println("\nNo se ha encontrado el archivo. Intenta de nuevo.");
			menu();
		}
	}
	
	public static void addBillboard() throws IOException {
		try {
			System.out.println("\n_____ Agregar valla publicitaria _____"
					+ "\nDigita la información de la valla publicitaria: ");
			
			String billboardInfo = in.nextLine();
			
			data.addBillboard(billboardInfo);
			
			System.out.println("\nValla publicitaria creada exitosamente.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ha sucedido un error creando la valla publicitaria.Porfavor intenta de nuevo");
		}
		
		menu();
	}
	
	public static void seeBillboards() throws IOException {
		System.out.println("\n_____ Ver vallas publicitarias _____"
				+ "\n\n" + data.billboardsToString());
		
		menu();
	}
	
	public static void exportDangerReport() throws IOException {
		System.out.println("\n_____ Reporte de peligrosidad _____");
		
		data.exportDangerousReport();
		
		System.out.println(data.dangerousBillboardsToString());
		
		menu();
	}

	public static void exit() {
		System.out.println("\n¡Adiós!");
		System.exit(0);
	}
	
}
