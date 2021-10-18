public class Client extends Person //extends superclass
{
    public String companyname;
    public Client(String nname,String ssurname,String aage,String ccompanyname,String ccontactdetails)//constructor for Client object
    {
        super(nname,ssurname,aage,ccontactdetails);
        companyname = ccompanyname; //superclass does not have this
    }
    public String getCompanyname() //getter method 
    {
        return companyname;
    }
    public String getName() //getter method overides superclass method
    {
        return "Client: "+name;
    }
}
