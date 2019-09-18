package TestJavassist;

public class Emp {
    private String name;
    private int age;

    public void sayHello(int a){
        System.out.println("Hello,"+a);
    }
    public Emp() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
