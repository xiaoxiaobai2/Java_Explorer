package Reflact;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射
 *    动态获取对象  和方法
 */
public class Demo03 {
    public static void main(String[] args) {
        Class clazz;
        try {
            System.out.println("***********动态创建对象*********");
            clazz=Class.forName("Reflact.Student");
            Student student=(Student)clazz.newInstance();//通过无参构造器实例化对象
            System.out.println("***********动态获得方法、并给定数据*******");
            Method method=clazz.getMethod("setName", String.class);//方法名，含有的参数（防止重载）
            method.invoke(student,"zhanghao");//此方法类似   student.setName(),但是后期  可动态获取调用方法
            System.out.println(student.getName());
            System.out.println("***********动态获得属性、并给属性设置（Age=18)*******");
            Field age=clazz.getDeclaredField("age");//获取age属性
            age.setAccessible(true);//不用做安全检查
            System.out.println(age.get(student));//获得 student对象的age属性的值
            age.set(student,18);//给 student对象  的age属性设值
            System.out.println(student.getAge());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
