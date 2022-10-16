package com.cg.oam.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.exception.InvalidDataException;
import com.cg.oam.service.IMedicineService;
import com.cg.oam.dto.MedicineDTO;

@RestController
@RequestMapping(value = "/oam/userinterface")
public class MedicineAPI {

    @Autowired
    private IMedicineService iMedicineService;

    @Autowired
    private Environment environment;

    @GetMapping(value = "/medicine")
    public ResponseEntity<List<MedicineDTO>> getAllMedicines() throws InvalidDataException{
        List<MedicineDTO> medicineDTOs = iMedicineService.showAllMedicine();
        return new ResponseEntity<List<MedicineDTO>>(medicineDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/medicine/{medicineId}")
    public ResponseEntity<MedicineDTO> getMedicine(@RequestBody MedicineDTO inputMedicineDTO) throws InvalidDataException{
        MedicineDTO medicineDTO = iMedicineService.viewMedicine(inputMedicineDTO);
        return new ResponseEntity<MedicineDTO>(medicineDTO,HttpStatus.OK);
    }

    @PostMapping(value = "/medicine")
    public ResponseEntity<String> addMedicine(@RequestBody MedicineDTO newMedicineDTO) throws InvalidDataException{
        iMedicineService.addMedicine(newMedicineDTO);
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + newMedicineDTO.getMedicineId();
        return new ResponseEntity<String>(successMessage,HttpStatus.CREATED);
    }

    @PutMapping(value = "/medicine/{medicineId}")
    public ResponseEntity<String> updateMedicine(@RequestBody MedicineDTO newmeMedicineDTO) throws InvalidDataException{
        iMedicineService.updateMedicine(newmeMedicineDTO);
        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<String>(successMessage,HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/medicine/{medicineId}")
    public ResponseEntity<String> deleleMedicine(@RequestBody MedicineDTO medicineDTO) throws InvalidDataException{
        iMedicineService.deleteMedicine(medicineDTO);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<String>(successMessage,HttpStatus.OK);
    }
    
}