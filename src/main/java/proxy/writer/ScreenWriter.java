package proxy.writer;

public class ScreenWriter extends Writer {

    @Override
    public void print(String content) {
        try {
            Thread.sleep(100);  // 출력을 위한 준비 시간이라 가정
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(content);
        callCount++;
    }
}
