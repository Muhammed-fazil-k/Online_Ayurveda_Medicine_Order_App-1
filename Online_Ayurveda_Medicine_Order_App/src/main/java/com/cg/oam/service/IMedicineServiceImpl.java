package com.cg.oam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.dto.MedicineDTO;
import com.cg.oam.entity.Medicine;
import com.cg.oam.exception.InvalidDataException;
import com.cg.oam.repository.IMedicineRepository;
import com.cg.oam.repository.ICategoryRepository;



@Service(value = "iMedicineService")
public class IMedicineServiceImpl implements IMedicineService {

    @Autowired
    private IMedicineRepository iMedicineRepository;

    @Autowired
    private ICategoryRepository iCategoryRepository; 

    

    public MedicineDTO convertEntityToDto(Medicine medicine) {
		MedicineDTO resultOMedicineDto = new MedicineDTO();
		resultOMedicineDto.setMedicineId(medicine.getMedicineId()); 
		resultOMedicineDto.setMedicineName(medicine.getMedicineName());
		resultOMedicineDto.setMedicineCost(medicine.getMedicineCost());
		resultOMedicineDto.setMfd(medicine.getMfd());
		resultOMedicineDto.setExpiryDate(medicine.getExpiryDate());
        resultOMedicineDto.setCompanyName(medicine.getCompanyName());
        resultOMedicineDto.setCategory(medicine.getCategory());

		return resultOMedicineDto;
	}

    @Override
    public MedicineDTO addMedicine(MedicineDTO medicineDTO) throws InvalidDataException {
        // TODO Auto-generated method stub
        Medicine medicineEntity = new Medicine();
        // medicineEntity.setMedicineId(medicineDTO.getMedicineId());
        medicineEntity.setMedicineName(medicineDTO.getMedicineName());
        medicineEntity.setMedicineCost(medicineDTO.getMedicineCost());
        medicineEntity.setMfd(medicineDTO.getMfd());
        medicineEntity.setExpiryDate(medicineDTO.getExpiryDate());
        medicineEntity.setCompanyName(medicineDTO.getCompanyName());
        medicineEntity.setCategory(medicineDTO.getCategory());
        Medicine createdMedicine  = iMedicineRepository.save(medicineEntity);

        MedicineDTO createdMedicineDTO = convertEntityToDto(createdMedicine);

        return createdMedicineDTO;
    }

    @Override
    public MedicineDTO viewMedicine(MedicineDTO medicineDTO) throws InvalidDataException {
        // TODO Auto-generated method stub
        
        Optional<Medicine> optional = iMedicineRepository.findById(medicineDTO.getMedicineId());
		Medicine medicineEntity = optional.orElseThrow(()->new InvalidDataException("Medicine not found"));

		MedicineDTO createdMedicineDTO = convertEntityToDto(medicineEntity);

        return createdMedicineDTO;
    }

    @Override
    public MedicineDTO updateMedicine(MedicineDTO medicineDTO) throws InvalidDataException {
        // TODO Auto-generated method stub
        Optional<Medicine> optional = iMedicineRepository.findById(medicineDTO.getMedicineId());
		Medicine medicineEntity = optional.orElseThrow(()->new InvalidDataException("Medicine not found"));

        if(medicineEntity.getMedicineName()!=null)
			medicineEntity.setMedicineName(medicineEntity.getMedicineName());
        if(medicineEntity.getMedicineCost()!=null)
			medicineEntity.setMedicineCost(medicineEntity.getMedicineCost());
        if(medicineEntity.getMfd()!=null)
			medicineEntity.setMfd(medicineEntity.getMfd());
        if(medicineEntity.getExpiryDate()!=null)
			medicineEntity.setExpiryDate(medicineEntity.getExpiryDate());
        if(medicineEntity.getCompanyName()!=null)
			medicineEntity.setCompanyName(medicineEntity.getCompanyName());
        if(medicineEntity.getCategory()!=null)
			medicineEntity.setCategory(medicineEntity.getCategory());

            MedicineDTO createdMedicineDTO = convertEntityToDto(medicineEntity);

            return createdMedicineDTO;

    }

    @Override
    public MedicineDTO deleteMedicine(MedicineDTO medicineDTO) throws InvalidDataException  {
        // TODO Auto-generated method stub
        Optional<Medicine> optional = iMedicineRepository.findById(medicineDTO.getMedicineId());
		Medicine medicineEntity = optional.orElseThrow(()->new InvalidDataException("Medicine not found"));

        MedicineDTO createdMedicineDTO = convertEntityToDto(medicineEntity);

        
        iMedicineRepository.delete(medicineEntity);
        return createdMedicineDTO;
    }

    @Override
    public List<MedicineDTO> showAllMedicine()throws InvalidDataException  {
        // TODO Auto-generated method stub
        Iterable<Medicine> medicines= iMedicineRepository.findAll(); 
        List<MedicineDTO> medicineDTOs = new ArrayList<>();

        medicines.forEach(medicine->{
            MedicineDTO newmeMedicineDTO = new MedicineDTO(medicine.getMedicineId(), medicine.getMedicineName(), medicine.getMedicineCost(), medicine.getMfd(), medicine.getExpiryDate(), medicine.getCompanyName(),  medicine.getCategory());
            medicineDTOs.add(newmeMedicineDTO);
        });

        return medicineDTOs;
    }
    

}
