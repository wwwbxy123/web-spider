package spider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/** count words frequency and print them according to frequency descending order*/
public class WordCount {

    /** remove non-characters, remove blank lines*/
    public static void wordCount(String htmlRemoveTag){
        // use ArrayList to store words
        List<String> lists = new ArrayList<String>();

        //String readLine = null;
        if ( htmlRemoveTag!= null){

            // only save characters
            String[] wordsArr1 = htmlRemoveTag.split("[^a-zA-Z]");
            for (String word : wordsArr1) {
                if(word.length() != 0){
                    lists.add(word);
                }
            }
        }
        buildMap(lists);
    }

    /** count frequency of every word, return a map<word, frequency> */
    public static void buildMap(List<String> lists){
        // use TreeMap to store<key: word, value: frequency>
        Map<String, Integer> wordsCount = new TreeMap<String, Integer>();
        //count word frequency
        for (String li : lists) {
            if(wordsCount.get(li) != null){
                wordsCount.put(li,wordsCount.get(li) + 1);
            }else{
                wordsCount.put(li,1);
            }

        }

        SortMap(wordsCount);
    }

    /** override sort function using lambda to sort according to value(descending sort) */
    public static void SortMap(Map<String,Integer> oldmap){

        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();  //descending sort
            }
        });

        printWordFrequency(list);
    }

    /** print words and frequency according to value descending sort */
    public static void printWordFrequency( ArrayList<Map.Entry<String,Integer>> list){
        System.out.println("***************************************************************************************************");
        System.out.println("The frequencies of every word are: ");
        System.out.println("***************************************************************************************************");
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());
        }
        System.out.println("===================================================================================================");
    }

}
