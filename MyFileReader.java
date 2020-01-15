package ads;
import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;

public class MyFileReader{
String line="";
BufferedReader br;
public MyFileReader(File f)
{
    try
    {
       FileReader fr=new FileReader(f);
       br=new BufferedReader(fr);
    }
    catch(Exception e){}
}

public String getData()
{
    try{
	String data;
        while((data=br.readLine())!=null)
	{
            line+=data;
        }
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
     return line;
    }
}


