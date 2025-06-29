# Java Alarm Clock

This is a simple console-based **alarm clock application in Java**.  
It allows you to set an alarm time in `HH:mm:ss` format.  
When the time matches, it plays an audio file as the alarm sound.

---

## 🚀 Features
✅ Set alarm time via console input  
✅ Displays a live clock counting seconds  
✅ Plays a `.wav` audio file when alarm time is reached  
✅ Press Enter to stop the alarm sound

---

## 🛠 Requirements
- Java JDK 8 or above
- A `.wav` audio file (example used: `Ran During Time - Freedom Trail Studio.wav`)
- Git (optional, for version control)

---

## 📂 Files
- `alarm_clock.java` : Main Java source code  
- `Ran During Time - Freedom Trail Studio.wav` : Audio file to play as alarm (you can use your own `.wav` file)

---

## 📝 How to Compile
Open terminal / command prompt in your project directory and run:

```bash
javac alarm_clock.java

HOW TO RUN
java alarm_clock

🎧 Usage Instructions
Run the program.

Enter alarm time in HH:mm:ss format, for example:

Enter the alarm time in HH:mm:ss format: 15:30:00
The console will keep updating the current time every second.

When it reaches the alarm time, it plays the audio file.

Press Enter to stop the alarm sound.

⚠️ Notes
Make sure the audio file path matches in your code.
Example line:

String filePath = "Ran During Time - Freedom Trail Studio.wav";
If your file is named differently or in another folder, update this accordingly.

Only .wav files are supported by javax.sound.sampled.

💡 Example Output
Enter the alarm time in HH:mm:ss format: 15:30:00
Alarm set for: 15:30
15:29:50
15:29:51
...
15:30:00
Alarm ringing! Time to wake up!
Press enter to stop the audio
