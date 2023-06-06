public class AlfredTest {
    
    public static void main (String[] args) {

        AlfredQuotes alfredBot = new AlfredQuotes();

        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        
        String alexisTest = alfredBot.respondBeforeAlexis("Alexis! Play some low-fi beats.");
        String alfredTest = alfredBot.respondBeforeAlexis("I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelavantTest = alfredBot.respondBeforeAlexis("Maybe that's what Batman is about. Not winning. But failing..");      

        System.out.println(testGreeting + "\n");
        System.out.println(testGuestGreeting + "\n");
        System.out.println(testDateAnnouncement + "\n");
        System.out.println(alexisTest + "\n");
        System.out.println(alfredTest + "\n");
        System.out.println(notRelavantTest + "\n");

        System.out.println(alfredBot.emergencyResponse("Bruce") + "\n");
        System.out.println(alfredBot.emergencyResponse("Vicki") + "\n");

        System.out.println(alfredBot.guestGreeting());
    }
}