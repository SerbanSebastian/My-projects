package dataModels;

import java.util.Collections;
import java.util.TreeMap;

public class Polynomial{
    private TreeMap<Integer, Monomial> poly;

    public Polynomial() {
        this.poly = new TreeMap<Integer, Monomial>();
    }

    public void addMonomial(Monomial monomial){
        this.poly.put(monomial.getPower(), monomial);
    }

    public void removeMonomial(Monomial monomial){
        this.poly.remove(monomial.getPower());
    }
    public TreeMap<Integer, Monomial> getPoly(){
        return this.poly;
    }
    public TreeMap<Integer, Monomial> getPolyReverse() {
        TreeMap<Integer, Monomial> poly = new TreeMap<>(Collections.reverseOrder());
        poly.putAll(this.poly);
        return poly;
    }
}
