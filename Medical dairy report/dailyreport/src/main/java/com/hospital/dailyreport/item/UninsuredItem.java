package com.hospital.dailyreport.item;

public class UninsuredItem {

    private Long id;
    private String name;
    private String detail;
    private int unitPrice;
    private String printLabel;
    private boolean active;

    public UninsuredItem(Long id, String name, String detail,
                         int unitPrice, String printLabel, boolean active) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.unitPrice = unitPrice;
        this.printLabel = printLabel;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDetail() { return detail; }
    public int getUnitPrice() { return unitPrice; }
    public String getPrintLabel() { return printLabel; }
    public boolean isActive() { return active; }
}