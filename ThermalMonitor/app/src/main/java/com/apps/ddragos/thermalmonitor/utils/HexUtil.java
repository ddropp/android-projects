package com.apps.ddragos.thermalmonitor.utils;

/**
 * Created by Dragos on 28-Apr-15.
 */
@SuppressWarnings("ALL")
public class HexUtil {
    /*
 *	functia care ne returneaza daca un caracter primit la intrare
 *	este o cifra hexa sau nu
 */
    public static boolean IsHexNumber(char hex)
    {
        hex = Character.toUpperCase(hex);

        return (hex >= '0' && hex <= '9') || (hex >= 'A' && hex <= 'F');
    }


    /*
     *	functia care primeste la intrare un caracter in hexa si returneaza
     *	valoarea intreaga corespunzatoare acestuia
     */
    public static char CharToHex(char c)
    {
        c = Character.toUpperCase(c);

        if( c >= '0' && c <= '9' )
        {
            return (char)(c-'0');
        }
        else
        {
            return (char)(c-'A'+10);
        }
    }

    public static char ConvByte_AsciiToHex(char c)
    {
        if( (c >= '0') && (c <= '9') )
            return (char)(c - '0');
        if( (c >= 'A') && (c <= 'F') )
            return (char)( c - 'A' + 10 );
        return 0;
    }

    public static char ConvByte_HexToAscii(char c)
    {
        if( (c >= 0) && (c <= 9) )
            return (char)(c + '0');
        if( (c >= 10) && (c <= 15) )
            return (char)(c - 10 + 'A');
        return 0;
    }

    public static int ConvString_AsciiHexToInteger(char[] str)
    {
        int err = 0;
        int i, j;
        int nr;

        if( str[ 0 ] == '0' && (str[ 1 ] == 'x' || str[ 1 ] == 'X') )
        {
            i = 2;
        }
        else
        {
            i = 0;
        }

        for( j = i; str[j] != '\0' ; j++ )
        {
            if( !IsHexNumber( str[ j ] ))
            {
                err = -1;
                break;
            }
        }

        if(err != -1 )
        {
            for (j = i, nr = 0; str[ j ] != '\0'; j++)
            {
                nr = nr * 16 + CharToHex(str[ j ]);
            }

            return nr;
        }
        else
            return err;

    }

}
