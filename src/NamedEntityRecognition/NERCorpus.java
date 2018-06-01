package NamedEntityRecognition;

import java.io.*;
import java.util.ArrayList;
import Corpus.*;
import DataStructure.CounterHashMap;

public class NERCorpus extends Corpus{

    public NERCorpus(){
        sentences = new ArrayList<Sentence>();
        wordList = new CounterHashMap<>();
    }

    public NERCorpus emptyCopy(){
        return new NERCorpus();
    }

    public NERCorpus(String fileName){
        String line;
        sentences = new ArrayList<Sentence>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null){
                addSentence(new NamedEntitySentence(line));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addSentence(NamedEntitySentence s){
        sentences.add(s);
    }

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
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
