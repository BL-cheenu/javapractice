// ============================================================
// Day 47 - Part 2: AJAX Server Calls to JSONServer using PROMISE
// ============================================================
// Run: node 2_promise.js
// Requires json-server running: npx json-server --watch db.json --port 3000

const http = require("http");

// Helper: AJAX-style GET using http module wrapped in a Promise
function ajaxGet(url) {
  return new Promise((resolve, reject) => {
    http.get(url, (res) => {
      let data = "";

      res.on("data", (chunk) => {
        data += chunk;
      });

      res.on("end", () => {
        try {
          const parsed = JSON.parse(data);
          resolve(parsed);
        } catch (err) {
          reject(new Error("Failed to parse JSON: " + err.message));
        }
      });
    }).on("error", (err) => {
      reject(err);
    });
  });
}

// ---- Using .then().catch() chaining ----
console.log("=== Fetching ALL Employees (Promise .then/.catch) ===");
ajaxGet("http://localhost:3000/employees")
  .then((employees) => {
    console.log("Employees List:");
    employees.forEach((emp) => {
      console.log(
        `  ID: ${emp.id} | Name: ${emp.name} | Dept: ${emp.department} | Salary: $${emp.salary}`
      );
    });
  })
  .catch((err) => {
    console.error("Error:", err.message);
  });

// ---- Using async/await ----
async function getEmployeeById(id) {
  console.log(`\n=== Fetching Employee ID=${id} (async/await) ===`);
  try {
    const employee = await ajaxGet(`http://localhost:3000/employees/${id}`);
    console.log("Employee Found:");
    console.log(`  Name: ${employee.name}`);
    console.log(`  Department: ${employee.department}`);
    console.log(`  Salary: $${employee.salary}`);
  } catch (err) {
    console.error("Error fetching employee:", err.message);
  }
}

// ---- Promise.all: Fetch multiple employees in parallel ----
async function getAllParallel() {
  console.log("\n=== Fetching Multiple Employees in Parallel (Promise.all) ===");
  try {
    const [emp1, emp2, emp3] = await Promise.all([
      ajaxGet("http://localhost:3000/employees/1"),
      ajaxGet("http://localhost:3000/employees/2"),
      ajaxGet("http://localhost:3000/employees/3"),
    ]);
    console.log("Parallel Results:");
    [emp1, emp2, emp3].forEach((emp) => {
      console.log(`  ${emp.name} - ${emp.department} - $${emp.salary}`);
    });
  } catch (err) {
    console.error("Error in parallel fetch:", err.message);
  }
}

// Run async functions
getEmployeeById(1);
getAllParallel();
