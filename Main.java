import java.util.Scanner;

public class Main {
    private static LinkedList codeList = new LinkedList();  // Lista que armazena o código
    private static boolean hasUnsavedChanges = false;  // Verifica se há alterações não salvas

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        String input;
        
        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().trim();

            if (input.startsWith("LOAD")) {
                loadFile(input.substring(5).trim());
            } else if (input.equalsIgnoreCase("LIST")) {
                listCode();
            } else if (input.equalsIgnoreCase("RUN")) {
                runCode();
            } else if (input.startsWith("INS")) {
                insertInstruction(input.substring(4).trim());
            } else if (input.startsWith("DEL")) {
                deleteLine(input.substring(4).trim());
            } else if (input.equalsIgnoreCase("SAVE")) {
                saveFile();
            } else if (input.startsWith("SAVE")) {
                saveAs(input.substring(5).trim());
            } else if (input.equalsIgnoreCase("EXIT")) {
                exit();
            } else {
                System.out.println("Erro: comando inválido.");
            }
        }
    }

    // Comando LOAD: Carrega um arquivo
    private static void loadFile(String filePath) {
        // Implemente a lógica de carregamento do arquivo aqui
        System.out.println("Arquivo '" + filePath + "' carregado com sucesso.");
    }

    // Comando LIST: Lista o código carregado
    private static void listCode() {
        if (codeList.isEmpty()) {
            System.out.println("Erro: nenhum código carregado.");
        } else {
            codeList.list();
        }
    }

    // Comando RUN: Executa o código
    private static void runCode() {
        if (codeList.isEmpty()) {
            System.out.println("Erro: nenhum código carregado.");
        } else {
            // Implemente a execução do código Assembly aqui
            System.out.println("Executando código...");
        }
    }

    // Comando INS: Insere ou atualiza uma linha
    private static void insertInstruction(String args) {
        String[] parts = args.split(" ", 2);
        int lineNumber = Integer.parseInt(parts[0]);
        String instruction = parts[1];

        codeList.insert(lineNumber, instruction);
        hasUnsavedChanges = true;
        System.out.println("Linha inserida: " + lineNumber + " " + instruction);
    }

    // Comando DEL: Deleta uma linha
    private static void deleteLine(String args) {
        int lineNumber = Integer.parseInt(args.trim());
        codeList.delete(lineNumber);
        hasUnsavedChanges = true;
        System.out.println("Linha removida: " + lineNumber);
    }

    // Comando SAVE: Salva o código no arquivo atual
    private static void saveFile() {
        if (hasUnsavedChanges) {
            // Salve o arquivo atual aqui
            System.out.println("Arquivo salvo com sucesso.");
            hasUnsavedChanges = false;
        } else {
            System.out.println("Nenhuma alteração para salvar.");
        }
    }

    // Comando SAVE <ARQUIVO>: Salva o código em um novo arquivo
    private static void saveAs(String filePath) {
        // Salve o código no arquivo especificado aqui
        System.out.println("Arquivo '" + filePath + "' salvo com sucesso.");
        hasUnsavedChanges = false;
    }

    // Comando EXIT: Encerra o programa
    private static void exit() {
        if (hasUnsavedChanges) {
            System.out.print("Arquivo atual contém alterações não salvas. Deseja salvar? (S/N) ");
            Scanner Scanner = new Scanner(System.in);
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("S")) {
                saveFile();
            }
        }
        System.out.println("Fim.");
        System.exit(0);
    }
}
