package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Item item1 = new Item(1, new Product(1, "ProductOne"),
                new BigDecimal(20), 1, new BigDecimal(25));
        Item item2 = new Item(2, new Product(2, "ProductTwo"),
                new BigDecimal(20), 2, new BigDecimal(25));

        //When
        itemDao.save(item1);
        itemDao.save(item2);
        int item1ID = item1.getId();
        int item2ID = item2.getId();

        //Then
        assertEquals(1, item1ID);
        assertEquals(2, item2ID);

        //CleanUp
        itemDao.deleteProductByIdIsGreaterThan(1);
        //itemDao.deleteById(item1ID);
        //itemDao.deleteById(item2ID);
    }

    @Test
    void testInvoiceDaoSaveTwo() {
        //Given
        Invoice invoice1 = new Invoice(1, "PX/0001");
        Invoice invoice2 = new Invoice(2, "PX/0002");

        Item item1 = new Item(1, new Product(1, "ProductOne"),
                new BigDecimal(20), 1, new BigDecimal(25), invoice1);
        Item item2 = new Item(2, new Product(2, "ProductTwo"),
                new BigDecimal(20), 2, new BigDecimal(25), invoice2);

        //When
        itemDao.save(item1);
        itemDao.save(item2);
        int id1 = item1.getId();
        int id2 = item2.getId();

        //Then
        assertEquals(1, id1);
        assertEquals(2, id2);

        //CleanUp
        //itemDao.deleteProductByIdIsGreaterThan(1);
        //invoiceDao.deleteById(id1);
        //invoiceDao.deleteById(id2);
    }
}

