package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.AddProductService;
import lv.javaguru.java2.businesslogic.ValidationError;
import lv.javaguru.java2.businesslogic.api.AddProductRequest;
import lv.javaguru.java2.businesslogic.api.AddProductResponse;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.argThat;

@RunWith(MockitoJUnitRunner.class)
public class AddProductServiceImplTest {

    @Mock private ProductDAO productDAO;
    @Mock private ProductValidator productValidator;

    @InjectMocks
    private AddProductService service = new AddProductServiceImpl();

    @Test
    public void shouldReturnFailedResponseIfValidationFails() {
        ValidationError error = new ValidationError("title", "empty");
        Mockito.doReturn(Optional.of(error))
                .when(productValidator)
                .validate(null, "description");

        AddProductRequest request = new AddProductRequest(null, "description");
        AddProductResponse response = service.addProduct(request);

        assertThat(response.isResult(), is(false));
        assertThat(response.getErrorField(), is("title"));
        assertThat(response.getErrorMessage(), is("empty"));
    }

    @Test
    public void shouldReturnSuccess() {
        Mockito.doReturn(Optional.empty())
                .when(productValidator)
                .validate("title", "description");

        AddProductRequest request = new AddProductRequest("title", "description");
        AddProductResponse response = service.addProduct(request);

        assertThat(response.isResult(), is(true));
        assertThat(response.getErrorField(), is(nullValue()));
        assertThat(response.getErrorMessage(), is(nullValue()));

        Mockito.verify(productDAO)
                .save(argThat(new ProductMatcher("title", "description")));
    }

}

class ProductMatcher implements ArgumentMatcher<Product> {

    private String title;
    private String description;

    public ProductMatcher(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean matches(Product product) {
        return product.getTitle().equals(title)
                && product.getDescription().equals(description);
    }
}
