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
 * This class is for help TokiInfor class to read the compatibility
 * name and id is for read the tokimon's compatibility
 * The getter fuctions is for return the compatibility of Tokimons
 * The setter fuctions is for reset the compatibility of Tokimons
 */
public class Compatibility {
    private double score;
    private String comment;
    public double getScore() {
        return score;
    }
    public String getComment() {
        return comment;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString() {
        String tComment = comment.replace("\n", " ");
        return ""+score+","+tComment+",";
    }
}
