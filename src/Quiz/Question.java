package Quiz;

/* Irene Feng 10/12/2022
A question class with Answers.
*/
import java.util.Scanner;


public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category that corresponds to the answer
    Category ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }
        if (sc.hasNextInt()) {
            int ans = sc.nextInt();
            if (ans <= 4) {
                return possibleAnswers[ans - 1].cat;
            } else {
                Scanner pc = new Scanner(System.in);
                System.out.println("Unidentifiable input. Please enter a number 1 through 4");
                return ask(pc);
            }

        } else {
            Scanner pc = new Scanner(System.in);
            System.out.println("Unidentifiable input. Please enter a number 1 through 4");
            return ask(pc);
        }

    }

}
