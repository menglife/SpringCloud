package com.zmn.springcloud.jdk8;

import com.zmn.springcloud.funInterface.MathOperation;

public class LambdaTest {
    LambdaTest lambdaTest=new LambdaTest();
    MathOperation mathOperation=(int a,int b)->a+b;// 类型声明
    MathOperation subtraction  =(a,b)->a-b; // 不用类型声明
    MathOperation multiplication=(a,b)->{ // 大括号中的返回语句
        return a*b;
    };
    //lambda配合  方法的引用::一起使用


}
