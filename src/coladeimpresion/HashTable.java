/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coladeimpresion;

/**
 * HashTable, clase usada para representar una tabla hash que dado un nombre de usuario 
 * como key value, retorna una lista de registros los cuales representan los documentos 
 * que el usuario ha mandado a la impresora
 * @author Samuel
 */
public class HashTable {
    private List<List<UserDocuments>> hashTable;
    private int max = 300;

    public List<List<UserDocuments>> getHashTable() {
        return hashTable;
    }

    public void setHashTable(List<List<UserDocuments>> hashTable) {
        this.hashTable = hashTable;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    public class UserDocuments {
        private String username;
        private List<Register> documentsInPrinter;

        public UserDocuments(String username, List<Register> documentsInPrinter) {
            this.username = username;
            this.documentsInPrinter = documentsInPrinter;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<Register> getDocumentsInPrinter() {
            return documentsInPrinter;
        }

        public void setDocumentsInPrinter(List<Register> documentsInPrinter) {
            this.documentsInPrinter = documentsInPrinter;
        }
    }
    
    public HashTable(){
        hashTable = new List<>();
        for (int i = 0; i < getMax(); i++) {
            hashTable.append(new List<>());
        }
    }
    
    //Añade un elemento a la HashTable, usando el nombre de usuario como key
    public void put(String username, List<Register> documents) {
        List<UserDocuments> list = hashTable.get(Math.abs(username.hashCode()) % getMax());
        
        Node<UserDocuments> u = list.getHead();
        while(u != null){
            if (u.getData().getUsername().equals(username)){
                u.getData().setDocumentsInPrinter(documents);
                return;
            }
            u = u.getNext();
        } 
            
        UserDocuments user = new UserDocuments(username, documents);
        list.append(user);
    }
    
    //Obtiene la lista de registros dada la key (username)
    public List<Register> get(String username) {
        List<UserDocuments> list = hashTable.get(Math.abs(username.hashCode()) % getMax());

        if (list != null) {
            Node<UserDocuments> u = list.getHead();
            while(u != null){
                if (u.getData().getUsername().equals(username)){
                    return u.getData().getDocumentsInPrinter();
                }
                u = u.getNext();
            } 
        }
        return null;
    }
}
