import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RoadTrippin {

    public static void main(String[] args) {
        MapUSA theMap = new MapUSA();
        System.out.println("The Fastest route to every city is... ");
        System.out.println(Arrays.toString(theMap.quickestRoute("San Fran")));

    }
}
