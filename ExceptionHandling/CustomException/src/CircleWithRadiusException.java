public class CircleWithRadiusException {
    private double radius;
    private static int numberOfObjects = 0;

    public CircleWithRadiusException() throws InvalidRadiousException{
        this(1.0);
    }

    public CircleWithRadiusException(double newRadius) throws InvalidRadiousException{
            setRadius(newRadius);
            numberOfObjects++;
    }

    public double getRadius() {
        return radius;
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public void setRadius(double newRadius)
        throws InvalidRadiousException {
            if(newRadius >= 0) {
                radius = newRadius;
            } else {
                throw new InvalidRadiousException(newRadius);
            }
        }
    }
