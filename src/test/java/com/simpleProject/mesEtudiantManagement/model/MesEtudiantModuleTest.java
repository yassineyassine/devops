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
    void testGetetudiantEmail() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantEmail("Electronics");
        assertEquals("Electronics", product.getEtudiantEmail());
    }

    @Test
    void testGetetudiantLastName() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantLastName("This is a product");
        assertEquals("This is a product", product.getEtudiantLastName());
    }

    @Test
    void testGetetudiantId() {
        MesEtudiantModule product = new MesEtudiantModule();
        UUID id = UUID.randomUUID();
        product.setEtudiantId(id);
        assertEquals(id, product.getEtudiantId());
    }

    @Test
    void testGetetudiantFirstName() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantFirstName("Product Name");
        assertEquals("Product Name", product.getEtudiantFirstName());
    }

    @Test
    void testGetetudiantCnssEtab() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantCnssEtab(100);
        assertEquals(100, product.getEtudiantCnssEtab());
    }

    @Test
    void testGetetudiantCIN() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantCIN(10);
        assertEquals(10, product.getEtudiantCIN());
    }

    @Test
    void testHashCode() {
        MesEtudiantModule product = new MesEtudiantModule();
        assertNotNull(product.hashCode());
    }

    @Test
    void testSetetudiantEmail() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantEmail("Electronics");
        assertEquals("Electronics", product.getEtudiantEmail());
    }

    @Test
    void testSetetudiantLastName() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantLastName("This is a product");
        assertEquals("This is a product", product.getEtudiantLastName());
    }

    @Test
    void testSetetudiantId() {
        MesEtudiantModule product = new MesEtudiantModule();
        UUID id = UUID.randomUUID();
        product.setEtudiantId(id);
        assertEquals(id, product.getEtudiantId());
    }

    @Test
    void testSetetudiantFirstName() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantFirstName("Product Name");
        assertEquals("Product Name", product.getEtudiantFirstName());
    }

    @Test
    void testSetetudiantCnssEtab() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantCnssEtab(100);
        assertEquals(100, product.getEtudiantCnssEtab());
    }

    @Test
    void testSetetudiantCIN() {
        MesEtudiantModule product = new MesEtudiantModule();
        product.setEtudiantCIN(10);
        assertEquals(10, product.getEtudiantCIN());
    }

    @Test
    void testToString() {
        MesEtudiantModule product = new MesEtudiantModule();
        assertNotNull(product.toString());
    }
}
