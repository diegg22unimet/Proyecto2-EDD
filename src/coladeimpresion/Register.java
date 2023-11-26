/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coladeimpresion;

/**
 * Clase Register, la misma representa un documento en la impresora
 * @author manza
 */
public class Register {
    private Document document;
    private int time;

    public Register(Document document, int time) {
        this.document = document;
        this.time = time;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString(){
        return "(" + time + ")";
    }
    
}
