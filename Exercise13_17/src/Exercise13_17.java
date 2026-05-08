import java.util.Scanner;
public class Exercise13_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        Complex c1 = new Complex(a, b);

        System.out.print("Enter the second complex number: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        Complex c2 = new Complex(c, d);

        System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = " + c1.add(c2));
        System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = " + c1.subtract(c2));
        System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = " + c1.multiply(c2));
        System.out.println("(" + c1 + ")" + " / " + "(" + c2 + ")" + " = " + c1.divide(c2));
        System.out.println("|" + c1 + "| = " + c1.abs());

        Complex c3 = (Complex)c1.clone();
        System.out.println(c1 == c3);
        System.out.println(c3.getRealPart());
        System.out.println(c3.getImaginaryPart());
        Complex c4 = new Complex(4, -0.5);
        Complex[] list = {c1, c2, c3, c4};
        java.util.Arrays.sort(list);
        System.out.println(java.util.Arrays.toString(list));
    }}
class Complex implements Cloneable, Comparable<Complex>{
        double realPart;
        double imaginaryPart;

        Complex() {
            realPart = 0;
            imaginaryPart = 0;
        }

        Complex(double realPart) {
            this.realPart = realPart;
            imaginaryPart = 0;
        }

        Complex(double realPart, double imaginaryPart) {
            this.realPart = realPart;
            this.imaginaryPart = imaginaryPart;
        }

        Complex add(Complex c1) {
            double real = this.getRealPart() + c1.getRealPart();
            double imaginary = this.getImaginaryPart() + c1.getImaginaryPart();
            return new Complex(real, imaginary);
        }

        public Complex subtract(Complex c1) {
            double real = this.getRealPart() - c1.getRealPart();
            double imaginary = this.getImaginaryPart() - c1.getImaginaryPart();
            return new Complex(real, imaginary);
        }

        public Complex multiply (Complex c1) {
            double real = (this.getRealPart() * c1.getRealPart()) - (this.getImaginaryPart() * c1.getImaginaryPart());
            double imaginary = (this.getImaginaryPart() * c1.getRealPart()) + (this.getRealPart() * c1.getImaginaryPart());
            return new Complex(real, imaginary);
        }

        public Complex divide(Complex c1) {
            double a = this.getRealPart();
            double b = this.getImaginaryPart();
            double c = c1.getRealPart();
            double d = c1.getImaginaryPart();

            double real = ((a*c) + (b * d)) / (Math.pow(c, 2) + Math.pow(d, 2));
            double imaginary = ((b*c)-(a*d)) / (Math.pow(c, 2) + Math.pow(d, 2));
            return new Complex(real, imaginary);
        }

        public double abs() {
            double abs = Math.sqrt(Math.pow(this.realPart,2) + Math.pow(this.getImaginaryPart(), 2));
            return abs;
        }

        public double getRealPart() {
            return realPart;
        }

        public double getImaginaryPart() {
            return imaginaryPart;
        }

        @Override
        public String toString() {
            if(imaginaryPart == 0) {
                return realPart + "";
            }
            else {
                return  realPart + " + " + imaginaryPart + "i";
            }
        }

        /*
        public String toString(Complex[] list) {
            String str = "";
            for(int i =0; i < list.length; i++) {
                if(imaginaryPart == 0) {
                    str += realPart + "";
                }
                else {
                    str += realPart + " + " + imaginaryPart + "i";
                }
            }

            return str;
        }
*/
        @Override
        public int compareTo(Complex c1) {
            if(this.abs() > c1.abs()) {
                return 1;
            }
            if(this.abs() == c1.abs()) {
                return 0;
            }
            else {
                return -1;
            }
        }

        @Override
        public Object clone() {
            try {
                return super.clone();
            }
            catch (CloneNotSupportedException ex) {
                return null;
            }
        }

    }


