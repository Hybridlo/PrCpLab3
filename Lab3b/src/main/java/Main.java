public class Main {
    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop();
        Barber barber = new Barber(barberShop);
        ClientScheduler clientScheduler = new ClientScheduler(barberShop);

        barber.start();
        clientScheduler.start();
    }
}
