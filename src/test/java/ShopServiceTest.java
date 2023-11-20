import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void addOrderTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");

        //WHEN
        Order actual = shopService.addOrder(productsIds);

        //THEN
        Order expected = new Order("-1", List.of(new Product("1", "Apfel")), OrderStatus.PROCESSING);
        assertEquals(expected.products(), actual.products());
        assertNotNull(expected.id());
    }

    @Test
    void addOrderTest_whenInvalidProductId_expectNull() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1", "2");

        //WHEN
        Order actual = shopService.addOrder(productsIds);

        //THEN
        assertNull(actual);
    }

    /*
    @Test
    void findAllOrderByStatus_whenOrderStatusIsProcessing_thenReturnEquals() {
        //GIVEN
        //orderListRepo.addOrder(new Order("11", List.of(new Product("01", "Apple")), OrderStatus.PROCESSING));
        Product product1 = new Product("11", "Banana");
        ProductRepo pr1 = new ProductRepo();
        pr1.addProduct(product1);
        Order order1 = new Order("01", List.of(product1), OrderStatus.PROCESSING);
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        orderMapRepo.addOrder(order1);
        ShopService shopService = new ShopService();

        List<String> productIds = new ArrayList<>();
        productIds.add("11");

        shopService.addOrder(productIds);

        //WHEN
        List<Order> actual = shopService.findAllOrdersByStatus(OrderStatus.PROCESSING);
        //THEN
        List<Order> expected = List.of(order1);
        assertEquals(1, actual.size());

    }
*/


}
