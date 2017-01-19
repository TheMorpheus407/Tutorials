import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			func();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomException e) {
			System.out.println(e.data);
		}
	}
	
	public static void func() throws IOException, CustomException
	{
		File f = new File("C:\\");
		CustomException e = new CustomException();
		e.data = 42;
		throw e;
	}

}
