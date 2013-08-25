import org.junit.Assert;

public class HelloTests {

    @org.junit.Test
    public void helloWorldTest() throws Exception {
        Hello testClass = new Hello();
        Assert.assertEquals("Hello World!", testClass.printHelloWorld());
    }
}
