package br.com.raytsson.restwitchspringbootandjava.MathController;

import br.com.raytsson.restwitchspringbootandjava.converters.NumberConventers;
import br.com.raytsson.restwitchspringbootandjava.exceptions.UnsupportedMathOperationException;
import br.com.raytsson.restwitchspringbootandjava.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Math.sqrt;


@RestController
public class mathController {
    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable( value = "numberOne")String numberOne,
                      @PathVariable( value = "numberTwo")String numberTwo)  throws Exception{
        if (!NumberConventers.isNumeric(numberOne) || !NumberConventers.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor coloque um numero");
        }
        return math.sum(NumberConventers.convertToDouble(numberOne), NumberConventers.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/subt/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subt(@PathVariable( value = "numberOne")String numberOne,
                      @PathVariable( value = "numberTwo")String numberTwo)  throws Exception{
        if (!NumberConventers.isNumeric(numberOne) || !NumberConventers.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor coloque um numero");
        }
        return math.subt(NumberConventers.convertToDouble(numberOne), NumberConventers.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable( value = "numberOne")String numberOne,
                       @PathVariable( value = "numberTwo")String numberTwo)  throws Exception{
        if (!NumberConventers.isNumeric(numberOne) || !NumberConventers.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor coloque um numero");
        }
        return math.mult(NumberConventers.convertToDouble(numberOne), NumberConventers.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/divi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divi(@PathVariable( value = "numberOne")String numberOne,
                       @PathVariable( value = "numberTwo")String numberTwo)  throws Exception{
        if (!NumberConventers.isNumeric(numberOne) || !NumberConventers.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor coloque um numero");
        }
        return math.divi(NumberConventers.convertToDouble(numberOne), NumberConventers.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(@PathVariable( value = "numberOne")String numberOne,
                       @PathVariable( value = "numberTwo")String numberTwo)  throws Exception{
        if (!NumberConventers.isNumeric(numberOne) || !NumberConventers.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor coloque um numero");
        }
        return math.media(NumberConventers.convertToDouble(numberOne), NumberConventers.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
    public Double raiz(@PathVariable( value = "numberOne")String numberOne ){
        if (!NumberConventers.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Por favor coloque um numero");
        }
        return math.raiz(sqrt((NumberConventers.convertToDouble(numberOne))));
    }


}
