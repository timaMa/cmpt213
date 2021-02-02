package ca.cmpt213.as2;

/**
 * In json file
 * "team": [
 *     {
 *        "name": " ",
 *        "id": " ",
 *        "compatibility": {
 *           "score": ,
 *           "comment": " "
 *        }
 *     }
 * }
 * This class is for read this part ( about Tokimons information).
 * name and id is for read the tokimon's name and id
 * compatibility is from the Compatibility class, for read the Tokimon's compatibility
 * The getter fuctions is for return the information's of Tokimons
 * The setter fuctions is for reset the information's of Tokimons
 */
public class TokiInfor {
    private String name;
    private String id;
    private Compatibility compatibility;
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public Compatibility getCompatibility() {
        return compatibility;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCompatibility(Compatibility compatibility) {
        this.compatibility = compatibility;
    }

    public String toString() {
        return id+","+compatibility.toString();
    }

}
