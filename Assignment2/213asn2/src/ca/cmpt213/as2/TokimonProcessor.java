package ca.cmpt213.as2;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * read all json file and output to csv file
 * Enter the program arguments: fist is the json file's pathname, and the second one is where to store the csv file
 * csv file will be creat after run TokimonProcessor, just give the pathname where to store the csv file
 */

public class TokimonProcessor {
    public static void main(String[] args) {
        String pathInput = args[0];
        String pathOutput = args[1];
        if(args.length != 2) {
            System.out.println("Please only enter two arguement");
            return;
        }

        List<String> filelist = TokiGson.getFileList(pathInput);
        if(filelist.size() == 0) {
            System.out.println("File Not Exist!");
            return;
        }
        Map<String, TokiTeam> teamMap = new HashMap<>();
        for(String filename:filelist) {
            TokiFeed tokiFeed = TokiGson.getTokiFeed(filename);
            String tokimonNum = tokiFeed.getTokimonNum();
            Tokimon toki = new Tokimon(tokimonNum, tokiFeed);
            String tName = toki.getTeamName();
            if(!teamMap.containsKey(tName)) {
                TokiTeam tokiTeam = new TokiTeam(tName);
                teamMap.put(tName, tokiTeam);
            }
            TokiTeam tokiTeam = teamMap.get(tName);
            tokiTeam.getTokimons().add(toki);
        }


        StringBuffer str = new StringBuffer();
        str.append("TokiTeam#,From Toki,To Toki,Score,TokiInfor,,Extra\n");
        List<String> teName= new LinkedList<>();
        for(String name:teamMap.keySet()) {
            teName.add(name);
        }
        Collections.sort(teName);
        for(String name:teName) {

            TokiTeam tokiTeam = teamMap.get(name);
            if(!tokiTeam.isValid()) {
                System.out.println("Please include all tokimons ");
                return;
            }
            str.append(tokiTeam.toCSV());
        }
        TokiGson.toFile(pathOutput, str.toString());

    }

}

