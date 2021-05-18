public class ThreadExemplo{

    public static void main(String[] args) {
        
    }

}


public class PDFGenerator implements Runnable{

    @Override
    public void run(){
        System.out.print("Gerando PDF");
    }

}

public class BarraCarregamento implements Runnable{
    @Override
    public void run(){ System.out.println("Loading...");}
}

public class BarraCarregamento2 extends Thread{
    @Override
    public void run(){ 
        super.run();
        System.out.println("Loading..." + this.getName());
    }
}