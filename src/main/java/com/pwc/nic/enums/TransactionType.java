package com.pwc.nic.enums;

public enum TransactionType {

    REG(1), DIS(3), SHP(2), CMB(4);

    public final int typeNumber;

    TransactionType(int i) {
        this.typeNumber = i;
    }
}
