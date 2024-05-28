package ca.georgiancollege.comp1011summer2024tuesdays;

public class Week4 {

    public static void main(String[] args) {

        SampleInterface sampleInterface =
                new SampleInterface() {
            @Override
            public boolean isOddNumb(int number) {
                return number % 2 == 1;
            }
        };
    }
}
