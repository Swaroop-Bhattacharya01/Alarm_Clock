import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class AlarmClock implements Runnable {
    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    public AlarmClock(LocalTime alarmTime, String filePath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        LocalTime now = LocalTime.now();
        while (now.isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);
                now = LocalTime.now();
                System.out.printf("\r%02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond());
            } catch (InterruptedException e) {
                System.out.println("Alarm thread interrupted.");
            }
        }
        System.out.println("\nAlarm ringing! Time to wake up!");
        playSound(filePath);
    }

    private void playSound(String filePath) {
        File audioFile = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.println("Press enter to stop the audio");
            scanner.nextLine();
            clip.stop();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file format.");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable.");
        } catch (IOException e) {
            System.out.println("Error playing audio file: " + e.getMessage());
        }
    }
}

public class alarm_clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        while (alarmTime == null) {
            try {
                System.out.print("Enter the alarm time in HH:mm:ss format: ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for: " + alarmTime);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please enter the time in HH:mm:ss format.");
            }
        }

        String filePath = "Ran During Time - Freedom Trail Studio.wav";
        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}
