package Class4_2908;

public class Email {
    public boolean isValid(String email) {
        int atCount = 0;

        if (email.isEmpty()){
            return false;
        }

        char[] emailChars = email.toCharArray();
        for (int i = 0; i < email.length(); i++) {
            if (i == 0 && emailChars[i] == '@'){
                return false;
            }

            if (i == email.length() - 1 && emailChars[i] == '@'){
                return false;
            }

            if (emailChars[i] == '@'){
                atCount++;
            }
        }

        if (atCount == 0 || atCount > 1){
            return false;
        }

        boolean flag = false;
        for (int i = email.indexOf('@'); i < email.length(); i++) {
            if (emailChars[i] == '.'){
                if (flag) {
                    return false;
                }
                if (emailChars[i+1] == '@' || emailChars[i-1] == '@'){
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }
}
