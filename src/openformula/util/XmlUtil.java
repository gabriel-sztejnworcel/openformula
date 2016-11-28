
package openformula.util;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XmlUtil
{
	public static Document getDocFromBuffer(byte[] buf) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setNamespaceAware(true);

	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document doc = builder.parse(new ByteArrayInputStream(buf)); 

	    return doc;
	}
}
