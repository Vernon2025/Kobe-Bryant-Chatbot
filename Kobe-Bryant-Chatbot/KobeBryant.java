public class KobeBryant {

    public String getGreeting() {
        return "Hi";
    }

    public String getResponse(String statement) {
        statement.trim();
        String sentence = "";
        switch (statement) {
            case "cool":
                sentence = "Im cool";
                break;
            default:
                sentence = getRandomResponse();
                break;
        }
        return sentence;
    }

    private String getRandomResponse() {
        int min = 1;
        int max = 3;
        int random = (int) (Math.random() * max) + min;
        String sentence = "";
        if (random == 1) {
            sentence = "That is interesting man!";
        } else if (random == 2) {
            sentence = "Tell me more I'm actually interested";
        } else if (random == 3) {
            sentence = "Woah! That is cool!";
        }

        return sentence;

    }

    private String findKeyword(String statement) {
        return "";
    }
}