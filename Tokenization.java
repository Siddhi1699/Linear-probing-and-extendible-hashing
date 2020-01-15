package ads;
import java.io.*;
import java.util.*;

public class Tokenization
{
    String token;
    ArrayList<String> original=new ArrayList<String>();
    ArrayList<String> tks=new ArrayList<String>();
        
    public Tokenization(String token)
    {
	this.token=token;
    }
         
    public ArrayList<String> tokenize()
    {
        String[] tokens=token.split("[\\� /[!]@#$%^&*()_<>,.:;'+{}\t\"]");
        for(String t:tokens)
        {
            if(!t.equals(""))
            {
                if(t.length()>10)
                {
                    addOrg(t);
                    t=t.substring(0,10);
                    addTks(t);
                }
                else if(t.length()<10)
                {
                    addOrg(t);
                    for(int j=t.length()+1;j<=10;j++)
                    {
                        t+="*";
                    }
                    addTks(t);
                }
            }
        }
	return tks;
    }
    
    public void addOrg(String t)
    {
        original.add(t);
    }
    
    public void addTks(String t)
    {
        tks.add(t);
    }
        
    public ArrayList<String> getTokens()
    {
	return original;
    }
}