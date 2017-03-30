package strings;

public class SubString {

	public static void main(String[] args) {
		String inp = "mynameisashutoshanand";
		String toFind = "anand";
		SubString obj = new SubString();
		boolean result = obj.isSubString(inp, toFind);
		System.out.println(result);
	}

	public boolean isSubString(String inp, String toFind) {
		if (inp == null || toFind == null || toFind.length() == 0 || toFind.length() > inp.length()) {
			return false;
		}

		int hashCodeToFind = hashCode(toFind, 0, toFind.length(), -1);
		int prevHashCode = -1;        
		for (int i=0; i<=inp.length() - toFind.length(); i++) {
			int currentHashCode = hashCode(inp, i, toFind.length(), prevHashCode);
			if (currentHashCode == hashCodeToFind) {
				if (matches(inp, i, toFind)) {
					return true;
				}        
			}
			prevHashCode = currentHashCode;
		}
		return false;
	}


	private boolean matches(String inp, int startIdx, String toFind) {
		for (int i=startIdx, j=0; j<toFind.length(); i++, j++) {
			if (inp.charAt(i) != toFind.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	private int hashCode(String inp, int startIdx, int length, int prevHashCode) {
		if (prevHashCode == -1) {
			int res = 0;
			for (int i=startIdx; i<startIdx+length; i++) {
				res += inp.charAt(i);
			}
			return res;
		} else {
			int toRemove = inp.charAt(startIdx-1);
			int toAdd = inp.charAt(startIdx+length-1);
			return prevHashCode - toRemove + toAdd;
		}
	}
}
