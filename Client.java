import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Client
{
    
  
    public Client()
    {
    }
   
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Client started");
            Socket soc = new Socket("localhost",9806);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number and I will check to see if it is prime:");
            String str = userInput.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
            out.println(str);
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(in.readLine());
            soc.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}