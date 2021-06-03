import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class ClientEx {

	public static void main(String[] args) {
		try {
			Socket s=new Socket("106.211.61.55",4801);	
			System.out.println("Connect to server");
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello Server from Umang");
			String m=din.readUTF();
			System.out.println("Server: "+m);
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
