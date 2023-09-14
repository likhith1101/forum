package com.prodapt.learningspring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prodapt.learningspring.model.Student;

public class ClassroomDbConnect {

	Connection cnx = null;
	List<Student> studentList;

	public ClassroomDbConnect() {
		try {
			this.cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/student-data", "prodapt", "we1c@me1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		studentList = new ArrayList<Student>();
	}

	public void addStudent(Student student) {

		String addMatchQuery = "INSERT INTO students (name, score) VALUES (?, ?)";
		try (PreparedStatement statement = cnx.prepareStatement(addMatchQuery)) {
			statement.setString(1, student.getName());
			statement.setInt(2, student.getScore());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Student> retrieveStudentList() {
		studentList = new ArrayList<Student>();
		String retrieveNewsQuery = "SELECT * FROM students";

		try (PreparedStatement statement = cnx.prepareStatement(retrieveNewsQuery)) {
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					int score = resultSet.getInt("score");
					Student student = new Student();
					student.setId(id);
					student.setName(name);
					student.setScore(score);
					studentList.add(student);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public void deleteStudent(int id) {

		String addMatchQuery = "DELETE FROM students WHERE id = ?";
		try (PreparedStatement statement = cnx.prepareStatement(addMatchQuery)) {
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(int id,String name,int score) {

		String addMatchQuery = "UPDATE students SET name = ?, score = ? WHERE id = ?";
		try (PreparedStatement statement = cnx.prepareStatement(addMatchQuery)) {
			statement.setString(1, name);
			statement.setInt(2, score);
			statement.setInt(3, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}