package Lesson_16.grouping;

import org.testng.annotations.Test;

public class Groups {
    @Test(groups = "first", priority = 0)
    public void one() {}

    @Test(groups = "second", priority = 0)
    public void two() {}

    @Test(groups = "first", dependsOnMethods = {"one"})
    public void three() {}

    @Test(groups = "second", dependsOnMethods = {"two"})
    public void four() {}

    @Test(groups = "first", dependsOnMethods = {"three"})
    public void five() {}

    @Test(groups = "second", dependsOnMethods = {"four"})
    public void six() {}

    @Test(groups = "first", dependsOnMethods = {"five"})
    public void seven() {}

    @Test(groups = "second", dependsOnMethods = {"six"})
    public void eight() {}
}
