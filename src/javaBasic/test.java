package javaBasic;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.apache.poi.hssf.record.formula.functions.Char;

import java.util.*;

public class test {

    public static void printString() {
        String[] strings = {"b","b","c","a","d"};

        int times = 0;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                map.put(strings[i], map.get(strings[i]) + 1);
            }else {
                map.put(strings[i], times + 1);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                for (int j= 0; j<strings.length; j++) {
                    if (key.equals(strings[j])) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }

    public static void printStringChar() {
        String strings = "abcdcb";
        char[] chars = strings.toCharArray();

        int times = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            }else {
                map.put(chars[i], times + 1);
            }
        }

        for (char key : map.keySet()) {
            if (map.get(key) == 1) {
                for (int j= 0; j<chars.length; j++) {
                    if (key == (chars[j])) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }


    public static void printStringChar3() {
        String strings = "abacdcb";
        Set<Character> temp = new HashSet<>();


        for(int i = 0; i < strings.length(); i++) {
            char a = strings.charAt(i);
            if (temp.contains(a)) {
                continue;
            } else {
                int last = strings.lastIndexOf(a);
                if (i == last) {
                    System.out.println(i);
                    return;
                }
                temp.add(a);
            }
        }
    }

    public static void printStringChar4() {
        String strings = "abacdcb";
        Set<Character> temp = new HashSet<>();


        for(int i = 0; i < strings.length(); i++) {
            char a = strings.charAt(i);
            int first = strings.indexOf(a);
            int last = strings.lastIndexOf(a);
            if (first == last) {
                System.out.println(first);
                return;
            }
        }
    }

    public static void printStringChar5() {
        String strings = "abacdcb";
        char[] chars = strings.toCharArray();

        int times = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            }else {
                map.put(chars[i], times + 1);
            }
        }
        for (Character key : map.keySet()) {
            if (map.get(key) == 1) {
                System.out.println(strings.indexOf(key));
                return;
            }
        }
    }

    public static void printStringChar6() {
        String strings = "abacdcb";
        char[] chars = strings.toCharArray();

        int times = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], times + 1);
            }
        }
        for (int i = 0; i < chars.length; i ++) {
            if (1 == map.get(chars[i])) {
                System.out.println(i);
                return;
            }
        }
    }



    public static void main(String[] args){
//        test.printString();
//        test.printStringChar();
        test.printStringChar5();
    }
}
