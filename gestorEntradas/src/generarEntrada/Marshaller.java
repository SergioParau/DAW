package generarEntrada;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Marshaller {

	private Document dom = null;
	private Entrada entradas = null;

	public Marshaller(Entrada e) {
		entradas = e;
	}

	public void crearDocumento() {
		// factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// documentBuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// instancia DOM

			dom = db.newDocument();

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	public void crearArbolDOM() {

		// elemento ra�z "entradas"

		Element docEle = dom.createElement("entradas");
		dom.appendChild(docEle);

			// Crear cada objeto entrada, creamos el elemento <entradas>
			Element EntradaEle = setEntrada(entradas);
			docEle.appendChild(EntradaEle);

		}
		
	
	
	private Element setEntrada(Entrada e){
		
		//creamos el elemento entrada
		Element EntradaEle = dom.createElement("entrada");
		
		//Creamos los elementos  y el nodo de texto y lo a�adimos
		Element nombreEle = dom.createElement("nombre");
		Text nombreTexto = dom.createTextNode(e.getNombre());
		nombreEle.appendChild(nombreTexto);
		EntradaEle.appendChild(nombreEle);
		
		Element apellidoEle = dom.createElement("apellido");
		Text apellidoTexto = dom.createTextNode(e.getApellidos());
		apellidoEle.appendChild(apellidoTexto);
		EntradaEle.appendChild(apellidoEle);
		
		
		Element fechaEle = dom.createElement("fecha");
		Text fechaTexto = dom.createTextNode(e.getFecha());
		fechaEle.appendChild(fechaTexto);
		EntradaEle.appendChild(fechaEle);
		
		Element nomEventEle = dom.createElement("nombreEvento");
		Text EventoTexto = dom.createTextNode(e.getNomEvent());
		nomEventEle.appendChild(EventoTexto);
		EntradaEle.appendChild(nomEventEle);
		
		Element localizacionEle = dom.createElement("localizacion");
		Text localTexto = dom.createTextNode(e.getLocalizacion());
		localizacionEle.appendChild(localTexto);
		EntradaEle.appendChild(localizacionEle);
		
		Element ciudadEle = dom.createElement("ciudad");
		Text ciudadTexto = dom.createTextNode(e.getCiudad());
		ciudadEle.appendChild(ciudadTexto);
		EntradaEle.appendChild(ciudadEle);
		
		
		Element precioEle = dom.createElement("precio");
		Text precioTexto = dom.createTextNode(Integer.toString(e.getPrecio()));
		precioEle.appendChild(precioTexto);
		EntradaEle.appendChild(precioEle);
		
		Element idEle = dom.createElement("idEntrada");
		Text idTexto = dom.createTextNode(e.getId());
		idEle.appendChild(idTexto);
		EntradaEle.appendChild(idEle);
		
		return EntradaEle;
			
	}
	
	public void escribirDocumentAXml(File file) throws TransformerException{
		//creamos una instancia para escribir el resultado
		
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		
		
		//Especificaciones donde escribimos y la fuente de datos
		
		StreamResult result = new StreamResult(file);
		DOMSource source = new DOMSource(dom);
		trans.transform(source, result);
	
	}
	
	

}
