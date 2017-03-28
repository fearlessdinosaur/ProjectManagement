package ie.dit;

/**
 * Created by David on 06/03/2017.
 */

public class Main {
    public static void main(String Args[])
    {
        Client client = new Client();
        try
        {
            client.post();
            client.get();
        }
        catch(Exception e)
        {

        }
    }

}
