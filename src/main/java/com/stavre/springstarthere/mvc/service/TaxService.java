package com.stavre.springstarthere.mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.MathContext;

@RequiredArgsConstructor
@Service
public class TaxService {

    @Value("${vat.percentage}")
    private String vatPercentage;

    public BigDecimal computeVatTax(BigDecimal subtotal) {
        BigDecimal vat = new BigDecimal(vatPercentage);
        return subtotal.multiply(vat).round(new MathContext(2));
    }
}
