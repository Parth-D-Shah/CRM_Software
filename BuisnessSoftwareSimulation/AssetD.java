import java.util.*;
import javax.swing.*;
public class AssetD extends Asset //extends superclass
{
    public JFrame f;
    public String assetgrowth;
    public AssetD(String aassetname,String aassetamount,String aassetquantity,String aassettype,String aassetgrowth) //constructor for AssetD object
    {
        super(aassetname,aassetamount,aassetquantity,"DISPOSABLE");
        assetgrowth = aassetgrowth; //superclass does not have this
    }
    public String getName() //getter method overides superclass method
    {
        return "Disposable"+assetname;
    }
    public void removeItem() //this class method overides the method in parent class
    {
        JOptionPane.showMessageDialog(f,"This Item has been removed");
    }
    public String getassetgrowth() //getter method
    {
        return assetgrowth;
    }
    public void changeassetgrowth(String state) //setter method
    {
        assetgrowth = state;
    }
}
