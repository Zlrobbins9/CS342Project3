import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.control.ListView;


public class GameServer{
    int count = 1; //TODO: rename to reflect keeping playercount
    int portNum = 5555;
    HashMap<ClientThread, ServerGameManager> clientMap = new HashMap<ClientThread, ServerGameManager>();
    ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
    TheServer server;
    private Consumer<Serializable> callback;


    GameServer(Consumer<Serializable> call, Integer portNum){
    	this.portNum = portNum;
        callback = call;
        server = new TheServer();
        server.start();
    }


    public class TheServer extends Thread{

        public void run() {

            try(ServerSocket mysocket = new ServerSocket(portNum);){
                System.out.println("Server is waiting for a client!");

               //this loop adds clientThreads indefinately
                while(true) {
                	System.out.println("Server is waiting for the next client...");
                    ClientThread c = new ClientThread(mysocket.accept(), count);
                    //callback.accept("client has connected to server: " + "client #" + count);
                    System.out.println("client has connected to server: " + "client #" + count);
                    clients.add(c);
                    clientMap.put(c, new ServerGameManager());
                    c.start();

                    count++;

                }
            }//end of try
            catch(Exception e) {
                callback.accept("Server socket did not launch");
            }
        }//end of while
    }


    class ClientThread extends Thread{


        Socket connection;
        int count;
        ServerGameManager thisGameManager = new ServerGameManager();
        ObjectInputStream in;
        ObjectOutputStream out;

        ClientThread(Socket s, int count){
            this.connection = s;
            this.count = count;
        }

        public void updateClients(UpdatePack message) {
                try {
                    this.out.writeObject(message);
                }
                catch(Exception e) {}
        }

        public void run(){

            try {
                in = new ObjectInputStream(connection.getInputStream());
                out = new ObjectOutputStream(connection.getOutputStream());
                connection.setTcpNoDelay(true);
            }
            catch(Exception e) {
                callback.accept("Streams not open");
            }


            while(true) {
                try {
                    UpdatePack data = (UpdatePack) in.readObject();
                    
                    if(data.categoryChosen != "none" && thisGameManager.sendingPack.categoryChosen == "none")//the client has chosen a category
                    {
                    	thisGameManager.sendingPack.categoryChosen = data.categoryChosen;
                    	thisGameManager.decodedWord = thisGameManager.getWord(thisGameManager.CategoryMap.get(data.categoryChosen));
                    	thisGameManager.encodeDecodedWord();
                    	try {
                    	out.writeObject(thisGameManager.sendingPack);
                    	}catch(Exception e) {}
                    }
                    //callback.accept("client: " + count + " sent: " + data);
                    
                    //updateClients("client #"+count+" selected: "+data.categoryChosen);
                }
                catch(Exception e) {
                    callback.accept("OOOOPPs...Something wrong with the socket from client: " + count + "....closing down!");
                    //updateClients("Client #"+count+" has left the server!");
                    clients.remove(this);
                    break;
                }
            }
        }//end of run


    }//end of client thread
}






