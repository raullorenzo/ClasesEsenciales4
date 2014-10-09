package edu.upc.eetac.dsa.rlorenzo.ejercicio4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Archivo {
	
	public int cuentaChars(){
		int num=0;
		
		try {
			FileReader fr = new FileReader("/home/raul/registro.txt");
			BufferedReader br = new BufferedReader(fr);
			int aux = br.read();
			int count =-1;
			while(aux!=-1){
				aux = br.read();
				count++;
			}
			num = count;
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	public void leerFichero(){
		try {
			FileReader fr = new FileReader("/home/raul/registro.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null){
				System.out.println(linea);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void escribirFichero(){
		String date=obtenerFecha();
		String nameFile = "registro.txt";
		try{
			FileWriter fw = new FileWriter("/home/raul/registro.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(nameFile+"\n");
			bw.write(date+"\n");
			
			bw.close();
			fw.close();
			
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	private String obtenerFecha(){	
		
		String date=null;
		
		Calendar fecha = new GregorianCalendar();
		
		int año= fecha.get(Calendar.YEAR);
		int mes=fecha.get(Calendar.MONTH);
		int dia=fecha.get(Calendar.DAY_OF_MONTH);
		int hora=fecha.get(Calendar.HOUR);
		int minuto=fecha.get(Calendar.MINUTE);
		int segundo=fecha.get(Calendar.SECOND);
		
		date=dia+"/"+mes+"/"+año+" "+hora+":"+minuto+":"+segundo;
		
		return date;
		
	}

}
