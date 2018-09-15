package NamedEntityRecognition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class Gazetteer {
    private HashSet<String> data;
    private String name;

    public Gazetteer(String name, String fileName){
        this.name = name;
        data = new HashSet<>();
        ClassLoader classLoader = getClass().getClassLoader();
        Scanner input = new Scanner(classLoader.getResourceAsStream(fileName));
        while (input.hasNext()){
            data.add(input.next().toLowerCase());
        }
    }

    public String getName(){
        return name;
    }

    public boolean contains(String word){
        String wordLowercase = word.toLowerCase(new Locale("tr"));
        return data.contains(wordLowercase);
    }

}
