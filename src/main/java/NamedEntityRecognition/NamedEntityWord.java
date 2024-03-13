package NamedEntityRecognition;

import Dictionary.Word;

public class NamedEntityWord extends Word{
    private final NamedEntityType namedEntityType;

    /**
     * A constructor of {@link NamedEntityWord} which takes name and nameEntityType as input and sets the corresponding attributes
     * @param name Name of the word
     * @param namedEntityType {@link NamedEntityType} of the word
     */
    public NamedEntityWord(String name, NamedEntityType namedEntityType){
        super(name);
        this.namedEntityType = namedEntityType;
    }

    /**
     * Accessor method for namedEntityType attribute.
     *
     * @return namedEntityType of the word.
     */
    public NamedEntityType getNamedEntityType() {
        return namedEntityType;
    }
}
