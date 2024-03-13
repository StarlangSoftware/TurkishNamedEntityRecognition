package NamedEntityRecognition;

public class Slot {
    private SlotType type;
    private final String tag;

    public Slot(SlotType type, String tag){
        this.type = type;
        this.tag = tag;
    }

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

    public SlotType getType(){
        return type;
    }

    public String getTag(){
        return tag;
    }

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
