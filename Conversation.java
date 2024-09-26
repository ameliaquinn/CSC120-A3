import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * <p> This class can execute a basic conversation with the Chatbot. </p>
 * @author Amelia Quinn
 * @version 1.0
 */
class Conversation {

  public static void main(String[] args) {
    // first I create my scanner and my random instance
    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    Random random = new Random();
    List<String> transcript = new ArrayList<>();
// This boolean is to keep track of whether we're going to mirror the user's response
    boolean mirror = false;
    // then I'm making a list of all the pronouns I'm going to check for 
    List<String> pronounList = new ArrayList<>();
    pronounList.add("I");
    pronounList.add("me");
    pronounList.add("am");
    pronounList.add("you");
    pronounList.add("my");
    pronounList.add("your");
    // Then I make a corresponding lists of all the replaecment pronouns
    List<String> replacementList = new ArrayList<>();
    replacementList.add("you");
    replacementList.add("you");
    replacementList.add("are");
    replacementList.add("I");
    replacementList.add("your");
    replacementList.add("my");
    // Then we ask the user how many rounds and store their response
    System.out.println("How many rounds?");
    int roundCount = scanner.nextInt();
    // Then we begin the conversation and iterate as many times as the user tells us!
    String hello = "Hello! What's on your mind?";
    System.out.println(hello);
    transcript.add(hello);
    for (int i=1; i<= roundCount; i++) {
      Scanner newScanner = new Scanner(System.in);
      String userResponse = newScanner.nextLine();
      transcript.add(userResponse);
      for (int n=0; n <= 5; n++) {
        String pronoun = pronounList.get(n);
        String replacement = replacementList.get(n);
        if (userResponse.contains(pronoun)) {
          userResponse = userResponse.replaceAll(pronoun,replacement);
          mirror = true;
        } }
      if (mirror == true) {
      System.out.println(userResponse + "?"); 
      transcript.add(userResponse + "?");
    } else {
        List<String> cannedResponses = new ArrayList<>();
        cannedResponses.add("Interesting!");
        cannedResponses.add("Mm-hm!");
        cannedResponses.add("Uh-huh.");
        int randomIdentifier = random.nextInt(cannedResponses.size());
        String randomResponse = cannedResponses.get(randomIdentifier);
        System.out.println(randomResponse);
        transcript.add(randomResponse);
        }
        newScanner.close();
       }
       scanner.close();
       scanner2.close();
       System.out.println(transcript);
      }
      
      }
    



  

