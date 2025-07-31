package Lesson_16.priority;

import org.testng.annotations.Test;

public class Priority1 {

    @Test(priority = 6)
    public void a() {}

    @Test(priority = 5)
    public void b() {}

    @Test(priority = 4)
    public void c() {}

    @Test(priority = 3)
    public void d() {}

    @Test(priority = 2)
    public void e() {}

    @Test(priority = 1)
    public void f() {}

    @Test(priority = 0)
    public void g() {}
}
