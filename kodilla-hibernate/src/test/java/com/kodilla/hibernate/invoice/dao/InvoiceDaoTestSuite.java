package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
        Item item1 = new Item(1, new Product(1, "ProductOne"),
                new BigDecimal(20), 1, new BigDecimal(25));
        Item item2 = new Item(2, new Product(2, "ProductTwo"),
                new BigDecimal(20), 2, new BigDecimal(25));

        List<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);

        Invoice invoice1 = new Invoice(1, "PX/0001", itemList1);
        Invoice invoice2 = new Invoice(2, "PX/0002", itemList2);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        int id1 = invoice1.getId();
        int id2 = invoice2.getId();

        //Then
        assertEquals(1, id1);
        assertEquals(2, id2);

        //CleanUp
        invoiceDao.deleteProductByIdIsGreaterThan(1);
        itemDao.deleteProductByIdIsGreaterThan(1);
        //invoiceDao.deleteById(id1);
        //invoiceDao.deleteById(id2);
    }
}

