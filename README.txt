requirements:
1.Track books, borrowers, and due dates with a search feature.
2.mind map:
                 ┌──────────────────┐
                 │  Welcome Page    │      ---------|
                 │  [Start/Login]   │               |
                 └────────┬─────────┘          |-------Background(1stpage)
                             │                       |
                             ▼                       |
                 ┌──────────────────┐          |
                 │   Login Page     │                |
                 │ [Username, PW]   │      ----------|
                 │  [Login Button]  │
                 └────────┬─────────┘
                             │
                             ▼
                 ┌────────────────────┐
                 │   Main Dashboard   │
                 │ [Books Category]   │
                 │ [Search Books]     │      ----------2nd page
                 │ [Add/Remove Books] │
                 │ [Logout]           │
                 └────┬────┬────┬─────┘
                        │     │     │
     ┌─────────────┘     │     └────────────┐
     ▼                   ▼                  ▼
┌────────────┐     ┌──────────────┐    ┌─────────────────┐
│ Book List  │     │ Search Books │    │ Add/Remove Book │
└────────────┘     └──────────────┘    └─────────────────┘

LibraryManagementSystem/
│
├── src/                        ← Java source code root
│   ├── entity/                 ← Core data classes (Book, User, etc.)
│   │   ├── Book.java
│   │   └── User.java
│   │
│   ├── gui/                    ← GUI screens (Swing windows)
│   │   ├── WelcomePage.java
│   │   ├── LoginPage.java
│   │   ├── DashboardPage.java
│   │   ├── BookListPage.java
│   │   ├── SearchPage.java
│   │   └── AddRemovePage.java
│   │
│   ├── files/                  ← File handling (optional: for save/load)
│   │   ├── BookFileHandler.java
│   │   └── UserFileHandler.java
│   │
│   └── Main.java              ← Entry point of your app
│
├── images/                    ← Store logo or icons for GUI
│   ├── logo.png
│   └── book_icon.png
│
├── .gitignore                 ← (If using GitHub: ignore compiled files, etc.)
├── README.md                  ← Project description




