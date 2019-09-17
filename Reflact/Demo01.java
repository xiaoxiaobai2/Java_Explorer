package Reflact;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz=Class.forName("Reflact.Student");
        //获得类的所有注解
        Annotation[] annotations=clazz.getAnnotations();
        for (Annotation a:annotations)
            System.out.println(a);
        System.out.println("***************获得类的特定属性（age）********");
        //获得类的特定属性
        Field f=clazz.getDeclaredField("age");
        //获得属性的注解
        myField field=f.getAnnotation(myField.class);
        //通过注解找到注解信息
        System.out.println(field.type());
        System.out.println("***************获得类的所有属性的列名********");
        //获得类的所有属性
        Field[] fields=clazz.getDeclaredFields();
        for (Field f2:fields){
            System.out.println(f2.getAnnotation(myField.class).coloumName());
        }
        System.out.println("***************获得类的所有方法********");
        //注意获得指定方法时后面要加参数类型，因为有重载
        Method[] methods=clazz.getDeclaredMethods();
        for (Method m:methods)
            System.out.println(m);
    }
}
