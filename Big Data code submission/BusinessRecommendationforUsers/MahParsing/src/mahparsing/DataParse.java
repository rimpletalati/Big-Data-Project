/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahparsing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author dishujindal
 */
public class DataParse {
        String readLine="8736	[70050:3.0,44597:3.0,27846:3.0,64019:3.0,59391:2.0,61307:2.0,39121:2.0,72172:2.0,65451:2.0,30604:2.0]";
        HashMap <String, HashMap<String,String>> map=new HashMap<>();
        String inputLine=null;
        private BufferedReader reader = null;
        String filePath="/Users/dishujindal/input.txt";
        String filename="/Users/dishujindal/mahoutput.csv";
        private static final String COMMA_DELIMITER = ",";
        private static final String NEW_LINE_SEPARATOR = "\n";
        private static final String FILE_HEADER = "userid,businessid,value";

        
        
        
        public void dataParse() throws IOException
        {
           reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)), 1024 * 100);
           inputLine = reader.readLine();
            //inputLine="8736	[70050:3.0,44597:3.0,27846:3.0,64019:3.0,59391:2.0,61307:2.0,39121:2.0,72172:2.0,65451:2.0,30604:2.0]";
            int co=0;
            while (inputLine != null) 
            {
                HashMap<String,String>inner=new HashMap<>();
                int pos= inputLine.indexOf("[");
                String key=inputLine.substring(0, pos).trim();
                String value= inputLine.substring(pos+1,inputLine.length());
                String[]subValues=value.split(",");
                for(int i=0; i< subValues.length; i++)
                {
                    int loc=subValues[i].indexOf(":");
                    String innerkey= subValues[i].substring(0,loc);
                    String innervalue= subValues[i].substring(loc+1,subValues[i].length()-1);
                    inner.put(innerkey, innervalue);
                }
                map.put(key, inner);
                co=co+1;
                System.out.println(co);
                inputLine=reader.readLine();
            }
           
            try (FileWriter fileWriter = new FileWriter(filename)) {
                fileWriter.append(FILE_HEADER.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
                
                
                
                for (HashMap.Entry<String, HashMap<String, String>> letterEntry :map.entrySet()) 
                {
                    String userid = letterEntry.getKey();
                    // ...
                    for (HashMap.Entry<String, String> nameEntry : letterEntry.getValue().entrySet())
                    {
                        String businessid = nameEntry.getKey();
                        String value = nameEntry.getValue();
                        fileWriter.append(userid);
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(businessid);
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(value);
                        fileWriter.append(NEW_LINE_SEPARATOR);
                        
                    }
                }
                
                fileWriter.flush();
            }

            
        }
        
        
}
