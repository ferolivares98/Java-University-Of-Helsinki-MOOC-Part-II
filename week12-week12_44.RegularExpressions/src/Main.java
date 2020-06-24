
public class Main {

    public static void main(String[] args) {
        // write test code here
    }
    
    public static boolean isAWeekDay(String string){
        if(string.matches("mon|tue|wed|thu|fri|sat|sun")){
            return true;
        }
        return false;
    }
    
    public static boolean allVowels(String string){
        if(string.matches("(a|e|i|o|u|ä|ö)*")){
            return true;
        }
        return false;
    }
    
    public static boolean clockTime(String string){
        //return string.matches("([01][0123456789]|2[0123]):[012345][0123456789]:[012345][0123456789]");
        //O con split y mirar int...
        if(string.matches("([01][0-9]|2[0-3])(:[0-5][0-9]){2}")){
            return true;
        }
        return false;
    }
}
