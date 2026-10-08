import java.util.HashSet;
import java.util.Set;

public class setuse {
    public static void main(String args[])

    {
        Set<String> setofcities = new HashSet<>(); // its help us avoid the duplication ...
        setofcities.add("mumbai");
        setofcities.add("jalandar");
        setofcities.add("mumbai"); // this one should get ignored ,,
        setofcities.add("hyderabad");
        setofcities.add("delhi");
        setofcities.add("chennai");
        setofcities.add("banglore");

        System.out.println("the folowings cities are ---->" + setofcities + "\n");

    }

}