package com.example.service_paiement_multidevises.mapper;


import com.example.service_paiement_multidevises.dto.CarteVirtuelleDTO;
import com.example.service_paiement_multidevises.entity.CarteVirtuelle;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("CartevirtuelleMapper")
public class CarteVirtuelleMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    // Custom mapping: Only map utilisateur.id to utilisateurId in DTO


    // Map Transaction to TransactionDTO
    public CarteVirtuelleDTO toDTO(CarteVirtuelle carteVirtuelle) {
        return modelMapper.map(carteVirtuelle, CarteVirtuelleDTO.class);
    }

    // Map TransactionDTO to Transaction
    public  CarteVirtuelle toEntity(CarteVirtuelleDTO carteVirtuelleDTO) {
        return modelMapper.map(carteVirtuelleDTO, CarteVirtuelle.class);
    }
}
