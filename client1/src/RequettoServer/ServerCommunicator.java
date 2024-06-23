package RequettoServer;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import MODEL.ModelUser;
import MODEL.SanPhamMD;

public class ServerCommunicator implements Serializable {
    private static final String host = "localhost";
    private static final int port = 9999;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ServerCommunicator() {}

    public String sendRequest(String action, String userName, String password) {
        try (Socket socket = new Socket(host, port)) {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            // Send action and credentials
            out.writeObject(action);
            out.writeObject(userName);
            out.writeObject(password);

            // Read response from the server
            String responseMessage = (String) in.readObject();
            return responseMessage;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public ModelUser receiveUserData() throws IOException, ClassNotFoundException {
        return (ModelUser) in.readObject();
    }

    public ArrayList<SanPhamMD> receiveProductData() throws IOException, ClassNotFoundException {
        return (ArrayList<SanPhamMD>) in.readObject();
    }
}
