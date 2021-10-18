import javax.swing.*;  
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class AssetFrame extends MainFrame implements ActionListener
{
    public JMenuItem menuMain;
    public JMenu menuasset;
    public JButton button2;
    public JFrame f;
    public JButton button3;
    public JButton button4;
    public int LENGTH = 600;
    public int WIDTH = 800;
    JMenuBar bar1;
    public JButton buttonback;
    ArrayList<Asset> CompanyAssets;
    public AssetFrame() //User can control assets from this frame
    {
        frame.remove(buttonm2);  //removing buttons from previous frames
        frame.remove(buttonm3);
        frame.remove(buttonm4);
        frame.remove(buttonm5);
        frame.remove(buttonm6);
        frame.remove(buttonm7);
        frame.remove(buttonm8);
        setId(CompanyAssets);
        bar1 = new JMenuBar();
        menuasset = new JMenu("Menu");    
        menuMain = new JMenuItem("Main Menu"); //button which takes you to the main frame
        menuasset.add(menuMain); 
        menuMain.addActionListener(this);
        bar1.add(menuasset);
        frame.setJMenuBar(bar1);
        button2 = new JButton("Add New Asset");  //button which lets you input a new asset
        button2.setBounds(LENGTH/2-75,0,150,20);
        button2.addActionListener(this);
        button3 = new JButton("Display Assets"); //button which shows all the assets you already have
        button3.setBounds(LENGTH/2-75,200,150,20);
        button3.addActionListener(this);
        button4 = new JButton("Remove Asset");     //button which lets you remove an asset you have already added
        button4.setBounds(LENGTH/2-75,400,150,20);
        button4.addActionListener(this);
        buttonback = new JButton("Back"); //button which takes you to the main frame
        buttonback.setBounds(0,720,100,20);
        buttonback.addActionListener(this);
        frame.add(buttonback);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if((e.getSource()==menuMain)||(e.getSource()==buttonback)) //user can navigate back to the main menu from here
        {
           frame.dispose();
           new MainFrame();
        }
        if(e.getSource()==button2) //user enters asset name amount and value and these values are then put into a text file
        {  
            String answer;
            String amount;
            String value;
            String type;
            answer = JOptionPane.showInputDialog(f,"Enter new Asset name");
            amount = JOptionPane.showInputDialog(f,"Enter Asset amount");
            value = JOptionPane.showInputDialog(f,"Enter Asset value");
            type = JOptionPane.showInputDialog(f,"Enter Asset type: 'stock' or 'disposable' or 'nondisposable' ");
            String liquidity = "none";
            String dividend = "none";
            String assetgrowth = "none";
            if((answer != null)&(amount != null)&(value != null)&(type != null)) //checks for a invalid userinput
            {
                if(type.equals("nondisposable")) //checking asset type
                {
                    liquidity = JOptionPane.showInputDialog(f,"Enter how liquid this asset is 'high' or 'low'.");
                }
                else if(type.equals("stock")) //checking asset type
                {
                    dividend = JOptionPane.showInputDialog(f,"Enter how divdend of share per year");
                }
                else if(type.equals("disposable")) //checking asset type
                {
                    assetgrowth = JOptionPane.showInputDialog(f,"Enter growth of asset per year");
                }
                ArrayList<Asset> CompanyAssets = new ArrayList<Asset>();
                if(type.equals("stock"))
                {
                    Asset a1 = new AssetStock(answer,amount,value,"",dividend);
                    JOptionPane.showMessageDialog(f,a1.getName()+" has been added"); 
                    CompanyAssets.add(a1); //adding new asset to arraylist
                    try
                    {
                        File file = new File("dividend.txt");
                        FileWriter fr = new FileWriter(file,true);
                        BufferedWriter br = new BufferedWriter(fr);
                        br.write(dividend);
                        br.write("\n");
                        br.close();
                        fr.close(); //closing the filewriters
                    }
                    catch(Exception eassets)
                    {
                        System.out.println("File IO Error");
                    }
                }
                else if(type.equals("disposable"))
                {
                    Asset a1 = new AssetD(answer,amount,value,"",assetgrowth);
                    JOptionPane.showMessageDialog(f,a1.getName()+" has been added");
                    CompanyAssets.add(a1); //adding new asset to arraylist
                    try
                    {
                        File file = new File("assetgrowth.txt");
                        FileWriter fr = new FileWriter(file,true);
                        BufferedWriter br = new BufferedWriter(fr);
                        br.write(assetgrowth);
                        br.write("\n");
                        br.close();
                        fr.close(); //closing the filewriters
                    }
                    catch(Exception eassets)
                    {
                        System.out.println("File IO Error");
                    }
                }
                else if(type.equals("nondisposable"))
                {
                    Asset a1 = new AssetND(answer,amount,value,"",liquidity);
                    JOptionPane.showMessageDialog(f,a1.getName()+" has been added");
                    CompanyAssets.add(a1); //adding new asset to arraylist
                    try
                    {
                        File file = new File("liquid.txt");
                        FileWriter fr = new FileWriter(file,true);
                        BufferedWriter br = new BufferedWriter(fr);
                        br.write(liquidity);
                        br.write(" "+value);
                        br.write("\n");
                        br.close();
                        fr.close(); //closing the filewriters
                    }
                    catch(Exception eassets)
                    {
                        System.out.println("File IO Error");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(f,"Oops Something went wrong!");
                }
                try
                {
                    File file = new File("asset.txt");
                    FileWriter fr = new FileWriter(file,true);
                    BufferedWriter br = new BufferedWriter(fr);
                    br.write(answer);
                    br.write(" "+amount);
                    br.write(" "+value);
                    br.write(" "+type);
                    br.write(" "+liquidity);
                    br.write("\n");
                    br.close();
                    fr.close(); //closing the filewriters
                }
                catch(Exception eassets)
                {
                    //do nothhing
                }
            }
        }
        if(e.getSource()==button3)
        {
            try
            {
                BufferedReader inputStream = new BufferedReader(new FileReader("Asset.txt"));
                boolean end = false; //while loop end condition
                int count = 0;
                ArrayList<Asset> CompanyAssets = new ArrayList<Asset>();
                while (end == false)
                {
                  String line = inputStream.readLine(); //Read the next line in the file and store it in the variable line
                  if (line != null)
                  {
                    String[] linedata = line.split(" "); //splits line into array spaced by whitespaces
                    Asset a1 = new Asset(linedata[0],linedata[1],linedata[2],linedata[3]);
                    CompanyAssets.add(a1);
                    if(linedata[3]=="nondisposable")
                    {
                        AssetND s1 = new AssetND(linedata[0],linedata[1],linedata[2],linedata[3],linedata[4]);
                        String liquidity = s1.getliquidity();
                        JOptionPane.showMessageDialog(f,"Asset Liqudity: "+liquidity);
                    }
                  }
                  else
                  {
                    end = true;
                  }
                }
                inputStream.close();
                if(CompanyAssets.size()==0) //checking that the arraylist is not of size 0 
                {
                    JOptionPane.showMessageDialog(f,"There are currently no Assets to display");
                }
                for(int i = 0; i < CompanyAssets.size(); i++)
                {
                    Asset a1 = CompanyAssets.get(i);
                    String assetype = a1.getType();
                    String assetname = a1.getName();
                    String assetamount = a1.getAmount();
                    String assetquantity = a1.getQuantity();
                    JOptionPane.showMessageDialog(f,"Asset ID: "+count+"\nAsset Type: "+assetype+"\nAsset Name: "+assetname+"\nAsset Amount: "+assetamount+"\nAsset Quantity: "+assetquantity);
                    count = count + 1;
                }
            }
            catch(Exception eassets)
            {
                //do nothing
            }
        }
        if(e.getSource()==button4)
        {
            try
            {
                BufferedReader inputStream = new BufferedReader(new FileReader("Asset.txt"));
                boolean end = false; //while loop end condition
                int count = 0;
                ArrayList<Asset> CompanyAssets = new ArrayList<Asset>();
                while (end == false)
                {
                  String line = inputStream.readLine(); //Read the next line in the file and store it in the variable line
                  if (line != null)
                  {
                    String[] linedata = line.split(" "); //splits line into array spaced by whitespaces
                    Asset a1 = new Asset(linedata[0],linedata[1],linedata[2],linedata[3]);
                    CompanyAssets.add(a1);
                  }
                  else
                  {
                    end = true;
                  }
                }
                String answer = JOptionPane.showInputDialog(f,"Enter the AssetID of the asset you want to remove");
                int answer0 = Integer.parseInt(answer);
                Asset a1 = CompanyAssets.get(answer0);
                boolean arraylistupdate = false;
                if(a1.getType().equals("nondisposable"))
                {
                    Asset a2 = new AssetND(a1.getName(),a1.getAmount(),a1.getQuantity(),"","");
                    a2.removeItem(); 
                }
                else if(a1.getType().equals("disposable"))
                {
                    Asset a2 = new AssetD(a1.getName(),a1.getAmount(),a1.getQuantity(),"","");
                    a2.removeItem();
                    arraylistupdate = true;
                }
                else
                {
                    Asset a2 = new AssetStock(a1.getName(),a1.getAmount(),a1.getQuantity(),"","");
                    a2.removeItem();
                    arraylistupdate = true;      
                }
                if(arraylistupdate == true)
                {
                    CompanyAssets.remove(answer0); //removing the asset
                    File file = new File("asset.txt");
                    PrintWriter writer = new PrintWriter(file);
                    writer.print("");
                    writer.close();
                    FileWriter fr = new FileWriter(file,true);
                    BufferedWriter br = new BufferedWriter(fr);
                    for(int i = 0; i < CompanyAssets.size();i++) //loop through arraylist
                    {
                        br.write(a1.getName());
                        br.write(" "+a1.getQuantity());
                        br.write(" "+a1.getAmount());
                        br.write(" "+a1.getType());
                        br.write("\n");
                    }
                    br.close();
                    fr.close(); //closing the filewriters
                }
            }
            catch(Exception eassets)
            {
                System.out.println("File IO error");
            }
        }
    }
    public void setId(ArrayList<Asset> id) //this method makes sure that this arraylist is only declared once
    {
        if (id == null)
        {
            ArrayList<Asset> CompanyAssets = new ArrayList<Asset>();
        }
    }
}