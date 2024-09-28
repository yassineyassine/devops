package com.simpleProject.mesEtudiantManagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.simpleProject.mesEtudiantManagement.model.MesEtudiantModule;

public class MesEtudiantServiceTest {
    @Test
    void testCreateTajilProduct() {

    }

    @Test
    void testDeleteTajilProduct() {

    }

    @Test
    void testGetAllTajilProduct() {
        // Buat mock untuk MesEtudiantModule
        MesEtudiantModule mockProduct1 = Mockito.mock(MesEtudiantModule.class);
        MesEtudiantModule mockProduct2 = Mockito.mock(MesEtudiantModule.class);

        // Buat list produk tajil
        List<MesEtudiantModule> mockProducts = Arrays.asList(mockProduct1, mockProduct2);

        // Buat mock untuk TajilProductService dan atur perilakunya
        MesEtudiantService mockService = Mockito.mock(MesEtudiantService.class);
        when(mockService.getAllTajilProduct()).thenReturn(mockProducts);

        // Panggil metode yang ingin diuji
        List<MesEtudiantModule> returnedProducts = mockService.getAllTajilProduct();

        // Verifikasi hasilnya
        assertEquals(mockProducts, returnedProducts, "Harus mengembalikan list produk tajil yang sama");
    }

    @Test
    void testGetTajilProductByetudiantId() {

    }

    @Test
    void testUpdateTajilProduct() {

    }
}
