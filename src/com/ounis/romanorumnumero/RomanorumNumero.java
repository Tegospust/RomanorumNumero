/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ounis.romanorumnumero;

/**
 *
 * @author AndroidDev
 * 
 * Źródła dot. rzymskiego systemu liczb: 
 * 
 * https://www.tuomas.salste.net/doc/roman/numeri-romani-1-5000.html
 * https://www.tuomas.salste.net/doc/roman/numeri-romani.html
 * https://pl.wikipedia.org/wiki/Rzymski_system_zapisywania_liczb
 * 
 * 
 */
public class RomanorumNumero {

    
    private static final int MAX_VALUE_2_CONVERT = 4999; // MMMMCMXCIX

    private static final String ROMAN_ZERO = "nihil";
    
    private static final String R_1_I = "I";
    private static final String R_5_V = "V";
    private static final String R_10_X = "X";
    private static final String R_50_L = "L";
    private static final String R_100_C = "C";
    private static final String R_500_D = "D";
    private static final String R_1000_M = "M";
    
    
    private static final String[] UNITY  = {R_1_I, R_1_I+R_1_I, R_1_I+R_1_I+R_1_I, R_1_I+R_5_V, R_5_V, 
                                            R_5_V+R_1_I,R_5_V+R_1_I+R_1_I,R_5_V+R_1_I+R_1_I+R_1_I,R_1_I+R_10_X};
    private static final String[] DOZENS = {R_10_X,R_10_X+R_10_X,R_10_X+R_10_X+R_10_X, R_10_X+R_50_L, R_50_L,
                                            R_50_L+R_10_X, R_50_L+R_10_X+R_10_X,R_50_L+R_10_X+R_10_X+R_10_X, R_10_X+R_100_C};
    private static final String[] HUNDREDS = {R_100_C, R_100_C+R_100_C,R_100_C+R_100_C+R_100_C,R_100_C+R_500_D,R_500_D,
                                                R_500_D+R_100_C,R_500_D+R_100_C+R_100_C, R_500_D+R_100_C+R_100_C+R_100_C,R_100_C+R_1000_M};
    private static final String[] THOUSANDS = {R_1000_M, R_1000_M+R_1000_M, R_1000_M+R_1000_M+R_1000_M, R_1000_M+R_1000_M+R_1000_M+R_1000_M,null,
                                                null,null,null,null};
    
    private static final String[][] ROMAN_DIGITS = { 
                            UNITY,
                            DOZENS,
                            HUNDREDS,
                            THOUSANDS};    

    
    private final int  number;
    private final boolean handleZeroValue;
    
    public RomanorumNumero(int aNumber, boolean aHandleZeroValue) {
        this.number = aNumber; 
        this.handleZeroValue = aHandleZeroValue; // zamiast wurzucać wyjątek zwróc tekst ROMAN_ZERO jeżeli aNumber == 0
    }
    
    private String convert2RomanNumber() throws RomanorumNumeroConvertException{
        String result = "";
        
        
        if (number < 0)
            throw  new RomanorumNumeroConvertException(String.format(RomanorumNumeroConvertException.EXC_MSG_NAGATIVE_VALUE,
                                RomanorumNumeroConvertException.class.getName()));
        
        if (!handleZeroValue && (number == 0) )
            throw new RomanorumNumeroConvertException(String.format(RomanorumNumeroConvertException.EXC_MSG_VALUE_ZERO,
                    RomanorumNumeroConvertException.class.getName()));
            

        if (number > MAX_VALUE_2_CONVERT)
            throw new RomanorumNumeroConvertException(
                    String.format(RomanorumNumeroConvertException.EXC_MSG_VALUE_OUT_OF_RANGE,
                            RomanorumNumeroConvertException.class.getName(),MAX_VALUE_2_CONVERT));
        else {
            if (number != 0) {
                String sNum  = String.valueOf(number);
                String digits[] = sNum.split("");

                for (int x = 0;x <= digits.length-1;x++) {
                    int ind = Math.abs(x - digits.length+1);
                    if (digits[x].equals("0")) continue;
                    String buff = ROMAN_DIGITS[ind][Integer.valueOf(digits[x])-1];
                       result += (buff != null)?buff:"--";
                }
            }
            else
                result = ROMAN_ZERO;
            
        }
        
        return result;
    }
    

    public String getRomanNumber() throws RomanorumNumeroConvertException {
        String result = convert2RomanNumber();
        
        return result;
    }
    
}
