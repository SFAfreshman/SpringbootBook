package com.example.demo.generic;


import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created BY DarkSheep ON 2021/7/18 23:16
 * 通过反射获取获取泛型类型
 * genericGetDemo.class.getMethod("test01",Map.class);方法名和参数类型
 * method.getGenericParameterTypes();获取方法的泛型参数
 * if (genericParameterType instanceof ParameterizedType) 如果参数类型是参数化类型如Collection<String>
 * ((ParameterizedType) genericParameterType).getActualTypeArguments();获取真实参数
 *
 **/
@SpringBootTest(classes = genericGetDemo.class)
public class genericGetDemo {
    public Map<String,String> test02()
    {
        System.out.println("test02");
        return null;
    }
    public void test01(Map<String,Integer> test){
        return;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //此处通过类名直接获取Class而非Class.forName("全路径名")获取
        Method method = genericGetDemo.class.getMethod("test01",Map.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
            for (Type genericParameterType : genericParameterTypes) {
                System.out.println("#"+genericParameterType);
                if (genericParameterType instanceof ParameterizedType)
                {
                    Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                    for (Type actualTypeArgument : actualTypeArguments) {
                        System.out.println(actualTypeArgument);
                    }
                }
            }
           /*
           输出结果
           #java.util.Map<java.lang.String, java.lang.Integer>:获取到的泛型参数类型
            class java.lang.String:获取到的泛型中的实际参数类型
            class java.lang.Integer*/
        Method method02=genericGetDemo.class.getMethod("test02");
        Type genericReturnType = method02.getGenericReturnType();
        System.out.println("#"+genericReturnType);
        if (genericReturnType instanceof ParameterizedType)
        {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
       /* #java.util.Map<java.lang.String, java.lang.String>
        class java.lang.String
        class java.lang.String*/
    }
}
