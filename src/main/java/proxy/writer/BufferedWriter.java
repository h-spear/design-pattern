package proxy.writer;

import java.util.ArrayList;
import java.util.List;

public class BufferedWriter extends Writer {

    private List<String> buffer = new ArrayList<>();
    private ScreenWriter screenWriter;
    private int bufferSize;

    public BufferedWriter(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Override
    public void print(String content) {
        buffer.add(content);
        if (buffer.size() == bufferSize) {
            flush();
        }
    }

    public void flush() {
        if (screenWriter == null) {
            screenWriter = new ScreenWriter();
        }
        String lines = String.join("\n", buffer);
        screenWriter.print(lines);  // buffer 출력
        callCount++;
        buffer.clear();
    }
}
