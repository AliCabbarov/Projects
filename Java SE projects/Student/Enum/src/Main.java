public class Main {
    public static void main(String[] args) {
        Planets[] planets = Planets.values();
        for (int i = 0; i < planets.length; i++) {
            System.out.println(planets[i].getInfo());
        }

    }
}