package br.com.raytsson.restwitchspringbootandjava.math;

import static java.lang.Math.sqrt;

public class SimpleMath {

    public Double sum(Double numberOne,Double numberTwo) {

        return numberOne + numberTwo;
    }


    public Double subt(Double numberOne,Double numberTwo)  throws Exception{

        return numberOne - numberTwo;
    }


    public Double mult(Double numberOne,Double numberTwo)  throws Exception{

        return numberOne * numberTwo;
    }


    public Double divi(Double numberOne,Double numberTwo)  throws Exception{

        return numberOne / numberTwo;
    }


    public Double media(Double numberOne,Double numberTwo)  throws Exception{

        return (numberOne + numberTwo) / 2 ;
    }


    public Double raiz(Double numberOne ){

        return sqrt((numberOne));
    }
}
