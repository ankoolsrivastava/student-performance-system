<div align="center">

# 📊 Student Performance Analysis System

[![Node.js](https://img.shields.io/badge/Node.js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white)]()
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)]()
[![Chart.js](https://img.shields.io/badge/Chart.js-FF6384?style=for-the-badge&logo=chartdotjs&logoColor=white)]()
[![Status](https://img.shields.io/badge/Status-Live-success?style=for-the-badge)]()

A robust, full-stack web application designed specifically for **class teachers** to efficiently track, manage, and visualize the academic metrics of their students. 

**[🚀 View Live Demo Here](https://student-performance-web-rpkb.onrender.com)** <!-- Replace '#' with your actual hosted link -->

</div>

---

## 🔑 Demo Access

To explore the live application as a class teacher, please use the following test credentials:
*   **Email:** `rahul@college.com`
*   **Password:** `12345`

---

## 📑 Table of Contents
- [About the Project](#-about-the-project)
- [Key Features](#-key-features)
- [System Architecture](#-system-architecture)
- [Tech Stack](#-tech-stack)
- [Installation & Setup](#-installation--setup)
- [API Reference](#-api-reference)
- [Author](#-author)

---

## 📖 About the Project

The Student Performance Analysis System is built to eliminate the administrative burden of manual grade tracking. Designed with the **class teacher** in mind, this platform bridges the gap between raw academic data and actionable insights. 

By leveraging a relational PostgreSQL database and a responsive front-end powered by Chart.js, a class teacher can seamlessly input academic records, instantly view performance trends, and identify students who may need additional support through subject-wise analytics and attendance correlations.



## ✨ Key Features

*   **Class Teacher Dashboard:** A centralized, at-a-glance view of the entire class's performance, attendance averages, and overall academic health.
*   **Interactive Data Visualization:** Real-time generation of bar, line, and pie charts using Chart.js to map both class-wide trends and individual student progress.
*   **Optimized Relational Database:** Highly normalized PostgreSQL schema ensuring data integrity across student profiles, course modules, and grading criteria.
*   **RESTful API Architecture:** Scalable Node.js/Express backend providing secure and efficient endpoints for adding and managing student records.
*   **Responsive User Interface:** Clean, intuitive interface accessible across desktop and mobile devices, perfect for updating records on the go.

---

## 🏗️ System Architecture

*   **Client Layer:** Renders the UI and dynamic charts. Communicates with the server via REST APIs.
*   **Application Layer (Node.js/Express):** Handles business logic, request routing, and database connections.
*   **Data Layer (PostgreSQL):** Persists student profiles and performance data securely.

---

## 💻 Tech Stack

**Frontend:**
*   HTML5 & CSS3
*   Vanilla JavaScript (ES6+)
*   Chart.js (Data Visualization)

**Backend:**
*   Node.js
*   Express.js (REST API Framework)

**Database:**
*   PostgreSQL
*   `pg` (Node-Postgres library for database integration)

---

## 🚀 Installation & Setup

Follow these instructions to run a local copy of the project.

### Prerequisites
*   [Node.js](https://nodejs.org/) installed (v14.x or higher)
*   [PostgreSQL](https://www.postgresql.org/) installed and running locally

### Step-by-Step Guide

**1. Clone the repository:**
```bash
git clone [https://github.com/your-username/student-performance-analysis.git](https://github.com/your-username/student-performance-analysis.git)
cd student-performance-analysis
