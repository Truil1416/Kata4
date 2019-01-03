package kata4.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kata4.model.Mail;

public class MailListReader {
    
    public List<Mail> read(String fileName){
        List<Mail> list = new ArrayList<>();
        File textFile = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = null;
            try {
                while((line = br.readLine()) != null){
                    Pattern p = Pattern.compile("^.+@.+\\..+$");
                    if(p.matcher(line).matches()){
                        list.add(new Mail(line));
                    }
                }
                return list;
            } catch (IOException ex) {
                return null;
            }
        } catch (FileNotFoundException ex) {
            return null;
        }
    }
    
}
