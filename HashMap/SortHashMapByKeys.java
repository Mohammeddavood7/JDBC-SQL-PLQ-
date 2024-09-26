package com.may02.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortHashMapByKeys {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(100, "Amit");
        hashMap.put(101, "Vijay");
        hashMap.put(102, "Rahul");
      
        
       
       
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(hashMap.entrySet());
       
        Collections.sort(entryList, Collections.reverseOrder(Map.Entry.comparingByKey()));

        
        Iterator<Entry<Integer, String>> it = entryList.iterator();
        while(it.hasNext())
        {
        	System.out.println(it.next());
        	
        }
        
//        for (Map.Entry<Integer, String> entry : entryList) 
//        {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
    }
}







