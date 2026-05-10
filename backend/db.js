const { Pool } = require("pg");
require("dotenv").config();

const pool = new Pool({
  // This uses the single URL we set in the Render Dashboard
  connectionString: process.env.DATABASE_URL,
  // This is required for cloud databases like Render
  ssl: {
    rejectUnauthorized: false,
  },
});

/* Test DB connection */
pool
  .connect()
  .then(() => {
    console.log("PostgreSQL Connected Successfully");
  })
  .catch((err) => {
    console.error("PostgreSQL Connection Error:", err);
  });

module.exports = pool;
