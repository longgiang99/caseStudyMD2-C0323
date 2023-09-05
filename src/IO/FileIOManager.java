/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IO;

/**
 *
 * @author longg
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;

public class FileIOManager {
    private static final String USER_FILE_PATH = "users.txt";
    private static final String SCORE_FILE_PATH = "scores.txt";
    private static final String STUDENT_FILE_PATH = "students.txt";

    public static void writeUsers(List<String> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH))) {
            for (String user : users) {
                writer.write(user);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readUsers() {
        List<String> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    public static void writeScores(List<Integer> scores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE_PATH))) {
            for (Integer score : scores) {
                writer.write(score.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Integer> readScores() {
        List<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SCORE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scores.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public static void writeStudents(List<SinhVien> students) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE_PATH))) {
            outputStream.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<SinhVien> readStudents() {
        List<SinhVien> students = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(STUDENT_FILE_PATH))) {
            students = (List<SinhVien>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}

