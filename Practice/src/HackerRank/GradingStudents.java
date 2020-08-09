package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class GradingStudents {

    public static void main(String[] args) throws IOException{

        InputStream in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = gradingStudents(grades);
        System.out.println("\n");
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static List<Integer> gradingStudents(List<Integer> grades) {

        for(int index = 0; index < grades.size(); ++index) {
            int g = grades.get(index);
            if(g >= 38) {
                int mod5 = g % 5;
                if(mod5 ==3 || mod5 == 4) {
                    grades.set(index, (5-mod5+g));
                }
            }

        }

        return grades;

    }

}
