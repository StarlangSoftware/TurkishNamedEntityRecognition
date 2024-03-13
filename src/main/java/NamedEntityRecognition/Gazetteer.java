package NamedEntityRecognition;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class Gazetteer {
    private final HashSet<String> data;
    private final String name;

    /**
     * A constructor for a specific gazetteer. The constructor takes name of the gazetteer and file name of the
     * gazetteer as input, reads the gazetteer from the input file.
     * @param name Name of the gazetteer. This name will be used in programming to separate different gazetteers.
     * @param fileName File name of the gazetteer data.
     */
    public Gazetteer(String name, String fileName){
        this.name = name;
        data = new HashSet<>();
        ClassLoader classLoader = getClass().getClassLoader();
        Scanner input = new Scanner(classLoader.getResourceAsStream(fileName));
        while (input.hasNext()){
            data.add(input.next().toLowerCase());
        }
    }

    /**
     * Accessor method for the name of the gazetteer.
     * @return Name of the gazetteer.
     */
    public String getName(){
        return name;
    }

    /**
     * The most important method in {@link Gazetteer} class. Checks if the given word exists in the gazetteer. The check
     * is done in lowercase form.
     * @param word Word to be search in Gazetteer.
     * @return True if the word is in the Gazetteer, False otherwise.
     */
    public boolean contains(String word){
        String wordLowercase = word.toLowerCase(new Locale("tr"));
        return data.contains(wordLowercase);
    }

}
