package com.simpleProject.mesEtudiantManagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class MesEtudiantModuleTest {
    @Test
    void testCanEqual() {
        MesEtudiantModule product1 = new MesEtudiantModule();
        MesEtudiantModule product2 = new MesEtudiantModule();
        assertTrue(product1.canEqual(product2));
    }

    @Test
    void testEquals() {
        MesEtudiantModule product1 = new MesEtudiantModule();
        MesEtudiantModule product2 = new MesEtudiantModule();
        assertEquals(product1, product2);
    }

    @Test
    void testGetProductCategory() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductCategory("Electronics");
        assertEquals("Electronics", product.getProductCategory());
    }

    @Test
    void testGetProductDesciption() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductDesciption("This is a product");
        assertEquals("This is a product", product.getProductDesciption());
    }

    @Test
    void testGetProductId() {
        MesEtudiantModule product = new MesEtudiantModule();
        UUID id = UUID.randomUUID();
        product.setProductId(id);
        assertEquals(id, product.getProductId());
    }

    @Test
    void testGetProductName() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductName("Product Name");
        assertEquals("Product Name", product.getProductName());
    }

    @Test
    void testGetProductPrice() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductPrice(100);
        assertEquals(100, product.getProductPrice());
    }

    @Test
    void testGetProductStock() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductStock(10);
        assertEquals(10, product.getProductStock());
    }

    @Test
    void testHashCode() {
        MesEtudiantModule product = new MesEtudiantModule();
        assertNotNull(product.hashCode());
    }

    @Test
    void testSetProductCategory() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductCategory("Electronics");
        assertEquals("Electronics", product.getProductCategory());
    }

    @Test
    void testSetProductDesciption() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductDesciption("This is a product");
        assertEquals("This is a product", product.getProductDesciption());
    }

    @Test
    void testSetProductId() {
        MesEtudiantModule product = new MesEtudiantModule();
        UUID id = UUID.randomUUID();
        product.setProductId(id);
        assertEquals(id, product.getProductId());
    }

    @Test
    void testSetProductName() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductName("Product Name");
        assertEquals("Product Name", product.getProductName());
    }

    @Test
    void testSetProductPrice() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductPrice(100);
        assertEquals(100, product.getProductPrice());
    }

    @Test
    void testSetProductStock() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setProductStock(10);
        assertEquals(10, product.getProductStock());
    }

    @Test
    void testToString() {
        MesEtudiantModule product = new MesEtudiantModule();
        assertNotNull(product.toString());
    }
}
