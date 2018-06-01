package NamedEntityRecognition;

public enum NamedEntityType {
    NONE, PERSON, ORGANIZATION, LOCATION, TIME, MONEY;

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
