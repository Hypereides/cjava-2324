import java.util.*;
class SentenceStats {
    int sentenceNumber;
    int count;
    Set<Integer> positions = new HashSet<>();

    public int getCount() {
        return count;
    }
}