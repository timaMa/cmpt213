package ca.cmpt213.as2;

/**
 * This class is for read the Tokimon's number and use the TokiFeed.
 */
public class Tokimon {
    private String num;
    private TokiFeed tokiFeed;
    public String getNum() {
        return num;
    }
    public TokiFeed getTokiFeed() {
        return tokiFeed;
    }
    public void setNum(String n) {
        this.num = n;
    }

    public void setTokiFeed(TokiFeed tokiF) {
        this.tokiFeed = tokiF;
    }
    public Tokimon(String n, TokiFeed tokiFeed) {
        this.num = n;
        this.tokiFeed = tokiFeed;
    }


    public String getTeamName() {
        String Tname = tokiFeed.getTeam().get(0).getName();
        return Tname.split(" ")[0];
    }

}
