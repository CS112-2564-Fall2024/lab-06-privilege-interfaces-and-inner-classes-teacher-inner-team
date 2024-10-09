public class Person implements Comparable<Person>
{
	public class Identity {
		String pronouns;
		String background;

		public static final String DEFAULT_PRONOUNS = "Xe,Xim";
		public static final String DEFAULT_BACKGROUND = "None";	

		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}

		public Identity() {
			this.pronouns = DEFAULT_PRONOUNS;
			this.background = DEFAULT_BACKGROUND;
		}

		public String toString() {
			return "Pronouns: " + this.pronouns + " Background: " + this.background;
		}

		public boolean equals(Identity other) {
			return this.pronouns.equals(other.pronouns) 
					&& this.background.equals(other.background);
		}
	}

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private Identity identity;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String pronouns, String background, int privilege) {
		Identity identity = new Identity(pronouns, background);
		this.setAll(name, identity, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, Identity.DEFAULT_PRONOUNS, Identity.DEFAULT_BACKGROUND, DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if (original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.identity, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setIdentity(String pronouns, String background) {
		this.identity = new Identity(pronouns, background);
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, Identity identity, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setIdentity(identity.pronouns, identity.background);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}
		
	public Identity getIdentity() {
		return this.identity;
	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " and "+ this.identity + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
		      return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.identity.equals(otherPerson.identity) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/
	public int compareTo(Person other) {
		if (this.privilege < other.privilege) {
			return -1;
		}
		else if (this.privilege > other.privilege) {
			return 1;
		}
		else {
			return 0;
		}
	}
}