import java.util.*;
import javax.swing.*;
public class AssetStock extends Asset //extends superclass
{
    public JFrame f;
    public String dividend;
    public AssetStock(String aassetname,String aassetamount,String aassetquantity,String aassettype,String ddividend) //constructor for AssetStock object
    {
        super(aassetname,aassetamount,aassetquantity,"STOCK");
        dividend = ddividend; //superclass does not have this
    }
    public String getName() //getter method overides superclass method
    {
        return "STOCK"+assetname;
    }
    public void removeItem() //this class method overides the method in parent class
    {
        JOptionPane.showMessageDialog(f,"This Stock has been removed");
    }
     public String getdividend() //getter method
    {
        return dividend;
    }
    public void changedividend(String state) //setter method
    {
        dividend = state;
    }
}
