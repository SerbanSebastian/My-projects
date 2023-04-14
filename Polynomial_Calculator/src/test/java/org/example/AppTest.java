package org.example;
import businessLogic.*;
import GUI.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private CalcView view = new CalcView();
    private Operations op = new Operations(view);
    @Test
    public void testAdunare(){
        this.view.setPolynomial1TextField("-5x^3+2x^2+2x-10");
        this.view.setPolynomial2TextField("-5x^2+25x+1");
        try {
            op.constructPolynomials(2);
            Assert.assertEquals("-5x^3-3x^2+27x-9", op.add());
        }catch(Exception e1){
            System.out.println("Nu ai ajuns bine");
        }
    }
    @Test
    public void testScadere(){
        this.view.setPolynomial1TextField("-5x^3+2x^2+2x-10");
        this.view.setPolynomial2TextField("-5x^2+25x+1");
        try {
            op.constructPolynomials(2);
            Assert.assertEquals("-5x^3+7x^2-23x-11", op.sub());
        }catch(Exception e1){
            System.out.println("Nu ai ajuns bine");
        }
    }
    @Test
    public void testInmultire(){
        this.view.setPolynomial1TextField("-5x^3+2x^2+2x-10");
        this.view.setPolynomial2TextField("-5x^2+25x+1");
        try {
            op.constructPolynomials(2);
            Assert.assertEquals("25x^5-135x^4+35x^3+102x^2-248x-10", op.mul());
        }catch(Exception e1){
            System.out.println("Nu ai ajuns bine");
        }
    }
    @Test
    public void testImpartire(){
        this.view.setPolynomial1TextField("x^2-5x-2");
        this.view.setPolynomial2TextField("x-3");
        try {
            op.constructPolynomials(2);
            Assert.assertEquals("rest= x-2 cat= -8", op.div());
        }catch(Exception e1){
            System.out.println("Nu ai ajuns bine");
        }
    }
    @Test
    public void testDerivare(){
        this.view.setPolynomial1TextField("x^2-5x-2");
        try {
            op.constructPolynomials(1);
            Assert.assertEquals("2x-5", op.dif());
        }catch(Exception e1){
            System.out.println("Nu ai ajuns bine");
        }
    }
    @Test
    public void testIntegrare(){
        this.view.setPolynomial1TextField("x^2-5x-2");
        try {
            op.constructPolynomials(1);
            Assert.assertEquals("1/3x^3-5/2x^2-2x", op.integration());
        }catch(Exception e1){
            System.out.println("Nu ai ajuns bine");
        }
    }
}
