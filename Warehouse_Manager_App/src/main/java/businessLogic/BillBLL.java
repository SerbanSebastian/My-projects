package businessLogic;

import dataAccess.AbstractDAO;
import dataAccess.BillDAO;
import model.Bill;
import model.Bill;

import java.util.List;


/**
 * @Author Serban Sebastian Mihai
 * This class is meant to operate with the model Bill
 */
public class BillBLL extends AbstractDAO<Bill> {
    private BillDAO dao;

    public BillBLL(){
        dao = new BillDAO();
    }

    /**
     *
     * @param bill
     * @return Bill
     * @throws Exception
     */
    public Bill insertBill(Bill bill) throws Exception {
        Bill bl = (Bill) dao.insert(bill);
        if(bl == null){
            throw new Exception("The insertion of the bill was not completed");
        }

        return bl;
    }

    /**
     *
     * @return a ist of bills
     * @throws Exception
     */
    public List<Bill> findAllBills()throws Exception{
        List<Bill> bills = dao.findAll();
        if(bills.size() == 0){
            throw new Exception("The table is empty");
        }

        return bills;
    }
}
