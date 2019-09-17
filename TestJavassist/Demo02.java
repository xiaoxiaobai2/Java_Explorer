package TestJavassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 测试Javassist 的API
 */
public class Demo02 {
    public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException {
        test01();
    }

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
}
