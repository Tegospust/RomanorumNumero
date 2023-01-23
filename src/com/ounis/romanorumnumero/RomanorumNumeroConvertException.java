/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ounis.romanorumnumero;

/**
 *
 * @author AndroidDev
 */
public class RomanorumNumeroConvertException extends Exception {
  
    
    protected static final String EXC_MSG_VALUE_OUT_OF_RANGE = "%s: Zbyt duża wartość konwertowanej liczby (maks.: %d)";
    protected static final String EXC_MSG_VALUE_ZERO = "%s: Liczba zero w systemie rzymskim nie istnieje";
    protected static final String EXC_MSG_NAGATIVE_VALUE = "%s: Liczby ujemne nie są obsługiwane";
    
    public RomanorumNumeroConvertException(String errorMessage) {
        super(errorMessage);
    }
}
