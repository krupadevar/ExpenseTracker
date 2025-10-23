document.addEventListener('DOMContentLoaded', function() {
    console.log('💰 Expense Tracker Loaded!');
    
    // Set today's date as default
    const dateInput = document.getElementById('date');
    if (dateInput) {
        const today = new Date().toISOString().split('T')[0];
        dateInput.value = today;
    }
    
    // Form validation
    const form = document.getElementById('expenseForm');
    if (form) {
        form.addEventListener('submit', function(e) {
            const amount = document.getElementById('amount').value;
            const description = document.getElementById('description').value.trim();
            
            if (!amount || amount <= 0) {
                showAlert('⚠️ Please enter a valid amount!', 'error');
                e.preventDefault();
                return;
            }
            
            if (!description) {
                showAlert('⚠️ Please enter what you bought!', 'error');
                e.preventDefault();
                return;
            }
            
            // Show loading effect
            const submitBtn = form.querySelector('button[type="submit"]');
            submitBtn.innerHTML = '⏳ Adding...';
            submitBtn.disabled = true;
        });
    }
    
    // Auto-hide messages after 4 seconds
    const messages = document.querySelectorAll('.message');
    messages.forEach(function(message) {
        setTimeout(function() {
            message.style.opacity = '0';
            message.style.transform = 'translateY(-20px)';
            setTimeout(() => message.style.display = 'none', 300);
        }, 4000);
    });
    
    // Currency formatting
    const amountInputs = document.querySelectorAll('input[type="number"]');
    amountInputs.forEach(input => {
        input.addEventListener('blur', function() {
            if (this.value) {
                this.value = parseFloat(this.value).toFixed(2);
            }
        });
    });
});

function showAlert(message, type) {
    const alertDiv = document.createElement('div');
    alertDiv.className = `message ${type}`;
    alertDiv.textContent = message;
    alertDiv.style.position = 'fixed';
    alertDiv.style.top = '20px';
    alertDiv.style.right = '20px';
    alertDiv.style.zIndex = '1000';
    alertDiv.style.minWidth = '300px';
    
    document.body.appendChild(alertDiv);
    
    setTimeout(() => {
        alertDiv.remove();
    }, 3000);
}

// Fun console message
console.log(`
    💰 EXPENSE TRACKER
    ================
    Built with ❤️ using:
    - Java Servlets
    - JSP Pages  
    - MySQL Database
    - Cool CSS Animations
    
    Happy Spending! 😄
`);