package generarEntrada;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Procesar {

	public Procesar() {

	}

	public void transform(String XML, String XSL, String HTML)
			throws TransformerConfigurationException, TransformerException {

		TransformerFactory factory = TransformerFactory.newInstance();
		StreamSource xslStream = new StreamSource(XSL);
		Transformer transformer = factory.newTransformer(xslStream);

		StreamSource in = new StreamSource(XML);
		StreamResult out = new StreamResult(HTML);
		transformer.transform(in, out);

		System.out.println("Se ha generado el fichero" + HTML);

	}

	public void abrir(String fichero) throws IOException {
		File htmlFile = new File(fichero);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}
}