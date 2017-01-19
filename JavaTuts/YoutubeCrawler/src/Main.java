import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		BufferedReader br = null;
		InputStreamReader isr = null;
		URL url = null;
		
		String urlString = "https://www.youtube.com";
		
		
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			isr = new InputStreamReader(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		br = new BufferedReader(isr);
		
		String line = null;
		ArrayList<String> allLinks = new ArrayList<String>();
		try {
			while((line = br.readLine()) != null)
			{
				if(line.contains("watch?v="))
				{
					String substring = line;
					substring = substring.substring(substring.indexOf("watch?")-1, substring.indexOf("watch?")+19);
					allLinks.add(substring);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < allLinks.size(); i++)
		{
			allLinks.set(i, "https://youtube.com" + allLinks.get(i));
			System.out.println(allLinks.get(i));
		}
	}

}
