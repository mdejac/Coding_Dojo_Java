import java.util.HashMap;
import java.util.Set;

public class SongLyrics {
    public static void main (String[] args) {
        
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Row Row Row Your Boat", "Row, row, row your boat\nGently down the stream\nMerrily merrily, merrily, merrily\nLife is but a dream\nRow, row, row your boat\nGently down the stream\nMerrily merrily, merrily, merrily\nLife is but a dream\nRow, row, row your boat\nGently down the stream\nMerrily merrily, merrily, merrily\nLife is but a dream\nRow, row, row your boat\nGently down the stream\nMerrily merrily, merrily, merrily\nLife is but a dream\n");
        trackList.put("London Bridge is falling down", "London Bridge is falling down\nFalling down, falling down\nLondon Bridge is falling down\nMy fair lady\nLondon Bridge is falling down\nFalling down, falling down\nLondon Bridge is falling down\nI am here lady\nLondon Bridge is falling down\nFalling down, falling down\nLondon Bridge is falling down\nMy fair lady\nLondon Bridge is falling down\nFalling down, falling down\nLondon Bridge is falling down\nMy fair lady\nLondon Bridge is falling down\nFalling down, falling down\nLondon Bridge is falling down\nI am here lady\n");
        trackList.put("Old MacDonald", "Old MacDonald had a farm\nEe i ee i o\nAnd on his farm he had some cows\nEe i ee i oh\nWith a moo-moo here\nAnd a moo-moo there\nHere a moo, there a moo\nEverywhere a moo-moo\nOld MacDonald had a farm\nEe i ee i o\nOld MacDonald had a farm\nEe i ee i o\nAnd on his farm he had some chicks\nEe i ee i o\nWith a cluck-cluck here\nAnd a cluck-cluck there\nHere a cluck, there a cluck\nEverywhere a cluck-cluck\nOld MacDonald had a farm\nEe i ee i o\nOld MacDonald had a farm\nEe i ee i o\nAnd on his farm he had some pigs\nEe i ee i o\nWith an oink-oink here\nAnd an oink-oink there\nHere an oink, there an oink\nEverywhere an oink-oink\nOld MacDonald had a farm\nEe i ee i o\n");
        trackList.put("The wheels on the bus", "The wheels on the bus go round and round,\nround and round,\nround and round.\nThe wheels on the bus go round and round,\nall through the town.\n\nThe wipers on the bus go swish, swish, swish;\nSwish, swish, swish;\nSwish, swish, swish.\nThe wipers on the bus go Swish, swish, swish,\nall through the town.\n\nThe horn on the bus goes beep, beep, beep;\nBeep, beep, beep;\nBeep, beep, beep.\nThe horn on the bus goes beep, beep, beep,\nall through the town…\n\nThe money on the bus goes, clink, clink, clink;\nClink, clink, clink;\nClink, clink, clink.\nThe money on the bus goes, clink, clink, clink,\nall through the town.\n\nThe Driver on the bus says “Move on back,\nmove on back, move on back;”\nThe Driver on the bus says “Move on back,”\nall through the town.\n\nThe baby on the bus says “Wah, wah, wah;\nWah, wah, wah;\nWah, wah, wah”.\nThe baby on the bus says “Wah, wah, wah,”\nall through the town.\n\nThe mommy on the bus says “Shush, shush, shush;\nShush, shush, shush;\nShush, shush, shush.”\nThe mommy on the bus says “Shush, shush, shush,”\nall through the town.\n");

        String song = trackList.get("Row Row Row Your Boat");
        System.out.println(song);  

        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println(key);
            System.out.println("-".repeat(key.length()));
            System.out.println(trackList.get(key)+"\n");
        }
    }
}