package NamedEntityRecognition;

import java.io.*;
import java.util.ArrayList;
import Corpus.*;
import DataStructure.CounterHashMap;

public class NERCorpus extends Corpus{

    /**
     * A constructor of {@link NERCorpus} which initializes the sentences of the corpus, the word list of
     * the corpus.
     */
    public NERCorpus(){
        sentences = new ArrayList<>();
        wordList = new CounterHashMap<>();
    }

    /**
     * A clone method for the {@link NERCorpus} class.
     *
     * @return A copy of the current {@link NERCorpus} class.
     */
    public NERCorpus emptyCopy(){
        return new NERCorpus();
    }

    /**
     * Another constructor of {@link NERCorpus} which takes a fileName of the corpus as an input, reads the
     * corpus from that file.
     *
     * @param fileName Name of the corpus file.
     */
    public NERCorpus(String fileName){
        String line;
        sentences = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null){
                addSentence(new NamedEntitySentence(line));
                line = br.readLine();
            }
        } catch (IOException ignored) {
        }
    }

    /**
     * addSentence adds a new sentence to the sentences {@link ArrayList}
     * @param s Sentence to be added.
     */
    public void addSentence(NamedEntitySentence s){
        sentences.add(s);
    }

    /**
     * writeToFile writes the corpus in the format given above into the file with the given fileName.
     * @param fileName Output file name.
     */
    public void writeToFile(String fileName){
        PrintWriter writer;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
            for (Sentence sentence : sentences){
                for (int i = 0; i < sentence.wordCount(); i++){
                    NamedEntityWord word = (NamedEntityWord) sentence.getWord(i);
                    switch (word.getNamedEntityType()){
                        case LOCATION:
                            writer.print(" <b_enamex TYPE=\"LOCATION\">" + word.getName() + "<e_enamex>");
                            break;
                        case ORGANIZATION:
                            writer.print(" <b_enamex TYPE=\"ORGANIZATION\">" + word.getName() + "<e_enamex>");
                            break;
                        case PERSON:
                            writer.print(" <b_enamex TYPE=\"PERSON\">" + word.getName() + "<e_enamex>");
                            break;
                        case TIME:
                            writer.print(" <b_enamex TYPE=\"TIME\">" + word.getName() + "<e_enamex>");
                            break;
                        case MONEY:
                            writer.print(" <b_enamex TYPE=\"MONEY\">" + word.getName() + "<e_enamex>");
                            break;
                        default:
                            writer.print(" " + word.getName());
                            break;
                    }
                }
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ignored) {
        }
    }

}
