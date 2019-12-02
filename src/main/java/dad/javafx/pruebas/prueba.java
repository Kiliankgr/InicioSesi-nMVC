package dad.javafx.pruebas;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class prueba {
	public static void main(String[] args) throws IOException {
		String path= new File("").getCanonicalPath();
		path+="/Users.csv";
		System.out.println(path);
		FileReader fr=new FileReader(path);
		BufferedReader bf=new BufferedReader(new FileReader(path));
		System.out.println(bf.readLine());
	
		
		CSVReader reader = null;
		try {
			
	         reader = new CSVReader(new FileReader(path));
	         String[] nextLine=null;
	         
	         while ((nextLine = reader.readNext()) != null) {
	            System.out.println(Arrays.toString(nextLine));
	         }
	         
	      } catch (Exception e) {
	         System.out.println("fail");
	      } finally {
	         if (null != reader) {
	        	 reader.close();
	         } 
	      }
	}
}
