package com.interrator;

class  Test1{
    public static void main(String[] ags){
        new B();
    }
}
class A{
    static {
        System.out.println("static A");
    }
    {
        System.out.println("A");
    }

    public A() {
        System.out.println("A()");
    }
    static {
        System.out.println("static A");
    }
}
class B extends A{
    static {
        System.out.println("static B");
    }
    {
        System.out.println("B");
    }

    public B() {
        System.out.println("B()");
    }
}
    public abstract class Shape {
        abstract double getArea();
    }
    class Rectangle extends Shape{
        double width;
        double height;

        public Rectangle() {
        }

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }


        double getArea() {
            return width*height;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }
    }
    class Cirlce extends Shape{
        double x;
        double y;
        double r;

        public Cirlce() {
        }

        public Cirlce(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        double getArea() {
            return Math.PI*r*r;
        }

        @Override
        public String toString() {
            return "Cirlce{" +
                    "x=" + x +
                    ", y=" + y +
                    ", r=" + r +
                    '}';
        }
    }

