# ⚽ JLeague Simulator - Soccer Domain Simulator

[![Java Version](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/)
[![Architecture](https://img.shields.io/badge/Architecture-DDD%20%2F%20Clean%20Code-blue.svg)]()
[![License](https://img.shields.io/badge/License-MIT-green.svg)]()

**JLeague Simulator** is a soccer match domain simulator built in Java. The project was architected by strictly applying the pillars of **Object-Oriented Programming (OOP)** and **Clean Code** best practices, focusing on rigid encapsulation, entity state protection, and specialized business rule handling through custom exceptions.

The system simulates everything from the lineup and validation of athletes and coaching staff to real-time match events, featuring a probabilistic decision-making engine to simulate the fouls and cards system (VAR).

---

## 🚀 Key Features

* **Strict Domain Validation:** Blocks invalid states at the root. Players have a minimum age requirement of 6 years old, and coaches must be at least 18. Custom exceptions are immediately thrown if these rules are violated.
* **High-Level Encapsulation:** Leverages memory shielding with native `final` arrays, defensive copies (`Arrays.copyOf`), and Constructor Chaining for logical centralization.
* **Probabilistic Foul Mechanism (VAR):** Simulates referee decision-making using the `Random` class to distribute verbal warnings, yellow cards, and direct red cards based on percentage chances.
* **Vital State Management:** Sent-off players have their state changed to unavailable (`isExpelled`), creating a rigid lock (Guard Clauses) that prevents new actions or goals by throwing an `IllegalStateException`.
* **Match Analytics:** Real-time scoreboard control structured under the **CQS (Command Query Separation)** architectural pattern, featuring dynamic winner identification and an optimized Top Scorer search.

---

## 🛠️ Architecture and Folder Structure

The project is organized into cohesive packages, isolating business responsibilities, services, and test infrastructure:

```text
src/
└── shall/
    ├── domain/               # Domain Entities (Rich Model)
    │   ├── enums/
    │   │   └── Gender.java   # Gender Definition (Enum)
    │   ├── Person.java       # Base Abstract Superclass
    │   ├── Player.java       # Player Specialization (Age and Card Rules)
    │   ├── Coach.java        # Coach Specialization (Formation and Experience)
    │   ├── Team.java         # Aggregator of Players and Coaching Staff
    │   └── Match.java        # Match and Scoreboard Orchestrator
    ├── error/                # Business Rule Exceptions Layer
    │   ├── InvalidAge.java   # Age requirement errors (Unchecked)
    │   ├── FullTeam.java     # Squad capacity limit errors (Unchecked)
    │   └── NullPlayerException.java # Protection against null data injection
    ├── services/             # Peripheral Service Classes
    │   └── CheckCategory.java # Age-based Subcategory Classifier
    └── test/                 # Test Scenarios and Simulations
        ├── Test09.java       # Full Game Simulation (Match Simulation)
        └── Test10.java       # Discipline System Stress Test (VAR)
