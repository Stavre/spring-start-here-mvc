package com.stavre.springstarthere.mvc.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Product(UUID id, String name, String imageUrl, BigDecimal price) {}
