
import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations requested in the assignment here!
        HashMap<String, String> nick = new HashMap<String, String>();
        
        nick.put("matti", "mage");
        nick.put("mikael", "mixu");
        nick.put("arto", "arppa");
        String getN = nick.get("mikael");
        System.out.println(getN);
    }

}
