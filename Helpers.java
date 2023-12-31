import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {

    // Essa classe possui algumas funções que auxiliam na execução do programa principal

    public void printLogo(boolean imprime) {
        
        // Função que imprime o logo do programa com fonte ASCII
        if (!imprime) {
            return;
        }

        System.out.println("\n  /$$$$$$  /$$           /$$$$$$$            /$$$$$$$ \r\n" + //
                " /$$__  $$|__/          | $$__  $$          | $$__  $$\r\n" + //
                "| $$  \\ $$ /$$  /$$$$$$ | $$  \\ $$ /$$$$$$$ | $$  \\ $$\r\n" + //
                "| $$$$$$$$| $$ /$$__  $$| $$$$$$$ | $$__  $$| $$$$$$$ \r\n" + //
                "| $$__  $$| $$| $$  \\__/| $$__  $$| $$  \\ $$| $$__  $$\r\n" + //
                "| $$  | $$| $$| $$      | $$  \\ $$| $$  | $$| $$  \\ $$\r\n" + //
                "| $$  | $$| $$| $$      | $$$$$$$/| $$  | $$| $$$$$$$/\r\n" + //
                "|__/  |__/|__/|__/      |_______/ |__/  |__/|_______/\n");
    }

    public void printUser(boolean imprime) {

        // Função que imprime o logo para usuários com fonte ASCII
        if (!imprime) {
            return;
        }
        System.out.println("\n  /$$$$$$  /$$           /$$$$$$$            /$$$$$$$                      /$$   /$$                              \r\n" + //
                " /$$__  $$|__/          | $$__  $$          | $$__  $$                    | $$  | $$                              \r\n" + //
                "| $$  \\ $$ /$$  /$$$$$$ | $$  \\ $$ /$$$$$$$ | $$  \\ $$                    | $$  | $$  /$$$$$$$  /$$$$$$   /$$$$$$ \r\n" + //
                "| $$$$$$$$| $$ /$$__  $$| $$$$$$$ | $$__  $$| $$$$$$$        /$$$$$$      | $$  | $$ /$$_____/ /$$__  $$ /$$__  $$\r\n" + //
                "| $$__  $$| $$| $$  \\__/| $$__  $$| $$  \\ $$| $$__  $$      |______/      | $$  | $$|  $$$$$$ | $$$$$$$$| $$  \\__/\r\n" + //
                "| $$  | $$| $$| $$      | $$  \\ $$| $$  | $$| $$  \\ $$                    | $$  | $$ \\____  $$| $$_____/| $$      \r\n" + //
                "| $$  | $$| $$| $$      | $$$$$$$/| $$  | $$| $$$$$$$/                    |  $$$$$$/ /$$$$$$$/|  $$$$$$$| $$      \r\n" + //
                "|__/  |__/|__/|__/      |_______/ |__/  |__/|_______/                      \\______/ |_______/  \\_______/|__/      \r\n");
    }

    public void printProp(boolean imprime) {

        if (!imprime) {
            return;
        }
        // Função que imprime o logo para proprietários com fonte ASCII
        System.out.println("\n  /$$$$$$  /$$           /$$$$$$$            /$$$$$$$                      /$$$$$$$                    \r\n" + //
                " /$$__  $$|__/          | $$__  $$          | $$__  $$                    | $$__  $$                   \r\n" + //
                "| $$  \\ $$ /$$  /$$$$$$ | $$  \\ $$ /$$$$$$$ | $$  \\ $$                    | $$  \\ $$ /$$$$$$   /$$$$$$ \r\n" + //
                "| $$$$$$$$| $$ /$$__  $$| $$$$$$$ | $$__  $$| $$$$$$$        /$$$$$$      | $$$$$$$//$$__  $$ /$$__  $$\r\n" + //
                "| $$__  $$| $$| $$  \\__/| $$__  $$| $$  \\ $$| $$__  $$      |______/      | $$____/| $$  \\__/| $$  \\ $$\r\n" + //
                "| $$  | $$| $$| $$      | $$  \\ $$| $$  | $$| $$  \\ $$                    | $$     | $$      | $$  | $$\r\n" + //
                "| $$  | $$| $$| $$      | $$$$$$$/| $$  | $$| $$$$$$$/                    | $$     | $$      |  $$$$$$/\r\n" + //
                "|__/  |__/|__/|__/      |_______/ |__/  |__/|_______/                     |__/     |__/       \\______/ \n");
    }

    public void printError(boolean imprime) {
        if (!imprime) {
            return;
        }
        System.out.println("\n /$$$$$$$$ /$$$$$$$  /$$$$$$$   /$$$$$$  /$$$$$$$  /$$\r\n" + //
                "| $$_____/| $$__  $$| $$__  $$ /$$__  $$| $$__  $$| $$\r\n" + //
                "| $$      | $$  \\ $$| $$  \\ $$| $$  \\ $$| $$  \\ $$| $$\r\n" + //
                "| $$$$$   | $$$$$$$/| $$$$$$$/| $$  | $$| $$$$$$$/| $$\r\n" + //
                "| $$__/   | $$__  $$| $$__  $$| $$  | $$| $$__  $$|__/\r\n" + //
                "| $$      | $$  \\ $$| $$  \\ $$| $$  | $$| $$  \\ $$    \r\n" + //
                "| $$$$$$$$| $$  | $$| $$  | $$|  $$$$$$/| $$  | $$ /$$\r\n" + //
                "|________/|__/  |__/|__/  |__/ \\______/ |__/  |__/|__/\n");
    }

    public void printSeeYa(boolean imprime) {
        if (!imprime) {
            return;
        }
        System.out.println("\n  /$$$$$$                            /$$     /$$        /$$\r\n" + //
                " /$$__  $$                          |  $$   /$$/       | $$\r\n" + //
                "| $$  \\__/  /$$$$$$   /$$$$$$        \\  $$ /$$//$$$$$$ | $$\r\n" + //
                "|  $$$$$$  /$$__  $$ /$$__  $$        \\  $$$$/|____  $$| $$\r\n" + //
                " \\____  $$| $$$$$$$$| $$$$$$$$         \\  $$/  /$$$$$$$|__/\r\n" + //
                " /$$  \\ $$| $$_____/| $$_____/          | $$  /$$__  $$    \r\n" + //
                "|  $$$$$$/|  $$$$$$$|  $$$$$$$          | $$ |  $$$$$$$ /$$\r\n" + //
                " \\______/  \\_______/ \\_______/          |__/  \\_______/|__/\n");
    }

    public int getInt() {
            // Função que retorna um inteiro digitado pelo usuário
            Scanner sc = new Scanner(System.in);
            int num = 0;
            boolean erro = false;
            do {
                try {
                    num = sc.nextInt();
                    erro = false;
                } catch (InputMismatchException e) {
                    System.out.print("Entrada inválida! Digite novamente: ");
                    erro = true;
                    sc.nextLine();
                }
            } while (erro);
            return num;
    }

    public double getDouble() {

        // Função que retorna um double digitado pelo usuário
        Scanner sc = new Scanner(System.in);
        double num = 0;
        boolean erro = false;
        do {
            try {
                num = sc.nextDouble();
                erro = false;
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida! Digite novamente: ");
                erro = true;
                sc.nextLine();
            }
        } while (erro);
        return num;
    }

    public boolean verificaEmail(String email) {

        // Verifica se o email é válido a partir do uso de REGEX
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(email);
        boolean match = matcher.find();
        return match;
    }

    public void clearScreen() {
        // Função que limpa a tela do terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void opCancelada() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nOperação cancelada!");
        System.out.print("Pressione ENTER para continuar...");
        sc.nextLine();
    }

}
