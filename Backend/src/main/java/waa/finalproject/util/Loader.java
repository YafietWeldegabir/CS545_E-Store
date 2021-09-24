package waa.finalproject.util;

import waa.finalproject.service.buyer.BuyerService;
import waa.finalproject.service.review.ReviewService;
import waa.finalproject.service.seller.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import waa.finalproject.domain.*;
import waa.finalproject.repository.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

@Component
public class Loader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired

    private BuyerRepository buyerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    SellerService sellerService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    ReviewService reviewService;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createAdmins();
        createSellers();
        createBuyers();
        createProducts();
        createOrders();
        createReviews();
        createAddress();
    }

    private void createRoles(){
        Role roleAdmin = new Role(1,"ROLE_ADMIN", null);
        Role roleSeller = new Role(2,"ROLE_SELLER", null);
        Role roleBuyer = new Role(3,"ROLE_BUYER", null);

        roleRepository.saveAll(Arrays.asList(roleAdmin, roleSeller, roleBuyer));
        System.out.println(roleRepository.findAll().toString());
    }

    private void createSellers(){
        Seller seller = new Seller("Seid Abrar ", true, null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepository.findById(2L).get());
        seller.setUsername("seya");
        seller.setPassword(new BCryptPasswordEncoder().encode("666"));
        seller.setRoles(roleSet);
        sellerRepository.saveAll(Arrays.asList(seller));
        StreamSupport.stream(sellerRepository.findAll().spliterator(),false)
                .forEach(seller1 -> System.out.println("Seller ID: " + seller1.getId() + " Seller Username: " + seller1.getUsername()));
        System.out.println("Seller Password: 666");
    }

    private void createBuyers(){
        Buyer buyer = new Buyer(0,"Ziyneb Fathi",null,null,null,null,null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepository.findById(3L).get());
        buyer.setUsername("zeyneb");
        buyer.setPassword(new BCryptPasswordEncoder().encode("123"));
        buyer.setRoles(roleSet);
        Buyer savedBuyer = buyerRepository.save(buyer);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setBuyer(savedBuyer);
        shoppingCartRepository.save(shoppingCart);
        StreamSupport.stream(buyerRepository.findAll().spliterator(),false)
                .forEach(buyer1 -> System.out.println("Buyer ID: " + buyer1.getId() + " Buyer Username: " + buyer1.getUsername()));
        System.out.println("Buyer Password: 123");

    }

    private void createAdmins(){
        Admin admin = new Admin();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepository.findById(1L).get());
        admin.setUsername("admin");
        admin.setPassword(new BCryptPasswordEncoder().encode("admin_plus"));
        admin.setRoles(roleSet);
        adminRepository.save(admin);
        StreamSupport.stream(adminRepository.findAll().spliterator(),false)
                .forEach(admin1 -> System.out.println("Admin ID: " + admin1.getId() + " Admin Username: " + admin1.getUsername()));
        System.out.println("Admin Password: admin_plus");

    }

    private void createProducts(){

        Product product = new Product(1,"Bag","Woman zara", 150, null, null, null);
        Product product1 = new Product(2,"Shirt","Denim", 20, null, null, null);
        sellerService.addProduct(product1, 5L);
        sellerService.addProduct(product, 5L);
        System.out.println(productRepository.findAll().toString());
    }

    private void createOrders(){

        Optional<Buyer> buyer = buyerRepository.findById(6L);
        Optional<Product> product = productRepository.findById(8L);
        System.out.println(buyer.get());
        System.out.println(product.get());
        Order order = new Order();
        order.setStatus(OrderStatus.ORDERED);
        order.setProduct(product.get());
        order.setBuyer(buyer.get());
        orderRepository.save(order);
        System.out.println(order.toString());
        System.out.println(orderRepository.findAll().toString());
    }

    private void createReviews(){
        Review review = new Review();
        review.setContent("Awesome Products");
        buyerService.addReviewByBuyerId(review,6, 8);
    }

    private void createAddress(){
        Address address = new Address();
        address.setAddressType(AddressType.BILLING);
        address.setCountry("USA");
        address.setCity("Fairfield");
        address.setState("Iowa");
        address.setZipCode(52557);
        buyerService.addAddressToBuyer(address,6);
    }

}
