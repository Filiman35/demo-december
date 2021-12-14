package december.christmas.demo.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParserTestUtil {

  @SneakyThrows
  public static List<Map<String, String>> csvToMap(Resource csv, String encoding) {

    // We skip the first line ("sep=\t"), otherwise it breaks parsing
    final BufferedReader bufferedReader =
        new BufferedReader(
            new StringReader(
                new BufferedReader(new InputStreamReader(csv.getInputStream(), encoding))
                    .lines()
                    .skip(1)
                    .collect(Collectors.joining("\n"))));

    return CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter('\t').withRecordSeparator("\n")
        .parse(bufferedReader).getRecords().stream()
        .map(CSVRecord::toMap)
        .collect(Collectors.toList());
  }
}
