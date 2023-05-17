package com.pwc.nic.enums;

public enum SupplyType {
    O("O","Outward"), I("I","Inward");

    public final String type;
    public final String typeAcronym;

    SupplyType(String typeAcronym, String type) {
        this.typeAcronym = typeAcronym;
        this.type = type;
    }
}
