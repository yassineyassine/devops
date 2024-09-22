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

    public Optional<MesEtudiantModule> getTajilProductByProductId(UUID id){
        return tajilProducts.stream().filter(t -> t.getProductId().equals(id)).findFirst();
    }

    public MesEtudiantModule createTajilProduct(MesEtudiantModule tajilProduct){
        tajilProducts.add(tajilProduct);
        return tajilProduct;
    }

    public Optional<MesEtudiantModule> updateTajilProduct(UUID id, MesEtudiantModule tajilProductDetails){
        Optional<MesEtudiantModule> tajilProductOptional = getTajilProductByProductId(id);
        if (tajilProductOptional.isPresent()) {
            MesEtudiantModule tajilProduct = tajilProductOptional.get();
            tajilProduct.setProductName(tajilProductDetails.getProductName());
            tajilProduct.setProductDesciption(tajilProductDetails.getProductDesciption());
            tajilProduct.setProductPrice(tajilProductDetails.getProductPrice());
            tajilProduct.setProductCategory(tajilProductDetails.getProductCategory());
            tajilProduct.setProductStock(tajilProductDetails.getProductStock());
        }

        return tajilProductOptional;
    }

    public void deleteTajilProduct(UUID id){
        tajilProducts.removeIf(t -> t.getProductId().equals(id));
    }
}
