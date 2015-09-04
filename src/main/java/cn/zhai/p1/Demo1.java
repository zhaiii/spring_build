package cn.zhai.p1;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by zhai on 15/9/3.
 */
public class Demo1 {

    @Test
    public void fun1(){

        double pi = Math.PI;
        BigDecimal b=new BigDecimal(pi);

        BigDecimal bigDecimal = b.setScale(2, BigDecimal.ROUND_CEILING);
        System.out.println(bigDecimal.toString());

    }
}
