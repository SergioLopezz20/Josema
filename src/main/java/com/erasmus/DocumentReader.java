package com.erasmus;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentReader {

    public List<University> readDocument(String filePath) {
        List<University> universities = new ArrayList<>();

        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            String[] lines = text.split("\n");
            for (int i = 1; i < lines.length; i++) {
                String[] cells = lines[i].split("\\|");
                if (cells.length < 5) continue;

                String country = cells[0].trim();
                String universityName = cells[1].trim();
                String destinationSubject = cells[2].trim();
                String etsisiSubject = cells[3].trim();
                String procede = cells[4].trim();

                University university = findOrCreateUniversity(universities, universityName, country);
                university.addSubject(new Subject(destinationSubject, etsisiSubject, procede));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return universities;
    }

    private University findOrCreateUniversity(List<University> universities, String name, String country) {
        for (University university : universities) {
            if (university.getName().equals(name) && university.getCountry().equals(country)) {
                return university;
            }
        }

        University newUniversity = new University(name, country);
        universities.add(newUniversity);
        return newUniversity;
    }
}
