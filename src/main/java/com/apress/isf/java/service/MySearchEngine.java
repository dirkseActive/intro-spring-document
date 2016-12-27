package com.apress.isf.java.service;

import java.util.ArrayList;
import java.util.List;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;

public class MySearchEngine implements SearchEngine {

	@Override
	public List<Document> findByType(Type documentType) {
		List<Document> result = new ArrayList<Document>();
		for (Document document : storage()) {
			if (document.getType().getName().equals(documentType.getName()))
				result.add(document);
		}
		return result;
	}

	@Override
	public List<Document> listAll() {
		return storage();
	}

	private List<Document> storage() {
		List<Document> result = new ArrayList<Document>();

		Type type = new Type();
		type.setName("PDF");
		type.setDesc("Portable Document Format");
		type.setExtension(".pdf");

		Document document = new Document();
		document.setName("Book Template");
		document.setType(type);
		document.setLocation("/Documents/Book Template.pdf");

		result.add(document);

		return result;
	}

}
