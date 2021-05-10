public class Client {
    private String name;
    private int age;

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
        validationAge();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isElderly() {
        return (age >= 60);
    }
    
    public void validationAge(){
        if(this.age < 16){
            this.age = 18;
        }
    }

    public boolean validationName(){
        for (int i = 0; i < 4; i++) {
            if(name.charAt(i) == ' '){
                return false;
            }
        }
        return true;
    }
}