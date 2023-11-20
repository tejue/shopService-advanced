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

    @Test
    void findAllOrdersByStatusTest_when1OrderStatusIsProcessing_thenReturn1() {
        // GIVEN
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Order order1 = new Order("01", List.of(new Product("a", "Apple"), new Product("b", "Banana")), OrderStatus.PROCESSING);
        Order order2 = new Order("02", List.of(new Product("c", "Cacao"), new Product("d", "Dragonfruit")), OrderStatus.IN_DELIVERY);
        Order order3 = new Order("03", List.of(new Product("e", "Eggplant"), new Product("f", "Fig")), OrderStatus.COMPLETED);

        orderRepo.addOrder(order1);
        orderRepo.addOrder(order2);
        orderRepo.addOrder(order3);

        // WHEN
        List<Order> processingOrders = shopService.findAllOrdersByStatus(OrderStatus.PROCESSING);

        // THEN
        assertEquals(1, processingOrders.size());
    }
}


