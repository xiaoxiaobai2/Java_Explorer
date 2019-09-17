package TestJavassist;

import javassist.*;

import java.io.IOException;

/**
 * 测试使用javassist创建一个新的类
 */
public class Demo01 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        //获取类池
        ClassPool classPool=ClassPool.getDefault();
        //类名
        CtClass emp=classPool.makeClass("Emp");
        //创建属性
        CtField field1=CtField.make("private String name;",emp);
        CtField field2=CtField.make("private int age;",emp);
        emp.addField(field1);
        emp.addField(field2);
        //创建方法
        CtMethod method1=CtMethod.make("public void setName(String name){this.name=name;}",emp);
        CtMethod method2=CtMethod.make("public String getName(){return this.name;}",emp);
        emp.addMethod(method1);
        emp.addMethod(method2);
        //创建构造方法
        CtConstructor constructor=new CtConstructor(new CtClass[]{CtClass.intType,classPool.get("java.lang.String")},emp);
        constructor.setBody("{this.age=age;this.name=name;}");
        emp.addConstructor(constructor);
        //写出类文件
        emp.writeFile("C:\\Users\\张浩\\Desktop\\Java\\Java_code\\Java_Explorer\\src\\TestJavassist");

    }
}
