package NamedEntityRecognition;

import static org.junit.Assert.assertEquals;

public class SlotTest {

    @org.junit.Test
    public void testSlot() {
        Slot slot1 = new Slot("B-depart_date.month_name");
        assertEquals(SlotType.B, slot1.getType());
        assertEquals("depart_date.month_name", slot1.getTag());
        assertEquals("B-depart_date.month_name", slot1.toString());
        Slot slot2 = new Slot("O");
        assertEquals(SlotType.O, slot2.getType());
        assertEquals("O", slot2.toString());
        Slot slot3 = new Slot("I-round_trip");
        assertEquals(SlotType.I, slot3.getType());
        assertEquals("round_trip", slot3.getTag());
        assertEquals("I-round_trip", slot3.toString());
    }

}
