import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		FileWriter writer;
		File datei = new File("soundso.txt");
		
		try {
			writer = new FileWriter(datei);
			writer.write("ich bin eine Datei");
			writer.write(System.getProperty("line.separator"));
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
