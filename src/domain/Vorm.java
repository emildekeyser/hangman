package domain;

public abstract class Vorm {
	private Omhullende o;

	public abstract Omhullende getOmhullende();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vorm other = (Vorm) obj;
		if (o == null) {
			if (other.o != null)
				return false;
		} else if (!o.equals(other.o))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vorm [o=" + o + "]";
	}
	
	
}
