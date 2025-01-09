import java.util.List;

import iceCream.flavors.IceCream;

public class App {
    public static void main(String[] args) throws Exception {
          IceCream iceCream = new IceCream();

        iceCream.loadFamily();
        iceCream.loadFlavors();

        List<String> familyMembers = iceCream.getFamilyMembers();

        for (String aMember : familyMembers) {
            System.out.println("Welcome " + aMember + "!");
            iceCream.displayFlavors();
            iceCream.addVote();
            System.out.println("Thank you for your vote " + aMember + "!\n");
        }

        iceCream.displayFinalVotes();
    }    
}
