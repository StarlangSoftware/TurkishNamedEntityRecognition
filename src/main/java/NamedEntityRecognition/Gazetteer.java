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
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Scanner input = new Scanner(new File(classLoader.getResource(fileName).getFile()));
            while (input.hasNext()){
                data.add(input.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
