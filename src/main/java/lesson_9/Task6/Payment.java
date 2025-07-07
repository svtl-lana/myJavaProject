package lesson_9.Task6;

public class Payment {
    private String customer;

    public Payment(String customer) {
        this.customer = customer;
    }
    public class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }
        public double getPrice() {
            return price;
        }

        public void printItem() {
            System.out.println("Customer: " + Payment.this.customer);
            System.out.println("Item: " + name + ", Price: " + price);
        }
    }
    public void showTotal(Item[] items) {
        double total = 0;

        for (Item item : items) {
            item.printItem();
            total += item.getPrice();
        }
        System.out.println("Total amount: " + total);
    }
}
