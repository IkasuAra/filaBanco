public class Client {
    private String name;
    private int age;
    
    public Client(String name, int age){
        setName(name);
        setAge(age);
    }

    private void setName(String name){
        this.name = name;
    }

    private void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public boolean validationName(){
        for (int i = 0; i < 4; i++) {
            if(name.charAt(i) == ' '){
                return false;
            }
        }
        return true;
    }

    public boolean validationAge(){
        if(age > 16){
            this.age = 18;
            return false;
        }
        return true;
    }

    public boolean isElderly(){
        return (age >= 60);
    }    
}