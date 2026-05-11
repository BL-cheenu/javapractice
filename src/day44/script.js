// EmployeePayrollData class
class EmployeePayrollData {
  constructor(name, salary, department, startDate) {
    this.name       = name;
    this.salary     = salary;
    this.department = department;
    this.startDate  = startDate;
  }
}

// UC 2 – On Document Load Set Event Listeners
window.addEventListener('DOMContentLoaded', (event) => {

  // ── Name validation listener ──────────────────────────────
  const name      = document.querySelector('#name');
  const textError = document.querySelector('.text-error');

  name.addEventListener('input', function () {
    if (name.value.length == 0) {
      textError.textContent = "";
      return;
    }
    try {
      (new EmployeePayrollData()).name = name.value;;
      textError.textContent = "";
    } catch (e) {
      textError.textContent = e;
    }
  });

  // ── Salary range display listener ─────────────────────────
  const salary = document.querySelector('#salary');
  const output = document.querySelector('.salary-output');

  salary.addEventListener('input', function () {
    output.textContent = salary.value
      ? "Selected salary: ₹" + Number(salary.value).toLocaleString('en-IN') + " / month"
      : "";
  });

});

// ── save() called by onsubmit ─────────────────────────────────
function save() {
  event.preventDefault();

  const name       = document.querySelector('#name').value.trim();
  const salary     = document.querySelector('#salary').value;
  const department = document.querySelector('#department').value;
  const startDate  = document.querySelector('#startDate').value;
  const textError  = document.querySelector('.text-error');

  // Validate name: must start with capital, min 3 chars
  if (!/^[A-Z][a-zA-Z ]{2,}$/.test(name)) {
    textError.textContent = "Name must start with a capital letter and be at least 3 characters.";
    return;
  }

  // Validate date: must not be in the past
  if (startDate) {
    const chosen = new Date(startDate);
    const today  = new Date();
    today.setHours(0, 0, 0, 0);
    const dateErrors = document.querySelectorAll('.text-error');
    if (chosen < today) {
      if (dateErrors[1]) dateErrors[1].textContent = "Start date cannot be in the past.";
      return;
    } else {
      if (dateErrors[1]) dateErrors[1].textContent = "";
    }
  }

  const empData = new EmployeePayrollData(name, salary, department, startDate);
  console.log("Employee Payroll Data: ", empData);
  alert("Employee record saved!\n\nName: " + empData.name +
        "\nSalary: ₹" + Number(empData.salary).toLocaleString('en-IN') +
        "\nDepartment: " + empData.department +
        "\nStart Date: " + empData.startDate);
}

// ── resetForm() called by onreset ────────────────────────────
function resetForm() {
  document.querySelectorAll('.text-error').forEach(el => el.textContent = "");
  document.querySelector('.salary-output').textContent = "";
  console.log("Form Reset");
}
