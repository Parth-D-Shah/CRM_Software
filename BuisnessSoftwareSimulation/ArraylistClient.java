import java.util.*;
public class ArraylistClient
{
    ArrayList<Person> CompanyClients;
    public ArraylistClient()
    {
        ArrayList<Person> CompanyClients = new ArrayList<Person>();
    }
    public void addClient(Person item) //adds a new client object to the arraylist
    {
        CompanyClients.add(item);
    }
    public void removeClient(int position) //removes a client object from the arraylist
    {
        CompanyClients.remove(position);
    }
}
