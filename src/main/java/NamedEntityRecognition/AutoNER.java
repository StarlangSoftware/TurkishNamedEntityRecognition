package NamedEntityRecognition;

public abstract class AutoNER {
    protected Gazetteer personGazetteer;
    protected Gazetteer organizationGazetteer;
    protected Gazetteer locationGazetteer;

    public AutoNER(){
        personGazetteer = new Gazetteer("PERSON", "gazetteer-person.txt");
        organizationGazetteer = new Gazetteer("ORGANIZATION", "gazetteer-organization.txt");
        locationGazetteer = new Gazetteer("LOCATION", "gazetteer-location.txt");
    }

}
