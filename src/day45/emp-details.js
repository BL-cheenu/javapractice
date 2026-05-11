// UC 5 – View Employee Payroll Details from JSON Object
// Uses Template Literals + for loop to populate table
// Showcases each Department separately

window.addEventListener('DOMContentLoaded', (event) => {

  const container = document.querySelector('#deptContainer');
  const countEl   = document.querySelector('#empCount');

  // UC 5 – Get unique departments from JSON Object using for loop
  const departments = [];
  for (let i = 0; i < employeePayrollData.length; i++) {
    if (!departments.includes(employeePayrollData[i].department)) {
      departments.push(employeePayrollData[i].department);
    }
  }

  let totalCount = 0;
  let deptHTML   = '';

  // UC 5 – Loop through each department and build HTML using Template Literals
  for (let d = 0; d < departments.length; d++) {
    const dept = departments[d];

    // Filter employees for this department using for loop
    const deptEmployees = [];
    for (let i = 0; i < employeePayrollData.length; i++) {
      if (employeePayrollData[i].department === dept) {
        deptEmployees.push(employeePayrollData[i]);
      }
    }

    totalCount += deptEmployees.length;

    // UC 5 – Build table rows using for loop + Template Literals
    let rowsHTML = '';
    for (let r = 0; r < deptEmployees.length; r++) {
      const emp = deptEmployees[r];
      rowsHTML += `
        <tr style="background: ${r % 2 === 0 ? '#fff' : '#f8fafc'}">
          <td class="td-serial">${r + 1}</td>
          <td class="td-name">${emp.name}</td>
          <td class="td-date">${formatDate(emp.startDate)}</td>
          <td><span class="salary-badge">₹${emp.salary.toLocaleString('en-IN')} / month</span></td>
        </tr>
      `;
    }

    // UC 5 – Use Template Literal to build each Department section
    deptHTML += `
      <div class="dept-section">
        <div class="dept-heading">
          <span class="dept-badge dept-badge-lg">${dept}</span>
          <span class="dept-count">${deptEmployees.length} employee${deptEmployees.length > 1 ? 's' : ''}</span>
        </div>
        <table class="emp-table">
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Start Date</th>
              <th>Salary / Month</th>
            </tr>
          </thead>
          <tbody>
            ${rowsHTML}
          </tbody>
        </table>
      </div>
    `;
  }

  // UC 5 – Set innerHTML using document object
  container.innerHTML = deptHTML;

  // Update total count
  if (countEl) countEl.textContent = totalCount;

});

// Format date as DD/MM/YYYY
function formatDate(dateStr) {
  if (!dateStr) return '-';
  const d = new Date(dateStr);
  return d.toLocaleDateString('en-IN', {
    day:   '2-digit',
    month: '2-digit',
    year:  'numeric'
  });
}
