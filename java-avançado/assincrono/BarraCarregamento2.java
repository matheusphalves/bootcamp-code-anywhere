public class BarraCarregamento2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Loading..." + this.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}