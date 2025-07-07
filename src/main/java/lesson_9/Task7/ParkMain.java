package lesson_9.Task7;

public class ParkMain {
    public static void main(String[] args) {
        Park park = new Park("Dream");

        Park.Attraction Attraction1 = park.new Attraction("Attraction1", "10:00 - 20:00", 11.0);
        Park.Attraction Attraction2 = park.new Attraction("Attraction2", "09:00 - 20:00", 9.5);
        Park.Attraction Attraction3 = park.new Attraction("Attraction3", "11:00 - 22:00", 15.7);

        Park.Attraction[] list = {Attraction1, Attraction2, Attraction3};

        park.showAttractions(list);
    }
}

