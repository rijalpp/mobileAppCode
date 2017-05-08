package com.example.multipleactivities;

public class Item {
	
	private String name;
	private Integer qty;
	
	// constructors
	public Item (String name)
	{
		this.name = name;
		this.qty = 0;
	}
	
	public Item (String name, Integer qty)
	{
		this.name = name;
		this.qty = qty;
	}
	
	
	//methods
		// getters and setters
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public Integer getQty() {
			return qty;
		}
	
		public void setQty(Integer qty) {
			this.qty = qty;
		}
		
		//to string override
		@Override
		public String toString() {
			return "Item [name=" + name + ", qty=" + qty + "]";
		}
		
		// hashcode for name only
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
	
		
	
	
	
}
