package Quiz;
import Game.GameWriteable;
import java.util.HashMap;
import java.util.Scanner;

public class Quiz implements GameWriteable{

        static Scanner sc = new Scanner(System.in);
        static boolean isPlaying = true;
        
        @Override
        public void play(){

                // Create Categories
                Category answer = new Category(
                                "Answer.java",
                                "Efficient, you may not be the most complex file but without you everything would fall apart");
                Category category = new Category(
                                "Category.java",
                                "Your greatest strength is your personality, and you being unapologetically yourself inspires those around you");
                Category question = new Category(
                                "Question.java",
                                "A calm and intelligent mind, you question the world around you and seek out knowledge in everything");
                Category quiz = new Category(
                                "Quiz.java",
                                "You are a leader, the backbone of any group. When you speak, everyone listens.");

                // Create Questions
                Question q1 = new Question("What is your favorite color?");
                q1.possibleAnswers[0] = new Answer("Red", answer);
                q1.possibleAnswers[1] = new Answer("Yellow", category);
                q1.possibleAnswers[2] = new Answer("Blue", question);
                q1.possibleAnswers[3] = new Answer("Green", quiz);

                Question q2 = new Question("What do you do when starting to write an essay?");
                q2.possibleAnswers[0] = new Answer("Outline", answer);
                q2.possibleAnswers[1] = new Answer("Brainstorm", quiz);
                q2.possibleAnswers[2] = new Answer("Skip the planning stage and go straight into writing", category);
                q2.possibleAnswers[3] = new Answer("Think deeply about the essay topic", question);

                Question q3 = new Question(
                                "If you could be anywhere (out of these options) right now, where would you be?");
                q3.possibleAnswers[0] = new Answer("Library", question);
                q3.possibleAnswers[1] = new Answer("Some place I’ve never been before", quiz);
                q3.possibleAnswers[2] = new Answer("Home", answer);
                q3.possibleAnswers[3] = new Answer("Right here!", category);

                Question q4 = new Question("If you could have a super power, what would it be?");
                q4.possibleAnswers[0] = new Answer("Flight", category);
                q4.possibleAnswers[1] = new Answer("Mind reading", question);
                q4.possibleAnswers[2] = new Answer("Invincibility", answer);
                q4.possibleAnswers[3] = new Answer("Force fields", quiz);

                Question q5 = new Question("If you had infinite money, what would be the first thing you would buy?");
                q5.possibleAnswers[0] = new Answer("A lab for science experiments", question);
                q5.possibleAnswers[1] = new Answer("A new house", answer);
                q5.possibleAnswers[2] = new Answer("A cool car", category);
                q5.possibleAnswers[3] = new Answer("A business", quiz);

                Question q6 = new Question("If faced with a lion, what do you do?");
                q6.possibleAnswers[0] = new Answer("Run away screaming", answer);
                q6.possibleAnswers[1] = new Answer("Lure it away", question);
                q6.possibleAnswers[2] = new Answer("Back away slowly", quiz);
                q6.possibleAnswers[3] = new Answer("Try to tame it", category);

                Question q7 = new Question("What do you do in your free time?");
                q7.possibleAnswers[0] = new Answer("Read a book", question);
                q7.possibleAnswers[1] = new Answer("Play a sport", answer);
                q7.possibleAnswers[2] = new Answer("Practice a skill", quiz);
                q7.possibleAnswers[3] = new Answer("Hang out with friends", category);

                Question q8 = new Question("When do you go to bed each night?");
                q8.possibleAnswers[0] = new Answer("Once I finish the book I am reading", question);
                q8.possibleAnswers[1] = new Answer("Once I finish all the work I am doing", quiz);
                q8.possibleAnswers[2] = new Answer("After all of my friends go to sleep", category);
                q8.possibleAnswers[3] = new Answer("8 hours before I wake up", answer);

                HashMap<String, Integer> pastPlays = new HashMap<>();
                pastPlays.put("Answer.java", 0);
                pastPlays.put("Category.java", 0);
                pastPlays.put("Question.java", 0);
                pastPlays.put("Quiz.java", 0);

                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8 };
                Category[] cList = { answer, category, question, quiz };

                while (isPlaying) {
                        String mostPopular = "";
                        int maxPlays = 0;
                        gameIntro();
                        if (!isPlaying)
                                break;

                        for (Category c : cList) {
                                c.points = 0;
                        }

                        for (Question q : qList) {
                                Category c = q.ask(sc);
                                c.points++;
                        }

                        int index = getMostPopularCatIndex(cList);

                        System.out.println("\nIf you were a BuzzFeedQuiz.java file, you would be " + cList[index].label
                                        + ".");
                        System.out.println(cList[index].description);

                        String label = cList[index].label;
                        pastPlays.put(label, pastPlays.get(label) + 1);

                        System.out.println("category popularity:");
                        for (String key : pastPlays.keySet()) {
                                System.out.println(key + ", " + pastPlays.get(key));
                        }
                        

                        for (String key : pastPlays.keySet()) {
                                if (pastPlays.get(key) > maxPlays) {
                                        maxPlays = pastPlays.get(key);
                                        mostPopular = key;
                                }
                        }
                        System.out.println("The most popular category is: " + mostPopular);
                }
        }

        public static void gameIntro() {
                System.out.println("\nWhich BuzzFeedQuiz file Are You?");
                System.out.println("Choose numbers 1-4 for each question. Enter '1' to play!");
                int play = sc.nextInt();
                if (play != 1) {
                        isPlaying = false;
                }
        }

        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }


        @Override
        public String getGameName() {
            return "Quiz";
        }

    @Override
    public boolean isHighScore(String score, String currentHighScore) {
        return false;
    }

    @Override
    public String getScore() {
        return "";
    }
}
