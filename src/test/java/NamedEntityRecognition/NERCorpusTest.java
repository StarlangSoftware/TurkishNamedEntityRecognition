package NamedEntityRecognition;

import DataStructure.CounterHashMap;

import static org.junit.Assert.*;

public class NERCorpusTest {

    @org.junit.Test
    public void testNERCorpus() {
        CounterHashMap<NamedEntityType> counter = new CounterHashMap<>();
        NERCorpus nerCorpus = new NERCorpus("nerdata.txt");
        assertEquals(27556, nerCorpus.sentenceCount());
        assertEquals(492233, nerCorpus.numberOfWords());
        for (int i = 0; i < nerCorpus.sentenceCount(); i++){
            NamedEntitySentence namedEntitySentence = (NamedEntitySentence) nerCorpus.getSentence(i);
            for (int j = 0; j < namedEntitySentence.wordCount(); j++){
                NamedEntityWord namedEntityWord = (NamedEntityWord) namedEntitySentence.getWord(j);
                counter.put(namedEntityWord.getNamedEntityType());
            }
        }
        assertEquals(438976, (int) counter.get(NamedEntityType.NONE));
        assertEquals(23878, (int) counter.get(NamedEntityType.PERSON));
        assertEquals(16931, (int) counter.get(NamedEntityType.ORGANIZATION));
        assertEquals(12448, (int) counter.get(NamedEntityType.LOCATION));
    }

}