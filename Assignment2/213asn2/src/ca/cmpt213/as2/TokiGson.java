package ca.cmpt213.as2;

/**
 * get the TokiFeed from the json file
 * and then read all json file
 * then output to the csv file
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TokiGson {
    public static TokiFeed getTokiFeed(String file) {
        try {
            String path = file;
            JsonParser jp = new JsonParser();
            BufferedReader insert = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"),  50 * 1024 * 1024);
            JsonObject obj = (JsonObject) jp.parse(insert);
            Gson gson = new Gson();
            TokiFeed toki = gson.fromJson(obj, TokiFeed.class);
            return toki;
        } catch (Exception e) {
            System.out.println("File Not Exist!");
        }
        return null;
    }
    public static List<String> filelist = new LinkedList<>();
    public static List<String> getFileList(String s) {
        File f = new File(s);
        File[] files = f.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fName = files[i].getName();
                if (files[i].isDirectory()) {
                    getFileList(files[i].getAbsolutePath());
                }
                else if (fName.endsWith("json")) {
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println(strFileName);
                    filelist.add(strFileName);
                }
                else {
                    continue;
                }
            }

        }
        return filelist;
    }

    public static void toFile(String file, String str) {
        try {
            FileWriter Fwrit = new FileWriter(file+"/team_info.csv");
            Fwrit.write(str);
            Fwrit.flush();
            Fwrit.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}