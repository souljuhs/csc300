public class Parallelogram extends Trapezoid
{
    public Parallelogram(double x1, double y1, double x2, double y2,
                         double x3, double y3, double x4, double y4)
    {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    // method to calculate width
    public double getWidth()
    {
        if (getPoint1().getY() == getPoint2().getY())
        {
            return Math.abs(getPoint1().getX() - getPoint2().getX());
        }
        else
        {
            return Math.abs(getPoint2().getX() - getPoint3().getX());
        }
    }

    public String toString()
    {
        return "Coordinates of parallelogram are " + returnCoordsAsString() +
               "\nWidth is " + String.format("%.2f", getWidth()) +
               " Height is " + String.format("%.2f", getHeight()) +
               " Area is: " + String.format("%.2f", getArea());
    }
}