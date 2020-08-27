package com.example.demo.study;

/**
 * @Description: 三目运算
 * @Author: crx
 * @Create: 9:26 2020/5/8
 */
public class ThreeConditionTest {
    public static void main(String[] args) {
        boolean flag = true;
        boolean simpleBoolean = false;
        Boolean objectBoolean = Boolean.FALSE;

        //当第二位和第三位表达式都是对象时，表达式返回值也为对象；
        Boolean x1 = flag ? objectBoolean : objectBoolean;
        //反编译后代码为：Boolean x1 = flag ? objectBoolean : objectBoolean;
        //因为x1的类型是对象，所以不需要做任何特殊操作。

        //当第二位和第三位表达式都为基本类型时，表达式返回值也为基本类型；
        boolean x2 = flag ? simpleBoolean : simpleBoolean;
        //反编译后代码为：boolean x2 = flag ? simpleBoolean : simpleBoolean;
        //因为x2的类型也是基本类型，所以不需要做任何特殊操作。

        //当第二位和第三位表达式中有一个为基本类型时，表达式返回值也为基本类型；
        boolean x3 = flag ? objectBoolean : simpleBoolean;
        //反编译后代码为：boolean x3 = flag ? objectBoolean.booleanValue() : simpleBoolean;
        //因为x3的类型是基本类型，所以需要对其中的包装类进行拆箱。

        //当第二位和第三位表达式都是对象时，表达式返回值也为对象；
        boolean x4 = flag ? objectBoolean : objectBoolean;
        //反编译后代码为：boolean x4 = (flag ? objectBoolean : objectBoolean).booleanValue();
        //因为x4的类型是基本类型，所以需要对表达式结果进行自动拆箱。

        //当第二位和第三位表达式都为基本类型时，表达式返回值也为基本类型；
        Boolean x5 = flag ? simpleBoolean : simpleBoolean;
        //反编译后代码为：Boolean x5 = Boolean.valueOf(flag ? simpleBoolean : simpleBoolean);
        //因为x5的类型是对象类型，所以需要对表达式结果进行自动装箱。

        //当第二位和第三位表达式中有一个为基本类型时，表达式返回值也为基本类型；
        Boolean x6 = flag ? objectBoolean : simpleBoolean;
        //反编译后代码为：Boolean x6 = Boolean.valueOf(flag ? objectBoolean.booleanValue() : simpleBoolean);
        //因为x6的类型是对象类型，所以需要对表达式结果进行自动装箱。
    }
}
