package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Places;
import net.azib.java.students.t050545.homework.sport.PointSystem.Discipline;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


/**
 * XMLWriter
 *
 * @author libricon
 */
public class XMLWriter implements SportmanWriter {
	
	/** XML file forms and writing here */
	private XMLStreamWriter writer;
	
	/** XML file will be written to stream.
	 * @param stream XML file stream
	 * @throws XMLStreamException
	 */
	public XMLWriter(Writer stream) throws XMLStreamException{
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		writer = factory.createXMLStreamWriter(stream);
	}
	/** XML document will be written to fileName
	 * @param fileName XML output file name
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws XMLStreamException
	 */
	public XMLWriter(String fileName) throws ParserConfigurationException, FileNotFoundException, XMLStreamException {
		// New document  initialise
		PrintWriter out = new PrintWriter(fileName);
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		writer = factory.createXMLStreamWriter(out);	
	}

	/**
	 *  Method form XML file by using competition and save it to stream
	 *  After this method, it's needed to call <code>close()</code> method
	 *  @param comp lint to competition with results and places
	 */
	@Override
	public void printResultTable(Competition comp) throws XMLStreamException {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		writer.writeStartDocument();
		writer.writeCharacters("\n");
		writer.writeStartElement("competition");
		writer.writeAttribute("name", comp.getName());
		writer.writeAttribute("id", String.valueOf(comp.getId()));
		for (Places pl  : comp.getPlaces()) {
			writer.writeCharacters("\n");
			writer.writeStartElement("place");
			 writer.writeAttribute("num", pl.getPlaceNum());
			 writer.writeCharacters("\n   ");
			 writer.writeStartElement("sportman");
			  writer.writeCharacters("\n\t");
			  writer.writeStartElement("name");
			    writer.writeCharacters(pl.getSportman().getPerson().getName());
			  writer.writeEndElement(); // name
			  writer.writeCharacters("\n\t");
			  writer.writeStartElement("birthday");
			    writer.writeCharacters(df.format(pl.getSportman().getPerson().getBirthDay().getTime()));
			  writer.writeEndElement(); // BOD
			  writer.writeCharacters("\n\t");
			  writer.writeStartElement("country");
			    writer.writeCharacters(pl.getSportman().getPerson().getCountry());
			  writer.writeEndElement(); // country
			  writer.writeCharacters("\n\t");
			  writer.writeStartElement("resulttable");
			  for(Discipline dis : Discipline.values()){
				  writer.writeCharacters("\n\t\t");
				  writer.writeStartElement(dis.toString());
				  writer.writeCharacters("\n\t\t\t");
				  writer.writeStartElement("result");
				  writer.writeCharacters(String.valueOf(pl.getSportman().getPoints().getResults()[dis.ordinal()]));
				  writer.writeEndElement();
				  writer.writeCharacters("\n\t\t\t");
				  writer.writeStartElement("score");
				  writer.writeCharacters(String.valueOf(pl.getSportman().getPoints().getScores()[dis.ordinal()]));
				  writer.writeEndElement();
				  writer.writeCharacters("\n\t\t");
				  writer.writeEndElement();
			  }
			  writer.writeCharacters("\n\t");
			  writer.writeStartElement("total");
			  writer.writeCharacters(String.valueOf(pl.getSportman().getPoints().getScore()));
			  writer.writeEndElement(); // name
			  writer.writeCharacters("\n\t");
			  writer.writeEndElement(); // resulttable
			writer.writeCharacters("\n   ");
			writer.writeEndElement(); // sportman
			writer.writeEndElement(); // place end 
			
		}
		
		writer.writeCharacters("\n");
	
		writer.writeEndDocument();
		writer.flush();
	}
	
	/** 
	 *  close write stream
	 */
	@Override
	public void close(){
		
		try {
			writer.close();
		}
		catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
	}


}