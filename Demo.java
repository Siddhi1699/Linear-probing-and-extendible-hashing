package ads;
import java.util.*;
import java.io.*;

public class Demo
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        File f=new File("D:\\SEM 6\\ADS\\Practical1\\input.c");
        MyFileReader mf= new MyFileReader(f);
	String token=mf.getData();
        System.out.println("Token read is: "+token+"\n");
	Tokenization tk=new Tokenization(token);
        ArrayList<String> original=tk.getTokens();
        ArrayList<String> tks=tk.tokenize();
        System.out.println("Number of Tokens: "+tks.size()+"\n");
	for(int i=0;i<original.size();i++)
	{
        System.out.println("Tokenised tokens: "+tks.get(i));
        System.out.println("Original token: "+original.get(i));
	}
        HashFunction hf=new HashFunction(tks);
	ArrayList<Integer> val=hf.hashfunction();//sum of ascii values
        HashEntry[] entry=hf.address(val,original);
        System.out.println("\nTable size: "+hf.tableSize()+"\n");
        printTable(entry);
        System.out.println("Enter the key to be searched: ");
        String skey=in.next();
        HashTable ht=new HashTable();
        int c=0;
        for(String s:original)
        {
            if(s.equals(skey))
            {
                ht.search(entry,val.get(c)%hf.tableSize(),skey);
            }
            c++;
        }
        System.out.println("Enter the key to be deleteded: ");
        String dkey=in.next();
        int c1=0;
        for(String s:original)
        {
            if(s.equals(dkey))
            {
                ht.delete(entry,val.get(c1)%hf.tableSize(),dkey);
            }
            c1++;
        }
        printTable(entry);
        System.out.println("\n EXTENDIBLE HASHING:\n");
        int gf=2;
        Extendible ex=new Extendible(gf);
        ArrayList<String>bin=ex.binary(val);
        ArrayList<String>padded=ex.pad(bin);
        ex.hash(original,padded,4);
    }

public static void printTable(HashEntry[] entry)
{
    System.out.println("LOCATION"+"\tKEY "+"\t\tVALUE \n");
    int i=0;
    for(HashEntry he:entry)
    {
        try{
            System.out.println((i)+"\t\t"+he.key+"\t\t"+he.value);
        }
        catch(Exception e)
        {
            System.out.println(i+"\t\tnull"+"\t\t--");
        }
        i++;
    }
}
}