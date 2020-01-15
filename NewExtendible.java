package ads;
import java.util.*;
import java.lang.*;

public class NewExtendible{
	Map<Integer,List<String>> dir;
	ArrayList<String> bin;
	ArrayList<String> pad;
        ArrayList<Integer> lds=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>>values=new ArrayList<ArrayList<Integer>>();
        int dsize,gd,ld=2,bsize,count=0,ind;
	public NewExtendible(int gf)
	{
            this.gd=gf;
            dsize=(int) Math.pow(2,gd);
            dir=new HashMap<Integer,List<String>>(dsize);
	}

	public ArrayList<String> binary(ArrayList<Integer> values)
	{
            bin=new ArrayList<String>();
		for(Integer a: values)
		{
                    String x=Integer.toBinaryString(a);
			addBin(x);
		}
                return bin;
        }

	public void addBin(String x)
	{
		bin.add(x);
	}

	public ArrayList<String> pad(ArrayList<String> binary)
	{
            pad=new ArrayList<String>();
            int len=maxLen(bin);
            for(String b:binary)
            {
                String x=String.format("%"+len+"s",b).replaceAll(" ","0");   
                addPad(x);			
            }
            return pad;
        }

	public void addPad(String x)
	{
		pad.add(x);
	}

	public int maxLen(ArrayList<String> bin)
	{
            int len=0;
       	    for(String b:bin)
            {
                if(b.length()>len)
		{
                    len=b.length();
		}
            }
            return len;
	}

	public void hash(ArrayList<Integer> org,ArrayList<String> padded,int bsize)
	{
            int k;
            this.bsize=bsize;
            for(k=0;k<dsize;k++)
            {
                values.add(new ArrayList<Integer>(bsize+1));
                addLds(ld);
            }     
            hash1(org,padded,bsize);
            System.out.println("\n FINAL VALUES:\n"+values);
	}

        public void addLds(int ld)
        {
            lds.add(ld);
        }
        public void expand(int key,String bits,int token,ArrayList<Integer> org,ArrayList<String> padded,ArrayList<ArrayList<Integer>>values)
        {
            int j;
            System.out.println(values);
            for(j=0;j<values.size();j++)
            {
                if(values.get(j).get(0)==key)
                    break;
            }
            if(values.get(j).size()<bsize+1)
            {
                values.get(j).add(token);
            }
            else
            {
                System.out.println("Splitting for token: "+token);
                if(lds.get(key)==gd)
                {
                    gd=gd+1;
                    int nld=lds.get(key);
                    dsize=(int) Math.pow(2,gd);
                    dir=new HashMap<Integer,List<String>>(dsize);
                    lds.set(key,nld+1);
                    values.add(new ArrayList<Integer>(bsize+1));
                    addLds(ld+1);
                    count++;
                    hash1(org,padded,bsize);
                }
                if(lds.get(key)<gd)
                {
                    lds.set(key,lds.get(key)+1);
                    values.add(new ArrayList<Integer>(bsize+1));
                    addLds(ld+1);
                    count++;
                    hash1(org,padded,bsize);
                }
            }
         }
        
       public void hash1(ArrayList<Integer> org,ArrayList<String> padded,int bsize)
       {
           ind=-1;
           for(int c=0;c<values.size();c++)
           {
               values.get(c).clear();
           }
           for(int c=0;c<4;c++)
           {
               values.get(c).add(c);
           }
           for(String p:padded)
           {
               String bit=p.substring(p.length()-gd);
               int key=Integer.parseInt(bit,2)%dsize;
               if(key>=4)
               {
                   for(int b=0;b<values.size();b++)
                   {
                       if(values.get(b).isEmpty())
                       {
                            addNewKey(values.get(b),key);
                            break;
                       }
                   }
               }
               if(key>values.size())
               {
                   key=Integer.parseInt(bit.substring(bit.length()-gd+1),2)%(values.size());
               }
               ind++;
               if(ind<=org.size()-1)
               {expand(key,bit,org.get(ind),org,padded,values);}
               
           }  
       }
       public void addNewKey(ArrayList<Integer>values,int key)
       {
           values.add(key);
       }
}

