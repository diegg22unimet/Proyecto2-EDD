/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coladeimpresion;

/**
 * Clase User, usada para representar un usuario y cada uno puede tener cero o más documentos 
 * @author manza
 */
public class User {
    private String username;
    private String priority;
    List<Document> createdDocuments;

    public User(String username, String priority) {
        this.username = username;
        this.priority = priority;
        this.createdDocuments = new List<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<Document> getCreatedDocuments() {
        return createdDocuments;
    }

    public void setCreatedDocuments(List<Document> createdDocuments) {
        this.createdDocuments = createdDocuments;
    }

}
