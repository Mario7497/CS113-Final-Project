import java.util.ArrayList;

// Java program to print all permutations of a
// given string.
public class Permutation
{
    private ArrayList<String> permutations = new ArrayList<>();
    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    public void permute(String str, int l, int r)
    {
        if (l == r)
            permutations.add(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public ArrayList<String> getPermutations() {
        return permutations;
    }

}

// This code is contributed by Mihir Joshi
