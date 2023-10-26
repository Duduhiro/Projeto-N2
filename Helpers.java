import java.util.InputMismatchException;
import java.util.Scanner;

public class Helpers {

    // Essa classe possui algumas funções que auxiliam na execução do programa principal

    public void printLogo() {
        
        // Função que imprime o logo do programa com fonte ASCII
        System.out.println("\n  /$$$$$$  /$$           /$$$$$$$            /$$$$$$$ \r\n" + //
                " /$$__  $$|__/          | $$__  $$          | $$__  $$\r\n" + //
                "| $$  \\ $$ /$$  /$$$$$$ | $$  \\ $$ /$$$$$$$ | $$  \\ $$\r\n" + //
                "| $$$$$$$$| $$ /$$__  $$| $$$$$$$ | $$__  $$| $$$$$$$ \r\n" + //
                "| $$__  $$| $$| $$  \\__/| $$__  $$| $$  \\ $$| $$__  $$\r\n" + //
                "| $$  | $$| $$| $$      | $$  \\ $$| $$  | $$| $$  \\ $$\r\n" + //
                "| $$  | $$| $$| $$      | $$$$$$$/| $$  | $$| $$$$$$$/\r\n" + //
                "|__/  |__/|__/|__/      |_______/ |__/  |__/|_______/\n");
    }

    public void printUser() {

        // Função que imprime o logo para usuários com fonte ASCII
        System.out.println("\n  /$$$$$$  /$$           /$$$$$$$            /$$$$$$$                      /$$   /$$                              \r\n" + //
                " /$$__  $$|__/          | $$__  $$          | $$__  $$                    | $$  | $$                              \r\n" + //
                "| $$  \\ $$ /$$  /$$$$$$ | $$  \\ $$ /$$$$$$$ | $$  \\ $$                    | $$  | $$  /$$$$$$$  /$$$$$$   /$$$$$$ \r\n" + //
                "| $$$$$$$$| $$ /$$__  $$| $$$$$$$ | $$__  $$| $$$$$$$        /$$$$$$      | $$  | $$ /$$_____/ /$$__  $$ /$$__  $$\r\n" + //
                "| $$__  $$| $$| $$  \\__/| $$__  $$| $$  \\ $$| $$__  $$      |______/      | $$  | $$|  $$$$$$ | $$$$$$$$| $$  \\__/\r\n" + //
                "| $$  | $$| $$| $$      | $$  \\ $$| $$  | $$| $$  \\ $$                    | $$  | $$ \\____  $$| $$_____/| $$      \r\n" + //
                "| $$  | $$| $$| $$      | $$$$$$$/| $$  | $$| $$$$$$$/                    |  $$$$$$/ /$$$$$$$/|  $$$$$$$| $$      \r\n" + //
                "|__/  |__/|__/|__/      |_______/ |__/  |__/|_______/                      \\______/ |_______/  \\_______/|__/      \r\n");
    }

    public void printProp() {

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

}
