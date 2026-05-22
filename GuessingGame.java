import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private int secretNumber;
    private int attempts;
    private int score;
    private Random random;
    private Scanner scanner;

    public GuessingGame() {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.score = 0;
    }

    public void startNewGame() {
        this.secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        this.attempts = 0;
        playGame();
    }

    private void playGame() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎮 JOGO DE ADIVINHAÇÃO");
        System.out.println("=".repeat(50));
        System.out.println("Tente adivinhar o número entre " + MIN_NUMBER + " e " + MAX_NUMBER);
        System.out.println("=".repeat(50) + "\n");

        boolean guessed = false;

        while (!guessed) {
            System.out.print("Digite seu palpite: ");
            
            try {
                int guess = Integer.parseInt(scanner.nextLine().trim());
                attempts++;

                if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                    System.out.println("⚠️  Digite um número entre " + MIN_NUMBER + " e " + MAX_NUMBER);
                    attempts--;
                    continue;
                }

                if (guess == secretNumber) {
                    guessed = true;
                    handleCorrectGuess();
                } else if (guess < secretNumber) {
                    System.out.println("📈 O número é MAIOR que " + guess);
                    showHint(guess);
                } else {
                    System.out.println("📉 O número é MENOR que " + guess);
                    showHint(guess);
                }

                System.out.println("Tentativas: " + attempts + "\n");

            } catch (NumberFormatException e) {
                System.out.println("✗ Digite um número válido!\n");
                attempts--;
            }
        }
    }

    private void showHint(int guess) {
        int difference = Math.abs(secretNumber - guess);
        if (difference <= 5) {
            System.out.println("🔥 Muito quente!");
        } else if (difference <= 15) {
            System.out.println("🌡️  Quente!");
        } else if (difference <= 30) {
            System.out.println("❄️  Frio!");
        } else {
            System.out.println("🥶 Muito frio!");
        }
    }

    private void handleCorrectGuess() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎉 PARABÉNS! Você acertou!");
        System.out.println("=".repeat(50));
        System.out.println("Número: " + secretNumber);
        System.out.println("Tentativas: " + attempts);

        int points = calculateScore(attempts);
        score += points;

        System.out.println("Pontos desta rodada: " + points);
        System.out.println("Pontuação total: " + score);
        System.out.println("=".repeat(50) + "\n");
    }

    private int calculateScore(int attempts) {
        if (attempts <= 3) {
            return 100;
        } else if (attempts <= 5) {
            return 80;
        } else if (attempts <= 10) {
            return 60;
        } else if (attempts <= 15) {
            return 40;
        } else {
            return Math.max(10, 50 - (attempts - 15));
        }
    }

    private void showMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("MENU PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1. Jogar nova rodada");
        System.out.println("2. Ver pontuação");
        System.out.println("3. Limpar pontuação");
        System.out.println("4. Sair");
        System.out.println("=".repeat(50));
    }

    private void run() {
        boolean playing = true;

        System.out.println("\n🎮 Bem-vindo ao Jogo de Adivinhação!");
        System.out.println("Tente adivinhar números e acumule pontos!");

        while (playing) {
            showMenu();
            System.out.print("Escolha uma opção: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    startNewGame();
                    break;
                case "2":
                    System.out.println("\n📊 Sua pontuação: " + score + " pontos\n");
                    break;
                case "3":
                    score = 0;
                    System.out.println("✓ Pontuação resetada!\n");
                    break;
                case "4":
                    System.out.println("\n👋 Até logo! Pontuação final: " + score + " pontos");
                    playing = false;
                    break;
                default:
                    System.out.println("✗ Opção inválida!\n");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.run();
    }
}
