package NamedEntityRecognition;

/**
 * Enumerator class for Named Entity types.
 */
public enum NamedEntityType {
    NONE, PERSON, ORGANIZATION, LOCATION, TIME, MONEY;

    /**
     * Static function to convert a string entity type to {@link NamedEntityType} type.
     * @param entityType Entity type in string form
     * @return Entity type in {@link NamedEntityType} form
     */
    public static NamedEntityType getNamedEntityType(String entityType){
        switch (entityType.toUpperCase()){
            case "PERSON":
                return NamedEntityType.PERSON;
            case "LOCATION":
                return NamedEntityType.LOCATION;
            case "ORGANIZATION":
                return NamedEntityType.ORGANIZATION;
            case "TIME":
                return NamedEntityType.TIME;
            case "MONEY":
                return NamedEntityType.MONEY;
            default:
                return NamedEntityType.NONE;
        }
    }

    /**
     * Static function to convert a {@link NamedEntityType} to string form.
     * @param entityType Entity type in {@link NamedEntityType} form
     * @return Entity type in string form
     */
    public static String getNamedEntityType(NamedEntityType entityType){
        if (entityType == null)
            return null;
        switch (entityType){
            case PERSON:
                return "PERSON";
            case LOCATION:
                return "LOCATION";
            case ORGANIZATION:
                return "ORGANIZATION";
            case TIME:
                return "TIME";
            case MONEY:
                return "MONEY";
            default:
                return "NONE";
        }
    }

}
