

# Battery Alarm Application

## Overview

Battery Alarm is an Android application that monitors the battery level of your device. It notifies the user when the battery level is low (below 20%) by displaying a notification and updating the UI with appropriate images indicating the battery status.
![Promo](https://github.com/MalakAmgad/BattaryAlarm/blob/master/promo.gif)

## Features

- **Battery Level Monitoring:** Continuously monitors the device's battery level.
- **Low Battery Notification:** Displays a notification when the battery level is below 20%.
- **Dynamic UI Updates:** Updates the UI with different images representing the battery status (full or low).

## Architecture

The application follows the MVVM (Model-View-ViewModel) architecture and uses the following components:

- **Jetpack Compose:** For building the UI.
- **ViewModel:** To manage UI-related data in a lifecycle-conscious way.
- **StateFlow:** To handle state updates and UI reactivity.
- **BroadcastReceiver:** To listen for battery level changes.
- **NotificationUtils:** To handle the creation and display of notifications.

## Project Structure

```
.
├── app
│   ├── src/main
│   │   ├── java/com/example/batteryalarm
│   │   │   ├── MainActivity.kt
│   │   │   ├── BatteryViewModel.kt
│   │   │   ├── NotificationUtils.kt
│   │   ├── res
│   │   │   ├── drawable
│   │   │   │   ├── ic_battery_alert.xml
│   │   │   │   ├── battery_full.xml
│   │   │   │   ├── battery_low.xml
│   │   │   ├── layout
│   │   │   ├── values
│   │   │   │   ├── strings.xml
│   ├── AndroidManifest.xml
│   ├── build.gradle
├── build.gradle
```

## Getting Started

### Prerequisites

- Android Studio (latest version recommended)
- Android device or emulator running Android 13.0  or higher

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/MalakAmgad/BattaryAlarm.git
   ```

2. **Open the project in Android Studio:**

   - Open Android Studio.
   - Select "Open an existing Android Studio project".
   - Navigate to the cloned repository and select the project folder.

3. **Build and run the project:**

   - Connect an Android device or start an emulator.
   - Click the "Run" button in Android Studio to build and deploy the app.

## Usage

1. **Launch the app:** Open the Battery Alarm app on your device or emulator.
2. **Monitor battery level:** The app will automatically monitor the battery level.
3. **Receive notifications:** When the battery level drops below 20%, a notification will be displayed, and the UI will update to indicate the low battery status.

## Code Explanation

### MainActivity

The `MainActivity` is the entry point of the app. It initializes the UI and observes the `BatteryViewModel` for changes in battery level and low battery status.

### BatteryViewModel

The `BatteryViewModel` class manages the battery level data and handles the logic for updating the UI and triggering notifications. It uses a `BroadcastReceiver` to listen for battery level changes and updates `StateFlow` properties accordingly.

### NotificationUtils

The `NotificationUtils` class provides utility functions for creating and displaying notifications. It ensures that a notification channel is created (for Android 8.0 and higher) and displays a notification when the battery is low.

## Contributing

Contributions are welcome! If you have any improvements or bug fixes, please create a pull request.

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push to your branch.
4. Create a pull request explaining your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the Android Developers community for their excellent documentation and resources.
