package org.factory.design.config;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.factory.design.utility.AppConstant;
import org.factory.design.utility.Utility;

/*
 * @author Anish Singh
 * 
 * This file is responsible for handling xml marshalling and unmarshalling.
 * 
 */

public class XMLFileHandler {

	public static void marshal(Object marshallingObject, String writeToFile) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(marshallingObject.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(marshallingObject, new File(writeToFile));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Object unmarshal(String fileName, Class<?> typeOfObject) {
		try {
			InputStream stream = Utility.findResourcesInClassPath(fileName);
			if (stream == null)
				throw new RuntimeException("Unable to find " + AppConstant.FACTORY_CONFIG_FILE + " in the class path.");
			JAXBContext jaxbContext = JAXBContext.newInstance(typeOfObject);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return unmarshaller.unmarshal(stream);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static OutputStream marshal(Object marshallingObject) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(marshallingObject.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			marshaller.marshal(marshallingObject, baos);
			return baos;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
