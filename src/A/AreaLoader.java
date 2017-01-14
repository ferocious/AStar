package A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AreaLoader {

	public int[][] loadAreaFromFile(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        List<String[]> parsedLines = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            parsedLines.add(line.trim().split(" "));
        }

        int[][] resultArea = new int[parsedLines.size()][];
        for (int index = 0; index < parsedLines.size(); index++) {
            resultArea[index] = convertToInts(parsedLines.get(index));
        }
        
        reader.close();

        return resultArea;
    }

    private int[] convertToInts(String[] values) {
        int[] result = new int[values.length];
        for (int index = 0; index < values.length; index++) {
            if ("#".equals(values[index])) {
                result[index] = -1;
            } else if (">".equals(values[index])) {
                result[index] = -2;
            } else if ("X".equals(values[index])) {
                result[index] = -3;
            } else {
                result[index] = Integer.valueOf(values[index]);
            }
        }

        return result;
    }
}
