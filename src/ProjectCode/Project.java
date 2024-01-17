package ProjectCode;
import java.util.*;
public class Project {
    private static String[] easyWords = {"java", "code", "bug", "debug","tree", "bee", "doll", "toy", "chair", "mother", "father", "piece", "peace", "camel", "horse", "family", "friend", "pony", "jump", "forest", "deer", "clouds", "earth", "moon", "sun", "jelly", "bees", "monkey", "bull"};
    private static String[] mediumWords = {"hangman", "programming", "challenge", "computer", "aggressive","futuristic","imagine","\n" +
            "diverse","Japanese"," religion","produce","platinize"};
    private static String[] hardWords = {"algorithm", "complexity", "encapsulation", "inheritance","entrepreneur","acknowledgement","fraudulent","Literally","Irregardless","Disinterested","Lieutenant","Unabashed"};

    private static String chooseWord(String difficulty) {
        Random random = new Random();
        String[] words;

        switch (difficulty.toLowerCase()) {
            case "easy":
                words = easyWords;
                break;
            case "medium":
                words = mediumWords;
                break;
            case "hard":
                words = hardWords;
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty level");
        }

        return words[random.nextInt(words.length)];
    }

    private static String displayWord(String word, Set<Character> guessedLetters) {
        StringBuilder display = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                display.append(letter);
            } else {
                display.append("_");
            }
        }
        return display.toString();
    }

    private static void displayHangman(int incorrectGuesses, String[] hangmanArt) {
        int maxIndex = Math.min(incorrectGuesses, hangmanArt.length - 1);
        for (int i = 0; i <= maxIndex; i++) {
            System.out.println(hangmanArt[i]);
        }
    }

    private static void handleGuess(String word, Set<Character> guessedLetters, int maxAttempts, int incorrectGuesses, char letterGuess) {
        System.out.println("DEBUG: Guessed letter: " + letterGuess); // Debugging line
        System.out.println("DEBUG: Current word before guess: " + displayWord(word, guessedLetters)); // Debugging line

        // Always add the guessed letter
        guessedLetters.add(letterGuess);

        if (word.indexOf(letterGuess) == -1) {
            incorrectGuesses++;
            System.out.println("Incorrect guess. Attempts remaining: " + (maxAttempts - incorrectGuesses));
            if (incorrectGuesses == maxAttempts) {
                System.out.println("Game over! The word was: " + word);
            }
        } else {
            System.out.println("Impressive guess!");
        }

        System.out.println("DEBUG: Current word after guess: " + displayWord(word, guessedLetters)); // Debugging line
    }

    private static boolean isGameCompleted(String word, Set<Character> guessedLetters) {
        return guessedLetters.containsAll(Arrays.asList(word.chars().mapToObj(c -> (char) c).toArray()));
    }

    private static void playFourWayHangman() {
        Scanner scanner = new Scanner(System.in);

        String word1 = chooseWord("easy");
        String word2 = chooseWord("medium");
        String word3 = chooseWord("medium");
        String word4 = chooseWord("easy");

        Set<Character> commonGuessedLetters = new HashSet<>();

        int incorrectGuesses1 = 0;
        int incorrectGuesses2 = 0;
        int incorrectGuesses3 = 0;
        int incorrectGuesses4 = 0;

        String[] hangmanArt = {"  +---+", "  |   |", "  O   |", "  T   |", "  ^   |", "      |", "========="};

        System.out.println("\nWelcome to the 4-Way Hangman Challenge!");

        while (true) {
            System.out.println("\nWord 1: " + displayWord(word1, commonGuessedLetters));
            System.out.println("Guessed letters: " + commonGuessedLetters);
            displayHangman(incorrectGuesses1, hangmanArt);

            System.out.println("\nWord 2: " + displayWord(word2, commonGuessedLetters));
            System.out.println("Guessed letters: " + commonGuessedLetters);
            displayHangman(incorrectGuesses2, hangmanArt);

            System.out.println("\nWord 3: " + displayWord(word3, commonGuessedLetters));
            System.out.println("Guessed letters: " + commonGuessedLetters);
            displayHangman(incorrectGuesses3, hangmanArt);

            System.out.println("\nWord 4: " + displayWord(word4, commonGuessedLetters));
            System.out.println("Guessed letters: " + commonGuessedLetters);
            displayHangman(incorrectGuesses4, hangmanArt);

            System.out.print("Enter your next letter: ");
            String guess = scanner.nextLine().toLowerCase();

            // Update commonGuessedLetters for all words
            char letterGuess;
            if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
                letterGuess = guess.charAt(0);
                commonGuessedLetters.add(letterGuess);
            } else {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }

            // Handle the guess for Word 1
            handleGuess(word1, commonGuessedLetters, 5, incorrectGuesses1, letterGuess);

            // Handle the guess for Word 2
            handleGuess(word2, commonGuessedLetters, 5, incorrectGuesses2, letterGuess);

            // Handle the guess for Word 3
            handleGuess(word3, commonGuessedLetters, 5, incorrectGuesses3, letterGuess);

            // Handle the guess for Word 4
            handleGuess(word4, commonGuessedLetters, 5, incorrectGuesses4, letterGuess);

            // Check for game over conditions
            if (incorrectGuesses1 >= 5 || incorrectGuesses2 >= 5
                    || incorrectGuesses3 >= 5 || incorrectGuesses4 >= 5) {
                System.out.println("Game over! Exceeded maximum attempts for at least one word.");
                break;
            }

            // Check for game completion conditions
            if (isGameCompleted(word1, commonGuessedLetters) &&
                    isGameCompleted(word2, commonGuessedLetters) &&
                    isGameCompleted(word3, commonGuessedLetters) &&
                    isGameCompleted(word4, commonGuessedLetters)) {
                System.out.println("Congratulations! You've successfully guessed all the words!");
                break;
            }
        }

        scanner.close();
        System.exit(0); // Exit the program upon completing the games
    }

    private static void clearScreen() {
        // Simulate clearing the screen by printing several new lines
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void playCustomHangman() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Custom Hangman!");
        System.out.print("Enter a word to guess: ");
        String wordToGuess = scanner.nextLine().toLowerCase();

        int maxAttempts = 6;
        int incorrectGuesses = 0;
        Set<Character> guessedLetters = new HashSet<>();

        String[] hangmanArt = {"  +---+", "  |   |", "  O   |", "  T   |", "  ^   |", "      |", "========="};

        // Clear the screen before starting the game
        clearScreen();

        while (true) {
            System.out.println("\nCurrent word: " + displayWord(wordToGuess, guessedLetters));
            System.out.println("Guessed letters: " + guessedLetters);
            displayHangman(incorrectGuesses, hangmanArt);

            System.out.print("What's your next guess? Enter a letter: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
                char letterGuess = guess.charAt(0);

                if (guessedLetters.contains(letterGuess)) {
                    // No action if the letter has already been guessed
                } else {
                    guessedLetters.add(letterGuess);

                    if (wordToGuess.indexOf(letterGuess) == -1) {
                        incorrectGuesses++;
                        System.out.println("Incorrect guess. Attempts remaining: " + (maxAttempts - incorrectGuesses));
                        if (incorrectGuesses == maxAttempts) {
                            System.out.println("Game over! You couldn't guess the word.");
                            break;
                        }
                    } else {
                        System.out.println("Nice guess!");
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter a single letter.");
            }

            if (isGameCompleted(wordToGuess, guessedLetters)) {
                System.out.println("Congratulations! You've Guessed the Assigned Word: " + wordToGuess);
                return;
            }
        }

        scanner.close();
        System.exit(0);
    }

    private static void playHangmanGame(String difficulty, int maxAttempts, int numGames) {
        Scanner scanner = new Scanner(System.in);

        for (int game = 1; game <= numGames; game++) {
            int incorrectGuesses = 0;
            Set<Character> guessedLetters = new HashSet<>();
            String wordToGuess = chooseWord(difficulty);

            System.out.println("\nCommencing Game " + game + " of the Hangman Odyssey!");

            while (true) {
                System.out.println("\nCurrent word: " + displayWord(wordToGuess, guessedLetters));
                System.out.println("Guessed letters: " + guessedLetters);

                displayHangman(incorrectGuesses, new String[]{"  +---+", "  |   |", "  O   |", "  T   |", "  ^   |", "      |", "========="});

                System.out.print("What's your next move? Guess a letter or spell out the entire word: ");
                String guess = scanner.nextLine().toLowerCase();

                if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
                    // Single letter guess
                    char letterGuess = guess.charAt(0);

                    if (guessedLetters.contains(letterGuess)) {
                        // No action if the letter has already been guessed
                    } else {
                        guessedLetters.add(letterGuess);

                        if (wordToGuess.indexOf(letterGuess) == -1) {
                            incorrectGuesses++;
                            System.out.println("Incorrect guess. Attempts remaining: " + (maxAttempts - incorrectGuesses));
                        } else {
                            System.out.println("Masterful guess!");
                        }
                    }
                } else if (guess.length() == wordToGuess.length() && guess.equals(wordToGuess)) {
                    // Full word guess
                    System.out.println("Astounding! You've correctly deduced the word: " + wordToGuess);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a single letter or the entire word.");
                }

                // Check for game over conditions
                if (incorrectGuesses == maxAttempts) {
                    System.out.println("Game over! Exceeded maximum attempts. The word was: " + wordToGuess);
                    break; // Exit the loop if maxAttempts is reached
                }

                if (guessedLetters.containsAll(Arrays.asList(wordToGuess.chars().mapToObj(c -> (char) c).toArray()))) {
                    System.out.println("Kudos! You've conquered the word: " + wordToGuess);
                    break;
                }
            }

            if (game < numGames) {
                // If there are more games to play, present a message and await user input to proceed
                System.out.println("\nPress Enter to advance to the next game...");
                scanner.nextLine();
            } else {
                // If it's the final game, conclude the loop
                break;
            }
        }

        scanner.close();
        System.exit(0); // Bid farewell to the program after the gaming saga
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nThe Grand Hangman Adventure Awaits!");
            System.out.println("1. Embark on a Classic Hangman Quest");
            System.out.println("2. Partake in Multiple Word Conquests");
            System.out.println("3. Challenge the 4-Way Hangman Extravaganza");
            System.out.println("4. Test The Game Or Challenge a Local Friend By Choosing A Word To Guess");
            System.out.println("5. Bid Adieu");

            System.out.print("Choose your destiny: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Absorb the newline

            switch (choice) {
                case 1:
                    System.out.print("Select your desired difficulty (easy, medium, hard): ");
                    String difficulty = scanner.nextLine();

                    int maxAttempts;
                    switch (difficulty.toLowerCase()) {
                        case "easy":
                            maxAttempts = 8;
                            break;
                        case "medium":
                            maxAttempts = 6;
                            break;
                        case "hard":
                            maxAttempts = 4;
                            break;
                        default:
                            System.out.println("Invalid difficulty level. Departing...");
                            return;
                    }

                    playHangmanGame(difficulty, maxAttempts, 1);
                    break;
                case 2:
                    System.out.print("Enter the number of games you wish to partake in: ");
                    int numGames = scanner.nextInt();
                    scanner.nextLine(); // Absorb the newline

                    System.out.print("Select your desired difficulty (easy, medium, hard): ");
                    String difficultyMultiple = scanner.nextLine();

                    int maxAttemptsMultiple;
                    switch (difficultyMultiple.toLowerCase()) {
                        case "easy":
                            maxAttemptsMultiple = 8;
                            break;
                        case "medium":
                            maxAttemptsMultiple = 6;
                            break;
                        case "hard":
                            maxAttemptsMultiple = 4;
                            break;
                        default:
                            System.out.println("Invalid difficulty level. Departing...");
                            return;
                    }

                    playHangmanGame(difficultyMultiple, maxAttemptsMultiple, numGames);
                    break;
                case 3:
                    playFourWayHangman();
                    break;
                case 4:
                    playCustomHangman();
                    break;
                case 5:
                    System.out.println("Farewell, Valiant Hangman Explorer! Until we meet again!");
                    return;
                default:
                    System.out.println("Invalid option. Kindly make another selection.");
                    break;
            }
        }
    }}
