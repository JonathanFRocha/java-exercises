package br.com.jonathanferreira.javaFundamentals.modernJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class SortStrings {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words.add("abcd");
        words.add("acbdee");
        words.add("testinnng");
        words.add("be");

        Comparator<String> comparator = new SizeComparator();

        //Collections.sort(words,comparator);

        System.out.println(words);

        System.out.println("----------------------consumer------------");
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        });

        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("--------------lambda------------");
        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        words.forEach(System.out::println);
    }
}

class SizeComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}
