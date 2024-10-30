package com.erasmus;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentReader {

    public List<University> readDocument(String filePath) {
        List<University> universities = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            XWPFTable table = document.getTables().get(0);

            for (int i = 1; i < table.getRows().size(); i++) {
                XWPFTableRow row = table.getRow(i);
                String country = row.getCell(0).getText();
                String universityName = row.getCell(1).getText();
                String destinationSubject = row.getCell(2).getText();
                String etsisiSubject = row.getCell(3).getText();
                String procede = row.getCell(4).getText();

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
