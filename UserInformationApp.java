import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInformationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ввод данных
            System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол):");
            String input = scanner.nextLine();

            // Парсинг данных
            String[] userData = input.split("\\s+");
            if (userData.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных. Требуется 6 параметров.");
            }

            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date birthDate = dateFormat.parse(userData[3]);

            long phoneNumber = Long.parseLong(userData[4]);

            char gender = userData[5].charAt(0);
            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверный формат пола. Используйте 'f' или 'm'.");
            }

            // Создание файла
            String fileName = lastName + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                // Запись данных в файл
                writer.write(lastName + " " + firstName + " " + middleName + " " + dateFormat.format(birthDate) +
                        " " + phoneNumber + " " + gender);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IllegalArgumentException | ParseException e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        }
    }
}