<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>💰 Expense Tracker</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>💰 My Expense Tracker</h1>
        
        <!-- Show success/error messages -->
        <% if (request.getAttribute("message") != null) { %>
            <div class="message success"><%= request.getAttribute("message") %></div>
        <% } %>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="message error"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <!-- HTML Form (like you know, but sends data to Java!) -->
        <div class="form-container">
            <h2>➕ Add New Expense</h2>
            <form action="addExpense" method="post" id="expenseForm">
                <div class="form-group">
                    <label for="description">📝 What did you buy?</label>
                    <input type="text" id="description" name="description" required 
                           placeholder="e.g., Lunch at McDonald's">
                </div>
                
                <div class="form-group">
                    <label for="amount">💵 How much did you spend?</label>
                    <input type="number" id="amount" name="amount" step="0.01" min="0" required 
                           placeholder="0.00">
                </div>
                
                <div class="form-group">
                    <label for="category">📂 Category:</label>
                    <select id="category" name="category" required>
                        <option value="">Choose category...</option>
                        <option value="Food">🍕 Food</option>
                        <option value="Transport">🚗 Transport</option>
                        <option value="Shopping">🛍️ Shopping</option>
                        <option value="Bills">📄 Bills</option>
                        <option value="Entertainment">🎬 Entertainment</option>
                        <option value="Other">❓ Other</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="date">📅 When did you spend it?</label>
                    <input type="date" id="date" name="date" required>
                </div>
                
                <button type="submit" class="btn btn-primary">➕ Add Expense</button>
            </form>
        </div>
        
        <div class="navigation">
            <a href="viewExpenses" class="btn btn-secondary">📊 See All My Expenses</a>
        </div>
    </div>
    
    <script src="js/script.js"></script>
</body>
</html>