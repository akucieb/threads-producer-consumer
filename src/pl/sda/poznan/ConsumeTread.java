package pl.sda.poznan;

public class ConsumeTread extends Thread {

    private Buffer buffer;

    public ConsumeTread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int value = buffer.get();
            System.out.flush();
        }
    }
}
