package captor.projectsystem.build.buildutil;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Node;

/**
 * Utility class for dealing with XML DOM elements.
 * 
 * ********************************************************************* ***
 * DISCLAIMER *** This code is covered by the Creative Commons Attribution 2.5
 * License (http://creativecommons.org/licenses/by/2.5/).
 * 
 * You may use this code in any way you see fit as long as you realize that the
 * code is provided AS IS without any warrenties and confers to rights what so
 * ever! The author cannot be held accountable for any loss, direct or indirect,
 * afflicted by using the code.
 * 
 * *********************************************************************
 * 
 * 
 * @author Mikkel Heisterberg, lekkim@lsdoc.org
 */
public class XMLUtil
{

	/**
	 * Constructs a XPath query to the supplied node.
	 * 
	 * @param n
	 * @return
	 */
	public static String getXPath(Node n)
	{
		if (null == n) {
			throw new IllegalArgumentException("Invalid node");
		}

		ArrayList<Node> hierarchy = new ArrayList<Node>();
		StringBuffer buffer = new StringBuffer();
		Node parent = null;

		// Push parent element's on stack
		hierarchy.add(n);
		parent = n.getParentNode();
		while (parent != null && parent.getNodeType() != Node.DOCUMENT_NODE) {
			hierarchy.add(0, parent);
			parent = parent.getParentNode();
		}

		Iterator<Node> i = hierarchy.iterator();
		while (i.hasNext()) {
			Node node = i.next();
			buffer.append("/");
			buffer.append(node.getNodeName());
			if (node.hasAttributes()) {
				Node uuid = node.getAttributes().getNamedItem("uuid");
				if (uuid != null) {
					buffer.append("[@uuid='");
					buffer.append(uuid.getNodeValue());
					buffer.append("']");
				}
			}
		}
		

		// return buffer
		return buffer.toString();
	}
}
