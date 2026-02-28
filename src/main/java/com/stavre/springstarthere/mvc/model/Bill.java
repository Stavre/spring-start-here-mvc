package com.stavre.springstarthere.mvc.model;

import java.math.BigDecimal;
import java.util.List;

public record Bill(List<Product> products,
                   BigDecimal subtotal,
                   BigDecimal tax,
                   BigDecimal total) {}