
import java.util.*;

public class MapUSA {

    private final int NUM_OF_CITIES;
    private HashMap<Integer, String> verteices = new HashMap<>();

    int[][] edges = {
       //  Miles in between cities in matrix form
       //  Chicago  San Fran  Philly   Phoenix  Eugene  Denver  Kansas City  Georgia  Dallas  Albuquerque
            {0      , 2127  , 758   ,  1753  ,  2135}, // Chicago
            {2127   , 0     , 2827  ,  754   ,  528 }, // San Fran
            {758    , 2871  , 0     ,  2342  ,  2879}, // Philly
            {1753   , 752   , 2342  ,  0     ,  1226}, // Phoenix
            {2136   , 529   , 2879  ,  1229  ,  0   }  // Eugene




    };


    public MapUSA() {
        fillMatrix();
        NUM_OF_CITIES = verteices.size();
        printMap();
    }

    private void fillMatrix() {
        verteices.put(0, "Chicago");
        verteices.put(1, "San Fran");
        verteices.put(2, "Philadelphia");
        verteices.put(3, "Phoenix");
        verteices.put(4, "Eugene");
//        verteices.put(5, "Denver");
//        verteices.put(6, "Kansas City");
//        verteices.put(7, "Georgia");
//        verteices.put(8, "Dallas");
//        verteices.put(9, "Albuquerque");
    }

    public void printMap() {
        StringBuilder spaces;

        for (int i = 0; i < verteices.size(); i++) {
            System.out.print("    " + verteices.get(i));
        }
        System.out.println();
        for (int i = 0; i < NUM_OF_CITIES; i++) {
            for (int j = 0; j < NUM_OF_CITIES; j++) {
                spaces = new StringBuilder();
                for (int k = 0; k < verteices.get(j).length(); k++) {
                    spaces.append(" ");
                }
                System.out.print(spaces.toString() + edges[i][j]);
            }
            System.out.print("    " + verteices.get(i));
            System.out.println();
            System.out.println();
        }


    }

    private <K, V> Integer getKey(V value) {
        Map<Integer, String> map = verteices;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void dijkstra(String start, String[] pred, int[] distance) {
        HashSet<Integer> vMinusS = new HashSet<>(NUM_OF_CITIES);
        HashSet<Integer> s = new HashSet<>(NUM_OF_CITIES);

        // Instantiates the set s with the hash keys of all the cities
        for (int i = 0; i < NUM_OF_CITIES; i++) {
            if (i != getKey(start)) {
                vMinusS.add(i);
            }
        }

        while (!vMinusS.isEmpty()) {
            for (int i = 0; i < NUM_OF_CITIES; i++) {
                if (i != getKey(start)) {

                }
            }

        }

    }

    public ArrayList<String> possibleRoutes(String citiesToVisit) {
        Permutation permutations = new Permutation();
        ArrayList<String> permutationList;

        //Pass the cities into the permutation class as a string
        permutations.permute(citiesToVisit, 0, citiesToVisit.length() - 1);
        permutationList = permutations.getPermutations();


        return permutationList;
    }

    public String[] quickestRoute(String beginning) {
        //Create the arguments that will be passed into possibleRoutes()
        StringBuilder citiesToVisit = new StringBuilder();
        ArrayList<String> routes = new ArrayList<>();
        HashSet<HashSet<Integer>> set = new HashSet<>();
        int start = getKey(beginning);

        //Create a String of the cities that will be visited
        for (int i = 0; i < NUM_OF_CITIES; i++) {
            if (i != start) {
                citiesToVisit.append(i);
            }
        }
        //Get the routes
        routes = possibleRoutes(citiesToVisit.toString());

        int sum1 = 0, sum2 = 0;
        String tempRoute1, tempRoute2, bestRoute = null;
        int row1;
        int column1;
        int row2;
        int column2;

        for (int i = 1; i < routes.size(); i++) {
            tempRoute1 = routes.get(i - 1);
            tempRoute2 = routes.get(i);

            sum1 = edges[start][Character.getNumericValue(tempRoute1.charAt(0))];
            sum2 = edges[start][Character.getNumericValue(tempRoute2.charAt(0))];

            for (int j = 1; j < tempRoute1.length(); j++) {
                row1 = Character.getNumericValue(tempRoute1.charAt(j - 1));
                column1 = Character.getNumericValue(tempRoute1.charAt(j));
                sum1 += edges[row1][column1];

                row2 = Character.getNumericValue(tempRoute2.charAt(j - 1));
                column2 = Character.getNumericValue(tempRoute2.charAt(j));
                sum2 += edges[row2][column2];
            }

            if (sum1 < sum2) {
                bestRoute = tempRoute1;
            } else {
                bestRoute = tempRoute2;
            }

        }

        String[] cheapestRoute = new String[bestRoute.length()];
        for (int i = 0; i < bestRoute.length(); i++) {
            cheapestRoute[i] = verteices.get(Character.getNumericValue(bestRoute.charAt(i)));
        }


        return cheapestRoute;
    }



}
