package lesson_9.Task7;

public class Park {
        private String parkName;

        public Park(String parkName) {
            this.parkName = parkName;
        }

        public class Attraction {
            private String name;
            private String hours;
            private double price;

            public Attraction(String name, String hours, double price) {
                this.name = name;
                this.hours = hours;
                this.price = price;
            }

            public void getInfo() {
                System.out.println("Park: " + Park.this.parkName);
                System.out.println("Attraction: " + name);
                System.out.println("Working hours: " + hours);
                System.out.println("Ticket price: " + price);
            }
        }

        public void showAttractions(Attraction[] attractions) {
            for (Attraction a : attractions) {
                a.getInfo();
                System.out.println("--------------");
            }
        }
}
