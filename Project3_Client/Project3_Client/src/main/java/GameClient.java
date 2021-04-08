import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class GameClient extends Thread{
	UpdatePack clientPack;
Socket socketClient;
int portNum = 5555;
	
	ObjectOutputStream out;
	ObjectInputStream in;
	
	private Consumer<Serializable> callback;
	
	
	GameClient(Consumer<Serializable> call, int portNum){
		this.portNum = portNum;
		callback = call;
	}
	
	public void run() {
		
		try {
		socketClient= new Socket("127.0.0.1",portNum);
		clientPack = new UpdatePack();
		System.out.println("created new socket");
	    out = new ObjectOutputStream(socketClient.getOutputStream());
	    in = new ObjectInputStream(socketClient.getInputStream());
	    socketClient.setTcpNoDelay(true);
		}
		catch(Exception e) {
			System.out.println("Client socket did not launch");
		}

		try {
			while (true) {
				UpdatePack message = (UpdatePack) in.readObject();
				callback.accept(message);
			}
		} catch(Exception e) {
			UpdatePack message = new UpdatePack();
			message.connectionFail = true;
			callback.accept(message);
			System.out.println("Client Connection Fail");
		}

	
    }
	

	public void send(UpdatePack data) {
		
		try {
			out.writeObject(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

