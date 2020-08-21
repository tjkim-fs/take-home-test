package org.tj.scheintakehometest.service;

import org.springframework.stereotype.Service;

@Service
public class PatientStringFormatter {

    public String csvToSquareBrackets(String patientsInCSV) {
        String result;

        result = patientsInCSV.replace("\",\"", "] [");
        int lastId = result.lastIndexOf("\"");
        result = result.substring(0, lastId) + "]" + result.substring(lastId + 1);
        result = result.replace("\"\r\n", "]\r\n");
        result = result.replace("\"\n", "]\n");
        result = result.replace("\"", "[");

        return result;
    }

}
