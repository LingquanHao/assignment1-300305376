package design2;
import design5.PointCP5;

public class PointCP2 extends PointCP5 {
    private double rho;
    private double theta;

    public PointCP2(double rho, double theta) {
        this.rho = rho;
        this.theta = theta;
    }

    @Override
    public double getX() {
        return Math.cos(Math.toRadians(theta)) * rho;
    }

    @Override
    public double getY() {
        return Math.sin(Math.toRadians(theta)) * rho;
    }

    @Override
    public double getRho() {
        return rho;
    }

    @Override
    public double getTheta() {
        return theta;
    }

    @Override
    public String toString() {
        return "Polar Coordinates [Rho: " + rho + ", Theta: " + theta + "]";
    }
}
