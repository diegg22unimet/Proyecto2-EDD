/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coladeimpresion;

/**
 *
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

        public UserDocuments(String username) {
            this.username = username;
            this.documentsInPrinter = new List<>();
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
        for (int i = 0; i < max; i++) {
            hashTable.append(new List<>());
        }
    }
    
    public void put(String username, List<Register> documents) {
        List<UserDocuments> list = hashTable.get(Math.abs(username.hashCode()) % max);
        
        Node<UserDocuments> u = list.getHead();
        while(u != null){
            if (u.getData().getUsername().equals(username)){
                u.getData().documentsInPrinter = documents;
                return;
            }
            u = u.getNext();
        } 
            
        UserDocuments user = new UserDocuments(username);
        list.append(user);
    }
    
    public List<Register> get(String username) {
        List<UserDocuments> list = hashTable.get(Math.abs(username.hashCode()) % max);

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
