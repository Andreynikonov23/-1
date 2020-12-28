package ru.sapteh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataBaseConnection dataBase = new DataBaseConnection();
        Connection connection = dataBase.getConnection();
        String sqlSelect = "SELECT * FROM " + Students.TABLE_NAME;
        List<Students> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery();
            Students students = null;
            while (resultSet.next()) {
                int id = resultSet.getInt(Students.ID_COLUMN);
                String name = resultSet.getString(Students.NAME_COLUMN);
                String firstname = resultSet.getString(Students.FIRSTNAME_COLUMN);
                String lastname = resultSet.getString(Students.LASTNAME_COLUMN);
                String profession = resultSet.getString(Students.PROFESSION_COLUMN);
                String course = resultSet.getString(Students.COURSE_COLUMN);
                list.add(students);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите -с, -d или -u");
        String crud = scanner.nextLine();


        if(crud.equals("-c")) {
            System.out.println("Введите имя студента");
            String name = scanner.nextLine();
            System.out.println("Введите фамилию");
            String firstname = scanner.nextLine();
            System.out.println("Введите отчество");
            String lastname = scanner.nextLine();
            System.out.println("Введите специальность");
            String profession = scanner.nextLine();
            System.out.println("Введите курс");
            String course = scanner.nextLine();
            Students students = new Students(list.size()+1, name, firstname, lastname, profession, course);
            try {
                String sqlInsert = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES(?,?,?,?,?)",
                        Students.TABLE_NAME,Students.NAME_COLUMN,
                        Students.FIRSTNAME_COLUMN,Students.LASTNAME_COLUMN,
                        Students.PROFESSION_COLUMN,Students.COURSE_COLUMN);
                PreparedStatement statement = connection.prepareStatement(sqlInsert);
                statement.setString(1, name);
                statement.setString(2, firstname);
                statement.setString(3, lastname);
                statement.setString(4, profession);
                statement.setString(5, course);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (crud.equals("-d")) {
            System.out.println("Введите id записи");
            int id = Integer.parseInt(scanner.nextLine());
            try {
                String sqlDelete = String.format("DELETE FROM %s WHERE %s=?", Students.TABLE_NAME, Students.ID_COLUMN);
                PreparedStatement statement = connection.prepareStatement(sqlDelete);
                statement.setInt(1,id);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (crud.equals("-u")) {
            System.out.println("Введите id студента");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите имя студента");
            String name = scanner.nextLine();
            System.out.println("Введите фамилию");
            String firstname = scanner.nextLine();
            System.out.println("Введите отчество");
            String lastname = scanner.nextLine();
            System.out.println("Введите специальность");
            String profession = scanner.nextLine();
            System.out.println("Введите курс");
            String course = scanner.nextLine();
            try {
                String sqlUpdate = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
                        Students.TABLE_NAME,Students.NAME_COLUMN,
                        Students.FIRSTNAME_COLUMN,Students.LASTNAME_COLUMN,
                        Students.PROFESSION_COLUMN,Students.COURSE_COLUMN,
                        Students.ID_COLUMN);
                PreparedStatement statement = connection.prepareStatement(sqlUpdate);
                statement.setString(1,name);
                statement.setString(2,firstname);
                statement.setString(3,lastname);
                statement.setString(4,profession);
                statement.setString(5,course);
                statement.setInt(6,id);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

