public class Client extends Thread {

    private BarberShop barberShop;

    Client(BarberShop barberShop) {
        this.barberShop = barberShop;
    }


    @Override
    public void run() {
        System.out.println("Client wants his hair cut");

        if(!barberShop.tryAcquire()) {
            try {
                System.out.println("Shop is busy, client sleeps in queue");
                barberShop.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Shop is not busy, waking up barber");

        barberShop.wakeUpSleeping();

        System.out.println("Client gets his hair cut");

        try {
            barberShop.takeSeatAndSleep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
