package NamedEntityRecognition;

import java.util.ArrayList;
import Corpus.Sentence;
import Dictionary.Word;

public class NamedEntitySentence extends Sentence {

    public NamedEntitySentence(){
        super();
    }

    public NamedEntitySentence(String sentence){
        String entityType, candidate;
        NamedEntityType type = NamedEntityType.NONE;
        String[] wordArray;
        words = new ArrayList<Word>();
        wordArray = sentence.split(" ");
        for (String word : wordArray){
            if (!word.isEmpty()){
                if (!word.equals("<b_enamex")){
                    if (word.startsWith("TYPE=\"")){
                        int typeIndexEnd = word.indexOf('\"', 6);
                        if (typeIndexEnd != -1){
                            entityType = word.substring(6, typeIndexEnd);
                            type = NamedEntityType.getNamedEntityType(entityType);
                        }
                        if (word.endsWith("e_enamex>")){
                            candidate = word.substring(word.indexOf('>') + 1, word.indexOf('<'));
                            if (!candidate.isEmpty()){
                                words.add(new NamedEntityWord(candidate, type));
                            }
                            type = NamedEntityType.NONE;
                        } else {
                            candidate = word.substring(word.indexOf('>') + 1);
                            if (!candidate.isEmpty()){
                                words.add(new NamedEntityWord(candidate, type));
                            }
                        }
                    } else {
                        if (word.endsWith("e_enamex>")){
                            candidate = word.substring(0, word.indexOf('<'));
                            if (!candidate.isEmpty()){
                                words.add(new NamedEntityWord(candidate, type));
                            }
                            type = NamedEntityType.NONE;
                        } else {
                            if (!word.isEmpty()){
                                words.add(new NamedEntityWord(word, type));
                            }
                        }
                    }
                }
            }
        }
    }

}
