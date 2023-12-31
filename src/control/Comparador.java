package control;

import java.util.Comparator;
import modeloDatos.FitnessCenter.Member;

public class Comparador implements Comparator{
    
    @Override
    public int compare(Object t, Object t1) {     
        Member m = (Member)t;
        Member m1 = (Member)t1;
        return m.getName().compareTo(m1.getName());
    }
}
