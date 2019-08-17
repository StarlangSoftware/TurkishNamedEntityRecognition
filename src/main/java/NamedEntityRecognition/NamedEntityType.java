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
        if (entityType == null){
            return NamedEntityType.NONE;
        } else {
            if (entityType.equalsIgnoreCase("PERSON")){
                return NamedEntityType.PERSON;
            } else {
                if (entityType.equalsIgnoreCase("LOCATION")){
                    return NamedEntityType.LOCATION;
                } else {
                    if (entityType.equalsIgnoreCase("ORGANIZATION")){
                        return NamedEntityType.ORGANIZATION;
                    } else {
                        if (entityType.equalsIgnoreCase("TIME")){
                            return NamedEntityType.TIME;
                        } else {
                            if (entityType.equalsIgnoreCase("MONEY")){
                                return NamedEntityType.MONEY;
                            } else {
                                return NamedEntityType.NONE;
                            }
                        }
                    }
                }
            }
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
