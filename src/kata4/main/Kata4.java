package kata4.main;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {

    private String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;

    public static void main(String[] args) {
        Kata4 proyect = new Kata4("email.txt");
        proyect.execute();
    }

    public Kata4(String fileName) {
        this.fileName = fileName;
    }
    
    private void execute(){
        input();
        process();
        output();
    }
    
    private void input(){
        MailListReader reader = new MailListReader();
        mailList = reader.read(fileName);
    }
    
    private void process(){
        MailHistogramBuilder builder = new MailHistogramBuilder();
        histogram = builder.build(mailList);
    }
    
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}
