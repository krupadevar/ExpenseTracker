package model;

import java.sql.Date;
import java.math.BigDecimal;

public class Expense {
    private int id;
    private String description;
    private BigDecimal amount;
    private String category;
    private Date date;
    
    public Expense() {}
    
    public Expense(String description, BigDecimal amount, String category, Date date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}