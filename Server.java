package Module11;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
/**
 * Program that listens to a port and determines whether the number passed in is prime.
 *
 * @author Corbin Goodyear
 */
public class Server
{
    
   
    public Server()
    {
    }
    
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Waiting for clients...");
            ServerSocket ss = new ServerSocket(9806);
            Socket soc = ss.accept();
            System.out.println("Connection established");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            
            String str = in.readLine();
            
            int numberToCheck = Integer.parseInt(str);
            
            boolean isPrime = Server.isPrime(numberToCheck);
            
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            
            if(isPrime)
            {
                out.println("The number " + str + " is prime.");
            }
            else
            {
                out.println("The number " + str + " is not prime.");
            }
            
            ss.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    static  boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
       for(int i=2;i<=num/2;i++)
       {
           if((num%i)==0)
               return  false;
       }
       return true;
    }
}