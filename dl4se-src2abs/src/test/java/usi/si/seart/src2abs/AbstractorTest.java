package usi.si.seart.src2abs;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileInputStream;
import java.nio.file.Path;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class AbstractorTest {

    @NonFinal
    @TempDir
    Path results;
    Path outputs = Path.of(this.getClass().getResource("/outputs").getPath());
    Path inputs = Path.of(this.getClass().getResource("/inputs").getPath());
    Path idioms = Path.of(this.getClass().getResource("/idioms.csv").getPath());

    @ParameterizedTest
    @ValueSource(strings = {
            "01_main.java",
            "02_regular.java",
            "03_enum.java",
            "04_interface.java",
            "05_annotated.java",
            "06_comments.java"
    })
    void test(String fileName) {
        Path fileNamePath = Path.of(fileName);
        Path input = inputs.resolve(fileNamePath);
        Path expected = outputs.resolve(fileNamePath);
        Path actual = results.resolve(fileNamePath);
        Abstractor.abstractCode(Parser.Granularity.CLASS, input, actual, idioms);
        Assertions.assertTrue(contentEquals(expected, actual));
    }

    @SneakyThrows
    private boolean contentEquals(Path path1, Path path2) {
        return IOUtils.contentEquals(
          new FileInputStream(path1.toFile()),
          new FileInputStream(path2.toFile())
        );
    }
}