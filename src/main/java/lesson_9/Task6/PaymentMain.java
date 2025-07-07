package lesson_9.Task6;

public class PaymentMain {
    public static void main(String[] args) {
        Payment payment = new Payment("Svetlana");

        Payment.Item item1 = payment.new Item("Notebook", 7.3);
        Payment.Item item2 = payment.new Item("Pen", 2.5);
        Payment.Item item3 = payment.new Item("Paper", 11.2);

        Payment.Item[] cart = { item1, item2, item3 };

        payment.showTotal(cart);
    }
}
