public final class b {
	private static byte[] a = new byte[256];

	static {
		for (int i = 0; i < 256; ++i)
			a[i] = -1;
		for (int j = 65; j <= 90; ++j)
			a[j] = (byte) (j - 65);
		for (int k = 97; k <= 122; ++k)
			a[k] = (byte) (-97 + (k + 26));
		for (int l = 48; l <= 57; ++l)
			a[l] = (byte) (-48 + (l + 52));
		a[43] = 62;
		a[47] = 63;
	}

	public static byte[] a(char[] paramArrayOfChar) {
		int i = 0;
		int j = 3 * ((3 + paramArrayOfChar.length) / 4);
		if ((paramArrayOfChar.length > 0)
				&& (paramArrayOfChar[(-1 + paramArrayOfChar.length)] == '='))
			--j;
		if ((paramArrayOfChar.length > 1)
				&& (paramArrayOfChar[(-2 + paramArrayOfChar.length)] == '='))
			--j;
		byte[] arrayOfByte = new byte[j];
		int k = 0;
		int l = 0;
		int i1 = 0;
		int i4;
		int i5;

		while (true) {
			if (k < paramArrayOfChar.length) {
				int i2 = a[(0xFF & paramArrayOfChar[k])];
				if (i2 >= 0) {
					int i3 = l << 6;
					i4 = i1 + 6;
					i5 = i3 | i2;
					if (i4 < 8) {
						i1 = i4;
						l = i5;
					} else {
						int i6 = i4 - 8;
						int i7 = i + 1;
						arrayOfByte[i] = (byte) (0xFF & i5 >> i6);
						i = i7;
						l = i5;
						i1 = i6;
					}
				}
				
			}
			
			++k;
			
			if (k>=paramArrayOfChar.length)
				break;
			

			// if (i != arrayOfByte.length)
			// throw new Error("miscalculated data length!");
			

		}
		
		return arrayOfByte;
	}
}