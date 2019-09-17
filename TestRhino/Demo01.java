package TestRhino;


import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        //获得脚本引擎对象
        ScriptEngineManager engineManager=new ScriptEngineManager();
        ScriptEngine engine=engineManager.getEngineByName("javascript");

        System.out.println("***********************");
        //定义变量，存储到上下文
        engine.put("msg","zhanghao is a good man");
        String str="var user = {name:'张浩',age:24};";
        str +="print(user.name);";
        //执行脚本
        engine.eval(str);
        //通过脚本修改MSG
        engine.eval("msg=\"张浩是个好男人\";");
        System.out.println(engine.get("msg"));
        System.out.println("****执行脚本函数******");
        //定义函数
        engine.eval("function add(a,b){var sum=a+b;return sum;}");
        //取得调用接口
        Invocable invocable=(Invocable)engine;
        //执行函数
        Object result=invocable.invokeFunction("add",new Object[]{10,20});
        System.out.println(result);
        System.out.println("\n\n****导入其他Java包，调用包中的类****");
        String s="var list= java.util.Arrays.asList([\"西北大学\",\"北京大学\"]);";
        engine.eval(s);
        List<String> list=(List<String>)engine.get("list");
        for (String a :
                list) {
            System.out.println(a);
        }
    }
}
