// UC 4 – View Employee Payroll Details using Template Literals (ES6)
// Note: DOMContentLoaded listener is used to set innerHTML of table

window.addEventListener('DOMContentLoaded', (event) => {

  // UC 4 – Retrieve table-display element using document object
  const tbody = document.querySelector('#empTableBody');
  const emptyState = document.querySelector('#emptyState');
  const table = document.querySelector('#empTable');
  const countEl = document.querySelector('#empCount');

  // Get records from Local Storage
  const records = getEmployeeRecords();

  if (records.length === 0) {
    table.style.display = 'none';
    emptyState.classList.add('show');
    return;
  }

  table.style.display = 'table';
  emptyState.classList.remove('show');

  // UC 4 – innerHTML is populated using Template Literals
  // Template literals use backtick (`) and ${expression} placeholders
  tbody.innerHTML = records.map((emp, index) => `
    <tr style="background: ${index % 2 === 0 ? '#fff' : '#f8fafc'}">
      <td class="td-serial">${index + 1}</td>
      <td class="td-name">${emp.name}</td>
      <td><span class="dept-badge">${emp.department || '-'}</span></td>
      <td><span class="salary-badge">₹${Number(emp.salary).toLocaleString('en-IN')}</span></td>
      <td class="td-date">${formatDate(emp.startDate)}</td>
      <td>
        <button class="action-btn btn-edit"   onclick="editRecord(${index})">✏️ Edit</button>
        <button class="action-btn btn-delete" onclick="deleteRecord(${index})">🗑️ Delete</button>
      </td>
    </tr>
  `).join('');

  // Update record count
  if (countEl) countEl.textContent = records.length;

});

// Format date as DD/MM/YYYY
function formatDate(dateStr) {
  if (!dateStr) return '-';
  const d = new Date(dateStr);
  return d.toLocaleDateString('en-IN', {
    day: '2-digit',
    month: '2-digit',
    year: 'numeric'
  });
}

// Get all employee records from Local Storage
function getEmployeeRecords() {
  const data = localStorage.getItem('employeePayrollList');
  return data ? JSON.parse(data) : [];
}

// Save all records to Local Storage
function saveEmployeeRecords(records) {
  localStorage.setItem('employeePayrollList', JSON.stringify(records));
}

// Delete a record by index
function deleteRecord(index) {
  if (!confirm('Are you sure you want to delete this record?')) return;
  const records = getEmployeeRecords();
  records.splice(index, 1);
  saveEmployeeRecords(records);
  location.reload();
}

// Edit – redirect to add-employee page with index
function editRecord(index) {
  window.location.href = `add-employee.html?edit=${index}`;
}