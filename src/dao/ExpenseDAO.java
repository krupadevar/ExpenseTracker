package dao;

import model.Expense;
import util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ExpenseDAO {
    
    // Method to add new expense to database
    public boolean addExpense(Expense expense) {
        String sql = "INSERT INTO expenses (description, amount, category, date) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, expense.getDescription());
            stmt.setBigDecimal(2, expense.getAmount());
            stmt.setString(3, expense.getCategory());
            stmt.setDate(4, expense.getDate());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to get all expenses from database
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses ORDER BY date DESC";
        
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Expense expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setDescription(rs.getString("description"));
                expense.setAmount(rs.getBigDecimal("amount"));
                expense.setCategory(rs.getString("category"));
                expense.setDate(rs.getDate("date"));
                expenses.add(expense);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return expenses;
    }
    
    // Method to calculate total expenses
    public BigDecimal getTotalExpenses() {
        String sql = "SELECT SUM(amount) as total FROM expenses";
        BigDecimal total = BigDecimal.ZERO;
        
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                total = rs.getBigDecimal("total");
                if (total == null) total = BigDecimal.ZERO;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return total;
    }
}