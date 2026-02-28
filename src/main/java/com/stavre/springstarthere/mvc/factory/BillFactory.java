package com.stavre.springstarthere.mvc.factory;

import com.stavre.springstarthere.mvc.model.Bill;
import com.stavre.springstarthere.mvc.model.Product;
import com.stavre.springstarthere.mvc.service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Component
@RequestScope
public class BillFactory {

    private final TaxService taxService;

    public Bill getBill(List<Product> products) {
        BigDecimal subtotal = products.stream().map(Product::price).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal tax = taxService.computeVatTax(subtotal);
        BigDecimal total = subtotal.add(tax);

        return new Bill(products, subtotal, tax, total);
    }
}
