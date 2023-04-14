package businessLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.*;

public class CalcController{

    private  CalcView view;
    private Operations operations;

    public CalcController(CalcView view, Operations operations){
        this.view = view;
        this.operations = operations;
        this.view.addButtonListener(new AddBtn());
        this.view.subButtonListener(new SubBtn());
        this.view.mulButtonListener(new MulBtn());
        this.view.divButtonListener(new DivBtn());
        this.view.difButtonListener(new DifBtn());
        this.view.intButtonListener(new IntBtn());
    }
    class AddBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.init();
            try{
                operations.constructPolynomials(2);
                String result = operations.add();
                view.setResultTextField(result);
            }catch(Exception e1){
                if(e1.getMessage().equals("P1"))
                    view.setPoly1Text("Incorrect polynomial");
                else
                    view.setPoly2Text("Incorrect polynomial");
            }
        }
    }
    class SubBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.init();
            try{
                operations.constructPolynomials(2);
                String result = operations.sub();
                view.setResultTextField(result);
            }catch(Exception e1){
                if(e1.getMessage().equals("P1"))
                    view.setPoly1Text("Incorrect polynomial");
                else
                    view.setPoly2Text("Incorrect polynomial");
            }
        }
    }
    class MulBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.init();
            try{
                operations.constructPolynomials(2);
                String result = operations.mul();
                view.setResultTextField(result);
            }catch(Exception e1){
                if(e1.getMessage().equals("P1"))
                    view.setPoly1Text("Incorrect polynomial");
                else
                    view.setPoly2Text("Incorrect polynomial");
            }
        }
    }
    class DivBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.init();
            try{
                operations.constructPolynomials(2);
                String result = operations.div();
                view.setResultTextField(result);
            }catch(Exception e1){
                if(e1.getMessage().equals("P1"))
                    view.setPoly1Text("Incorrect polynomial");
                else
                    view.setPoly2Text("Incorrect polynomial");
            }
        }
    }
    class DifBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.init();
            try{
                operations.constructPolynomials(1);
                String result = operations.dif();
                view.setResultTextField(result);
            }catch(Exception e1){
                if(e1.getMessage().equals("P1"))
                    view.setPoly1Text("Incorrect polynomial");
                else
                    view.setPoly2Text("Incorrect polynomial");
            }
        }
    }
    class IntBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.init();
            try{
                operations.constructPolynomials(1);
                String result = operations.integration();
                view.setResultTextField(result);
            }catch(Exception e1){
                if(e1.getMessage().equals("P1"))
                    view.setPoly1Text("Incorrect polynomial");
                else
                    view.setPoly2Text("Incorrect polynomial");
            }
        }
    }
}
