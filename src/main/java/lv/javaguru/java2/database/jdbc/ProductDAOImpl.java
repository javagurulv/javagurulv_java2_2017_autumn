package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lv.javaguru.java2.domain.ProductBuilder.createProduct;

@Component
class ProductDAOImpl extends DAOImpl implements ProductDAO {

    @Override
    public Product save(Product product) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into PRODUCTS(id, title, description) values(default, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, product.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                product.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return product;
    }

    @Override
    public Optional<Product> getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from PRODUCTS where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            if (resultSet.next()) {
                product = createProduct()
                        .withId(resultSet.getLong("id"))
                        .withTitle(resultSet.getString("title"))
                        .withDescription(resultSet.getString("description")).build();
            }
            return Optional.ofNullable(product);
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Product> getByTitle(String title) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from PRODUCTS where title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            if (resultSet.next()) {
                product = createProduct()
                        .withId(resultSet.getLong("id"))
                        .withTitle(resultSet.getString("title"))
                        .withDescription(resultSet.getString("description")).build();
            }
            return Optional.ofNullable(product);
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductDAOImpl.getByTitle()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Product> getAll() throws DBException {
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from PRODUCTS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = createProduct()
                        .withId(resultSet.getLong("id"))
                        .withTitle(resultSet.getString("title"))
                        .withDescription(resultSet.getString("description")).build();
                products.add(product);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ProductDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return products;
    }

    @Override
    public void delete(Product product) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from PRODUCTS where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, product.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
