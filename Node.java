public class Node {
    int lineNumber;  // Número da linha
    String instruction;  // Instrução Assemblyy
    Node next;  // Próximo nó

    // Construtor
    public Node(int lineNumber, String instruction) {
        this.lineNumber = lineNumber;
        this.instruction = instruction;
        this.next = null;
    }
}
