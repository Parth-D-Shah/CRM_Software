import java.util.*;
import javax.swing.*; 
public class AssetND extends Asset //extends superclass
{
    public JFrame f;
    public String liquidity;
    public AssetND(String aassetname,String aassetamount,String aassetquantity,String aassettype,String lliquidity)//constructor for AssetND object
    {
        super(aassetname,aassetamount,aassetquantity,"NON-DISPOSABLE");
        liquidity = lliquidity; //superclass does not have this
    }
    public String getName() //getter method overides superclass method
    {
        return "NON-Disposable"+assetname;
    }
    public void removeItem() //this class method overides the method in parent class
    {
        JOptionPane.showMessageDialog(f,"You cannot remove a NON-Disposable Asset");
    }
    public String getliquidity() //getter method
    {
        return liquidity;
    }
    public void changeliquidity(String state) //setter method
    {
        liquidity = state;
    }
}
