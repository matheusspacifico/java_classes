package Class4_2908;

public class Main {
    public static void main(String[] args) {
        String email1 = "teste@gmail.com";
        String email2 = "teste@teste@gmail.com";
        String email3 = "teste@gmail.gmail.com";
        String email4 = "teste@.com";
        String email5 = "";

        Email email = new Email();
        System.out.println(email.isValid(email1));
        System.out.println(email.isValid(email2));
        System.out.println(email.isValid(email3));
        System.out.println(email.isValid(email4));
        System.out.println(email.isValid(email5));
    }
}