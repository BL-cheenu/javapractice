// UC 2 – Load Employee Details from Local Storage and render table

window.addEventListener('DOMContentLoaded', () => {

  loadEmployeeTable();

});

function loadEmployeeTable() {
  const tbody      = document.querySelector('#empTableBody');
  const emptyState = document.querySelector('#emptyState');
  const table      = document.querySelector('#empTable');

  // Get records from Local Storage
  const records = getEmployeeRecords();

  if (records.length === 0) {
    table.style.display = 'none';
    emptyState.classList.add('show');
    return;
  }

  table.style.display = 'table';
  emptyState.classList.remove('show');
  tbody.innerHTML = "";

  records.forEach((emp, index) => {
    const tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${index + 1}</td>
      <td>${emp.name}</td>
      <td><span class="dept-badge">${emp.department || '-'}</span></td>
      <td><span class="salary-badge">₹${Number(emp.salary).toLocaleString('en-IN')}</span></td>
      <td>${emp.startDate || '-'}</td>
      <td>
        <button class="action-btn btn-edit"   onclick="editRecord(${index})">Edit</button>
        <button class="action-btn btn-delete" onclick="deleteRecord(${index})">Delete</button>
      </td>
    `;
    tbody.appendChild(tr);
  });
}

// Get all employee records from Local Storage
function getEmployeeRecords() {
  const data = localStorage.getItem('employeePayrollList');
  return data ? JSON.parse(data) : [];
}

// Save all records back to Local Storage
function saveEmployeeRecords(records) {
  localStorage.setItem('employeePayrollList', JSON.stringify(records));
}

// Delete a record by index
function deleteRecord(index) {
  if (!confirm("Are you sure you want to delete this record?")) return;
  const records = getEmployeeRecords();
  records.splice(index, 1);
  saveEmployeeRecords(records);
  loadEmployeeTable();
}

// Edit – redirect to add-employee page with index (for future UC)
function editRecord(index) {
  window.location.href = 'add-employee.html?edit=' + index;
}
