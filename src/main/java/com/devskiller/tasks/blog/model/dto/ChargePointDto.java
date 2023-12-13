package com.devskiller.tasks.blog.model.dto;

import com.devskiller.tasks.blog.utilities.ChargePointStatus;

public record ChargePointDto(String chargePointName, ChargePointStatus status, int capty) {
}
