package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DatabaseUtil;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static lv.javaguru.java2.domain.ProductBuilder.createProduct;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProductDAOImplTest {

    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private ProductDAO productDAO = new ProductDAOImpl();

    @Before
    public void init() {
        databaseUtil.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        Product product = create("Title AAA", "Description VVV");
        assertThat(product.getId(), is(notNullValue()));

        Optional<Product> productFromDB = productDAO.getById(product.getId());

        assertThat(productFromDB.isPresent(), is(true));
        assertEquals(product.getId(), productFromDB.get().getId());
        assertEquals(product.getTitle(), productFromDB.get().getTitle());
        assertEquals(product.getDescription(), productFromDB.get().getDescription());
    }

    @Test
    public void testGetByTitle() throws Exception {
        Product product = create("Title AAABBB", "Description VVV");

        Optional<Product> productFromDB = productDAO.getByTitle(product.getTitle());

        assertThat(productFromDB.isPresent(), is(true));
        assertEquals(product.getId(), productFromDB.get().getId());
        assertEquals(product.getTitle(), productFromDB.get().getTitle());
        assertEquals(product.getDescription(), productFromDB.get().getDescription());
    }

    @Test
    public void testGetAll() throws Exception {
        Product product1 = create("Title AAABBB 1", "Description VVV");
        Product product2 = create("Title AAABBB 2", "Description VVV");

        List<Product> products = productDAO.getAll();

        assertThat(products.size(), is(2));
        assertThat(products.contains(product1), is(true));
        assertThat(products.contains(product2), is(true));
    }

    @Test
    public void testDelete() throws Exception {
        Product product = create("Title AAABBB", "Description VVV");
        List<Product> products = productDAO.getAll();
        assertThat(products.size(), is(1));

        productDAO.delete(product);
        products = productDAO.getAll();
        assertThat(products.size(), is(0));

        Optional<Product> productFromDb = productDAO.getById(product.getId());
        assertThat(productFromDb.isPresent(), is(false));
    }

    private Product create(String title, String description) {
        Product product = createProduct()
                .withTitle(title)
                .withDescription(description).build();
        return productDAO.save(product);
    }

}
