package TestJavassist;

import javassist.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * 测试Javassist 的API
 */
public class Demo02 {
    public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        test01();
//        test02();
//        test03();
        test04();
    }


    /**
     * 测试获取一个类
     * @throws NotFoundException
     * @throws IOException
     * @throws CannotCompileException
     */
    public static void test01() throws NotFoundException, IOException, CannotCompileException {
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.get("TestJavassist.Demo01");
        byte[] bytes=cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(cc.getName());
        System.out.println(cc.getPackageName());
        System.out.println(cc.getSimpleName());
        System.out.println(cc.getSuperclass());//获得父类
    }

    /**
     * 测试生成一个方法，并调用
     */
    public static void test02() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.getCtClass("TestJavassist.Emp");
        //创建方法
        CtMethod method=CtMethod.make("public int add(int a,int b){return a+b;}",cc);
        //创建方法
//        CtMethod method =new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
//        method.setModifiers(Modifier.PUBLIC);
//        method.setBody("{System.out.println($1+$2);return $1+$2;}");
        cc.addMethod(method);

        //通过反射调用方法
        Class clazz=cc.toClass();
        Object obj=clazz.newInstance();//通过调用构造方法实例化一个对象
        Method method1=clazz.getDeclaredMethod("add",int.class,int.class);
        Object result = method1.invoke(obj,20,30);
        System.out.println(result);
    }

    /**
     *     修改已有的方法
     */
    public static void test03() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.getCtClass("TestJavassist.Emp");
        //修改方法
        CtMethod method=cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
        method.insertBefore("System.out.println(\"张浩\");System.out.println($1);");
        //调用方法
        Class clazz=cc.toClass();
        Object obj=clazz.newInstance();//通过调用构造方法实例化一个对象
        Method method1=clazz.getDeclaredMethod("sayHello",int.class);
        method1.invoke(obj,20);
    }

    /**
     * 快速增加set/GET 方法
     */
    public static void test04() throws NotFoundException, CannotCompileException, NoSuchFieldException {
        System.out.println("**********启动Test04***********");
        ClassPool pool=ClassPool.getDefault();
        CtClass cc =pool.getCtClass("TestJavassist.Emp");
        CtField field=new CtField(pool.getCtClass("java.lang.String"),"school",cc);
        field.setModifiers(Modifier.PRIVATE);
        cc.addField(field);
        cc.addMethod(CtNewMethod.setter("setSchool",field));
        cc.addMethod(CtNewMethod.getter("getSchool",field));

    }
}
