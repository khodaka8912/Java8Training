package ch09.ex03;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

/**
 * @author hodaka
 */
public class MultiCatcher {

    /**
     * 複数例外をcatchしたブロックでその例外を再度throwする場合、すべての例外のthrows宣言が必要。
     */
    public void process() throws FileNotFoundException, UnknownHostException {
        try {
            handleFileResource();
            handleNetworkResource();
        } catch (FileNotFoundException | UnknownHostException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void handleFileResource() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    private void handleNetworkResource() throws UnknownHostException {
        throw new UnknownHostException();
    }
}
