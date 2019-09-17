package Reflact;

/**
 * 利用注解  讲Java语句中的属性转换为sql语句对应的创建表
 */

@Student_table("tb_stu")//设定和哪个表对应
public class Student {
    @myField(coloumName = "stsName",type = "String",len = 10)
    private String name;

    @myField(coloumName = "stsAge",type = "int",len = 3)
    private int age;

    @myField(coloumName = "stsName",type = "int",len = 10)
    private int id;

    public Student() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
