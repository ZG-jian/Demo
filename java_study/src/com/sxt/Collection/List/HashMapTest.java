package com.sxt.Collection.List;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        //添加元素
        map.put("a", "A");
        //获取元素方式一   通过get方法获取
        System.out.println("-----通过get方法获取----");
        System.out.println(map.get("a"));
        System.out.println("------通过keySet方法获取-----------");
        map.put("a", "B");
        map.put("b", "B");
        map.put("c", "C");
        map.put("d", "D");
        map.put("e", "E");

        //获取方式二    通过keySet方法获取
        Set<String> keySet = map.keySet();
        Object[] objects = keySet.toArray();
        int i = Arrays.binarySearch(objects, "a");
        System.out.println(i);
        for (String key:keySet
             ) {
            System.out.println(key+"----------"+map.get(key));
        }

        System.out.println("--------通过entrySet方法获取----");
        //获取方式三    通过entrySet方法获取Map.Entry类型获取元素
        Set<Map.Entry<String,String >> entrySet = map.entrySet();
        for (Map.Entry<String ,String > entry:entrySet) {
            System.out.println(entry.getKey()+"-----"+entry.getValue());
        }
        System.out.println("--------并集操作-------");
        map2.put("f","F");
        map2.put("g","G");
        map.putAll(map2);
        Set<String> keySet2 = map.keySet();
        for (String key:keySet2
        ) {
            System.out.println(key+"----------"+map.get(key));
        }
        map.remove("a");
        map.remove("b");
        System.out.println("-----------删除元素------");
        Set<String> keySet3 = map.keySet();
        for (String key:keySet2
        ) {
            System.out.println(key+"----------"+map.get(key));
        }
    }
}
