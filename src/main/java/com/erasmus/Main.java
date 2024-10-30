package com.erasmus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "path/to/your/document.docx";
        DocumentReader documentReader = new DocumentReader();
        List<University> universities = documentReader.readDocument(filePath);

        Menu menu = new Menu(universities);
        menu.displayMenu();
    }
}
