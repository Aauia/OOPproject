
---

## 🎓 University System Simulation

**Branch:** genMain
**Tech Stack:** Java, OOP, Design Patterns, File I/O, Serialization  
**Team Role:** Team Lead & System Architect

### 🧠 Overview
This project simulates core components of a university system, including:
- Student registration and course enrollment
- Research paper and journal publishing for researchers
- Curriculum and project management
- Role-based behavior using decorators

### ✨ Features
- **User Roles:** Student, Researcher, Admin  
- **Design Patterns:**  
  - *Singleton* for global user session and data access  
  - *Decorator* to extend user behaviors dynamically  
- **Persistence:** Java Serialization & File I/O  
- **Menu-driven Interface:** CLI menus per user role  
- **Data Models:** `ResearchPaper`, `Journal`, `ResearchProject`, `Curriculum`, etc.

### 📂 Branch Structure
The project code resides in the [`genMain`](https://github.com/Aauia/OOPproject.git) branch to separate it from main/test code.


### Presentation 
The project presentation is here: ['link'](https://www.canva.com/design/DAGaCADG-FI/KYreQ7L7SHnI0L78mQpLGA/edit?utm_content=DAGaCADG-FI&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton).


---

### 🧩 UML & Use Case Diagrams
-   Details can be viewd here : ['link'](https://drive.google.com/drive/folders/1FID5ETOeKHJKb75qXZpK4pnd9VnhRxHz?usp=share_link)
  

*(Preview via Google Drive or download for full resolution.)*

---

### 🚀 How to Run
```bash
# Clone repository and switch to 'gentian' branch
git clone https://github.com/your-username/your-repo.git
cd your-repo
git checkout gentian

# Run via your favorite IDE or compile manually:
javac Main.java
java Main
```

---

### 📌 Notes
- User sessions are maintained using a Singleton class.
- Research papers are linked with journals based on category.
- Serialization ensures data persists across restarts.

---
