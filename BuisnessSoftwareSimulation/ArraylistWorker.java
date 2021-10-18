import java.util.*;
public class ArraylistWorker
{
    ArrayList<Person> CompanyWorkers;
    public ArraylistWorker()
    {
        ArrayList<Person> CompanyWorkers = new ArrayList<Person>();
    }
    public void addWorker(Person item) //adds a new worker object to the arraylist
    {
        CompanyWorkers.add(item);
    }
    public void removeWorker(int position) //removes a worker object from the arraylist
    {
        CompanyWorkers.remove(position);
    }
}
