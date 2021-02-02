package ca.cmpt213.as2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is for read the team name and create the List<Tokimon> tokimons.
 * List<Tokimon> tokimons is for get different teams
 */

public class TokiTeam {
    private String name;
    private List<Tokimon> tokimons = new LinkedList<>();
    public TokiTeam(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public List<Tokimon> getTokimons() {
        return tokimons;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setTokimons(List<Tokimon> tokimons) {
        this.tokimons = tokimons;
    }



    public boolean isValid() {
        int size = tokimons.size();
        for(Tokimon tokimon:tokimons) {
            if(tokimon.getTokiFeed().getTeam().size() != size) {
                return false;
            }
        }
        return true;
    }

    public String toCSV() {
        Collections.sort(tokimons,new Comparator<Tokimon>() {
            @Override
            public int compare(Tokimon t1, Tokimon t2) {
                return t1.getNum().compareTo(t2.getNum());
            }
        });
        StringBuffer str = new StringBuffer();
        str.append(name+",,,,,,\n");

        for(Tokimon tokimon:tokimons) {
            Collections.sort(tokimon.getTokiFeed().getTeam(),new Comparator<TokiInfor>() {
                @Override
                public int compare(TokiInfor t1, TokiInfor t2) {
                    return t1.getId().compareTo(t2.getId());
                }
            });
            String tokimonno = tokimon.getNum();
            TokiFeed f = tokimon.getTokiFeed();
            String outToki = "";
            for(TokiInfor tokiInfor : f.getTeam()) {
                if(tokiInfor.getId().equals(tokimonno)) {
                    outToki = ","+tokimonno+","+"-"+","+ tokiInfor.getCompatibility().toString()+","+f.getOtherComments()+"\n";

                }else {
                    str.append(","+tokimonno+","+ tokiInfor.toString()+",\n");
                }
            }
            str.append(outToki);

        }
        str.append(",,,,,,\n");
        return str.toString();
    }

}
