package Reflact;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException {
        String s1="123456";
        String s2="a.dkjl;kj";
        //所有String都被映射在同一个class中
        System.out.println(s1.getClass().hashCode());
        System.out.println(s2.getClass().hashCode());
        System.out.println(String.class.hashCode());

    }
}
