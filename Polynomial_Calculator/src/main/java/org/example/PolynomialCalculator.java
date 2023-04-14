package org.example;
import GUI.*;
import businessLogic.CalcController;
import businessLogic.Operations;

public class PolynomialCalculator
{
    public static void main( String[] args ) {
        CalcView view = new CalcView();
        Operations operations = new Operations(view);
        CalcController controller = new CalcController(view, operations);
    }
}
