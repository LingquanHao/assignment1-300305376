package design3;
import design5.PointCP5;

public class PointCP3 extends PointCP5 {
 private double x;
 private double y;

 public PointCP3(double x, double y) {
     this.x = x;
     this.y = y;
 }

 @Override
 public double getX() {
     return x;
 }

 @Override
 public double getY() {
     return y;
 }

 @Override
 public double getRho() {
     return Math.sqrt(x * x + y * y);
 }

 @Override
 public double getTheta() {
     return Math.toDegrees(Math.atan2(y, x));
 }

 @Override
 public String toString() {
     return "Cartesian Coordinates [" + "X: " + x + ", Y: " + y + "]";
 }
}
