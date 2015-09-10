import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import com.bruceeckel.fileutil.*;

public class CharBufferTest {
    public static final int BSIZE = 4000;
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader(
            new File("CharBufferTest.java"));
        StringBuilder sb = new StringBuilder();
        CharBuffer buffer = CharBuffer.allocate(BSIZE);
        while (true) {
            int n = reader.read(buffer);
            if(n == -1) {
                break;
            }
            buffer.flip();
            sb.append(buffer, 0, n);
        }
        String textFile = sb.toString();
        CharBuffer charBuffer = CharBuffer.wrap(textFile);
        // Call the method
        PrintCharBuffer.printContents(charBuffer);
    }
}
