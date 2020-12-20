import org.alex.model.Cart;
import org.alex.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import utils.HibernateUtil;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Cart cart = new Cart();
        cart.setName("Third");
        cart.setTotal(BigDecimal.valueOf(119.50));
        session.persist(cart);

        Item item = new Item();
        item.setTotal(BigDecimal.valueOf(12.05));
        session.persist(item);

        Item item10 = new Item(BigDecimal.valueOf(117.00));
        Item item11 = new Item(BigDecimal.valueOf(09.00));
        Item item12 = new Item(BigDecimal.valueOf(500.00));
        Item item13 = new Item(BigDecimal.valueOf(1000.99));

        session.persist(item10);
        session.persist(item11);
        session.persist(item12);
        session.persist(item13);


        Item item1 = new Item(); item1.setTotal(BigDecimal.valueOf(13.00));
        Item item2 = new Item(); item2.setTotal(BigDecimal.valueOf(15.99));
        Item item3 = new Item(); item3.setTotal(BigDecimal.valueOf(199.99));
        Item item4 = new Item(); item4.setTotal(BigDecimal.valueOf(20.99));
        Set<Item> items = new HashSet<>(Arrays.asList(item1, item2, item3, item4));

       // items.stream().forEach(System.out::println);

        Cart cart1 = new Cart(BigDecimal.valueOf(9.99), "cart1");
        Cart cart2 = new Cart(BigDecimal.valueOf(15.99), "cart2");
        Cart cart3 = new Cart(BigDecimal.valueOf(9999.99), "cart3");
        Cart cart4 = new Cart(BigDecimal.valueOf(2000.00), "cart4");

        cart1.setItems(items);

        session.persist(cart1);
        session.persist(cart2);
        session.persist(cart3);
        session.persist(cart4);


        transaction.commit();
        session.close();

    }
}
