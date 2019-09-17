package Reflact;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface myField {
    String coloumName();//定义列名
    String type();//定义属性类型
    int len();//定义属性长度

}
