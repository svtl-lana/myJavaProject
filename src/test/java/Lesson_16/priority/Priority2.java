package Lesson_16.priority;

import org.testng.annotations.Test;

public class Priority2 {
    @Test(dependsOnMethods = {"b"})
    public void a() {}

    @Test(dependsOnMethods = {"c"})
    public void b() {}

    @Test(dependsOnMethods = {"d"})
    public void c() {}

    @Test(dependsOnMethods = {"e"})
    public void d() {}

    @Test(dependsOnMethods = {"f"})
    public void e() {}

    @Test(dependsOnMethods = {"g"})
    public void f() {}

    @Test()
    public void g() {}
}
