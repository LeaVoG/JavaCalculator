package calculator_package;

import java.math.BigDecimal;

public class BigDecimalCalculate {
	
	public static double add(double value1, double value2)	//大数加
	{  
        BigDecimal b1 = new BigDecimal(Double.toString(value1));  
        BigDecimal b2 = new BigDecimal(Double.toString(value2));  
        return b1.add(b2).doubleValue();  
    }  
	
	public static double sub(double value1, double value2) //大数减
	{  
        BigDecimal b1 = new BigDecimal(Double.toString(value1));  
        BigDecimal b2 = new BigDecimal(Double.toString(value2));  
        return b1.subtract(b2).doubleValue();  
    }  
	
	public static double mul(double value1, double value2) //大数乘
	{  
	    BigDecimal b1 = new BigDecimal(Double.toString(value1));  
	    BigDecimal b2 = new BigDecimal(Double.toString(value2));  
	    return b1.multiply(b2).doubleValue();  
	}
	
	public static double div(double dividend, double divisor) //大数除
	{
	    return div(dividend, divisor, 10);  
	}
	
	public static double div(double dividend, double divisor, int scale) 
	{
        BigDecimal b1 = new BigDecimal(Double.toString(dividend));  
        BigDecimal b2 = new BigDecimal(Double.toString(divisor));  
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();  
    }  
	
}
