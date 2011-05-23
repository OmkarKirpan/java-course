package net.azib.java.students.t107110.homework;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;

import static net.azib.java.students.t107110.homework.Utils.toInputStream;

/**
 * @author Eduard Shsutrov
 */
public class DBResultReaderTest {
	private static final String DB_URL = "jdbc:hsqldb:mem:db";
	private static final String DB_USER = "sa";
	private static final String DB_PASSWORD = "";
	private static final String DB_PROPERTIES =
			"db.url=" + DB_URL + "\n" + "db.user=" + DB_USER + "\n" + "db.password=" + DB_PASSWORD;

	private static final String CREATE_COMPETITIONS =
			"CREATE TABLE competitions (id INT GENERATED BY DEFAULT AS IDENTITY, name VARCHAR(32)) ";
	private static final String ADD_COMPETITION = "INSERT INTO competitions (name) VALUES (?)";

	private InputStream propertiesStream = toInputStream(DB_PROPERTIES);

	@Before
	public void prepare() throws SQLException {
		final Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		final Statement statement = connection.createStatement();
		statement.execute(CREATE_COMPETITIONS);
		final PreparedStatement addCompetition = connection.prepareStatement(ADD_COMPETITION);
		addCompetition.setString(1, "name1");
		addCompetition.execute();
		addCompetition.setString(1, "name2");
		addCompetition.execute();
		addCompetition.setString(1, "name1");
		addCompetition.execute();
	}

	@Test
	public void athleteName() {

	}
}
