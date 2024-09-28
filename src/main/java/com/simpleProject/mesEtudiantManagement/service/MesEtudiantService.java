package com.simpleProject.mesEtudiantManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simpleProject.mesEtudiantManagement.model.MesEtudiantModule;

@Service
public class MesEtudiantService {
    private List<MesEtudiantModule> tajilProducts = new ArrayList<>();

    public List<MesEtudiantModule> getAllTajilProduct() {
        return tajilProducts;
    }

    public Optional<MesEtudiantModule> getTajilProductByetudiantId(UUID id){
        return tajilProducts.stream().filter(t -> t.getEtudiantId().equals(id)).findFirst();

    }

    public MesEtudiantModule createTajilProduct(MesEtudiantModule tajilProduct){
        tajilProducts.add(tajilProduct);
        return tajilProduct;
    }

    public Optional<MesEtudiantModule> updateTajilProduct(UUID id, MesEtudiantModule tajilProductDetails){
        Optional<MesEtudiantModule> tajilProductOptional = getTajilProductByetudiantId(id);
        if (tajilProductOptional.isPresent()) {
            MesEtudiantModule tajilProduct = tajilProductOptional.get();
            tajilProduct.setEtudiantFirstName(tajilProductDetails.getEtudiantFirstName());
            tajilProduct.setEtudiantLastName(tajilProductDetails.getEtudiantLastName());
            tajilProduct.setEtudiantCnssEtab(tajilProductDetails.getEtudiantCnssEtab());
            tajilProduct.setEtudiantEmail(tajilProductDetails.getEtudiantEmail());
            tajilProduct.setEtudiantCIN(tajilProductDetails.getEtudiantCIN());
        }

        return tajilProductOptional;
    }

    public void deleteTajilProduct(UUID id){
        tajilProducts.removeIf(t -> t.getEtudiantId().equals(id));
    }
}
