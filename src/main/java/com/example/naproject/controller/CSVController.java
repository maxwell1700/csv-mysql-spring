package com.example.naproject.controller;

import com.example.naproject.Response;
import com.example.naproject.model.CSVModel;
import com.example.naproject.service.CSVServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/csv")
public class CSVController {

    @Autowired
    CSVServiceImpl fileService;



    @PostMapping("/loadcsv")
    public ResponseEntity<Response>  setCSVInDataBase() throws IOException {
        String message = "";
       try{
           fileService.setCSVData();

           message = "Uploaded the file successfully: ";
           return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
       } catch (Exception e) {
           message = "Could not load the file";
           return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
       }
    }


    @GetMapping("/getcsv")
    public ResponseEntity<List<CSVModel>> getAllRecords() {
        try {
            List<CSVModel> csvModels = fileService.getAllCSVRecords();

            if (csvModels.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(csvModels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/setcsv/{id}")
    public ResponseEntity<Response> updateCSVRecord(@RequestBody CSVModel csvModel, @PathVariable int id){
        String message = "";
       try{
           fileService.updateRecord(csvModel,id);
           message = "Record updated successfully";
           return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
       } catch (Exception e) {
           message = "Could not update record";
           return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
       }
    }

}