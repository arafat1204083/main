package bcs.mamun.com.days.Adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import bcs.mamun.com.days.Model.eItem;

/**
 * Created by Mamun on 5/19/2018.
 */

public class LiteData {
    public static String[] writers = new String[]{}  ;
    int i =0;
    public ArrayList<eItem> data = new ArrayList<>();
    public ArrayList<eItem> loadData(BufferedReader bufferedReader) {
        try {
            String str;
            while ((str = bufferedReader.readLine()) != null) {

                String first[] = str.split(":");
                if (first.length == 2) {
                    //writers[i++]=first[0];
                   eItem item = new eItem(first[0], first[1]);
                    data.add(item);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return data;
    }
}
