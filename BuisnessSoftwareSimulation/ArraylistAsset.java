import java.util.*;
public class ArraylistAsset
{
    ArrayList<Asset> CompanyAssets;
    public ArraylistAsset()
    {
        ArrayList<Asset> CompanyAssets = new ArrayList<Asset>();
    }
    public void addAssetS(AssetStock item) //adds a new stock asset object to the arraylist
    {
        CompanyAssets.add(item);
    }
    public void addAssetD(AssetD item) //adds a new disposable asset object to the arraylist
    {
        CompanyAssets.add(item);
    }
    public void addAssetND(AssetND item) //adds a new non disposable asset object to the arraylist
    {
        CompanyAssets.add(item);
    }
}
