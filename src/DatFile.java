
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   topX


public class DatFile {  //loads UI text elements?

    public DatFile(byte abyte0[]) {
        charAt(abyte0);
    }

    public final void charAt(byte abyte0[]) {  //loading numbers such as 8
//    	93524
//    	4045461
//    	14352389
//    	262148
//    	9223422
//    	10880768
//    	793344
//    	3528704
//    	2097200
    	
        IoBuffer buffer = new IoBuffer(abyte0);
        int j = buffer.F();
        int k = buffer.F();
        if (k != j) {
            byte abyte1[] = new byte[j];
            S.I(abyte1, j, abyte0, k, 6);
            charAt = abyte1;
            buffer = new IoBuffer(charAt);
            B = true;
        } else {
            charAt = abyte0;
            B = false;
        }
        length = buffer.readShort();
        toUpperCase = new int[length];
        I = new int[length];
        Z = new int[length];
        C = new int[length];
        int l = buffer.length + length * 10;
        for (int i1 = 0; i1 < length; i1++) {
            toUpperCase[i1] = buffer.readInt();
            I[i1] = buffer.F();
            Z[i1] = buffer.F();
            C[i1] = l;
            l += Z[i1];
        }

    }

    public final byte[] loadNestedDat(String s, byte abyte0[]) {  //some kind of loader dealing with index.dat and mapfunction.dat?
        int i = 0;
        s = s.toUpperCase();
        for (int j = 0; j < s.length(); j++)
            i = (i * 61 + s.charAt(j)) - 32;

        for (int k = 0; k < length; k++)
            if (toUpperCase[k] == i) {
                if (abyte0 == null)
                    abyte0 = new byte[I[k]];
                if (!B) {
                    S.I(abyte0, I[k], charAt, Z[k], C[k]);
                } else {
                    for (int l = 0; l < I[k]; l++)
                        abyte0[l] = charAt[C[k] + l];

                }
                return abyte0;
            }

        return null;
    }

    public byte charAt[];
    public int length;
    public int toUpperCase[];
    public int I[];
    public int Z[];
    public int C[];
    public boolean B;
}
