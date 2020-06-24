package reader;

import reader.criteria.Both;
import reader.criteria.Criterion;
import reader.criteria.ContainsWord;
import reader.criteria.EndsWithQuestionOrExclamationMark;
import reader.criteria.LengthAtLeast;

public class Main {

    public static void main(String[] args) {
    String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
    GutenbergReader book = new GutenbergReader(address);

     Criterion criterion = new LengthAtLeast(40);

    for (String line : book.linesWhichComplyWith(criterion)) {
        System.out.println(line);
    }
}
}
