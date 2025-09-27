package com.project.rest_app.data;

import com.project.rest_app.model.Customer;
import com.project.rest_app.model.Product;
import com.project.rest_app.model.ProductDetail;
import com.project.rest_app.repo.CustomerRepo;
import com.project.rest_app.repo.ProductRepo;
import com.project.rest_app.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataInitializer implements CommandLineRunner {


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Customer customer = new Customer();
            String name = Tools.randomElementFrom(Tools.FIRST_NAMES);
            customer.setName(name);
            String surname = Tools.randomElementFrom(Tools.LAST_NAMES);
            customer.setSurname(surname);
            customer.setEmail(name + "." + surname + "@example.com");
            customer.setPhone(Tools.randomElementFrom(Tools.MOBILE_NUMBERS));
            customerRepo.save(customer);
        }

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            int randomIndex = Tools.RANDOM.nextInt(Tools.PRODUCT_NAMES.size());
            product.setName(Tools.PRODUCT_NAMES.get(randomIndex));
            product.setDescription(Tools.PRODUCT_DESCRIPTIONS.get(randomIndex));
            product.setPrice((long) (Tools.RANDOM.nextInt(100) + 1));


            List<ProductDetail> details = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                ProductDetail detail = new ProductDetail();
                detail.setDetail("Detail " + (j + 1) + " for " + product.getName());
                detail.setProduct(product);
                details.add(detail);
            }
            product.setProductDetails(details);

            productRepo.save(product);
        }



    }
}
