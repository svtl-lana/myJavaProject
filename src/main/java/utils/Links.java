package utils;

public enum Links {
    LOGIN_PAGE("https://qa-course-01.andersenlab.com/login"),
    REGISTRATION_PAGE("https://qa-course-01.andersenlab.com/registration"),
    ACCOUNT_PAGE("https://qa-course-01.andersenlab.com/account"),
    AUTOMATION_PRACTICE("http://www.automationpractice.pl/index.php"),
    ZOO("https://zoo.waw.pl/"),
    W3SCHOOLS("https://www.w3schools.com/"),
    CLICK_SPEED_TEST("https://www.clickspeedtester.com/click-counter/"),
    ANDERSEN("https://andersenlab.com/");

    private final String link;
    public String getLink() {
        return link;
    }
    Links(String link) {
        this.link = link;
    }
}
