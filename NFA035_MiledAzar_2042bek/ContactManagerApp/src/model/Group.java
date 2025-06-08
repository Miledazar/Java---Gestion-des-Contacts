package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private Set<Contact> contacts;

	    // Constructor
	    public Group(String name, String description) {
	    	if(name == null) {
	    		throw new IllegalArgumentException("Group name cannot be null");
	    	}
	        this.name = name;
	        this.description = description;
	        this.contacts = new HashSet<>();
	    }

	    // Getters
	    public String getName() {
	        return name;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	    
	    public Set<Contact> getContacts() {
	        return contacts;
	    }
	    
	    // Setters
	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public void setContacts(Set<Contact> newContacts) {
	    	 for (Contact c : new HashSet<>(contacts)) {
	    	        if (!newContacts.contains(c)) {
	    	            removeContact(c); 
	    	        }
	    	    }

	    	    
	    	    for (Contact c : newContacts) {
	    	        if (!contacts.contains(c)) {
	    	            addContact(c); 
	    	        }
	    	    }
	    }

	    // Helpers
	    public void addContact(Contact contact) {
	    	 if (contacts.add(contact)) {
	    	        if (!contact.getGroup().contains(this)) {
	    	            contact.addGroup(this); 
	    	        }
	    	    }
	    }

	    public void removeContact(Contact contact) {
	    	if (contacts.remove(contact)) {
	            if (contact.getGroup().contains(this)) {
	                contact.removeGroup(this); 
	            }
	        }
	    }
	    
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Group)) return false;
	        Group group = (Group) o;

	        if (this.name == null) {
	            if (group.name != null) return false;
	        } else if (!this.name.equalsIgnoreCase(group.name)) {
	            return false;
	        }

	        if (this.description == null) {
	            if (group.description != null) return false;
	        } else if (!this.description.equalsIgnoreCase(group.description)) {
	            return false;
	        }

	        return true;
	    }


		@Override
		public int hashCode() {
		    int result = (name == null) ? 0 : name.toLowerCase().hashCode();
		    result = 31 * result + ((description == null) ? 0 : description.toLowerCase().hashCode());
		    return result;
		}
	    
	   @Override
		public String toString() {
		    return name;
		}

}
