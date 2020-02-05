package com.jnutz.justcook.database.inventory;

import java.math.BigDecimal;

public class Item
{
    private short id;
    private String name;
    private ItemGroup group;
    private BigDecimal price;
    private short availableAmount;
    private Measurement measurement;
    
    //TODO: Think ahead about statistic tracking
    // i.e. private short amountPurchased;
    //      private short amountSold;
    //      private short amountOfProductLost = amountPurchased - amountSold;
    //      private BigDecimal amountOfMoneyLost = amountOfProductLost * price;
    
    public Item()
    {
    }
    
    //Used when creating a new Item
    public Item(String name, ItemGroup group, BigDecimal price, short availableAmount, Measurement measurement)
    {
        this.name = name;
        this.group = group;
        this.price = price;
        this.availableAmount = availableAmount;
        this.measurement = measurement;
    }
    
    //Used when retrieving an already created Item from the database
    public Item(short id, String name, ItemGroup group, BigDecimal price, short availableAmount, Measurement measurement)
    {
        this.id = id;
        this.name = name;
        this.group = group;
        this.price = price;
        this.availableAmount = availableAmount;
        this.measurement = measurement;
    }
    
    public short getId()
    {
        return id;
    }
    
    public void setId(short id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public ItemGroup getGroup()
    {
        return group;
    }
    
    public void setGroup(ItemGroup group)
    {
        this.group = group;
    }
    
    public BigDecimal getPrice()
    {
        return price;
    }
    
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }
    
    public short getAvailableAmount()
    {
        return availableAmount;
    }
    
    public void setAvailableAmount(short availableAmount)
    {
        this.availableAmount = availableAmount;
    }
    
    public Measurement getMeasurement()
    {
        return measurement;
    }
    
    public void setMeasurement(Measurement measurement)
    {
        this.measurement = measurement;
    }
}