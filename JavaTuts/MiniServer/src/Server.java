import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {
	private ServerSocket server;
	
	public Server(int port)
	{
		try
		{
			server = new ServerSocket(port);
			server.setSoTimeout(100000);
		} catch (SocketException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void laufen()
	{
		while(true)
		{
			try{
				System.out.println(server.getInetAddress());
				System.out.println("Waiting for client at " + server.getLocalPort());
				Socket client = server.accept();
				DataInputStream input = new DataInputStream(client.getInputStream());
				System.out.println(input.readUTF());
				System.out.println(client.getRemoteSocketAddress());
				DataOutputStream output = new DataOutputStream(client.getOutputStream());
				output.writeUTF("Greetings, Lord Dave!");
				client.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Server s = new Server(1337);
		s.laufen();
	}

}
