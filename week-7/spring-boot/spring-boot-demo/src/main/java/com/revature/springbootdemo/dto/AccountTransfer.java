package com.revature.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountTransfer {
    private Long donor;
    private Long recip;
    private int amount;
}
