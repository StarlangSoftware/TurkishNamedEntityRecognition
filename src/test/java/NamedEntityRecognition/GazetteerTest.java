package NamedEntityRecognition;

import static org.junit.Assert.*;

public class GazetteerTest {

    @org.junit.Test
    public void testContains() {
        Gazetteer gazetteer = new Gazetteer("location", "gazetteer-location.txt");
        assertTrue(gazetteer.contains("bağdat"));
        assertTrue(gazetteer.contains("BAĞDAT"));
        assertTrue(gazetteer.contains("belçika"));
        assertTrue(gazetteer.contains("BELÇİKA"));
        assertTrue(gazetteer.contains("körfez"));
        assertTrue(gazetteer.contains("KÖRFEZ"));
        assertTrue(gazetteer.contains("küba"));
        assertTrue(gazetteer.contains("KÜBA"));
        assertTrue(gazetteer.contains("varşova"));
        assertTrue(gazetteer.contains("VARŞOVA"));
        assertTrue(gazetteer.contains("krallık"));
        assertTrue(gazetteer.contains("KRALLIK"));
        assertTrue(gazetteer.contains("berlin"));
        assertTrue(gazetteer.contains("BERLİN"));
    }
}