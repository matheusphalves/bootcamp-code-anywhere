package modulos.matheus.operacao;

import modulos.matheus.operacao.interno.DivHelper;
import modulos.matheus.operacao.interno.MultiHelper;
import modulos.matheus.operacao.interno.SubHelper;
import modulos.matheus.operacao.interno.SumHelper;

public class Calculadora {

    private SumHelper sum;
    private SubHelper sub;
    private MultiHelper multi;
    private DivHelper div;

    public Calculadora(){
        this.sum = new SumHelper();
        this.sub = new SubHelper();
        this.multi = new MultiHelper();
        this.div = new DivHelper();
    }

    public int sum(int a, int b){
        return this.sum.execute(a,b);
    }

    public int sub(int a, int b){
        return this.sub.execute(a,b);
    }

    public int multi(int a, int b){
        return this.multi.execute(a,b);
    }

    public int div(int a, int b){
        return this.div.execute(a,b);
    }
}
