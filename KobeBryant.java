import java.util.Random;

public class KobeBryant {
    private final String[] randomResponses = {"Interesting, tell me more",
            "Hmmm.",
            "Do you really think so?",
            "You don't say."
    };

    public String getGreeting() {
        return "Hello, let's talk.";
    }

    public String getResponse(String statement) {
        String response = "";

        if (statement.length() == 0) {
            response = "Say something, please.";
        } else if (findKeyword(statement, "no") >= 0) {
            response = "Why so negative?";
        } else if (findKeyword(statement, "I want to", 0) >= 0) {
            response = transformIWantToStatement(statement);
        } else if (findKeyword(statement, "I want", 0) >= 0) {
            response = transformIWantStatement(statement);
        } else if (findKeyword(statement, "famous") >= 0) {
            response = "I am famous for being a professional basketball player.";
        } else if (findKeyword(statement, "married") >= 0 || 
                   findKeyword(statement, "marry") >=0) {
            
            response = "Yes, I was married to Vanessa Laine Bryant.";
        } else if (findKeyword(statement, "children") >= 0) {
            response = "I have four daughters";
        } else if (findKeyword(statement, "names") >= 0) {
            response = "Their names are Natalia, Gianna, Bianka, and Capri";
        } else if (findKeyword(statement, "born") >= 0) {
            response = "I was born on August 23, 1978, in Philadelphia, Pennsylvania.";
        } else if (findKeyword(statement, "live") >= 0) {
            response = "I lived in Newport Beach, California, United States.";
        } else if (findKeyword(statement, "name") >= 0 || 
                   findKeyword(statement, "are") >= 0) {
            response = "I am Kobe Bryant.";
        } else {
            response = getRandomResponse();
        }

        return response;
    }

    private String transformIWantToStatement(String statement) {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword(statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }

    private String transformIWantStatement(String statement) {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword(statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Would you really be happy if you had " + restOfStatement + "?";
    }

    private String transformYouMeStatement(String statement) {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psnOfYou = findKeyword(statement, "you", 0);
        int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }

    private String transformIYouStatement(String statement) {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psnOfI = findKeyword(statement, "I", 0);
        int psnOfYou = findKeyword(statement, "you", psnOfI);
        String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
        return "Why do you " + restOfStatement + " me?";
    }

    private int findKeyword(String statement, String goal, int startPos) {
        String phrase = statement.trim();
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        while (psn >= 0) {
            String before = " ", after = " ";
            if (psn > 0) {
                before = phrase.substring(psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length()) {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
                return psn;
            }
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
        }
        return -1;
    }

    private int findKeyword(String statement, String goal) {
        return findKeyword(statement, goal, 0);
    }

    private String getRandomResponse() {
        Random r = new Random();
        return randomResponses[r.nextInt(randomResponses.length)];
    }
}
