package com.example.naproject.service;

import com.example.naproject.model.CSVModel;
import com.example.naproject.repository.CSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Service
public class CSVServiceImpl {

    String line = "";
    @Autowired
    CSVRepository csvRepository;


    public List<CSVModel> getAllCSVRecords() {
        return csvRepository.findAll();
    }


    public void setCSVData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("home/ec2-user/ac56fe111.csv"));

        while((line = br.readLine())!= null){
            String[]data = line.split(",");
            CSVModel csvModel = new CSVModel();
            csvModel.setFilename(data[0]);
            csvModel.setOrigin(data[1]);
            csvModel.setMetadata(data[2]);
            csvModel.setHash(data[3]);
            csvRepository.save(csvModel);
        }

    }
    public CSVModel getRecordById(int id){
        List<CSVModel> rep = csvRepository.findAll();
        return rep.get(id);
    }

    public CSVModel updateRecord(CSVModel csvModel ,int id) {
        CSVModel updatedCSV = new CSVModel();
        updatedCSV.setId(id);
        updatedCSV.setFilename(csvModel.getFilename());
        updatedCSV.setOrigin(csvModel.getOrigin());
        updatedCSV.setHash(csvModel.getHash());
        updatedCSV.setMetadata(csvModel.getMetadata());
        return csvRepository.save(updatedCSV);

    }
}

