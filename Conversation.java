import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
 * <p> This class can execute a basic conversation with the Chatbot. </p>
 * @author Amelia Quinn
 * @version 2.0
 */
class Conversation {
  public static void main(String[] args) {
    String[] inputs = {"I","me","am","you","my","your", "are", "You"};
    String[] replacements = {"you", "you", "are", "I", "your", "my", "am", "I"};
    String[] cannedResponses = {"Uh-huh.", "Mm-hm!", "Interesting!", "Tell me more!"};
    ArrayList<String> transcript = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    String opener = "How many rounds?";
    System.out.println(opener);
    transcript.add(opener);
    int roundNum = sc.nextInt();
    transcript.add(String.valueOf(roundNum));
    sc.nextLine();
    System.out.println("What's on your mind?");
    for (int n = 0; n < roundNum; n++) {
      String input = sc.nextLine();
      transcript.add(input);
      String[] words = input.split(" ");
      boolean changed = false;
      outer:
      for (int i=0; i < words.length; i++) {
        for (int j = 0; j < inputs.length; j++) {
          if (words[i].equals(inputs[j])) {
            words[i] = replacements[j];
            changed = true;
            continue outer;
          }     
        }
      }
      if (changed) {
        String response = String.join(" ", words);
        transcript.add(response);
        System.out.println(response);
      } else {
        int randomNum = random.nextInt(cannedResponses.length);
        String response = cannedResponses[randomNum];
        transcript.add(response);
        System.out.println(response);
      }
    }
    sc.close();
    System.out.println("");
    System.out.println("TRANSCRIPT:");
    for (int i = 0; i < transcript.size(); i++) {
      System.out.println(transcript.get(i));
    }
  }
}