package NamedEntityRecognition;

public class Slot {
    private SlotType type;
    private final String tag;

    /**
     * Constructor for the Slot object. Slot object stores the information about more specific entities. The slot
     * type represents the beginning, inside or outside the slot, whereas tag represents the entity tag of the
     * slot.
     * @param type Type of the slot. B, I or O for beginning, inside, outside the slot respectively.
     * @param tag Tag of the slot.
     */
    public Slot(SlotType type, String tag){
        this.type = type;
        this.tag = tag;
    }

    /**
     * Second constructor of the slot for a given slot string. A Slot string consists of slot type and slot tag
     * separated with '-'. For example B-Person represents the beginning of a person. For outside tagging simple 'O' is
     * used.
     * @param slot Input slot string.
     */
    public Slot(String slot){
        if (slot.equalsIgnoreCase("O")){
            type = SlotType.O;
            tag = null;
        } else {
            String type = slot.substring(0, slot.indexOf("-"));
            String tag = slot.substring(slot.indexOf("-") + 1);
            switch (type){
                case "B":
                    this.type = SlotType.B;
                    break;
                case "I":
                    this.type = SlotType.I;
                    break;
            }
            this.tag = tag;
        }
    }

    /**
     * Accessor for the type of the slot.
     * @return Type of the slot.
     */
    public SlotType getType(){
        return type;
    }

    /**
     * Accessor for the tag of the slot.
     * @return Tag of the slot.
     */
    public String getTag(){
        return tag;
    }

    /**
     * ToString method of the slot.
     * @return Type and tag separated with '-'. If the type is outside, it returns 'O'.
     */
    public String toString(){
        switch (type){
            case O:
                return "O";
            case B:
            case I:
                return type + "-" + tag;
        }
        return "";
    }
}
