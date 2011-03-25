package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.components.Result;
import net.azib.java.students.t104971.homework.athletics.util.InputParser;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Jaroslav Judin
 */
public class CSVWriter implements OutputWriter {

    private Collection<Athlete> athletes;

    public CSVWriter(Collection<Athlete> athletes) {
        this.athletes = athletes;
    }

    public String write(String outFileName) {
        try {
            if (outFileName.isEmpty()) {
                outFileName = PropertiesLoader.getXMLPath().replace(".xml", ".csv");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
            for (Athlete athlete : athletes) {
                writer.write(createLine(athlete));
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            Logger.getLogger(getClass()).error(e);
        }
        return outFileName;
    }

    private String createLine(Athlete athlete) {
        StringBuilder line = new StringBuilder()
                .append(athlete.getName())
                .append(",")
                .append(InputParser.formatDate(athlete.getDateBirth()))
                .append(",")
                .append(athlete.getCountry())
                .append(",");
        for (Result result : athlete.getResults()) {
            line.append(result.getResult())
                    .append(",");
        }
        line.deleteCharAt(line.length() - 1);
        return line.toString();
    }
}