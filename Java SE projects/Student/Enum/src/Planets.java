public enum Planets {
    MERCURY("58.6 Earth days", "57.9 million km", "74.8 million km²"),
    VENUS("116.8 Earth days", "108.2 million km", "460.2 million km²"),
    EARTH("24 hours", "149.6 million km", "510.1 million km²"),
    MARS("24.7 hours", "227.9 million km", "144.8 million km²"),
    JUPITER("9.9 hours", "778.6 million km", "61.4 billion km²"),
    SATURN("10.7 hours", "1.4 billion km", "42.7 billion km²"),
    URANUS("17.2 hours", "2.9 billion km", "8.1 billion km²"),
    NEPTUNE("16.1 hours", "4.5 billion km", "7.6 billion km²");
    private  String lengthOfDay;
    private  String distanceFromSun;
    private  String area;

    Planets(String lengthOfDay, String distanceFromSun, String area) {
        this.lengthOfDay = lengthOfDay;
        this.distanceFromSun = distanceFromSun;
        this.area = area;
    }

    public  String getInfo() {
        return "--------------------------------------------" +
                "-\n    lengthOfDay: " + lengthOfDay +
                "-\ndistanceFromSun: " + distanceFromSun +
                "-\n           area: " + area;
    }
}
