import java.util.Date;
import java.text.SimpleDateFormat;

public class AlfredQuotes {
    Date date = new Date();

    public String basicGreeting(){
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        return String.format("Hello, %s, lovely to see you. How are you?", name);
    }

    public String guestGreeting() {
        SimpleDateFormat militaryDateFormatter = new SimpleDateFormat("k");
        int hour = Integer.parseInt(militaryDateFormatter.format(date));
        String dayPeriod = hour > 4 && hour < 12 ? "morning" : hour > 12 && hour < 18 ? "afternoon" : "night";
        
        return String.format("Good %s. Lovely to see you.", dayPeriod);
    }

    public String dateAnnouncement() {
        return "It is currently " + date + ".";
    }

    public String respondBeforeAlexis(String conversation) {
        return conversation.indexOf("Alexis") != -1 ? "Right away, sir. She certainly isn't sophisticated enough for that." : conversation.indexOf("Alfred") != -1 ? "At your service. As you wish, naturally." : "Right. And with that I shall retire.";
    }

    public String emergencyResponse(String name) {
        return name == "Bruce" ? "Bruce, it's the red phone." : String.format("I am sorry, %s, I must show you out.", name);
    }
}