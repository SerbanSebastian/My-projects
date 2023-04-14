package businessLogic;
import GUI.*;
import dataModels.*;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Operations {
    private Polynomial p1;
    private Polynomial p2;
    private CalcView view;
    public Operations(CalcView view){
        this.view = view;
    }
    private boolean parsePolynomial(String polynomial, Polynomial p){
        Pattern pt1 = Pattern.compile("([x]{2,}|[X]{2,}|[\\^]{2,}|[\\+]{2,}[\\-]{2,})|([xX][\\+\\-]\\^)|(\\^\\d*[xX])|(x\\d+)|([^xX0-9\\+\\-\\^])");
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pt1.matcher(polynomial);
        Matcher mt;
        if(matcher.find())
            return false;
        int coef, power;
        boolean ok = false;
        matcher = pattern.matcher(polynomial);
        while(matcher.find()){
            if(matcher.group(1).equals("x") || matcher.group(1).equals("X")){
                power = 1;
                coef = 1;
                p.addMonomial(new Monomial(coef, power));
            }
            else {
                if (matcher.group(1).equals("-x") || matcher.group(1).equals("-X")) {
                    power = 1;
                    coef = -1;
                    p.addMonomial(new Monomial(coef, power));
                }else {
                    if (matcher.group(1).contains("x") || matcher.group(1).contains("X"))
                        ok = true;
                    pt1 = Pattern.compile("^(\\+?-?)\\d+");
                    mt = pt1.matcher(matcher.group(1));
                    coef = 1;
                    if(mt.find())
                        coef = Integer.parseInt(mt.group(0));
                    pt1 = Pattern.compile("\\d+$");
                    mt = pt1.matcher(matcher.group(1));
                    power = 0;
                    if(mt.find() && ok == true)
                        power = Integer.parseInt(mt.group(0));
                    if(power == 0 && ok == true)
                        power = 1;
                    ok = false;
                    p.addMonomial(new Monomial(coef, power));
                }
            }
        }
        return true;
    }
    public void constructPolynomials(int option) throws Exception{
        String poly1 = this.view.getPolynomial1TextField();
        String poly2;
        this.p1 = new Polynomial();
        if(poly1.length() > 0)
            if(!parsePolynomial(poly1, this.p1))
                throw new Exception("P1");
        if(option == 2) {
            this.p2 = new Polynomial();
            poly2 = this.view.getPolynomial2TextField();
            if(!parsePolynomial(poly2, this.p2))
                throw new Exception("P2");
        }
    }
    private String createResult(TreeMap<Integer, Monomial> p){
        String result = "";
        for(Map.Entry<Integer, Monomial> mono : p.entrySet()){
            if(mono.getValue().getCoefficient() != 0) {
                if(mono.getValue().getCoefficient() > 0)
                    if(!result.equals(""))
                        result = result + "+";
                if(mono.getValue().getCoefficient() > 1 || mono.getValue().getCoefficient() < -1)
                    result = result + mono.getValue().getCoefficient();
                if(mono.getKey() > 1)
                    result = result + "x^" + mono.getKey();
                if(mono.getKey() == 1)
                    result = result + "x";
                if(mono.getKey() == 0 && (mono.getValue().getCoefficient() == 1 || mono.getValue().getCoefficient() == -1))
                    result = result + mono.getValue().getCoefficient();
            }
        }
        if(result.equals(""))
            result = "0";
        return result;
    }
    public String add(){
        TreeMap<Integer, Monomial> p = new TreeMap<>(Collections.reverseOrder());
        Monomial m;
        p.putAll(p1.getPoly());
        for(Map.Entry<Integer, Monomial> mono : p2.getPoly().entrySet()){
            if(p.containsKey(mono.getKey())){
                m = p.get(mono.getKey());
                m.setCoefficient(m.getCoefficient() + mono.getValue().getCoefficient());
                p.put(mono.getKey(), m);
            }
            else{
                p.put(mono.getKey(), mono.getValue());
            }
        }
        return createResult(p);
    }
    public String sub(){
        TreeMap<Integer, Monomial> p = new TreeMap<>(Collections.reverseOrder());
        Monomial m;
        p.putAll(p1.getPoly());
        for(Map.Entry<Integer, Monomial> mono : p2.getPoly().entrySet()){
            if(p.containsKey(mono.getKey())){
                m = p.get(mono.getKey());
                m.setCoefficient(m.getCoefficient() - mono.getValue().getCoefficient());
                p.put(mono.getKey(), m);
            }
            else{
                p.put(mono.getKey(), new Monomial((-1) * mono.getValue().getCoefficient(), mono.getKey()));
            }
        }
        return createResult(p);
    }
    public String mul(){
        TreeMap<Integer, Monomial> p = new TreeMap<>(Collections.reverseOrder());
        int cf, pw;
        Monomial mono;
        for(Map.Entry<Integer, Monomial> m1 : p1.getPoly().entrySet()){
            for(Map.Entry<Integer, Monomial> m2 : p2.getPoly().entrySet()){
                cf = m1.getValue().getCoefficient() * m2.getValue().getCoefficient();
                pw = m1.getKey() + m2.getKey();
                if(p.containsKey(pw)){
                    mono = p.get(pw);
                    mono.setCoefficient(mono.getCoefficient() + cf);
                    p.put(pw, mono);
                }
                else{
                    p.put(pw, new Monomial(cf, pw));
                }
            }
        }
        return createResult(p);
    }
    public String div(){
        TreeMap<Integer, Monomial> p1, p2, aux, m;
        String intermediar;
        p1 = new TreeMap<>(Collections.reverseOrder());
        p2 = new TreeMap<>(Collections.reverseOrder());
        aux = new TreeMap<>(Collections.reverseOrder());
        m = new TreeMap<Integer, Monomial>();
        p1.putAll(this.p1.getPoly());
        p2.putAll(this.p2.getPoly());
        if(p2.firstKey() == 0 && p2.firstEntry().getValue().getCoefficient() == 0) {
            view.setPoly2Text("Divission by 0");
            return "Error";
        }
        while(p1.firstKey() >= p2.firstKey()){
            m.clear();
            m.put( p1.firstKey() - p2.firstKey(), new Monomial(p1.firstEntry().getValue().getCoefficient(), p1.firstKey() - p2.firstKey()));
            aux.putAll(m);
            this.p1 = new Polynomial();
            parsePolynomial(createResult(m), this.p1);
            intermediar = mul();
            this.p2 = new Polynomial();
            parsePolynomial(intermediar, this.p2);
            this.p1 = new Polynomial();
            parsePolynomial(createResult(p1), this.p1);
            intermediar = sub();
            this.p2 = new Polynomial();
            this.p1 = new Polynomial();
            parsePolynomial(intermediar, this.p1);
            parsePolynomial(createResult(p2), this.p2);
            p1.clear();
            p1.putAll(this.p1.getPoly());
        }

        return ("rest= " +  createResult(aux) + " cat= " + createResult(p1));
    }
    public String dif(){
        String result = "";
        int coef, power;
        if(p1.getPoly().containsKey(0))
            if(p1.getPoly().size() == 1)
                if(p1.getPoly().get(0).getCoefficient() == 0)
                    return "0";
        for( Map.Entry<Integer, Monomial> mono : p1.getPolyReverse().entrySet()){
            coef = mono.getValue().getCoefficient();
            power = mono.getValue().getPower();
            coef *= power;
            if(power > 0)
                power--;
            if(coef > 0){
                if(!result.equals(""))
                    result = result + "+";
                result = result + coef;
            }
            else{
                if(coef < 0)
                    result = result + coef;
            }
            if(power > 1)
                result = result + "x^" + power;
            if(power == 1)
                result = result + "x";
        }
        if(result.equals(""))
            result = "0";
        return result;
    }
    public String integration(){
        String result = "";
        int coef, power;
        boolean simplify;
        if(p1.getPoly().containsKey(0))
            if(p1.getPoly().size() == 1)
                if(p1.getPoly().get(0).getCoefficient() == 0)
                    return "0";
        for(Map.Entry<Integer,Monomial> mono : p1.getPolyReverse().entrySet()){
            coef = mono.getValue().getCoefficient();
            power = mono.getValue().getPower() + 1;
            if(coef > 0){
                if(!result.equals(""))
                    result = result + "+";
            }
            else{
                coef = coef * (-1);
                result = result + "-";
            }
            simplify = false;
            if(coef % power == 0) {
                simplify = true;
                coef = coef / power;
            }
            if(coef > 1)
                result = result + coef;
            if(coef == 1 && simplify == false){
                result = result + coef;
            }
            if(power > 1) {
                if(simplify == false)
                    result = result + "/" + power;
                result = result + "x^" + power;
            }
            else
                result = result + "x";
        }
        if(result.equals(""))
            result = "0";
        return result;
    }
}
