package NamedEntityRecognition;

import Dictionary.Word;

public class NamedEntityWord extends Word{
    private NamedEntityType namedEntityType;

    public NamedEntityWord(String name, NamedEntityType namedEntityType){
        super(name);
        this.namedEntityType = namedEntityType;
    }

    public NamedEntityType getNamedEntityType() {
        return namedEntityType;
    }
}
