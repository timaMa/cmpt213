package ca.cmpt213.as2;

import java.util.LinkedList;
import java.util.List;

/**
 * {
 *        "name": " ",
 *        "id": " ",
 *        "compatibility": {
 *           "score": ,
 *           "comment": " "
 *        }
 *     }
 *   ],
 *   "extra_comments": "That's all! It was 'fun'! (said....)"
 * }
 * This class is for read this part from Json file
 */

public class TokiFeed {
    private List<TokiInfor> team;
    private String extra_comments;

    public TokiFeed() {
        team = new LinkedList<>();
    }

    public List<TokiInfor> getTeam() {
        return team;
    }
    public String getOtherComments() {
        return extra_comments;
    }

    public void setTeam(List<TokiInfor> team) {
        this.team = team;
    }
    public void setOtherComments(String extra_comments) {
        this.extra_comments = extra_comments;
    }

    public String getTokimonNum() {
        return team.get(0).getId();
    }



}