package onskesoen.onskesoen.model;

public class Ønskeliste {
    int id;

    String name;

    public Ønskeliste(){

    }
    public Ønskeliste(int id, String name){
this.id = id;
this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id: "+ id + "- Ønskeliste navn: " + name;

    }
}
