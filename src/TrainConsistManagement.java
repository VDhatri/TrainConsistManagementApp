import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;

public class TrainConsistManagement {
    public static void main(String[] args){
        System.out.println("UC4 - Maintain Ordered Bogie Consist ");

        List<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist: ");
        System.out.println(trainConsist);

        trainConsist.add(2,"Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2: ");
        System.out.println(trainConsist);


        trainConsist.remove(0);
        int n = trainConsist.size();  // Had to keep n here as it becomes outdated after removing one;
        trainConsist.remove(n-1);

        System.out.println("After Removing First and Last Bogie: ");
        System.out.println(trainConsist);
    }
}
