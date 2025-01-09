package iceCream.flavors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class IceCream {
     private Set<String> flavors= new HashSet<String>();
    private Map<String,Integer>votes = new HashMap<String,Integer>();
    private List<String> familyMembers = new ArrayList<String>();

     Scanner scanner = new Scanner(System.in);

     public Set<String> getFlavors() {
        return flavors;
    }
    public Map<String, Integer> getVotes() {
        return votes;
    }
    public List<String> getFamilyMembers() {
        return familyMembers;
    }

    public void loadFlavors(){
        flavors.add("chocolate");
        flavors.add("cookiesncream");
        flavors.add("vanilla");
        flavors.add("strawberry");
        flavors.add("orange");
    }

    public void loadFamily(){
        familyMembers.add("John");
        familyMembers.add("Emily");
        familyMembers.add("Sam");
        familyMembers.add("Jack");
        familyMembers.add("Harry");
    }

    public void displayFlavors(){
        System.out.println("Lets vote favorite ice cream flavors. Here are your options:");
        for (String aFlavor : flavors) {
            System.out.println(aFlavor);
        }
    }

    private String validateFlavor(){
        System.out.println("\nProvide your favorite flavor:");
        boolean validFlavor = false;
        String userFlavor = "";
        
        int currentIteration = 0;
        do {
            
            if (currentIteration > 0){
                System.out.println("Please enter a valid flavor");
            }
                userFlavor = scanner.next().toLowerCase().trim();

            for (String aFlavor : flavors) {
                
                if(aFlavor.equals(userFlavor)){
                    validFlavor = true;                   
                }              
            }
            currentIteration++;
        }while(!validFlavor);
        return userFlavor;
    }

    public void addVote(){
        String userFlavor = validateFlavor();
        Set<String> flavorKeys = votes.keySet();
        boolean hasVotes = false;
        for (String aKey : flavorKeys) {
            if (aKey.equals(userFlavor)) {
                votes.put(aKey, votes.get(aKey)+1);
                hasVotes = true;
            }
        }
        if(!hasVotes){
            votes.put(userFlavor, 1);
        }
    }

    public void displayFinalVotes(){
        Set<String> keys = votes.keySet();
        int highestVotes = 0;
        System.out.println("The flavors with the most votes are:");
        for (String aKey : keys) {
                if (votes.get(aKey) > highestVotes){
                    highestVotes = votes.get(aKey);
                }
            }
        for (String aKey : keys) {
            if (votes.get(aKey).equals(highestVotes)){
                System.out.println(aKey);
            }
        } 
        scanner.close();
    }
}
