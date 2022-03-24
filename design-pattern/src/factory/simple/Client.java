package factory.simple;

/**
 * 工厂模式-静态
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new Factory();

        Shape square = factory.createInstance("Square");
        square.draw();

        Shape circle = factory.createInstance("Circle");
        circle.draw();
    }
}
