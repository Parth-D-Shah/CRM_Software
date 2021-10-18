import javax.swing.*;  
import java.util.*;
import java.io.*;
public class Analysis
{
    public JFrame f;
    public Analysis()
    {
        int[] total = {returndividend(),returnassetgrowth(),returnsales()*12}; //array of all 3 steady sources of income
        if((total[0] > total[1])&(total[0] > total[2]))
        {
            JOptionPane.showMessageDialog(f,"Analysis Complete: Your stocks provide the company the most money \nAmount: "+total[0]+" per year");
        }
        else if((total[1] > total[0])&(total[1] > total[2]))
        {
            JOptionPane.showMessageDialog(f,"Analysis Complete: Your assetgrowth from your disposable assets provide the company the most money \nAmount: "+total[1]+" per year");
        }
        else if((total[2] > total[1])&(total[2] > total[0]))
        {
            JOptionPane.showMessageDialog(f,"Analysis Complete: Your sales provide the company the most money \nAmount: "+total[2]+" per year \nThis is a rough 12 month estimate based on this months income from sales");
        }
    }
    public int returnsales() //method which returns sales numbers
    {
        String text;
        int lineNumber;
        try 
        {
            FileReader readfile = new FileReader("sales.txt");
            BufferedReader readbuffer = new BufferedReader(readfile);
            for (lineNumber = 1; lineNumber < 2; lineNumber++)
            {
                if (lineNumber == 1)
                {
                    text = readbuffer.readLine();
                    return Integer.parseInt(text);
                } 
            }
        }
        catch (IOException efileout) 
        {
            efileout.printStackTrace();
        }
        return -1;
    }
    public int returndividend() //method which returns dividend totals
    {
        try
        {
            BufferedReader inputStream = new BufferedReader(new FileReader("dividend.txt"));
            boolean end = false; //while loop end condition
            int total = 0;
            while (end == false)
            {
                String line = inputStream.readLine(); //Read the next line in the file and store it in the variable line
                if (line != null)
                {
                    String[] linedata = line.split(" "); //splits line into array spaced by whitespaces
                    AssetStock a1 = new AssetStock("","","","",linedata[0]);
                    String dividend = a1.getdividend();
                    total = total + Integer.parseInt(dividend);
                }
                else
                {
                    end = true;
                }
            }
            inputStream.close();
            return total;
        }
        catch(Exception emainframe)
        {
            System.out.println("No dividends");
        }
        return -1;
    }
    public int returnassetgrowth() //method which returns assetgrowth totals
    {
        try
        {
            BufferedReader inputStream = new BufferedReader(new FileReader("assetgrowth.txt"));
            boolean end = false; //while loop end condition
            int total = 0;
            while (end == false)
            {
                String line = inputStream.readLine(); //Read the next line in the file and store it in the variable line
                if (line != null)
                {
                    String[] linedata = line.split(" "); //splits line into array spaced by whitespaces
                    AssetD a1 = new AssetD("","","","",linedata[0]);
                    String assetgrowth = a1.getassetgrowth();
                    total = total + Integer.parseInt(assetgrowth);
                }
                else
                {
                    end = true;
                }
            }
            inputStream.close();
            return total;
        }
        catch(Exception emainframe)
        {
            System.out.println("No disposable assets");
        }
        return -1;
    }
}
