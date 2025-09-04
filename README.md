# 📊 JSON Loan Processor  

This project demonstrates how to parse and process **loan data from JSON** using **Jackson ObjectMapper** in Java.  

---

## ▶️ How It Works  

1. Reads loan data from a JSON file (`loanData.json`).  
2. Iterates through each loan record and checks the field **`overdue_y_n`**.  
   - If value = **"Y"** → Sort loans by **disbursement date (descending)**.  
   - If value = **"N"** → Sort loans by **total repayment amount (descending)**.  
3. Finally, all records are sorted by **overdue status (Y first, N later)**.  
4. Prints the processed and sorted list.  

---

## 🛠 Tech Stack  

- **Java 17+**  
- **Jackson (FasterXML ObjectMapper)**  

---

## 📂 Sample JSON Structure (`loanData.json`)  

```json
{
  "loans": [
    {
      "loan_id": "LN001",
      "disb_date": "15-08-24",
      "total_repayment_amount": 50000.0,
      "overdue_y_n": "Y"
    },
    {
      "loan_id": "LN002",
      "disb_date": "10-07-24",
      "total_repayment_amount": 75000.0,
      "overdue_y_n": "N"
    }
  ]
}
