package TestDynamicComplie;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 *   把Java代码写到文件里，在进行动态编译
 *        把Java文件写到文件里，动态运行，并获取输出结果
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        String java_code="public class HelloWorld{public static void main(String[] args){System.out.println(\"Hello,world!\");}}";
        String path ="HelloWorld.java";
        FileOutputStream file =new FileOutputStream(path);
        file.write(java_code.getBytes());
        file.flush();
        file.close();
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,path);
        System.out.println(result==0?"编译成功":"编译失败");

        //运行Java文件
        Runtime run=Runtime.getRuntime();
        Process process=run.exec("java -cp  C:/Users/张浩/Desktop/Java/Java_code/Java_Anonation HelloWorld");
        InputStream is=process.getInputStream();
        BufferedReader bf=new BufferedReader(new InputStreamReader(is));
        String car="";
        while (null!=(car=bf.readLine()))
            System.out.println(car);
    }
}
