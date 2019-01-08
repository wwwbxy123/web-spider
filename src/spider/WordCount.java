package spider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class WordCount {

    //public static void main(String[] args) throws Exception {


    //}

    //按value的大小进行排序
    public static void SortMap(Map<String,Integer> oldmap){

        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();  //降序
            }
        });

        
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());
        }
    }

}
