# 🎲 Snake and Ladder Game (Java)

A modular and testable **Snake and Ladder** game implemented in Java, using object-oriented design principles and strategy patterns.

---

## 🚀 Features

- 🎯 Configurable snake and ladder placement via Strategy Pattern
- 🎮 Multi-player game engine with dynamic turn handling
- 🎲 Dice abstraction for easier mocking in tests
- ✅ Unit tests using JUnit and Mockito
- 🧪 Dependency injection for better testability
- 🔍 Clean logging for traceable game flow

---

## ⚙️ Requirements

- Java 11+
- Maven 3.6+

---

## 🧪 Running Tests

```bash
mvn test
```

---
## ▶️ How to Play

Run the game using:
```bash
mvn compile exec:java -Dexec.mainClass="com.snakegame.SnakeAndLadderGame"
```
---

## 🧠 Design Highlights
Strategy Pattern: Used to inject different snake/ladder placement behaviors.
Dependency Injection: GameManager accepts board/dice as constructor arguments for testability.
Encapsulation: Player and Board manage their own state with safe accessors.
Optional API: Used to avoid nulls when checking for snake/ladder hits.
