package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product save(Product product) {
        session().save(product);
        return product;
    }

    @Override
    public Optional<Product> getById(Long id) {
        Product product = (Product) session().get(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> getByTitle(String title) {
        Product product = (Product) session().createCriteria(Product.class)
                .add(Restrictions.eq("title", title))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public void delete(Product product) {
        session().delete(product);
    }

    @Override
    public List<Product> getAll() {
        return session()
                .createCriteria(Product.class)
                .list();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

}
