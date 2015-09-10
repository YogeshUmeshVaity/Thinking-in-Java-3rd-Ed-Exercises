package com.bruceeckel.fileutil;

import java.io.*;
import java.nio.*;
import java.util.regex.*;
import java.nio.charset.*;

public final class PrintCharBuffer {

    private PrintCharBuffer() {}
    
    /* Prints upto the point where the characters are no 
    longer printable */
    public static void printContents(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            char c = buffer.get();
            System.out.print(c);
        }
    }
}
