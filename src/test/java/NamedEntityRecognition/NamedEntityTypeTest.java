package NamedEntityRecognition;

import static org.junit.Assert.*;

public class NamedEntityTypeTest {

    @org.junit.Test
    public void testNamedEntityType() {
        assertEquals(NamedEntityType.getNamedEntityType("person"), NamedEntityType.PERSON);
        assertEquals(NamedEntityType.getNamedEntityType("Time"), NamedEntityType.TIME);
        assertEquals(NamedEntityType.getNamedEntityType("location"), NamedEntityType.LOCATION);
    }

}
