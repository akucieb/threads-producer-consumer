package pl.sda.poznan;

public class Main {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        Thread producerThread = new ProducerThread(buffer);
        Thread consumerThread = new ConsumeTread(buffer);
        producerThread.setName("producerThread");
        producerThread.setDaemon(true);

        consumerThread.setName("consumerThread");
        consumerThread.setDaemon(true);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Koniec");
    }
}
    /*System.out.println("Hello World!");
        Thread nowyWatek = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from another Thraed");
        });
        nowyWatek.setName("Moj nowy watek");
        nowyWatek.start();

        try {
            nowyWatek.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main dziala dalej..........");
    }*/
