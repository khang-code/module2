package CircleAndCylinder.Circle;

public class Test {
    private String Color;

    public Test(double area) {
        Area = area;
    }

    private double Area;

    @Override
    public String toString() {
        return "Test{" +
                "Color='" + Color + '\'' +
                ", Area=" + Area +
                ", Color='" + Color + '\'' +
                '}';
    }

    public void setColor(String color) {
        Color = color;
    }
}

