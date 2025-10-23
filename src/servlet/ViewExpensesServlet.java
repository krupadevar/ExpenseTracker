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
import java.util.List;

@WebServlet("/viewExpenses")
public class ViewExpensesServlet extends HttpServlet {
    
    private ExpenseDAO expenseDAO = new ExpenseDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Expense> expenses = expenseDAO.getAllExpenses();
        BigDecimal total = expenseDAO.getTotalExpenses();
        
        request.setAttribute("expenses", expenses);
        request.setAttribute("total", total);
        
        request.getRequestDispatcher("expenses.jsp").forward(request, response);
    }
}