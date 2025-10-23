<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Expense, java.math.BigDecimal" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>📊 All My Expenses</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>📊 All My Expenses</h1>
        
        <!-- Show total money spent -->
        <div class="total-section">
            <h2>💰 Total Spent: ₹<%= request.getAttribute("total") != null ? request.getAttribute("total") : "0.00" %></h2>
        </div>
        
        <!-- Table showing all expenses -->
        <div class="table-container">
            <table class="expenses-table">
                <thead>
                    <tr>
                        <th>📅 Date</th>
                        <th>📝 Description</th>
                        <th>📂 Category</th>
                        <th>💵 Amount</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Expense> expenses = (List<Expense>) request.getAttribute("expenses");
                        if (expenses != null && !expenses.isEmpty()) {
                            for (Expense expense : expenses) {
                    %>
                    <tr>
                        <td><%= expense.getDate() %></td>
                        <td><%= expense.getDescription() %></td>
                        <td><%= expense.getCategory() %></td>
                        <td>₹<%= expense.getAmount() %></td>
                    </tr>
                    <% 
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="4" class="no-data">😔 No expenses yet! Go add some expenses.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        
        <div class="navigation">
            <a href="index.jsp" class="btn btn-primary">➕ Add New Expense</a>
        </div>
    </div>
</body>
</html>