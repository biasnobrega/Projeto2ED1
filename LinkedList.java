public class LinkedList {
    private Node head;  // Cabeça da lista

    public LinkedList() {
        this.head = null;
    }

    // Insere uma nova linha na lista
    public void insert(int lineNumber, String instruction) {
        Node newNode = new Node(lineNumber, instruction);
        if (head == null || head.lineNumber > lineNumber) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.lineNumber < lineNumber) {
            current = current.next;
        }
        
        if (current.next != null && current.next.lineNumber == lineNumber) {
            current.next.instruction = instruction; // Atualiza a linha existente
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remove uma linha pelo número
    public void delete(int lineNumber) {
        if (head == null) return;

        if (head.lineNumber == lineNumber) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.lineNumber != lineNumber) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next; // Remove o nó
        }
    }

    // Exibe as instruções
    public void list() {
        Node current = head;
        while (current != null) {
            System.out.println(current.lineNumber + " " + current.instruction);
            current = current.next;
        }
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return head == null;
    }
}
