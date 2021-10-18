import java.util.*;
import javax.swing.*;
public class Asset
{
    public String assetname;
    public String assetamount;
    public String assetquantity;
    public String assettype;
    public JFrame f;
    public Asset(String aassetname,String aassetamount,String aassetquantity,String aassettype) //constructor for Asset object
    {
        assetname = aassetname;
        assetamount = aassetamount;
        assetquantity = aassetquantity;
        assettype = aassettype;
    }
    public String getName() //getter method
    {
        return assetname;
    }
    public String getType() //getter method
    {
        return assettype;
    }
    public String getAmount() //getter method
    {
        return assetamount;
    }
    public String getQuantity() //getter method
    {
        return assetquantity;
    }
    public void removeItem() //overides class method from superclass
    {
        JOptionPane.showMessageDialog(f," Item removed");
    }
}
