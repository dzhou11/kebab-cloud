package com.dzhou11.kebabcloud.models;

import lombok.Data;

@Data
public class Order {
    private String deliveryName;
    private String deliveryApt;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;

    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
