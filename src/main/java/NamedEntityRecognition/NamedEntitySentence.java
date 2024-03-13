package NamedEntityRecognition;

import java.util.ArrayList;
import Corpus.Sentence;

public class NamedEntitySentence extends Sentence {

    /**
     * Empty constructor for {@link NamedEntitySentence}
     */
    public NamedEntitySentence(){
        super();
    }

    /**
     * Another constructor of {@link NamedEntitySentence}. It takes input a named entity annotated sentence in string
     * form, divides the sentence with respect to space and sets the tagged words with respect to their tags.
     * @param sentence Named Entity annotated sentence in string form
     */
    public NamedEntitySentence(String sentence){
        String entityType, candidate;
        NamedEntityType type = NamedEntityType.NONE;
        String[] wordArray;
        words = new ArrayList<>();
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
