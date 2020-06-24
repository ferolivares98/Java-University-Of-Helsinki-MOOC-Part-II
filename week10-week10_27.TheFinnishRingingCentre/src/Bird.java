
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null) {
            return false;
        }
        if (!(o instanceof Bird)) {
            return false;
        }

        Bird comp = (Bird) o;

        return this.latinName.equals(comp.latinName) && this.ringingYear == comp.ringingYear;
    }
    
    @Override
    public int hashCode() {
        return this.latinName.hashCode() + this.ringingYear; //Hash del nombre en latín + el añó deben coincidir.
    }
}


