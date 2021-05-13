public class Client {
    private String name;
    private int age;

    public Client(){}

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
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
    
    public static boolean validationAge(int age){
        if(age < 16){
            System.out.println("Idade inválida. A idade mínima deve ser acima de 16 anos.");
            return false;
        }
        return true;
    }

    public static boolean validationName(String name){
        String msg = "Nome inválido! Digite novamente.";
        if(name.length() < 5){
            System.out.println(msg);
            return false;
        }else{
            for (int i = 0; i < 5 ; i++) {
                if(name.charAt(i) == ' '){
                    System.out.println(msg);
                    return false;
                }
            }    
        }
        return true;
    }
}