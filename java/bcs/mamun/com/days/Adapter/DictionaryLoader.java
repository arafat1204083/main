package bcs.mamun.com.days.Adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import bcs.mamun.com.days.MainActivity;
import bcs.mamun.com.days.Model.daysItem;

public class DictionaryLoader {
    public static StringBuilder st;
    private static ArrayList<daysItem> allWords;

    public static ArrayList<daysItem> loadData(BufferedReader bufferedReader) {
        allWords = new ArrayList<>();
        st = new StringBuilder();
        BufferedReader br = bufferedReader;
        try {
            String str;
            while ((str = br.readLine()) != null) {
                st.append(str + "\n");
                String first[] = str.split(":");
                if (first.length == 2) {
                    int id = idGenerator(first[0].trim());
                    daysItem item = new daysItem(id, first[0], first[1]);
                    allWords.add(item);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return allWords;
    }

    private static int idGenerator(String date) {
        String parts[] = date.split(" ");
        int i = MainActivity.months.valueOf(parts[1]).ordinal();
        int id = (i * 30) + Integer.valueOf(parts[0].trim());
        return id;
    }
}