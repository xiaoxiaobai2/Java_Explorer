package Reflact;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 利用反射获取被擦除的泛型
 */
public class Demo04 {
    public static void main(String[] args) {
        try {
            System.out.println("*************获得指定方法泛型**********");
            //获得指定方法泛型
            Method method=Demo04.class.getMethod("test01", Map.class, int.class);
            Type[] types=method.getGenericParameterTypes();
            for (Type t:
                 types) {
                System.out.println(t.getTypeName());
                if (t instanceof ParameterizedType){
                    Type[] genericTypes = ((ParameterizedType)t).getActualTypeArguments();//获得泛型信息
                    for (Type t2:
                         genericTypes) {
                        System.out.println("泛型类型："+t2);
                    }
                }
            }

            System.out.println("\n\n*************获得指定方法返回参数泛型信息**********");
            Method method1=Demo04.class.getMethod("test02",null);
            Type returnType =method1.getGenericReturnType();
            System.out.println(returnType);
            if (returnType instanceof ParameterizedType){
                Type[] genericTypes = ((ParameterizedType)returnType).getActualTypeArguments();
                for (Type t:
                     genericTypes) {
                    System.out.println("返回参数泛型类型："+ t);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void test01(Map<String,Integer> map,int i){

    }

    public static Map<Integer,Character> test02(){
        Map<Integer,Character> map=new HashMap<>();
        map.put(1,'1');
        return map;
    }
}
