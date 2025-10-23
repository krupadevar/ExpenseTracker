package servlet;

import dao.ExpenseDAO;
import model.Expense;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {
    
    private ExpenseDAO expenseDAO = new ExpenseDAO();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            String description = request.getParameter("description");
            BigDecimal amount = new BigDecimal(request.getParameter("amount"));
            String category = request.getParameter("category");
            Date date = Date.valueOf(request.getParameter("date"));
            
            Expense expense = new Expense(description, amount, category, date);
            
            if (expenseDAO.addExpense(expense)) {
                request.setAttribute("message", "Expense added successfully!");
            } else {
                request.setAttribute("error", "Failed to add expense!");
            }
            
        } catch (Exception e) {
            request.setAttribute("error", "Error: " + e.getMessage());
        }
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}