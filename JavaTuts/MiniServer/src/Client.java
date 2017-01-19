import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class Client {

	public static void main(String[] args)
	{
		try
		{
			Socket client = new Socket("localhost", 1337);
			DataOutputStream output = new DataOutputStream(client.getOutputStream());
			output.writeUTF("Hi, I am " + client.getLocalSocketAddress());
			
			DataInputStream input = new DataInputStream(client.getInputStream());
			System.out.println(input.readUTF());
			client.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
