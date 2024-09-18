package SocialMedia_Challenge;

import java.time.LocalDate;

public class Post {
    private final String quote;
    private final LocalDate date;
    private int claps;
    private int boos;
    private final UserAccount account;

    public Post(UserAccount account, String quote){
        this.quote = quote;
        this.date = LocalDate.now();
        this.account = account;
    }

    public String show(){
        StringBuilder output = new StringBuilder();

        output.append("[").append(date).append("]");
        output.append(account.getUserName()).append(" says ");
        output.append("\"").append(quote).append("\"").append(" | ");
        output.append("Claps: ").append(claps).append(" | ");
        output.append("Boos: ").append(boos).append(".");

        return output.toString();
    }

    public void clap(){
        claps++;
    }

    public void boo(){
        boos++;
    }
}
