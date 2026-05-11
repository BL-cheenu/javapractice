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
      setInvalidUI(name, false);
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

// ── Helper: set invalid / valid UI on a field ─────────────────
function setInvalidUI(element, isInvalid) {
  if (isInvalid) {
    element.classList.add('input-invalid');
    element.classList.remove('input-valid');
  } else {
    element.classList.remove('input-invalid');
  }
}

function setValidUI(element) {
  element.classList.add('input-valid');
  element.classList.remove('input-invalid');
}

// ── UC 3 – save(): create EmployeePayrollData object on save ──
function save() {
  event.preventDefault();

  let isValid = true;

  const nameEl       = document.querySelector('#name');
  const salaryEl     = document.querySelector('#salary');
  const departmentEl = document.querySelector('#department');
  const startDateEl  = document.querySelector('#startDate');
  const nameError    = document.querySelectorAll('.text-error')[0];
  const dateError    = document.querySelectorAll('.text-error')[1];

  const name       = nameEl.value.trim();
  const salary     = salaryEl.value;
  const department = departmentEl.value;
  const startDate  = startDateEl.value;

  // Validate Name: must start with capital letter, min 3 chars
  if (!/^[A-Z][a-zA-Z ]{2,}$/.test(name)) {
    nameError.textContent = "Name must start with a capital letter and min 3 characters.";
    setInvalidUI(nameEl, true);
    isValid = false;
  } else {
    nameError.textContent = "";
    setValidUI(nameEl);
  }

  // Validate Date: must not be empty and not in the past
  if (!startDate) {
    dateError.textContent = "Start date is required.";
    setInvalidUI(startDateEl, true);
    isValid = false;
  } else {
    const chosen = new Date(startDate);
    const today  = new Date();
    today.setHours(0, 0, 0, 0);
    if (chosen < today) {
      dateError.textContent = "Start date cannot be in the past.";
      setInvalidUI(startDateEl, true);
      isValid = false;
    } else {
      dateError.textContent = "";
      setValidUI(startDateEl);
    }
  }

  // If validation failed, do not create object
  if (!isValid) return;

  // UC 3 – Create EmployeePayrollData object on save
  const empData = new EmployeePayrollData(name, salary, department, startDate);
  console.log("Employee Payroll Data: ", empData);

  alert(
    "Employee record saved!\n\n" +
    "Name       : " + empData.name + "\n" +
    "Salary     : ₹" + Number(empData.salary).toLocaleString('en-IN') + " / month\n" +
    "Department : " + empData.department + "\n" +
    "Start Date : " + empData.startDate
  );
}

// ── resetForm() called by onreset ────────────────────────────
function resetForm() {
  document.querySelectorAll('.text-error').forEach(el => el.textContent = "");
  document.querySelector('.salary-output').textContent = "";
  document.querySelectorAll('.input-invalid, .input-valid')
          .forEach(el => el.classList.remove('input-invalid', 'input-valid'));
  console.log("Form Reset");
}
