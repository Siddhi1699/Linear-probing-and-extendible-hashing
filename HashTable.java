package ads;

import java.util.ArrayList;
import java.util.Random;

public class HashTable
{
    HashEntry he[];
    ArrayList<Integer>hashadd=new ArrayList<Integer>();
    public HashTable(){}
    public HashTable(int s)
    {
        he = new HashEntry[s]; 
    }

    public HashEntry[]insert(HashEntry[] entry,int key,String value)
    {
        boolean found=false;
        Random r=new Random();
        try
	{
            if(he[key]==null)
            {
                he[key]=new HashEntry(value,r.nextInt(100));
            }
            else
            {
                while(he[key]!=null)
                {
                    key=(key+1)%he.length;
                }
                
                he[key]=new HashEntry(value,r.nextInt(100));
            }
        }
	catch(Exception e)
	{
            System.out.println(e);
	}
        return he;
    }

 public int search(HashEntry[] entry,int add,String s)
 {
     boolean flag=false;
     int pr=0,found=-1,f;
     try{
     for(f=add;f<entry.length;f++)
     {
         if(entry[f].key==null)
         {
             f++;
             break;
         }
         
         if(entry[f].key.equals(s))
         {
             pr++;
             System.out.println("Key "+s+" found at: "+f);
             System.out.println("No. of Probes required: "+pr);
             flag=true;
             found=f;
             break;
         }
         pr++;
     }
     
     for(f=0;f<add;f++)
     {
         if(entry[f].key==null)
         {
            f++; break;
         }
         if(entry[f].key.equals(s))
         {
             pr++;
             System.out.println("Key "+s+" found at: "+f);
             System.out.println("No. of Probes required: "+pr);
             flag=true;
             found=f;
             break;
         }
         pr++;
     }
   // System.out.println("No. of Probes required: "+pr);
     if(flag==false)
     {
         System.out.println("Key not found.");
     }
     }
     catch(Exception e)
     {
         
     }
return found;
 }
 
 public void delete(HashEntry[] entry,int add,String s)
 {
     int f;
     boolean flag=false;
     try{
     for(f=add;f<entry.length;f++)
     {
         if(entry[f].key==null)
         {
             f++;
             break;
         }
         
         if(entry[f].key.equals(s))
         {
             entry[f].key="MARKER";
             entry[f].value=0;
             System.out.println("Key "+s+" removed from: "+f);
             flag=true;
             break;
         }
     }
     
     for(f=0;f<add;f++)
     {
         if(entry[f].key==null)
         {
            f++; break;
         }
         if(entry[f].key.equals(s))
         {
             entry[f].key="MARKER";
             entry[f].value=0;
             System.out.println("Key "+s+" from: "+f);
             flag=true;
             break;
         }
     }
     if(flag==false)
     {
         System.out.println("Key not found.");
     }
     }
     catch(Exception e)
     {}
 }
 

}


