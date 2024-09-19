package Hotel_Challenge;

public class Guest {
    private final String ssn;
    private final String name;
    private final String email;

    public Guest(String ssn, String email, String name) {
        this.ssn = ssn;
        this.email = email;
        this.name = name;
    }

    public String getSsn(){
        return ssn;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}
