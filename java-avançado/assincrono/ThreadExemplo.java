public class ThreadExemplo{

    public static void main(String[] args) {
        BarraCarregamento2 test = new BarraCarregamento2();
        BarraCarregamento2 test2 = new BarraCarregamento2();
        test.start(); //processo é iniciado
        test2.start();
    }

}