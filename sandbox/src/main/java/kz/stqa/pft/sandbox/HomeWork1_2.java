package kz.stqa.pft.sandbox;

/**
 * Created by Xeniya on 25.05.2016.
 */
public class HomeWork1_2 {

    public static void main(String[] args){


        Point p1 = new Point(5,2);
        Point p2 = new Point(4,3);

        //p1.x = 5;
        //p1.y = 2;

        //p2.x = 4;
        //p2.y = 3;

        System.out.println("Координаты точки p1 = " + p1.x + " " + p1.y);
        System.out.println("Координаты точки p2 = " + p2.x + " " + p2.y);
        System.out.println("Расстояние медлу точками p1 и p2 = " + p1.distance(p2));
    }


}
