package usi.si.seart.src2abs;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class AbstractorTest {

    @NonFinal
    @TempDir
    Path results;
    Path outputs = Path.of(this.getClass().getResource("/outputs").getPath());
    Path inputs = Path.of(this.getClass().getResource("/inputs").getPath());
    Path idioms = Path.of(this.getClass().getResource("/idioms.csv").getPath());


    @Test
    void test() {
        Stream.of(inputs.toFile().listFiles())
                .map(File::toPath)
                .forEach(input -> {
                    Path name = input.getFileName();
                    Path expected = outputs.resolve(name);
                    Path actual = results.resolve(name);
                    Abstractor.abstractCode(Parser.Granularity.CLASS, input, actual, idioms);
                    Assertions.assertTrue(contentEquals(expected, actual));
                });
    }

    @SneakyThrows
    private boolean contentEquals(Path path1, Path path2) {
        return IOUtils.contentEquals(
          new FileInputStream(path1.toFile()),
          new FileInputStream(path2.toFile())
        );
    }
}