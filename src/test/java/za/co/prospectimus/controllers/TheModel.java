package za.co.prospectimus.controllers;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class TheModel implements Model{

	@Override
	public Model addAttribute(String attributeName, Object attributeValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model addAttribute(Object attributeValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model addAllAttributes(Collection<?> attributeValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model addAllAttributes(Map<String, ?> attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model mergeAttributes(Map<String, ?> attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAttribute(String attributeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> asMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
