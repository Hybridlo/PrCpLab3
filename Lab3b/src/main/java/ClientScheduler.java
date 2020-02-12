public class ClientScheduler extends Thread {

    private BarberShop barberShop;

    ClientScheduler(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(("\nStarting client thread\n"));
            Client client = new Client(barberShop);
            client.start();
            Thread.sleep(10000);

            System.out.println(("\nStarting three client threads\n"));
            for (int i = 0; i < 3; i++) {
                client = new Client(barberShop);
                client.start();
            }

            Thread.sleep(20000);

            System.out.println(("\nStarting three client threads\n"));
            for (int i = 0; i < 3; i++) {
                client = new Client(barberShop);
                client.start();
            }

            System.out.println(("\nStarting client thread\n"));
            Thread.sleep(7000);

            client = new Client(barberShop);
            client.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
