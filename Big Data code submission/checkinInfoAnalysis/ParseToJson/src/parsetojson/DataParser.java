/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsetojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author dishu Jindal
 */
public class DataParser {

    private BufferedReader reader = null;
    private String inputLine = null;
    private String filePath = null;
    private int ID;
    FileWriter writer;

    public DataParser(String filePath) throws IOException {
        this.filePath = filePath;
    }

    public void parse() {
        try {
            if (reader != null) {
                reader.close();
            }
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)), 1024 * 100);
            inputLine = reader.readLine();
            while (inputLine != null) {
                inputLine = processInputLines(reader, inputLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String processInputLines(BufferedReader reader, String input) throws IOException {

        writer = new FileWriter("/Users/dishujindal/testOutput.json", true);
        CompleteObject co = new CompleteObject();

        String line = input;
        String output = null;
            //System.out.println(line);
            int index = line.indexOf("business_id");
            output=inputLine.substring(index+15,inputLine.length()-2);
        
        co.setBusiness_id(output);
        
        //int count = (int)Math.round(Math.random()*10);
        
        co.getCheckinInfo().setMm((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setMa((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setMe((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setTa((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setTe((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setTm((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setWm((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setWa((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setWe((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setThm((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setTha((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setThe((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setFm((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setFa((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setFe((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setSa((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setSm((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setSe((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setSum((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setSua((int)Math.round(Math.random()*10));
        co.getCheckinInfo().setSue((int)Math.round(Math.random()*10));
        
        
        
//System.out.println("complete object: "+co);
        Gson gson = new Gson();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(co);
        writer.write(json + "\n");
        writer.close();
        line = reader.readLine();
        return line;
    }

}
