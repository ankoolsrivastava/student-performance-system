const express = require("express");
const cors = require("cors");

// Move these requires up here
const studentRoutes = require("./routes/studentRoutes");
const teacherRoutes = require("./routes/teacherRoutes");
const adminRoutes = require("./routes/adminRoutes");
const analysisRoutes = require("./routes/analysisRoutes");
const marksRoutes = require("./routes/marksRoutes");
const attendanceRoutes = require("./routes/attendanceRoutes");
const errorHandler = require("./middleware/errorHandler");
const assignmentRoutes = require("./routes/assignmentRoutes");

// 1. Initialize the app FIRST
const app = express();

// 2. Now you can use middleware
app.use(cors());
app.use(express.json());

/* Static folder for uploads */
app.use("/uploads", express.static("uploads"));

/* Routes */
app.use("/api/students", studentRoutes);
app.use("/api/teachers", teacherRoutes);
app.use("/api/admin", adminRoutes);
app.use("/api/analysis", analysisRoutes);
app.use("/api/marks", marksRoutes);
app.use("/api/attendance", attendanceRoutes);
app.use("/api/assignments", assignmentRoutes);

/* Health check */
app.get("/health", (req, res) => {
  res.json({
    status: "API running",
    timestamp: new Date(),
  });
});

/* Root route */
app.get("/", (req, res) => {
  res.send("Student Performance Analysis System API");
});

/* Error handler must be last */
app.use(errorHandler);

const PORT = process.env.PORT || 5000;

app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
