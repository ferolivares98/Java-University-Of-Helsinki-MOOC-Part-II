package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if(name != null && !(name.isEmpty()) && name.length() <= 40){
            this.name = name;
        }else{
            throw new IllegalArgumentException("The name can't be null, empty or longer than 40 characters");
        }
        
        if(age >= 0 && age <= 120){
            this.age = age;
        }else{
            throw new IllegalArgumentException("Age has to be between 0-120");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
