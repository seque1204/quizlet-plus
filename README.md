# 🧠 Flashcard Learning App (Quizlet Clone)

This is a **command-line flashcard application in Java** that emulates the *Learning* feature of Quizlet. It guides users through a structured learning cycle using spaced repetition logic based on user performance.

---

## 🚀 How It Works

- Users input term-definition pairs (e.g., `Term,Definition,Term,Definition,...`).
- Flashcards are managed in **three linked lists**:
  - `Learning`: initial state for all cards.
  - `Learned`: for cards answered correctly once.
  - `Mastered`: for cards answered correctly twice.
- A random card is presented from either `Learning` or `Learned`.
- Cards move up the ranks when answered correctly, or stay if incorrect.

---

## ✏️ Features

- **Interactive Setup**  
  - Input custom term-definition pairs via comma-separated input.
  - Modify terms or definitions before starting the quiz.

- **Learning Logic**  
  - Cards answered correctly in `Learning` → move to `Learned`.
  - Cards answered correctly in `Learned` → move to `Mastered`.
  - Cards answered incorrectly stay in their current list.

- **Editing Options**  
  - Modify individual terms or definitions after initial input.
  - Add new flashcards at any time.

- **Progress Tracking**  
  - Automatically prints progress across `Learning`, `Learned`, and `Mastered` lists.
  - Encourages review until all cards are mastered.

---

## 🧪 Example Usage

**Sample Input**:
first president,George Washington,second president,John Adams,third president,Thomas Jefferson

**Sample Prompts**:
- Enter your answer for the term "third president":
- Thomas Jefferson
- Correct!

---

## 🛠️ File Structure

- `Flashcard.java` — Class definition and logic for managing flashcards
- `Main.java` — Entry point; manages user interaction and control flow

---

## 🔧 Technologies

- Java Standard Library
  - `java.util.LinkedList`
  - `java.util.Scanner`
  - `java.util.Random`

---

## 🎓 Learning Goals

This project was built as a way to:
- Practice **object-oriented programming** in Java
- Learn to use **collections (LinkedList)** for state management
- Implement **simple user-driven state transitions**
- Build an engaging and interactive **terminal-based learning tool**

---

## 📬 Contact

Feel free to reach out for improvements or feature suggestions via [GitHub Issues](../../issues) or connect with me on [LinkedIn](https://www.linkedin.com/in/josequeira).
