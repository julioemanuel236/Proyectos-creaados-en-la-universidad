package ventana;

public final class funciones {
	
	
	
	public static String capitalizar(char s[]) {
		int r = 'a' - 'A';
		for (int i = 0; i < s.length; i++) {
			if (i == 0) {
				if (s[i] >= 'a' && s[i] <= 'z')
					s[i] -= r;
			} 
			else if (s[i] >= 'A' && s[i] <= 'Z')
				s[i] += r;
		}

		return new String(s);
	}
		

}
