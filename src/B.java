
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   B

public class B extends Graphics2D
{

    public final void I()
    {
        createRasterizer(I, append, toString);
    }

    //something to do with drawing icons
    //moves and updates icon object positions???
    public final void drawIcons(int xpos, int ypos)
    {
    	//System.out.println(xpos+","+ypos);
        xpos += Z;
        ypos += C;
        int k = xpos + ypos * width;
        int l = 0;
        int i1 = toString;
        int j1 = append;
        int k1 = width - j1;
        int l1 = 0;
        if(ypos < topY)
        {
            int i2 = topY - ypos;
            i1 -= i2;
            ypos = topY;
            l += i2 * j1;
            k += i2 * width;
        }
        if(ypos + i1 > bottomY)
            i1 -= (ypos + i1) - bottomY;
        if(xpos < topX)
        {
            int j2 = topX - xpos;
            j1 -= j2;
            xpos = topX;
            l += j2;
            k += j2;
            l1 += j2;
            k1 += j2;
        }
        if(xpos + j1 > bottomX)
        {
            int k2 = (xpos + j1) - bottomX;
            j1 -= k2;
            l1 += k2;
            k1 += k2;
        }
        if(j1 <= 0 || i1 <= 0)
        {
            return;
        } else
        {
            blitIcon(pixels, I, 0, l, k, j1, i1, k1, l1);
            return;
        }
    }

    public final void blitIcon(int globalpixels[], int mypixels[], int pixcolor, int j, int k, int l, int xsize, int j1, int k1)
    {
    	//System.out.println(i+","+j+","+k+","+l+","+i1+","+j1+","+k1);
        int l1 = -(l >> 2);
        l = -(l & 3);
        for(int i2 = -xsize; i2 < 0; i2++)
        {
            for(int j2 = l1; j2 < 0; j2++)
            {
                pixcolor = mypixels[j++];
                if(pixcolor != 0)
                	globalpixels[k++] = pixcolor;
                else
                    k++;
                pixcolor = mypixels[j++];
                if(pixcolor != 0)
                	globalpixels[k++] = pixcolor;
                else
                    k++;
                pixcolor = mypixels[j++];
                if(pixcolor != 0)
                    globalpixels[k++] = pixcolor;
                else
                    k++;
                pixcolor = mypixels[j++];
                if(pixcolor != 0)
                    globalpixels[k++] = pixcolor;
                else
                    k++;
            }

            for(int k2 = l; k2 < 0; k2++)
            {
                pixcolor = mypixels[j++];
                if(pixcolor != 0)
                    globalpixels[k++] = pixcolor;
                else
                    k++;
            }

            k += j1;
            j += k1;
        }

    }

    public B(int i, int j)
    {
    	//System.out.println(i+","+j);
        I = new int[i * j];
        append = B = i;
        toString = D = j;
        Z = C = 0;
    }

    public B(DatFile e, String s, int i)  //loads and defines mapfunctions?  71 of them.
    {
    	//System.out.println(s + "," + i);
        IoBuffer j = new IoBuffer(e.loadNestedDat((new StringBuilder()).append(s).append(IResourceLoader.I(1251)).toString(), null));
        IoBuffer k = new IoBuffer(e.loadNestedDat(IResourceLoader.I(1256), null));
        k.length = j.readShort();
        B = k.readShort();
        D = k.readShort();
        int l = k.readUnsigned();
        int ai[] = new int[l];
        for(int i1 = 0; i1 < l - 1; i1++)
        {
            ai[i1 + 1] = k.F();
            if(ai[i1 + 1] == 0)
                ai[i1 + 1] = 1;
        }

        for(int j1 = 0; j1 < i; j1++)
        {
            k.length += 2;
            j.length += k.readShort() * k.readShort();
            k.length++;
        }

        Z = k.readUnsigned();
        C = k.readUnsigned();
        append = k.readShort();
        toString = k.readShort();
        int k1 = k.readUnsigned();
        int l1 = append * toString;
        I = new int[l1];
        if(k1 == 0)
        {
            for(int i2 = 0; i2 < l1; i2++)
                I[i2] = ai[j.readUnsigned()];

        } else
        if(k1 == 1)
        {
            for(int j2 = 0; j2 < append; j2++)
            {
                for(int k2 = 0; k2 < toString; k2++)
                    I[j2 + k2 * append] = ai[j.readUnsigned()];

            }

        }
    }

    //draws minimap at pos i,j
    public final void Z(int i, int j)
    {
        i += Z;
        j += C;
        int k = i + j * width;
        int l = 0;
        int i1 = toString;
        int j1 = append;
        int k1 = width - j1;
        int l1 = 0;
        if(j < topY)
        {
            int i2 = topY - j;
            i1 -= i2;
            j = topY;
            l += i2 * j1;
            k += i2 * width;
        }
        if(j + i1 > bottomY)
            i1 -= (j + i1) - bottomY;
        if(i < topX)
        {
            int j2 = topX - i;
            j1 -= j2;
            i = topX;
            l += j2;
            k += j2;
            l1 += j2;
            k1 += j2;
        }
        if(i + j1 > bottomX)
        {
            int k2 = (i + j1) - bottomX;
            j1 -= k2;
            l1 += k2;
            k1 += k2;
        }
        if(j1 <= 0 || i1 <= 0)
        {
            return;
        } else
        {
            toString(pixels, I, l, k, j1, i1, k1, l1);
            return;
        }
    }

    public final void toString(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1)
    {
        int k1 = -(k >> 2);
        k = -(k & 3);
        for(int l1 = -l; l1 < 0; l1++)
        {
            for(int i2 = k1; i2 < 0; i2++)
            {
                ai[j++] = ai1[i++];
                ai[j++] = ai1[i++];
                ai[j++] = ai1[i++];
                ai[j++] = ai1[i++];
            }

            for(int j2 = k; j2 < 0; j2++)
                ai[j++] = ai1[i++];

            j += i1;
            i += j1;
        }

    }

    public int I[];
    public int append;
    public int toString;
    public int Z;
    public int C;
    public int B;
    public int D;
}
