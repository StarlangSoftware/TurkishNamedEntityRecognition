package NamedEntityRecognition;

public abstract class AutoNER {
    protected Gazetteer personGazetteer;
    protected Gazetteer organizationGazetteer;
    protected Gazetteer locationGazetteer;

    public AutoNER(){
        personGazetteer = new Gazetteer("PERSON", "Data/Ner/gazetteer-person.txt");
        organizationGazetteer = new Gazetteer("ORGANIZATION", "Data/Ner/gazetteer-organization.txt");
        locationGazetteer = new Gazetteer("LOCATION", "Data/Ner/gazetteer-location.txt");
    }

}
