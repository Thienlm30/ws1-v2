/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import thien.ws1.dto.Account;
import thien.ws1.dto.Category;
import thien.ws1.dto.Product;
import thien.ws1.utils.ConnectDB;

/**
 *
 * @author Thienlm30
 */
public class ProductDAO implements Accessible<Product> {
    private Connection connection = null;

    public ProductDAO() {
        ConnectDB connectDB = new ConnectDB();
        this.connection = connectDB.getConnection();
    }

    public ProductDAO(ServletContext sc) {
        ConnectDB connectDB = new ConnectDB(sc);
        this.connection = connectDB.getConnection();
    }

    @Override
    public int insertRec(Product obj) {
        return 0;
    }

    @Override
    public int updateRec(Product obj) {
        return 0;
    }

    @Override
    public int deleteRec(Product obj) {
        return 0;
    }

    @Override
    public Product getObjectById(String id) {
        Product p = null;
        try {
            if (connection != null) {
                String sql = "SELECT [productId], [productName], [productImage],\n"
                        + "[brief], [postedDate], [typeId], [account], [unit],\n"
                        + "[price], [discount]\n"
                        + "FROM [dbo].[products] WHERE productId = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    String name = rs.getString("productName");
                    String img = rs.getString("productImage");
                    String brief = rs.getString("brief");
                    Date postedDate = (Date) rs.getDate("postedDate");
                    int typeId = rs.getInt("typeId");
                    CategoryDAO cd = new CategoryDAO();
                    Category c = cd.getObjectById(String.valueOf(typeId));
                    String acc = rs.getString("account");
                    AccountDAO ad = new AccountDAO();
                    Account account = ad.getObjectById(acc);
                    String unit = rs.getString("unit");
                    int price = rs.getInt("price");
                    int discount = rs.getInt("discount");
                    p = new Product(id, name, img, brief, postedDate, c, account, unit, price, discount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    @Override
    public List<Product> listAll() {
        List<Product> list = new ArrayList<>();
        try {
            if (connection != null) {
                String sql = "SELECT [productId], [productName], [productImage],\n"
                        + "[brief], [postedDate], [typeId], [account], [unit],\n"
                        + "[price], [discount]\n"
                        + "FROM [dbo].[products]";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        String id = rs.getString("productId");
                        String name = rs.getString("productName");
                        String img = rs.getString("productImage");
                        String brief = rs.getString("brief");
                        Date postedDate = (Date) rs.getDate("postedDate");
                        int typeId = rs.getInt("typeId");
                        CategoryDAO cd = new CategoryDAO();
                        Category c = cd.getObjectById(String.valueOf(typeId));
                        String acc = rs.getString("account");
                        AccountDAO ad = new AccountDAO();
                        Account account = ad.getObjectById(acc);
                        String unit = rs.getString("unit");
                        int price = rs.getInt("price");
                        int discount = rs.getInt("discount");
                        Product p = new Product(id, name, img, brief, postedDate, c, account, unit, price, discount);
                        list.add(p);
                    }
                }
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
