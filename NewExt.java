package ads;

import java.util.ArrayList;

public class NewExt {
    public static void main(String[] args) {
        int gf=2;
        NewExtendible ex=new NewExtendible(gf);
        ArrayList<Integer>val=new ArrayList<Integer>();
        ArrayList<Integer>original=new ArrayList<Integer>();
        
            original.add(16);
            original.add(4);
            original.add(6);
            original.add(22);
            original.add(24);
            original.add(10);
            original.add(31);
            original.add(7);
            original.add(9);
            original.add(20);
            original.add(26);
            val.add(0);
            val.add(4);
            val.add(6);
            val.add(6);
            val.add(8);
            val.add(10);
            val.add(15);
            val.add(7);
            val.add(9);
            val.add(4);
            val.add(10);
        ArrayList<String>bin=ex.binary(val);
        ArrayList<String>padded=ex.pad(bin);
        ex.hash(original,padded,3);
        
    }
    
}
