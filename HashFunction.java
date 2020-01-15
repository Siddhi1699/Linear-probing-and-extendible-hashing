package ads;
import java.util.*;

public class HashFunction
{
    ArrayList<String> tokens=new ArrayList<>();
    ArrayList<Integer>values=new ArrayList<>();
    ArrayList<Integer> addr;
    int x;
	
    HashFunction(){}
    public HashFunction(ArrayList<String> tokens)
    {
	 this.tokens=tokens;
    }

    public ArrayList<Integer> hashfunction()
    {
    	for(String s:tokens)
    	{
    	 int sum=0;
    	 for(int j=0;j<s.length();j++)
    	 {
    	    sum+=(int)s.charAt(j);
    	 }
    	 addSum(sum);
    	}
	return values;
    }
    
    public void addSum(int sum)
    {
        values.add(sum);
    }

    public int tableSize()
    {
        boolean flag=false;
        x=tokens.size();
        if(isPrime(x))
            return x;
        while(!flag)
        {
            ++x;
           if(isPrime(x))
            {
                flag=true;
            }
           
        }
        return x;
    }
    
    public boolean isPrime(int x)
    {
        for(int i=2;i<=x/2;i++)
        {
            if(x%i==0)
                return false;
        }
        return true;
    }
    
    public HashEntry[]address(ArrayList<Integer>val,ArrayList<String>org)
    {
        HashEntry[] entries=new HashEntry[tableSize()];
    	addr=new ArrayList<>();
        int k=0;
    	HashTable ht=new HashTable(tableSize());
    	for(int i=0;i<org.size();i++)
    	{
            int haddr=val.get(i)%x;
            add1(haddr);
            k=ht.search(entries,haddr,org.get(i));
            if(k==-1)
            {
                System.out.println("Inserting: "+org.get(i));
                entries=ht.insert(entries,haddr,org.get(i));
            }
            else
            {
                System.out.println("Dupplicate key: "+org.get(i)+" cannot be inserted.");
                org.remove(i);
            }
    	}
        return entries;
    }
    
    public void add1(int haddr)
    {
    	addr.add(haddr);
    } 
}