package com.projetPfe.views;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.projetPfe.models.entity.Employe;

@XmlRootElement(name = "employes")
public class XmlViewComponent {

	@XmlElement(name = "employe" )
	private List<Employe> employes;

	public XmlViewComponent() {

	}

	public XmlViewComponent(List<Employe> employes) {
		this.employes = employes;
	}

	public List<Employe> getEmploye() {
		return employes;
    }
}