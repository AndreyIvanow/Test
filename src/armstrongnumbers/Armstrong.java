package armstrongnumbers;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class Armstrong {

    public final static int MAX_LEVEL = 20;

    private Verifier verifier = new Verifier();

    public Set<String> level (int level) {
        final Stream<byte[]> byteStream =  Representatives.asStream(level,  true);
        return collectStringsToSet(byteStream.map(verifier::apply));
    }

    private Set<String> collectStringsToSet(Stream<String> stream) {
        final ConcurrentSkipListSet result = new ConcurrentSkipListSet();
        stream.filter(s -> s != null).collect(toCollection(() -> result));
        return result;
    }
}
