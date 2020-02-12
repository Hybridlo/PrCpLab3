public class Main {
    public static void main(String[] args) {
        Honeypot honeypot = new Honeypot(10);
        Bear bear = new Bear(honeypot);

        bear.start();

        int beeAmount = 5;
        for (int i = 0; i < beeAmount; i++) {
            Bee bee = new Bee(honeypot, 400*(i+1));
            bee.start();
        }
    }

}
