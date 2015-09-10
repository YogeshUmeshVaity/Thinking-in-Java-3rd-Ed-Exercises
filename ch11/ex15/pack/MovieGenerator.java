package pack;
import com.bruceeckel.util.*;
import java.util.*;
public class MovieGenerator implements Generator {
	private int index = -1;
	public Object next() {
		index = (index + 1) % MovieCharacters.chars.length;
		return MovieCharacters.chars[index];
	}
}