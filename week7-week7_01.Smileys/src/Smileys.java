
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String characterString){
        String st = ":)";
        
        if(characterString.length() % 2 == 0){
            printRow(characterString, st);
            System.out.println(st + " " + characterString + " " + st);
            printRow(characterString, st);
        }else{
            printOddRow(characterString, st);
            System.out.println(st + " " + characterString + "  " + st);
            printOddRow(characterString, st);
        }
    }
    
    private static void printRow(String characterString, String st){
        for(int i = 0; i <= (characterString.length()+4)/2; i++){
            System.out.print(st);
        }
        System.out.println("");
    }
    
    private static void printOddRow(String characterString, String st){
        for(int i = 0; i <= (characterString.length()+4)/2+1; i++){
            System.out.print(st);
        }
        System.out.println("");
    }

}
