# NotesTracker (To-Do List App)

A minimal, clean Android application built with modern development practices. This app allows you to track your daily tasks while getting a dose of inspiration from a random quote every time you open it.

## Features

- **Task Management**: Add, view, edit, and delete tasks.
- **Random Quotes**: Fetches a new inspiring quote on every app launch using the ZenQuotes API.
- **Persistent Storage**: All tasks are saved locally using Room Database.
- **Modern UI**: Built entirely with Jetpack Compose and Material 3.
- **Architecture**: Implements MVVM (Model-View-ViewModel) for a clean separation of concerns.

## Tech Stack

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Local Database**: [Room](https://developer.android.com/training/data-storage/room)
- **Networking**: [Retrofit](https://square.github.io/retrofit/) & [Gson](https://github.com/google/gson)
- **Architecture**: MVVM
- **Dependency Management**: Gradle Version Catalog (libs.versions.toml)

## UI Design

- **Minimalist approach**: Simple lists and cards.
- **Dark/Light Mode**: Supports system theme settings.
- **Interactive**: Tap a task to edit, click the trash icon to delete.

## Getting Started

1. Clone this repository.
2. Open the project in **Android Studio (Ladybug or newer)**.
3. Sync Project with Gradle Files.
4. Run the app on an emulator or a physical device.

## License

This project is open-source and available under the [MIT License](LICENSE).
